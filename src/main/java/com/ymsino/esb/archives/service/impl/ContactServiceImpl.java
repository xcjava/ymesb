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
import com.ymsino.esb.archives.model.Contact;
import com.ymsino.esb.archives.service.api.ContactService;
import com.ymsino.esb.archives.vo.ContactModifyParam;
import com.ymsino.esb.archives.vo.ContactReturn;
import com.ymsino.esb.archives.vo.ContactSaveParam;
import com.ymsino.esb.manager.domain.ChargingUnitManager;

public class ContactServiceImpl implements ContactService {

	private Logger logger = Logger.getLogger(ContactServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ChargingUnitManager chargingUnitManager;
	public void setChargingUnitManager(ChargingUnitManager chargingUnitManager) {
		this.chargingUnitManager = chargingUnitManager;
	}
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public Long save(ContactSaveParam vo) {
		
		if(vo == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		if(vo.getUid() == null){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		Contact model = (Contact) ObjectMapping.objMapping(vo, new Contact());
		model.setCreateTimestamp(new Date().getTime());
		if(!StringUtils.isEmpty(model.getChargingUnitId()))
			model.setParentUnits(chargingUnitManager.getParentUnitIds(model.getChargingUnitId()));
		
		return (Long) this.commonHibernateDao.save(model);
	}

	@Override
	public Boolean modify(ContactModifyParam vo) {
		
		if(vo == null || vo.getId() == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		Contact po = (Contact) this.commonHibernateDao.get(Contact.class, vo.getId());
		if(po == null){
			logger.error("modify:联系信息未持久化");
			throw new RuntimeException("联系信息未持久化");
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
			logger.error("delete:联系信息id为空");
			throw new RuntimeException("联系信息id为空");
		}
		
		Contact po = (Contact) this.commonHibernateDao.get(Contact.class, id);
		if(po == null){
			logger.error("delete:联系信息未持久化");
			throw new RuntimeException("联系信息未持久化");
		}
		
		this.commonHibernateDao.delete(po);
		return Boolean.TRUE;
	}

	@Override
	public ContactReturn getById(Long id) {
		
		if(id == null)
			return null;
		
		Contact po = (Contact) this.commonHibernateDao.get(Contact.class, id);
		if(po == null)
			return null;
		
		return (ContactReturn) ObjectMapping.objMapping(po, new ContactReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from Contact model where 1=1 ";
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
		
		List<Contact> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<ContactReturn> result = new ArrayList<ContactReturn>();
		if(list != null && list.size() > 0){
			for(Contact item : list){
				ContactReturn cr = (ContactReturn) ObjectMapping.objMapping(item, new ContactReturn());
				result.add(cr);
			}
		}
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from Contact model where 1=1 ";
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
