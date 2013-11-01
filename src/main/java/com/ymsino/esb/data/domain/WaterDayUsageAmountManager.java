package com.ymsino.esb.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.gmail.xcjava.base.str.StringTool;
import com.ymsino.esb.archives.model.WaterMeter;
import com.ymsino.esb.data.model.CheckingFreezeData;
import com.ymsino.esb.data.model.WaterDayUsageAmount;

public class WaterDayUsageAmountManager {

	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	public Boolean saveByCheckingFreezeData(CheckingFreezeData data){
		
		Long initMeterReading = 0l;
		
		int year = Integer.parseInt(data.getFreezeYear());
		int month = Integer.parseInt(data.getFreezeMonth());
		
		int lastMonth = month - 1 > 0 ? month - 1 : 12;
		int lastYear = month - 1 > 0 ? year : year -1;
		
		String hql = "from CheckingFreezeData model where model.meterHardwareId = ? " +
				" and model.concHardwareId = ? and model.freezeYear = ? and model.freezeMonth = ?";
		
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(data.getMeterHardwareId());
		paramList.add(data.getConcHardwareId());
		paramList.add(StringTool.fromatNum(lastYear, 2));
		paramList.add(StringTool.fromatNum(lastMonth, 2));
		
		List<CheckingFreezeData> list = this.commonHibernateDao.findBy(hql, paramList.toArray(), 0, 1);
		if(list == null || list.size() < 0){
			WaterMeter waterMeter = (WaterMeter) this.commonHibernateDao.get(WaterMeter.class, data.getMeterHardwareId());
			initMeterReading = Long.valueOf(waterMeter.getInitialYards());
		}else{
			for(int i = 31; i > 0; i--){
				if(ObjectMapping.getFieldValue(data, "meterReading" + i) != null){
					initMeterReading = (Long) ObjectMapping.getFieldValue(data, "meterReading" + i);
				}
			}
		}
		
		
		WaterDayUsageAmount waterDayUsageAmount;
		hql = "from WaterDayUsageAmount model where model.meterHardwareId = ? " +
				" and model.concHardwareId = ? and model.freezeYear = ? and model.freezeMonth = ?";
		
		paramList = new ArrayList<Object>();
		paramList.add(data.getMeterHardwareId());
		paramList.add(data.getConcHardwareId());
		paramList.add(StringTool.fromatNum(lastYear, 2));
		paramList.add(StringTool.fromatNum(lastMonth, 2));
		
		List<WaterDayUsageAmount> WaterDayUsageAmountList = this.commonHibernateDao.findBy(hql, paramList.toArray(), 0, 1);
		if(WaterDayUsageAmountList == null || WaterDayUsageAmountList.size() < 0){
			waterDayUsageAmount = (WaterDayUsageAmount) this.commonHibernateDao.get(WaterDayUsageAmount.class, data.getMeterHardwareId());
		}else{
			waterDayUsageAmount = new WaterDayUsageAmount();
			waterDayUsageAmount.setChargingUnitId(data.getChargingUnitId());
			waterDayUsageAmount.setConcHardwareId(data.getConcHardwareId());
			waterDayUsageAmount.setCreateTimestamp(new Date().getTime());
			waterDayUsageAmount.setFreezeMonth(data.getFreezeMonth());
			waterDayUsageAmount.setFreezeYear(data.getFreezeYear());
			waterDayUsageAmount.setMeterHardwareId(data.getMeterHardwareId());
			waterDayUsageAmount.setParentUnits(data.getParentUnits());
			waterDayUsageAmount.setUserId(data.getUserId());
			waterDayUsageAmount.setWaterCustomerId(data.getWaterCustomerId());
		}
		
		for(int i = 1; i <= 31; i++){
			if(ObjectMapping.getFieldValue(data, "meterReading" + i) != null){
				
				long lastMeterReading = 0;
				long nowMeterReading = (Long) ObjectMapping.getFieldValue(data, "meterReading" + i);
				
				if(i == 1){
					lastMeterReading = initMeterReading;
				}else{
					lastMeterReading = (Long) ObjectMapping.getFieldValue(data, "meterReading" + (i - 1));
				}
				
				int amount = (int) (nowMeterReading - lastMeterReading);
				ObjectMapping.setFieldValue(waterDayUsageAmount, "usageAmount" + i, amount);
			}
		}
		
		if(waterDayUsageAmount.getId() == null){
			this.commonHibernateDao.save(waterDayUsageAmount);
		}
		
		return true;
		
	}
	
}