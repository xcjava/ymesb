package com.ymsino.esb.archives.domain;

import org.apache.log4j.Logger;

import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.archives.model.Concentrator;

public class ConcentratorManager {

	private Logger logger = Logger.getLogger(ConcentratorManager.class);
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	public void onLine(String hardwareId){
		Concentrator po = (Concentrator) this.commonHibernateDao.get(Concentrator.class, hardwareId);
		if(po == null)
			return;
		
		po.setStatus(Short.valueOf("1"));
	}
	
	public void offLine(String hardwareId){
		Concentrator po = (Concentrator) this.commonHibernateDao.get(Concentrator.class, hardwareId);
		if(po == null)
			return;
		
		po.setStatus(Short.valueOf("-1"));
	}
	
	public void resetAllOffLine(){
		this.commonHibernateDao.bulkUpdateDelete("update Concentrator model set model.status = -1");
	}
	
}
