package com.ymsino.esb.data.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.data.model.FreezeData;

public class FreezeDataManager {

	private Logger logger = Logger.getLogger(FreezeDataManager.class);
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	public boolean insertOrUpdate(FreezeData model){
		
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
		}
		
		return true;
	}
	
}
