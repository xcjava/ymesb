package com.ymsino.esb.freesettle.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.math.Arith;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
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
		
		String hql = "from PriceTemplate pt where pt.id = (select wc.priceTemplateId from WaterCustomer wc where wc.customerId = ?)";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(model.getMeterHardwareId());
		List<PriceTemplate> priceTemplatelist = this.commonHibernateDao.findBy(hql, paramList.toArray(), 0, 1);
		PriceTemplate pt;
		if(priceTemplatelist != null && priceTemplatelist.size() > 0){
			pt = priceTemplatelist.get(0);
		}else{
			logger.warn("用水用户:" + model.getWaterCustomerId() + "无法找到水价模板,无法计算水价");
			return;
		}
		
		Map<Integer, Long> priceMap = new HashMap<Integer, Long>();
		Map<Integer, Float> numMap = new HashMap<Integer, Float>();
		int priceLevel = 1;
		for(int i = 1; i < 5; i++){
			Float num = (Float) ObjectMapping.getFieldValue(model, "level" + i + "Num");
			Long cost = (Long) ObjectMapping.getFieldValue(model, "level" + i + "Cost");
			if(num == null || cost == null){
				break;
			}
			priceLevel = 1;
			priceMap.put(i, cost);
			numMap.put(i, num);
		}
		
		hql = "from WaterDayCost model where model.meterHardwareId = ? and model.freezeYear = ? and model.freezeMonth = ?";
		paramList = new ArrayList<Object>();
		paramList.add(model.getMeterHardwareId());
		paramList.add(model.getFreezeYear());
		paramList.add(model.getFreezeMonth());
		List<WaterDayCost> waterDayCostlist = this.commonHibernateDao.findBy(hql, paramList.toArray(), 0, 1);
		
		WaterDayCost dayCost;
		if(waterDayCostlist != null && waterDayCostlist.size() > 0){
			dayCost = waterDayCostlist.get(0);
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
				totalPrice = (long) Arith.add(totalPrice, Arith.mul(Arith.sub(totalAmount, numMap.get(j)), priceMap.get(j)));
				if(totalAmount <= numMap.get(j)){
					break;
				}
			}
			
			ObjectMapping.setFieldValue(dayCost, "cost" + i, totalPrice - lastTotalPrice);
			
			lastTotalAmount = totalAmount;
			lastTotalPrice = totalPrice;
		}
		
		if(dayCost.getId() == null){
			this.commonHibernateDao.save(dayCost);
		}
		
	}
	
}