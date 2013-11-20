package com.ymsino.esb.freesettle.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.freesettle.model.WaterDayCost;
import com.ymsino.esb.freesettle.model.WaterMonthCost;

public class WaterMonthCostManager {

	private Logger logger = Logger.getLogger(WaterMonthCostManager.class);
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	public void calculateByWaterDayCost(WaterDayCost dayCost){
		
		WaterMonthCost model;
		String hql = "from WaterMonthCost model where model.meterHardwareId = ? " +
				" and model.concHardwareId = ? and model.freezeYear = ? ";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(dayCost.getMeterHardwareId());
		paramList.add(dayCost.getConcHardwareId());
		paramList.add(dayCost.getFreezeYear());
		List<WaterMonthCost> list = this.commonHibernateDao.findBy(hql, paramList.toArray(), 0, 1);
		if(list == null || list.size() < 0){
			model = new WaterMonthCost();
			model.setChargingUnitId(dayCost.getChargingUnitId());
			model.setConcHardwareId(dayCost.getConcHardwareId());
			model.setCreateTimestamp(new Date().getTime());
			model.setFreezeYear(dayCost.getFreezeYear());
			model.setMeterHardwareId(dayCost.getMeterHardwareId());
			model.setParentUnits(dayCost.getParentUnits());
			model.setUserId(dayCost.getUserId());
			model.setWaterCustomerId(dayCost.getWaterCustomerId());
		}else{
			model = list.get(0);
		}
		
		if(ObjectMapping.getFieldValue(model, "cost" + Integer.parseInt(dayCost.getFreezeMonth())) != null){
			logger.info("月费用数据已经统计过");
			return;
		}
		
		long price = 0;
		for(int i = 1; i <= 31; i++){
			Long itemPrice = (Long) ObjectMapping.getFieldValue(dayCost, "cost" + i);
			price += itemPrice;
		}
		
		ObjectMapping.setFieldValue(model, "cost" + Integer.parseInt(dayCost.getFreezeMonth()), price);
		if(model.getId() == null){
			this.commonHibernateDao.save(model);
		}
		
	}
	
}
