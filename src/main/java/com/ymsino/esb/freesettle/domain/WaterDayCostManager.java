package com.ymsino.esb.freesettle.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.MapMapping;
import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.math.Arith;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.archives.model.User;
import com.ymsino.esb.archives.vo.UserReturn;
import com.ymsino.esb.data.model.WaterDayUsageAmount;
import com.ymsino.esb.freesettle.model.WaterDayCost;
import com.ymsino.esb.manager.model.PriceTemplate;

public class WaterDayCostManager {

	private Logger logger = Logger.getLogger(WaterDayCostManager.class);
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	private ProducerTemplate producerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	
	public void calculateByWaterDayUsageAmount(WaterDayUsageAmount model){
		
		if(model.getId() == null || model.getMeterHardwareId() == null || model.getWaterCustomerId() == null){
			logger.warn("日用量数据错误,无法计算水价");
			return;
		}
		
		String hql = "from PriceTemplate pt where pt.id = (select wc.priceTemplateId from WaterCustomer wc where wc.customerId = ?)";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(model.getWaterCustomerId());
		List<PriceTemplate> priceTemplatelist = this.commonHibernateDao.findBy(hql, paramList.toArray(), 0, 1);
		PriceTemplate pt;
		if(priceTemplatelist != null && priceTemplatelist.size() > 0){
			pt = priceTemplatelist.get(0);
		}else{
			logger.warn("用水用户:" + model.getWaterCustomerId() + "无法找到水价模板,无法计算水价");
			return;
		}
		
		//计算总共有几阶水价，缓存阶梯量和价格
		Map<Integer, Long> priceMap = new HashMap<Integer, Long>();
		Map<Integer, Float> numMap = new HashMap<Integer, Float>();
		int priceLevel = 1;
		for(int i = 1; i < 5; i++){
			Float num = (Float) ObjectMapping.getFieldValue(pt, "level" + i + "Num");
			Long cost = (Long) ObjectMapping.getFieldValue(pt, "level" + i + "Cost");
			if(num == null || cost == null){
				break;
			}
			priceLevel = i;
			priceMap.put(i, cost);
			numMap.put(i, num);
		}
		
		//检查是否已经结算过
		hql = "from WaterDayCost model where model.meterHardwareId = ? and model.freezeYear = ? and model.freezeMonth = ?";
		paramList = new ArrayList<Object>();
		paramList.add(model.getMeterHardwareId());
		paramList.add(model.getFreezeYear());
		paramList.add(model.getFreezeMonth());
		List<WaterDayCost> waterDayCostlist = this.commonHibernateDao.findBy(hql, paramList.toArray(), 0, 1);
		
		WaterDayCost dayCost;
		if(waterDayCostlist != null && waterDayCostlist.size() > 0){
			//dayCost = waterDayCostlist.get(0);
			logger.warn("用水用户:" + model.getWaterCustomerId() + "," + model.getFreezeYear() + "-" + model.getFreezeMonth() + "的费用数据已经统计过,无需再次统计");
			return;
		}else{
			dayCost = new WaterDayCost();
			dayCost.setChargingUnitId(model.getChargingUnitId());
			dayCost.setCheckPayStatus(Short.valueOf("-1"));
			dayCost.setConcHardwareId(model.getConcHardwareId());
			dayCost.setCreateTimestamp(new Date().getTime());
			dayCost.setFreezeMonth(model.getFreezeMonth());
			dayCost.setFreezeYear(model.getFreezeYear());
			dayCost.setMeterHardwareId(model.getMeterHardwareId());
			dayCost.setParentUnits(model.getParentUnits());
			dayCost.setPayStatus(Short.valueOf("1"));
			dayCost.setUserId(model.getUserId());
			dayCost.setWaterCustomerId(model.getWaterCustomerId());
		}
		
		float lastTotalAmount = 0f;
		long lastTotalPrice = 0l;
		for(int i = 1; i <= 31; i++){
			Float itemAmount = (Float) ObjectMapping.getFieldValue(model, "usageAmount" + i);
			
			float totalAmount = Arith.add(lastTotalAmount, itemAmount);
			long totalPrice = 0l;
			
			for(int j = 1; j <= priceLevel; j++){
				
				float lastLevelNum = 0f;
				if(j > 1)
					lastLevelNum = numMap.get(j - 1);
				
				//当当前总用量小于 该阶最大值的时候
				if(totalAmount <= numMap.get(j)){
					totalPrice = (long) Arith.add(totalPrice, Arith.mul(Arith.sub(totalAmount, lastLevelNum), priceMap.get(j)));
				}else{
					totalPrice = (long) Arith.add(totalPrice, Arith.mul(numMap.get(j), priceMap.get(j)));
				}
				
				if(totalAmount <= numMap.get(j)){
					break;
				}
			}
			
			ObjectMapping.setFieldValue(dayCost, "cost" + i, totalPrice - lastTotalPrice);
			
			lastTotalAmount = totalAmount;
			lastTotalPrice = totalPrice;
		}
		
		this.commonHibernateDao.save(dayCost);
		
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("method", "calculateByWaterDayCost");
		header.put("beanName", "waterMonthCostManager");
		producerTemplate.sendBodyAndHeaders("jms:queue:com.ymsino.esb.domain", ExchangePattern.InOnly, dayCost, header);
		

	}
	
	public Boolean settleCost(Long dayCostId){
		WaterDayCost dayCost = (WaterDayCost) this.commonHibernateDao.get(WaterDayCost.class, dayCostId);
		
		if(dayCost == null){
			logger.warn("结算水费数据,id:" + dayCostId + "不存在,结算失败");
			return false;
		}
		
		if(dayCost.getPayStatus().equals(Short.valueOf("1"))){
			logger.warn("结算水费数据,id:" + dayCostId + "已经结算过,结算失败");
			return false;
		}
		
		dayCost.setCheckPayStatus(Short.valueOf("1"));
		
		if(dayCost.getTotalCost() == null || dayCost.getUserId() == null){
			logger.warn("结算水费数据,id:" + dayCostId + "数据不完整,结算失败");
			return false;
		}
		
		String hql = "from User model where model.userId = ?";
		List<User> list = this.commonHibernateDao.findBy(hql, dayCost.getUserId());
		if(list == null || list.size() == 0){
			logger.warn("结算水费数据,id:" + dayCostId + "找不到用户档案,结算失败");
			return false;
		}
		Long uid = list.get(0).getId();
		 
		
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("method", "deduction");
		header.put("beanName", "userWalletManager");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("uid", uid);
		param.put("price", dayCost.getTotalCost());
		param.put("sysRemark", "用水月结扣费" + dayCost.getFreezeYear() + "年" + dayCost.getFreezeMonth() + "月,共扣除" + dayCost.getTotalCost() + "毫");
		
		if(!(Boolean) producerTemplate.sendBodyAndHeaders("jms:queue:com.ymsino.esb.domain", ExchangePattern.InOut, dayCost, header)){
			logger.warn("结算水费数据,id:" + dayCostId + "扣费失败");
			return false;
		}
		
		dayCost.setPayStatus(Short.valueOf("1"));
		return true;
		
	}
	
}
