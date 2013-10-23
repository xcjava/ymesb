package com.ymsino.esb.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.hql.OrderParamReader;
import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.hql.QueryParamReader;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.data.model.TestMeterCodeData;
import com.ymsino.esb.data.service.api.TestMeterCodeDataService;
import com.ymsino.esb.data.vo.TestMeterCodeDataReturn;

public class TestMeterCodeDataServiceImpl implements TestMeterCodeDataService {

	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public TestMeterCodeDataReturn getById(Long id) {
		
		if(id == null)
			return null;
		
		TestMeterCodeData po = (TestMeterCodeData) this.commonHibernateDao.get(TestMeterCodeData.class, id);
		if(po == null)
			return null;
		
		return (TestMeterCodeDataReturn) ObjectMapping.objMapping(po, new TestMeterCodeDataReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestMeterCodeDataReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from TestMeterCodeData model where 1=1 ";
		List<Object> paramList = new ArrayList<Object>();
		
		if(queryParam != null && 
				!StringUtils.isEmpty(queryParam.getQueryValue()) &&
				!StringUtils.isEmpty(queryParam.getQueryCon()) &&
				!StringUtils.isEmpty(queryParam.getQueryLink())){
			QueryParamReader qpr = new QueryParamReader(queryParam.getQueryValue(), queryParam.getQueryCon(), queryParam.getQueryLink());
			String queryHql = qpr.getQueryHql("model");
			paramList = qpr.getQueryParam();
			if(!StringUtils.isEmpty(queryHql))
				hql += queryHql;
		}
		
		hql += " order by ";
		if(queryParam != null &&
				(!StringUtils.isEmpty(queryParam.getOrderParamStr()) ||
				!StringUtils.isEmpty(queryParam.getCustomOrderParamStr()))){
			OrderParamReader opr = new OrderParamReader(queryParam.getOrderParamStr(), queryParam.getCustomOrderParamStr());
			hql += opr.getOrderString("model") + ",";
		}
		hql += " model.id desc";
		
		List<TestMeterCodeData> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<TestMeterCodeDataReturn> result = new ArrayList<TestMeterCodeDataReturn>();
		if(list != null && list.size() > 0){
			for(TestMeterCodeData item : list){
				TestMeterCodeDataReturn tmcdr = (TestMeterCodeDataReturn) ObjectMapping.objMapping(item, new TestMeterCodeDataReturn());
				result.add(tmcdr);
			}
		}
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from TestMeterCodeData model where 1=1 ";
		List<Object> paramList = new ArrayList<Object>();
		
		if(queryParam != null && 
				!StringUtils.isEmpty(queryParam.getQueryValue()) &&
				!StringUtils.isEmpty(queryParam.getQueryCon()) &&
				!StringUtils.isEmpty(queryParam.getQueryLink())){
			QueryParamReader qpr = new QueryParamReader(queryParam.getQueryValue(), queryParam.getQueryCon(), queryParam.getQueryLink());
			String queryHql = qpr.getQueryHql("model");
			paramList = qpr.getQueryParam();
			if(!StringUtils.isEmpty(queryHql))
				hql += queryHql;
		}
		
		Integer count = Integer.valueOf("0");
		if(paramList.size() > 0)
			count = this.commonHibernateDao.countBy(hql, paramList.toArray());
		else
			count = this.commonHibernateDao.count(hql);
		
		return count;
	}

}
