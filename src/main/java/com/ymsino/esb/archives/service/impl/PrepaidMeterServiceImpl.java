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
import com.ymsino.esb.archives.model.PrepaidMeter;
import com.ymsino.esb.archives.service.api.PrepaidMeterService;
import com.ymsino.esb.archives.vo.PrepaidMeterModifyParam;
import com.ymsino.esb.archives.vo.PrepaidMeterReturn;
import com.ymsino.esb.archives.vo.PrepaidMeterSaveParam;
import com.ymsino.esb.manager.domain.ChargingUnitManager;

public class PrepaidMeterServiceImpl implements PrepaidMeterService {

	private Logger logger = Logger.getLogger(PrepaidMeterServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ChargingUnitManager chargingUnitManager;
	public void setChargingUnitManager(ChargingUnitManager chargingUnitManager) {
		this.chargingUnitManager = chargingUnitManager;
	}
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public Boolean save(PrepaidMeterSaveParam vo) {
		
		if(vo == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		if(StringUtils.isEmpty(vo.getPmSn()) || vo.getType() == null){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		if(this.getBySn(vo.getPmSn().trim()) != null){
			logger.error("save:水表编码已经存在，不能重复添加");
			throw new RuntimeException("水表编码已经存在，不能重复添加");
		}
		
		PrepaidMeter model = (PrepaidMeter) ObjectMapping.objMapping(vo, new PrepaidMeter());
		model.setCreateTimestamp(new Date().getTime());
		if(!StringUtils.isEmpty(model.getChargingUnitId()))
			model.setParentUnits(chargingUnitManager.getParentUnitIds(model.getChargingUnitId()));
		
		this.commonHibernateDao.save(model);
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean modify(PrepaidMeterModifyParam vo) {
		
		if(vo == null || StringUtils.isEmpty(vo.getPmSn())){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		PrepaidMeter po = (PrepaidMeter) this.commonHibernateDao.get(PrepaidMeter.class, vo.getPmSn().trim());
		if(po == null){
			logger.error("modify:预付费水表未持久化");
			throw new RuntimeException("预付费水表未持久化");
		}
		if(vo.getChargingUnitId() != null && vo.getChargingUnitId().equals(po.getChargingUnitId())){
			if("".equals(vo.getChargingUnitId()))
				po.setParentUnits(null);
			else
				po.setParentUnits(chargingUnitManager.getParentUnitIds(vo.getChargingUnitId()));
			
		}
		vo.setPmSn(null);
		ObjectMapping.objMapping(vo, po, false);
		
		return Boolean.TRUE;
	}

	@Override
	public PrepaidMeterReturn getBySn(String pmSn) {
		
		if(StringUtils.isEmpty(pmSn))
			return null;
		
		PrepaidMeter po = (PrepaidMeter) this.commonHibernateDao.get(PrepaidMeter.class, pmSn.trim());
		if(po == null)
			return null;
		
		return (PrepaidMeterReturn) ObjectMapping.objMapping(po, new PrepaidMeterReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PrepaidMeterReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from PrepaidMeter model where 1=1 ";
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
		hql += " model.createTimestamp desc";
		
		List<PrepaidMeter> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<PrepaidMeterReturn> result = new ArrayList<PrepaidMeterReturn>();
		if(list != null && list.size() > 0){
			for(PrepaidMeter item : list){
				PrepaidMeterReturn pmr = (PrepaidMeterReturn) ObjectMapping.objMapping(item, new PrepaidMeterReturn());
				result.add(pmr);
			}
		}
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from PrepaidMeter model where 1=1 ";
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
