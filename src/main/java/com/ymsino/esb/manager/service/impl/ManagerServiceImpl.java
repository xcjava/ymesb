package com.ymsino.esb.manager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.amazonaws.services.identitymanagement.model.Role;
import com.gmail.xcjava.base.dataMapping.MapMapping;
import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.hql.OrderParamReader;
import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.hql.QueryParamReader;
import com.gmail.xcjava.base.security.MD5;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.gmail.xcjava.base.str.StringTool;
import com.ymsino.esb.manager.dal.ManagerDao;
import com.ymsino.esb.manager.model.Manager;
import com.ymsino.esb.manager.service.api.ManagerService;
import com.ymsino.esb.manager.vo.ManagerModifyParam;
import com.ymsino.esb.manager.vo.ManagerReturn;
import com.ymsino.esb.manager.vo.ManagerSaveParam;
import com.ymsino.esb.manager.vo.RoleReturn;

public class ManagerServiceImpl implements ManagerService {

	private Logger logger = Logger.getLogger(ManagerServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ProducerTemplate camelTemplate;
	private ManagerDao managerDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	public void setCamelTemplate(ProducerTemplate camelTemplate) {
		this.camelTemplate = camelTemplate;
	}
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean save(ManagerSaveParam vo, Boolean async) {
		
		if(vo == null){
			logger.error("save:管理员参数对象为空");
			throw new RuntimeException("管理员参数对象为空");
		}
		
		if(StringUtils.isEmpty(vo.getUserId()) || StringUtils.isEmpty(vo.getPassword())){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		Manager po = this.getManagetByUserId(vo.getUserId());
		if(po != null){
			logger.error("save:管理员id已经存在，不能重复添加");
			throw new RuntimeException("管理员id已经存在，不能重复添加");
		}
		
		if(async!= null && !async){
			return managerDao.insert((Map<String, Object>) MapMapping.obj2map(vo));
		}else{
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "insert");
			header.put("beanName", "managerDao");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.gdcct.ec.manager.dal", ExchangePattern.InOnly, MapMapping.obj2map(vo), header);
		}
		
		return Boolean.TRUE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean modify(ManagerModifyParam vo, Boolean async) {
		
		if(vo == null || StringUtils.isEmpty(vo.getUserId())){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		Manager po = this.getManagetByUserId(vo.getUserId());
		if(po == null){
			logger.error("modify:管理员未持久化");
			throw new RuntimeException("管理员未持久化");
		}
		
		if(async!= null && !async){
			return managerDao.update((Map<String, Object>) MapMapping.obj2map(vo));
		}else{
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "update");
			header.put("beanName", "managerDao");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.gdcct.ec.manager.dal", ExchangePattern.InOnly, MapMapping.obj2map(vo), header);
		}
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean frozenStatus(String userId, String mangerId, Boolean async) {
		
		if(StringUtils.isEmpty(userId)){
			logger.error("frozenStatus:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		if(StringUtils.isEmpty(mangerId)){
			logger.error("frozenStatus:审核管理员为空");
			throw new RuntimeException("审核管理员id为空");
		}
		
		Manager po = this.getManagetByUserId(userId);
		if(po == null){
			logger.error("frozenStatus:管理员未持久化");
			throw new RuntimeException("管理员未持久化");
		}
		
		Map<String, Object> vo = new HashMap<String, Object>();
		vo.put("userId", userId);
		vo.put("checkerId", mangerId);
		vo.put("status", Short.valueOf("-2"));
		if(async!= null && !async){
			return managerDao.updateStatus(vo);
		}else{
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "updateStatus");
			header.put("beanName", "managerDao");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.gdcct.ec.manager.dal", ExchangePattern.InOnly, vo, header);
		}
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean openStatus(String userId, String mangerId, Boolean async) {
		
		if(StringUtils.isEmpty(userId)){
			logger.error("openStatus:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		if(StringUtils.isEmpty(mangerId)){
			logger.error("openStatus:审核管理员为空");
			throw new RuntimeException("审核管理员id为空");
		}
		
		Manager po = this.getManagetByUserId(userId);
		if(po == null){
			logger.error("openStatus:管理员未持久化");
			throw new RuntimeException("管理员未持久化");
		}
		
		Map<String, Object> vo = new HashMap<String, Object>();
		vo.put("userId", userId);
		vo.put("checkerId", mangerId);
		vo.put("status", Short.valueOf("1"));
		if(async!= null && !async){
			return managerDao.updateStatus(vo);
		}else{
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "updateStatus");
			header.put("beanName", "managerDao");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.gdcct.ec.manager.dal", ExchangePattern.InOnly, vo, header);
		}
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean closeStatus(String userId, String mangerId, Boolean async) {
		
		if(StringUtils.isEmpty(userId)){
			logger.error("closeStatus:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		if(StringUtils.isEmpty(mangerId)){
			logger.error("closeStatus:审核管理员为空");
			throw new RuntimeException("审核管理员id为空");
		}
		
		Manager po = this.getManagetByUserId(userId);
		if(po == null){
			logger.error("closeStatus:管理员未持久化");
			throw new RuntimeException("管理员未持久化");
		}
		
		Map<String, Object> vo = new HashMap<String, Object>();
		vo.put("userId", userId);
		vo.put("checkerId", mangerId);
		vo.put("status", Short.valueOf("-1"));
		if(async!= null && !async){
			return managerDao.updateStatus(vo);
		}else{
			Map<String, Object> header = new HashMap<String, Object>();
			header.put("method", "updateStatus");
			header.put("beanName", "managerDao");
			camelTemplate.sendBodyAndHeaders("jms:queue:com.gdcct.ec.manager.dal", ExchangePattern.InOnly, vo, header);
		}
		
		return Boolean.TRUE;
	}

	@Override
	public ManagerReturn getByUserId(String userId) {
		
		if(StringUtils.isEmpty(userId)){
			logger.error("getByUserId:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		Manager po = this.getManagetByUserId(userId);
		if(po == null)
			return null;
		
		return (ManagerReturn) ObjectMapping.objMapping(po, new ManagerReturn());
	}

	@Override
	public List<RoleReturn> getLegalRoles(String userId) {
		
		if(StringUtils.isEmpty(userId)){
			logger.error("getLegalRole:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		Manager po = this.getManagetByUserId(userId);
		if(po == null){
			logger.error("getLegalRole:管理员未持久化");
			throw new RuntimeException("管理员未持久化");
		}
		
		List<RoleReturn> roles = this.getRoles(userId);
		if(roles == null || roles.size() == 0)
			return null;
		
		List<RoleReturn> result = new ArrayList<RoleReturn>();
		for(RoleReturn item : roles){
			if(Short.valueOf("1").equals(item.getStatus()))
				result.add(item);
		}
		
		return result;
	}
	
	@Override
	public List<RoleReturn> getRoles(String userId) {
		
		if(StringUtils.isEmpty(userId)){
			logger.error("getRoles:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		Manager po = this.getManagetByUserId(userId);
		if(po == null){
			logger.error("getRoles:管理员未持久化");
			throw new RuntimeException("管理员未持久化");
		}
		
		String rolesStr = po.getRoles();
		if(StringUtils.isEmpty(rolesStr))
			return null;
		
		List<String> roleIds = StringTool.split(rolesStr, "|");
		List<RoleReturn> result = new ArrayList<RoleReturn>();
		for(String str : roleIds){
			try {
				if(StringUtils.isEmpty(str))continue;
				Role role = (Role) this.commonHibernateDao.get(Role.class, Long.valueOf(str.trim()));
				if(role == null)continue;
				RoleReturn rr = (RoleReturn) ObjectMapping.objMapping(role, new RoleReturn());
				result.add(rr);	
			} catch (Exception e) {
				continue;
			}
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ManagerReturn login(String userId, String password, String loginIp) {
		
		if(StringUtils.isEmpty(userId)){
			logger.error("login:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		if(StringUtils.isEmpty(password)){
			logger.error("login:登录密码为空");
			throw new RuntimeException("登录密码为空");
		}
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(MD5.getMD5(password.trim()));
		paramList.add(userId.trim().toLowerCase());
		String hql = "from Manager model where status = 1 and model.password = ? and model.userId = ?";
		List<Manager> list = this.commonHibernateDao.findBy(hql, paramList.toArray());
		if(list.size() != 1)
			return null;
		else{
			list.get(0).setLoginIp(loginIp);
			list.get(0).setLastLoginTimestamp(new Date().getTime());
			return (ManagerReturn) ObjectMapping.objMapping(list.get(0), new ManagerReturn());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from Manager model where 1=1 and model.userId != 'administrator' ";
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
		hql += " model.createTimestamp desc, model.userId desc";
		
		List<Manager> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<ManagerReturn> result = new ArrayList<ManagerReturn>();
		if(list != null && list.size() > 0){
			for(Manager item : list){
				ManagerReturn mr = (ManagerReturn) ObjectMapping.objMapping(item, new ManagerReturn());
				result.add(mr);
			}
		}
		
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from Manager model where 1=1 and model.userId != 'administrator' ";
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

	/**
	 * 根据管理员id获取管理员实体(内部使用)
	 * @param userId
	 * @return
	 */
	private Manager getManagetByUserId(String userId){
		return (Manager) this.commonHibernateDao.get(Manager.class, userId.trim().toLowerCase());
	}
}
