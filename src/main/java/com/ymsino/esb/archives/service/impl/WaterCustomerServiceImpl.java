package com.ymsino.esb.archives.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.hql.OrderParamReader;
import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.hql.QueryParamReader;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.archives.model.WaterCustomer;
import com.ymsino.esb.archives.service.api.WaterCustomerService;
import com.ymsino.esb.archives.vo.WaterCustomerModifyParam;
import com.ymsino.esb.archives.vo.WaterCustomerReturn;
import com.ymsino.esb.archives.vo.WaterCustomerSaveParam;
import com.ymsino.esb.manager.domain.ChargingUnitManager;

public class WaterCustomerServiceImpl implements WaterCustomerService {

	private Logger logger = Logger.getLogger(WaterCustomerServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ChargingUnitManager chargingUnitManager;
	public void setChargingUnitManager(ChargingUnitManager chargingUnitManager) {
		this.chargingUnitManager = chargingUnitManager;
	}
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public Boolean save(WaterCustomerSaveParam vo) {
		
		if(vo == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		if(vo.getUid() == null || StringUtils.isEmpty(vo.getCustomerId())){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		if(this.getById(vo.getCustomerId()) != null){
			logger.error("save:用水用户编码已经存在，不可重复添加");
			throw new RuntimeException("用水用户编码已经存在，不可重复添加");
		}
		
		WaterCustomer model = (WaterCustomer) ObjectMapping.objMapping(vo, new WaterCustomer());
		model.setCreateTimestamp(new Date().getTime());
		if(!StringUtils.isEmpty(model.getChargingUnitId()))
			model.setParentUnits(chargingUnitManager.getParentUnitIds(model.getChargingUnitId()));
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean modidy(WaterCustomerModifyParam vo) {
		
		if(vo == null || StringUtils.isEmpty(vo.getCustomerId())){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		WaterCustomer po = (WaterCustomer) this.commonHibernateDao.get(WaterCustomer.class, vo.getCustomerId().trim());
		if(po == null){
			logger.error("modify:用水用户未持久化");
			throw new RuntimeException("用水用户未持久化");
		}
		
		if(vo.getChargingUnitId() != null && vo.getChargingUnitId().equals(po.getChargingUnitId())){
			if("".equals(vo.getChargingUnitId()))
				po.setParentUnits(null);
			else
				po.setParentUnits(chargingUnitManager.getParentUnitIds(vo.getChargingUnitId()));
			
		}
		vo.setCustomerId(null);
		ObjectMapping.objMapping(vo, po, false);
		
		return Boolean.TRUE;
	}

	@Override
	public WaterCustomerReturn getById(String customerId) {
		
		if(StringUtils.isEmpty(customerId))
			return null;
		
		WaterCustomer po = (WaterCustomer) this.commonHibernateDao.get(WaterCustomer.class, customerId.trim());
		if(po == null)
			return null;
		
		return (WaterCustomerReturn) ObjectMapping.objMapping(po, new WaterCustomerReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WaterCustomerReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from WaterCustomer model where 1=1 ";
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
		hql += " model.createTimestamp desc, model.customerId desc";
		
		List<WaterCustomer> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<WaterCustomerReturn> result = new ArrayList<WaterCustomerReturn>();
		if(list != null && list.size() > 0){
			for(WaterCustomer item : list){
				WaterCustomerReturn wcr = (WaterCustomerReturn) ObjectMapping.objMapping(item, new WaterCustomerReturn());
				result.add(wcr);
			}
		}
		
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from WaterCustomer model where 1=1 ";
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
