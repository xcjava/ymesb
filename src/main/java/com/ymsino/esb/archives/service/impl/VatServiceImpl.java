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
import com.ymsino.esb.archives.model.Vat;
import com.ymsino.esb.archives.service.api.VatService;
import com.ymsino.esb.archives.vo.VatModifyParam;
import com.ymsino.esb.archives.vo.VatReturn;
import com.ymsino.esb.archives.vo.VatSaveParam;
import com.ymsino.esb.manager.domain.ChargingUnitManager;

public class VatServiceImpl implements VatService {

	private Logger logger = Logger.getLogger(VatServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ChargingUnitManager chargingUnitManager;
	public void setChargingUnitManager(ChargingUnitManager chargingUnitManager) {
		this.chargingUnitManager = chargingUnitManager;
	}
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public Long save(VatSaveParam vo) {
		
		if(vo == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		if(vo.getUid() == null){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		Vat model = (Vat) ObjectMapping.objMapping(vo, new Vat());
		model.setCreateTimestamp(new Date().getTime());
		if(!StringUtils.isEmpty(model.getChargingUnitId()))
			model.setParentUnits(chargingUnitManager.getParentUnitIds(model.getChargingUnitId()));
		
		return (Long) this.commonHibernateDao.save(model);
	}

	@Override
	public Boolean modify(VatModifyParam vo) {
		
		if(vo == null || vo.getId() == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		Vat po = (Vat) this.commonHibernateDao.get(Vat.class, vo.getId());
		if(po == null){
			logger.error("modify:增值税未持久化");
			throw new RuntimeException("增值税未持久化");
		}
		
		if(vo.getChargingUnitId() != null && vo.getChargingUnitId().equals(po.getChargingUnitId())){
			if("".equals(vo.getChargingUnitId()))
				po.setParentUnits(null);
			else
				po.setParentUnits(chargingUnitManager.getParentUnitIds(vo.getChargingUnitId()));
			
		}
		vo.setId(null);
		ObjectMapping.objMapping(vo, po, false);
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean delete(Long id) {
		
		if(id == null){
			logger.error("delete:增值税id为空");
			throw new RuntimeException("增值税id为空");
		}
		
		Vat po = (Vat) this.commonHibernateDao.get(Vat.class, id);
		if(po == null){
			logger.error("delete:增值税未持久化");
			throw new RuntimeException("增值税未持久化");
		}
		
		this.commonHibernateDao.delete(po);
		return Boolean.TRUE;
	}

	@Override
	public VatReturn getById(Long id) {
		
		if(id == null)
			return null;
		
		Vat po = (Vat) this.commonHibernateDao.get(Vat.class, id);
		if(po == null)
			return null;
		
		return (VatReturn) ObjectMapping.objMapping(po, new VatReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VatReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from Vat model where 1=1 ";
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
		
		List<Vat> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<VatReturn> result = new ArrayList<VatReturn>();
		if(list != null && list.size() > 0){
			for(Vat item : list){
				VatReturn vr = (VatReturn) ObjectMapping.objMapping(item, new VatReturn());
				result.add(vr);
			}
		}
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from Vat model where 1=1 ";
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
