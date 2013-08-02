package com.ymsino.esb.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.MapMapping;
import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.hql.OrderParamReader;
import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.hql.QueryParamReader;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.manager.dal.RoleDao;
import com.ymsino.esb.manager.model.Role;
import com.ymsino.esb.manager.service.api.RoleService;
import com.ymsino.esb.manager.vo.RoleModifyParam;
import com.ymsino.esb.manager.vo.RoleReturn;
import com.ymsino.esb.manager.vo.RoleSaveParam;

public class RoleServiceImpl implements RoleService {

	private Logger logger = Logger.getLogger(RoleServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ProducerTemplate camelTemplate;
	private RoleDao roleDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	public void setCamelTemplate(ProducerTemplate camelTemplate) {
		this.camelTemplate = camelTemplate;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Long save(RoleSaveParam vo, Boolean async) {
		
		if(vo == null){
			logger.error("save:角色参数对象为空");
			throw new RuntimeException("角色参数对象为空");
		}
		if(async!= null && !async){
			return roleDao.insert((Map<String, Object>) MapMapping.obj2map(vo));
		}else{
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "insert");
			header.put("beanName", "roleDao");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.gdcct.ec.manager.dal", ExchangePattern.InOnly, MapMapping.obj2map(vo), header);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean modify(RoleModifyParam vo, Boolean async) {
		
		if(vo == null || vo.getId() == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		Role po = this.getRoleById(vo.getId());
		if(po == null){
			logger.error("modify:角色未持久化");
			throw new RuntimeException("角色未持久化");
		}
		
		if(async!= null && !async){
			return roleDao.update((Map<String, Object>) MapMapping.obj2map(vo));
		}else{
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "update");
			header.put("beanName", "roleDao");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.gdcct.ec.manager.dal", ExchangePattern.InOnly, MapMapping.obj2map(vo), header);
		}
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean delete(Long id, Boolean async) {
		
		if(id == null){
			logger.error("delete:角色id为空");
			throw new RuntimeException("角色id为空");
		}
		
		Role po = this.getRoleById(id);
		if(po == null){
			logger.error("delete:角色未持久化");
			throw new RuntimeException("角色未持久化");
		}
		
		if(async!= null && !async){
			return roleDao.delete(id);
		}else{
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "delete");
			header.put("beanName", "roleDao");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.gdcct.ec.manager.dal", ExchangePattern.InOnly, id, header);
		}
		
		return Boolean.TRUE;
	}

	@Override
	public RoleReturn getById(Long id) {
		
		if(id == null){
			logger.error("getById:角色id为空");
			throw new RuntimeException("角色id为空");
		}
		
		Role po = this.getRoleById(id);
		if(po == null)
			return null;
		
		return (RoleReturn) ObjectMapping.objMapping(po, new RoleReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from Role model where 1=1 ";
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
		hql += " model.id desc ";
		
		List<Role> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<RoleReturn> result = new ArrayList<RoleReturn>();
		if(list != null && list.size() > 0){
			for(Role item : list){
				RoleReturn rr = (RoleReturn) ObjectMapping.objMapping(item, new RoleReturn());
				result.add(rr);
			}
		}
		
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from Role model where 1=1 ";
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

	@Override
	public Boolean openStatus(Long id, Boolean async) {
		
		if(id == null){
			logger.error("openStatus:角色id为空");
			throw new RuntimeException("角色id为空");
		}
		
		Role po = this.getRoleById(id);
		if(po == null){
			logger.error("openStatus:角色未持久化");
			throw new RuntimeException("角色未持久化");
		}
		
		Map<String, Object> vo = new HashMap<String, Object>();
		vo.put("id", id);
		vo.put("status", Short.valueOf("1"));
		if(async!= null && !async){
			return roleDao.updateStatus(vo);
		}else{
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "updateStatus");
			header.put("beanName", "roleDao");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.gdcct.ec.manager.dal", ExchangePattern.InOnly, vo, header);
		}
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean closeStatus(Long id, Boolean async) {
		
		if(id == null){
			logger.error("closeStatus:角色id为空");
			throw new RuntimeException("角色id为空");
		}
		
		Role po = this.getRoleById(id);
		if(po == null){
			logger.error("closeStatus:角色未持久化");
			throw new RuntimeException("角色未持久化");
		}
		
		Map<String, Object> vo = new HashMap<String, Object>();
		vo.put("id", id);
		vo.put("status", Short.valueOf("-1"));
		if(async!= null && !async){
			return roleDao.updateStatus(vo);
		}else{
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "updateStatus");
			header.put("beanName", "roleDao");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.gdcct.ec.manager.dal", ExchangePattern.InOnly, vo, header);
		}
		
		return Boolean.TRUE;
	}
	
	/**
	 * 根据id获取角色对象(内部使用)
	 * @param id
	 * @return
	 */
	private Role getRoleById(Long id){
		return (Role) this.commonHibernateDao.get(Role.class, id);
	}
}
