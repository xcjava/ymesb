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
import com.ymsino.esb.archives.model.WaterMeter;
import com.ymsino.esb.archives.service.api.WaterMeterService;
import com.ymsino.esb.archives.vo.WaterMeterModifyParam;
import com.ymsino.esb.archives.vo.WaterMeterReturn;
import com.ymsino.esb.archives.vo.WaterMeterSaveParam;
import com.ymsino.esb.manager.domain.ChargingUnitManager;

public class WaterMeterServiceImpl implements WaterMeterService {

	private Logger logger = Logger.getLogger(WaterMeterServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ChargingUnitManager chargingUnitManager;
	public void setChargingUnitManager(ChargingUnitManager chargingUnitManager) {
		this.chargingUnitManager = chargingUnitManager;
	}
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public Boolean save(WaterMeterSaveParam vo) {
		
		if(vo == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		if(StringUtils.isEmpty(vo.getHardwareId()) ||
				vo.getType() == null ||
				vo.getInitialYards() == null){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		if(this.getById(vo.getHardwareId().trim()) != null){
			logger.error("save:水表编码已经存在，不能重复添加");
			throw new RuntimeException("水表编码已经存在，不能重复添加");
		}
		
		WaterMeter model =  (WaterMeter) ObjectMapping.objMapping(vo, new WaterMeter());
		model.setCreateTimestamp(new Date().getTime());
		if(!StringUtils.isEmpty(model.getChargingUnitId()))
			model.setParentUnits(chargingUnitManager.getParentUnitIds(model.getChargingUnitId()));
		
		this.commonHibernateDao.save(model);
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean modify(WaterMeterModifyParam vo) {
		
		if(vo == null || StringUtils.isEmpty(vo.getHardwareId())){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		WaterMeter po = (WaterMeter) this.commonHibernateDao.get(WaterMeter.class, vo.getHardwareId().trim());
		if(po == null){
			logger.error("modify:水表未持久化");
			throw new RuntimeException("水表未持久化");
		}
		if(vo.getChargingUnitId() != null && !vo.getChargingUnitId().equals(po.getChargingUnitId())){
			if("".equals(vo.getChargingUnitId()))
				po.setParentUnits(null);
			else
				po.setParentUnits(chargingUnitManager.getParentUnitIds(vo.getChargingUnitId()));
			
		}
		vo.setHardwareId(null);
		ObjectMapping.objMapping(vo, po, false);
		
		return Boolean.TRUE;
	}

	@Override
	public WaterMeterReturn getById(String hardwareId) {
		
		if(StringUtils.isEmpty(hardwareId))
			return null;
		
		WaterMeter po = (WaterMeter) this.commonHibernateDao.get(WaterMeter.class, hardwareId.trim());
		if(po == null)
			return null;
		
		return (WaterMeterReturn) ObjectMapping.objMapping(po, new WaterMeterReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WaterMeterReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from WaterMeter model where 1=1 ";
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
		
		List<WaterMeter> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<WaterMeterReturn> result = new ArrayList<WaterMeterReturn>();
		if(list != null && list.size() > 0){
			for(WaterMeter item : list){
				WaterMeterReturn wmr = (WaterMeterReturn) ObjectMapping.objMapping(item, new WaterMeterReturn());
				result.add(wmr);
			}
		}
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from WaterMeter model where 1=1 ";
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
