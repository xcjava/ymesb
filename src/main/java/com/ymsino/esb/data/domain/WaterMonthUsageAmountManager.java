package com.ymsino.esb.data.domain;

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
import com.gmail.xcjava.base.date.DateUtil;
import com.gmail.xcjava.base.io.PropertyReader;
import com.gmail.xcjava.base.math.Arith;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.data.model.WaterDayUsageAmount;
import com.ymsino.esb.data.model.WaterMonthUsageAmount;

public class WaterMonthUsageAmountManager {

	private Logger logger = Logger.getLogger(WaterMonthUsageAmountManager.class);
	private String settleDate = PropertyReader.getProperties("config.properties").getProperty("data.settleDate");
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	private ProducerTemplate producerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	
	public Boolean saveByWaterDayUsageAmount(WaterDayUsageAmount dayData){
		
		Date today  = new Date();
		Date dayUsageAmountDate = DateUtil.parseDate("20" + dayData.getFreezeYear() + "-" + dayData.getFreezeMonth(), "yyyy-MM");
		
		if(DateUtil.getMonthOffset(today, dayUsageAmountDate) < 1){
			logger.info("未到结算日,无法生成月用量统计");
			return false;
		}
		
		String settleDateStr = DateUtil.format(today, "yyyy-MM-") + settleDate;
		if(DateUtil.parseDate(settleDateStr, "yyyy-MM-dd HH:mm:ss").getTime() > today.getTime()){
			logger.info("未到结算日,无法生月用量成统计");
			return false;
		}
		
		WaterMonthUsageAmount model;
		String hql = "from WaterMonthUsageAmount model where model.meterHardwareId = ? " +
				" and model.concHardwareId = ? and model.freezeYear = ? ";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(dayData.getMeterHardwareId());
		paramList.add(dayData.getConcHardwareId());
		paramList.add(dayData.getFreezeYear());
		List<WaterMonthUsageAmount> list = this.commonHibernateDao.findBy(hql, paramList.toArray(), 0, 1);
		if(list == null || list.size() < 0){
			model = new WaterMonthUsageAmount();
			model.setChargingUnitId(dayData.getChargingUnitId());
			model.setConcHardwareId(dayData.getConcHardwareId());
			model.setCreateTimestamp(today.getTime());
			model.setFreezeYear(dayData.getFreezeYear());
			model.setMeterHardwareId(dayData.getMeterHardwareId());
			model.setParentUnits(dayData.getParentUnits());
			model.setUserId(dayData.getUserId());
			model.setWaterCustomerId(dayData.getWaterCustomerId());
		}else{
			model = list.get(0);
		}
		
		if(ObjectMapping.getFieldValue(model, "usageAmount" + Integer.parseInt(dayData.getFreezeMonth())) != null){
			logger.info("月用量数据已经统计过");
			return false;
		}
		
		float amount = 0;
		for(int i = 1; i <= 31; i++){
			Float itemAmount = (Float) ObjectMapping.getFieldValue(dayData, "usageAmount" + i);
			if(itemAmount == null){
				itemAmount = 0f;
				ObjectMapping.setFieldValue(dayData, "usageAmount" + i, 0);
			}
			amount = Arith.add(amount, itemAmount);
		}
		
		ObjectMapping.setFieldValue(model, "usageAmount" + Integer.parseInt(dayData.getFreezeMonth()), amount);
		if(model.getId() == null){
			this.commonHibernateDao.save(model);
		}
		
		this.commonHibernateDao.update(dayData);
		
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("method", "calculateByWaterDayUsageAmount");
		header.put("beanName", "waterDayCostManager");
		producerTemplate.sendBodyAndHeaders("jms:queue:com.ymsino.esb.domain", ExchangePattern.InOnly, MapMapping.obj2map(dayData), header);
		
		return true;
	}
	
}
