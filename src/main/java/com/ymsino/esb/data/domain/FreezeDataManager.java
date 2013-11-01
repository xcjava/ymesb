package com.ymsino.esb.data.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.MapMapping;
import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.data.model.FreezeData;

public class FreezeDataManager {

	private Logger logger = Logger.getLogger(FreezeDataManager.class);
	
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	private ProducerTemplate camelTemplate;
	public void setCamelTemplate(ProducerTemplate camelTemplate) {
		this.camelTemplate = camelTemplate;
	}
	
	public Boolean insertOrUpdate(FreezeData model){
		
		String hql = "from FreezeData model where model.meterHardwareId = ? and model.freezeDateStr = ?";
		List<Object> paramList = new ArrayList<Object>();
		
		paramList.add(model.getConcHardwareId());
		paramList.add(model.getFreezeDateStr());
		
		FreezeData po;
		List<FreezeData> list = this.commonHibernateDao.findBy(hql, paramList.toArray());
		if(list != null && list.size() > 0){
			po = list.get(0);
		}else{
			po = new FreezeData();
		}
		
		ObjectMapping.objMapping(model, po, false);
		if(model.getId() == null){
			this.commonHibernateDao.save(model);
			
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "saveByFreezeData");
			header.put("beanName", "checkingFreezeDataManager");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.ymsino.esb.domain", ExchangePattern.InOnly, MapMapping.obj2map(po), header);
		}
		
		return true;
	}
	
}
