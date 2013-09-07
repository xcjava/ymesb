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
import com.ymsino.esb.archives.model.BusiAddress;
import com.ymsino.esb.archives.service.api.BusiAddressService;
import com.ymsino.esb.archives.vo.BusiAddressModifyParam;
import com.ymsino.esb.archives.vo.BusiAddressReturn;
import com.ymsino.esb.archives.vo.BusiAddressSaveParam;

public class BusiAddressServiceImpl implements BusiAddressService {

	private Logger logger = Logger.getLogger(BusiAddressServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public Long save(BusiAddressSaveParam vo) {
		
		if(vo == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		if(vo.getUid() == null){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		BusiAddress model = (BusiAddress) ObjectMapping.objMapping(vo, new BusiAddress());
		model.setCreateTimestamp(new Date().getTime());
		return (Long) this.commonHibernateDao.save(model);
	}

	@Override
	public Boolean modify(BusiAddressModifyParam vo) {
		
		if(vo == null || vo.getId() == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		BusiAddress po = (BusiAddress) this.commonHibernateDao.get(BusiAddress.class, vo.getId());
		if(po == null){
			logger.error("modify:业务地址未持久化");
			throw new RuntimeException("业务地址未持久化");
		}
		
		vo.setId(null);
		ObjectMapping.objMapping(vo, po, false);
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean delete(Long id) {
		
		if(id == null){
			logger.error("delete:业务地址id为空");
			throw new RuntimeException("业务地址id为空");
		}
		
		BusiAddress po = (BusiAddress) this.commonHibernateDao.get(BusiAddress.class, id);
		if(po == null){
			logger.error("modify:业务地址未持久化");
			throw new RuntimeException("业务地址未持久化");
		}
		
		this.commonHibernateDao.delete(po);
		return Boolean.TRUE;
	}

	@Override
	public BusiAddressReturn getById(Long id) {
		
		if(id == null)
			return null;
		
		BusiAddress po = (BusiAddress) this.commonHibernateDao.get(BusiAddress.class, id);
		if(po == null)
			return null;
		
		return (BusiAddressReturn) ObjectMapping.objMapping(po, new BusiAddressReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusiAddressReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from BusiAddress model where 1=1 ";
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
		
		List<BusiAddress> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<BusiAddressReturn> result = new ArrayList<BusiAddressReturn>();
		if(list != null && list.size() > 0){
			for(BusiAddress item : list){
				BusiAddressReturn bar = (BusiAddressReturn) ObjectMapping.objMapping(item, new BusiAddressReturn());
				result.add(bar);
			}
		}
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from BusiAddress model where 1=1 ";
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
