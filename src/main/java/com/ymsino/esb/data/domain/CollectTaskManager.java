package com.ymsino.esb.data.domain;

import java.util.Date;

import org.apache.log4j.Logger;

import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.data.model.CollectTask;

public class CollectTaskManager {

	private Logger logger = Logger.getLogger(CollectTaskManager.class);
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	public void startExec(Long id){
		CollectTask po = (CollectTask) this.commonHibernateDao.get(CollectTask.class, id);
		po.setStartTimestamp(new Date().getTime());
	}
	
	public void endExec(Long id){
		CollectTask po = (CollectTask) this.commonHibernateDao.get(CollectTask.class, id);
		po.setStartTimestamp(new Date().getTime());
	}
}
