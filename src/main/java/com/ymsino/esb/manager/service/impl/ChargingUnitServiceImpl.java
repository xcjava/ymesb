package com.ymsino.esb.manager.service.impl;

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
import com.ymsino.esb.manager.domain.ChargingUnitManager;
import com.ymsino.esb.manager.model.ChargingUnit;
import com.ymsino.esb.manager.service.api.ChargingUnitService;
import com.ymsino.esb.manager.vo.ChargingUnitModifyParam;
import com.ymsino.esb.manager.vo.ChargingUnitReturn;
import com.ymsino.esb.manager.vo.ChargingUnitSaveParam;

public class ChargingUnitServiceImpl implements ChargingUnitService {

	private Logger logger = Logger.getLogger(ChargingUnitServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ChargingUnitManager chargingUnitManager;
	public void setChargingUnitManager(ChargingUnitManager chargingUnitManager) {
		this.chargingUnitManager = chargingUnitManager;
	}
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public Boolean save(ChargingUnitSaveParam vo) {
		
		if(vo == null){
			logger.error("save:收费单位参数对象为空");
			throw new RuntimeException("收费单位参数对象为空");
		}
		
		if(StringUtils.isEmpty(vo.getUnitId())){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		ChargingUnit po = (ChargingUnit) this.commonHibernateDao.get(ChargingUnit.class, vo.getUnitId());
		if(po != null){
			logger.error("save:收费单位编码已经存在，不能重复添加");
			throw new RuntimeException("收费单位编码已经存在，不能重复添加");
		}
		
		ChargingUnit model = (ChargingUnit) ObjectMapping.objMapping(vo, new ChargingUnit());
		model.setCreateTimestamp(new Date().getTime());
		model.setStatus(Short.valueOf("0"));
		if(model.getParentUnitId() != null){
			model.setParentUnits(chargingUnitManager.getParentUnitIds(model.getParentUnitId()));
		}
		this.commonHibernateDao.save(model);
		return Boolean.TRUE;
	}

	@Override
	public Boolean modify(ChargingUnitModifyParam vo) {
		
		if(vo == null || StringUtils.isEmpty(vo.getUnitId())){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		ChargingUnit po = (ChargingUnit) this.commonHibernateDao.get(ChargingUnit.class, vo.getUnitId());
		if(po == null){
			logger.error("modify:收费单位未持久化");
			throw new RuntimeException("收费单位未持久化");
		}
		
		if(vo.getLinkAddr() != null)
			po.setLinkAddr(vo.getLinkAddr());
		if(vo.getLinkMan() != null)
			po.setLinkMan(vo.getLinkMan());
		if(vo.getLinkTel() != null)
			po.setLinkTel(vo.getLinkTel());
		if(vo.getName() != null)
			po.setName(vo.getName());
		if(vo.getRemark() != null)
			po.setRemark(vo.getRemark());
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean openStatus(String unitId) {
		
		if(StringUtils.isEmpty(unitId)){
			logger.error("openStatus:收费单位编码为空");
			throw new RuntimeException("收费单位编码为空");
		}
		
		ChargingUnit po = (ChargingUnit) this.commonHibernateDao.get(ChargingUnit.class, unitId.trim());
		if(po == null){
			logger.error("openStatus:收费单位未持久化");
			throw new RuntimeException("收费单位未持久化");
		}
		
		po.setStatus(Short.valueOf("1"));
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean closeStatus(String unitId) {
		
		if(StringUtils.isEmpty(unitId)){
			logger.error("closeStatus:收费单位编码为空");
			throw new RuntimeException("收费单位编码为空");
		}
		
		ChargingUnit po = (ChargingUnit) this.commonHibernateDao.get(ChargingUnit.class, unitId.trim());
		if(po == null){
			logger.error("closeStatus:收费单位未持久化");
			throw new RuntimeException("收费单位未持久化");
		}
		
		String hql = "select count(*) from ChargingUnit model where model.parentUnitId = ?";
		int count = this.commonHibernateDao.countBy(hql, unitId.trim());
		if(count > 0){
			logger.error("closeStatus:收费单位有下级单位，不可删除");
			throw new RuntimeException("收费单位有下级单位，不可删除");
		}
		
		po.setStatus(Short.valueOf("1"));
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean delete(String unitId) {
		
		if(StringUtils.isEmpty(unitId)){
			logger.error("delete:收费单位编码为空");
			throw new RuntimeException("收费单位编码为空");
		}
		
		ChargingUnit po = (ChargingUnit) this.commonHibernateDao.get(ChargingUnit.class, unitId.trim());
		if(po == null){
			logger.error("delete:收费单位未持久化");
			throw new RuntimeException("收费单位未持久化");
		}
		
		if(Short.valueOf("0").equals(po.getStatus())){
			logger.error("delete:非新建状态收费单位不可删除");
			throw new RuntimeException("非新建状态收费单位不可删除");
		}
		
		this.commonHibernateDao.delete(po);
		return Boolean.TRUE;
	}
	
	@Override
	public ChargingUnitReturn getByUnitId(String unitId) {
		
		if(StringUtils.isEmpty(unitId))
			return null;
		
		ChargingUnit po = (ChargingUnit) this.commonHibernateDao.get(ChargingUnit.class, unitId.trim());
		if(po == null)
			return null;
		
		return (ChargingUnitReturn) ObjectMapping.objMapping(po, new ChargingUnitReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChargingUnitReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from ChargingUnit model where 1=1 ";
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
		
		List<ChargingUnit> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<ChargingUnitReturn> result = new ArrayList<ChargingUnitReturn> ();
		if(list != null && list.size() > 0){
			for(ChargingUnit item : list){
				ChargingUnitReturn cur = (ChargingUnitReturn) ObjectMapping.objMapping(item, new ChargingUnitReturn());
				result.add(cur);
			}
		}
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		String hql = "select count(*) from ChargingUnit model where 1=1 ";
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
