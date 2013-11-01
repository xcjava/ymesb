package com.ymsino.esb.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.hql.QueryCondition;
import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.hql.QueryParamWriter;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.data.model.CheckingFreezeData;
import com.ymsino.esb.data.model.FreezeData;

public class CheckingFreezeDataManager {

private Logger logger = Logger.getLogger(CheckingFreezeDataManager.class);
	
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	public Boolean saveByFreezeData(FreezeData freezeData){
		
		CheckingFreezeData data;
		
		String hql = "from CheckingFreezeData model where model.meterHardwareId = ? " +
				" and model.concHardwareId = ? and model.freezeYear = ? and model.freezeMonth = ?";
		
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(freezeData.getMeterHardwareId());
		paramList.add(freezeData.getConcHardwareId());
		paramList.add(freezeData.getFreezeDateStr().substring(0, 2));
		paramList.add(freezeData.getFreezeDateStr().substring(2, 4));
		
		List<CheckingFreezeData> list = this.commonHibernateDao.findBy(hql, paramList.toArray(), 0, 1);
		if(list == null || list.size() < 0){
			data = new CheckingFreezeData();
			data.setChargingUnitId(freezeData.getChargingUnitId());
			data.setConcHardwareId(freezeData.getConcHardwareId());
			data.setCreateTimestamp(new Date().getTime());
			data.setFreezeMonth(freezeData.getFreezeDateStr().substring(2, 4));
			data.setFreezeYear(freezeData.getFreezeDateStr().substring(0, 2));
			data.setMeterHardwareId(freezeData.getMeterHardwareId());
			data.setParentUnits(freezeData.getParentUnits());
			data.setUserId(freezeData.getUserId());
			data.setWaterCustomerId(freezeData.getWaterCustomerId());
		}else{
			data = list.get(0);
		}
		
		if(ObjectMapping.getFieldValue(data, "meterReading" + Integer.parseInt(freezeData.getFreezeDateStr().substring(4, 6))) != null){
			return true;
		}
		
		ObjectMapping.setFieldValue(data, "meterReading" + Integer.parseInt(freezeData.getFreezeDateStr().substring(4, 6)), 
				freezeData.getMeterReading());
		
		if(data.getId() == null){
			this.commonHibernateDao.save(data);
		}
		
		return true;
	}
	
	/*public static void main(String[] args){
		CheckingFreezeData data = new CheckingFreezeData();
		ObjectMapping.setFieldValue(data, "meterReading3", 123);
		System.out.println(ObjectMapping.getFieldValue(data, "meterReading4"));
	}*/
	
}
