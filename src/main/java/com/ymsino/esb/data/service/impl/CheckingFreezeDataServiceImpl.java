package com.ymsino.esb.data.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.date.DateUtil;
import com.gmail.xcjava.base.hql.OrderParamReader;
import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.hql.QueryParamReader;
import com.gmail.xcjava.base.io.PropertyReader;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.data.domain.WaterDayUsageAmountManager;
import com.ymsino.esb.data.model.CheckingFreezeData;
import com.ymsino.esb.data.service.api.CheckingFreezeDataService;
import com.ymsino.esb.data.vo.CheckingFreezeDataModifyParam;
import com.ymsino.esb.data.vo.CheckingFreezeDataReturn;

public class CheckingFreezeDataServiceImpl implements CheckingFreezeDataService {

	private Logger logger = Logger.getLogger(CheckingFreezeDataServiceImpl.class);
	private String settleDate = PropertyReader.getProperties("config.properties").getProperty("data.settleDate");
	private CommonHibernateDao commonHibernateDao;
	private WaterDayUsageAmountManager waterDayUsageAmountManager;
	public void setWaterDayUsageAmountManager(
			WaterDayUsageAmountManager waterDayUsageAmountManager) {
		this.waterDayUsageAmountManager = waterDayUsageAmountManager;
	}

	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public Boolean modify(CheckingFreezeDataModifyParam vo) {
		
		if(vo == null || vo.getId() == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		CheckingFreezeData po = (CheckingFreezeData) this.commonHibernateDao.get(CheckingFreezeData.class, vo.getId());
		if(po == null){
			logger.error("modify:水表冻结审核数据未持久化");
			throw new RuntimeException("水表冻结审核数据未持久化");
		}
		
		Date today = new Date();
		Date freezeDate = DateUtil.parseDate("20" + po.getFreezeYear() + "-" + po.getFreezeMonth() + "-" + settleDate, "yyyy-MM-dd HH:mm:ss");
		freezeDate = DateUtil.addMonth(freezeDate, 1);
		if(today.getTime() > freezeDate.getTime()){
			logger.error("modify:水表冻结审核数据进入结算流程，无法修改");
			throw new RuntimeException("水表冻结审核数据进入结算流程，无法修改");
		}
		
		vo.setId(null);
		ObjectMapping.objMapping(vo, po, false);
		
		waterDayUsageAmountManager.saveByCheckingFreezeData(po);
		
		return Boolean.TRUE;
	}

	@Override
	public CheckingFreezeDataReturn getById(Long id) {
		
		if(id == null)
			return null;
		
		CheckingFreezeData po = (CheckingFreezeData) this.commonHibernateDao.get(CheckingFreezeData.class, id);
		if(po == null)
			return null;
		
		return (CheckingFreezeDataReturn) ObjectMapping.objMapping(po, new CheckingFreezeDataReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckingFreezeDataReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from CheckingFreezeData model where 1=1 ";
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
		
		List<CheckingFreezeData> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<CheckingFreezeDataReturn> result = new ArrayList<CheckingFreezeDataReturn>();
		if(list != null && list.size() > 0){
			for(CheckingFreezeData item : list){
				CheckingFreezeDataReturn cfdr = (CheckingFreezeDataReturn) ObjectMapping.objMapping(item, new CheckingFreezeDataReturn());
				result.add(cfdr);
			}
		}
		
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from CheckingFreezeData model where 1=1 ";
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
