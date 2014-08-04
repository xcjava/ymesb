package com.ymsino.esb.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.MapMapping;
import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.archives.model.WaterMeter;
import com.ymsino.esb.data.model.FreezeData;

public class FreezeDataManager {

	private Logger logger = Logger.getLogger(FreezeDataManager.class);
	
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	private ProducerTemplate producerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	
	public Boolean insertOrUpdate(FreezeData model){
		
		String hql = "from FreezeData model where model.meterHardwareId = ? and model.freezeDateStr = ?";
		List<Object> paramList = new ArrayList<Object>();
		
		paramList.add(model.getMeterHardwareId());
		paramList.add(model.getFreezeDateStr());
		
		FreezeData po;
		List<FreezeData> list = this.commonHibernateDao.findBy(hql, paramList.toArray());
		if(list != null && list.size() > 0){
			po = list.get(0);
		}else{
			po = new FreezeData();
		}

		ObjectMapping.objMapping(model, po, false);
		
		this.commonHibernateDao.saveOrUpdate(po);
		
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("method", "saveByFreezeData");
		header.put("beanName", "checkingFreezeDataManager");
		producerTemplate.sendBodyAndHeaders("jms:queue:com.ymsino.esb.domain", ExchangePattern.InOnly, po, header);

		return true;
	}
	
	public void initNullFreezeData(String concHardwareId, String freezeDateStr){
		
		String hql = "from WaterMeter wm where wm.concHardwareId = ? and wm.hardwareId not in (" +
				"select fd.meterHardwareId from FreezeData fd where fd.freezeDateStr = ? and fd.concHardwareId = ?)";
		
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(concHardwareId);
		paramList.add(freezeDateStr);
		paramList.add(concHardwareId);
		List<WaterMeter> list = this.commonHibernateDao.findBy(hql, paramList.toArray());
		
		for(WaterMeter item : list){
			FreezeData model = new FreezeData();
			model.setChargingUnitId(item.getChargingUnitId());
			model.setConcHardwareId(model.getConcHardwareId());
			model.setCreateTimestamp(new Date().getTime());
			model.setFreezeDateStr(freezeDateStr);
			model.setMeterHardwareId(item.getHardwareId());
			model.setParentUnits(item.getParentUnits());
			model.setUserId(item.getUserId());
			model.setWaterCustomerId(item.getWaterCustomerId());
			insertOrUpdate(model);
		}
		
	}
	
}
