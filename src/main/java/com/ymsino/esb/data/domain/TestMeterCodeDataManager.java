package com.ymsino.esb.data.domain;

import java.util.Date;

import org.apache.log4j.Logger;

import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.data.model.TestMeterCodeData;

public class TestMeterCodeDataManager {

	private Logger logger = Logger.getLogger(TestMeterCodeDataManager.class);
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	public boolean save(TestMeterCodeData model){
		
		model.setId(null);
		model.setCreateTimestamp(new Date().getTime());
		this.commonHibernateDao.save(model);

		return true;
	}
	
}
