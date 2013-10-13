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
import com.gmail.xcjava.base.security.MD5;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.manager.domain.ChargingUnitManager;
import com.ymsino.esb.manager.model.Manager;
import com.ymsino.esb.manager.service.api.ManagerService;
import com.ymsino.esb.manager.vo.ManagerModifyParam;
import com.ymsino.esb.manager.vo.ManagerReturn;
import com.ymsino.esb.manager.vo.ManagerSaveParam;

public class ManagerServiceImpl implements ManagerService {

	private Logger logger = Logger.getLogger(ManagerServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ChargingUnitManager chargingUnitManager;
	public void setChargingUnitManager(ChargingUnitManager chargingUnitManager) {
		this.chargingUnitManager = chargingUnitManager;
	}
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}

	@Override
	public Boolean save(ManagerSaveParam vo) {
		
		if(vo == null){
			logger.error("save:管理员参数对象为空");
			throw new RuntimeException("管理员参数对象为空");
		}
		
		if(StringUtils.isEmpty(vo.getManagerId()) ||
				StringUtils.isEmpty(vo.getPassword()) ||
				StringUtils.isEmpty(vo.getChargingUnitId()) ||
				StringUtils.isEmpty(vo.getDepartmentId())){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		Manager po = this.getManagerByManagerId(vo.getManagerId());
		if(po != null){
			logger.error("save:管理员id已经存在，不能重复添加");
			throw new RuntimeException("管理员id已经存在，不能重复添加");
		}
		
		Manager model = (Manager) ObjectMapping.objMapping(vo, new Manager());
		model.setManagerId(vo.getManagerId().trim().toLowerCase());
		model.setCreateTimestamp(new Date().getTime());
		model.setPassword(MD5.getMD5(vo.getPassword().trim()));
		model.setStatus(Short.valueOf("0"));
		model.setParentUnits(chargingUnitManager.getParentUnitIds(model.getChargingUnitId()));
		this.commonHibernateDao.save(model);
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean modify(ManagerModifyParam vo) {
		
		if(vo == null || StringUtils.isEmpty(vo.getManagerId())){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		Manager po = this.getManagerByManagerId(vo.getManagerId());
		if(po == null){
			logger.error("modify:管理员未持久化");
			throw new RuntimeException("管理员未持久化");
		}
		
		if(vo.getName() != null){
			po.setName(vo.getName());
		}
		if(vo.getPassword() != null){
			po.setPassword(MD5.getMD5(vo.getPassword().trim()));
		}
		if(vo.getTel() != null){
			po.setTel(vo.getTel());
		}
		if(vo.getEmail() != null){
			po.setEmail(vo.getEmail());
		}
		if(vo.getDepartmentId() != null){
			po.setDepartmentId(vo.getDepartmentId());
		}
		if(vo.getChargingUnitId() != null){
			po.setChargingUnitId(vo.getChargingUnitId());
			po.setParentUnits(chargingUnitManager.getParentUnitIds(vo.getChargingUnitId()));
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean openStatus(String mangerId) {
		
		if(StringUtils.isEmpty(mangerId)){
			logger.error("openStatus:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		Manager po = this.getManagerByManagerId(mangerId);
		if(po == null){
			logger.error("openStatus:管理员未持久化");
			throw new RuntimeException("管理员未持久化");
		}
		
		po.setStatus(Short.valueOf("1"));
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean closeStatus(String mangerId) {
		
		if(StringUtils.isEmpty(mangerId)){
			logger.error("closeStatus:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		Manager po = this.getManagerByManagerId(mangerId);
		if(po == null){
			logger.error("closeStatus:管理员未持久化");
			throw new RuntimeException("管理员未持久化");
		}
		
		po.setStatus(Short.valueOf("-1"));
		
		return Boolean.TRUE;
	}

	@Override
	public ManagerReturn getByManagerId(String mangerId) {
		
		if(StringUtils.isEmpty(mangerId)){
			logger.error("getByManagerId:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		Manager po = this.getManagerByManagerId(mangerId.trim());
		if(po == null)
			return null;
		
		return (ManagerReturn) ObjectMapping.objMapping(po, new ManagerReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ManagerReturn login(String mangerId, String password) {
		
		if(StringUtils.isEmpty(mangerId)){
			logger.error("login:管理员id为空");
			throw new RuntimeException("管理员id为空");
		}
		
		if(StringUtils.isEmpty(password)){
			logger.error("login:登录密码为空");
			throw new RuntimeException("登录密码为空");
		}
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(MD5.getMD5(password.trim()));
		paramList.add(mangerId.trim().toLowerCase());
		String hql = "from Manager model where status = 1 and model.password = ? and model.managerId = ?";
		List<Manager> list = this.commonHibernateDao.findBy(hql, paramList.toArray());
		if(list.size() != 1)
			return null;
		else{
			return (ManagerReturn) ObjectMapping.objMapping(list.get(0), new ManagerReturn());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from Manager model where 1=1 and model.managerId != 'administrator' ";
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
		hql += " model.createTimestamp desc, model.managerId desc";
		
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
		
		String hql = "select count(*) from Manager model where 1=1 and model.managerId != 'administrator' ";
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
	 * @param mangerId
	 * @return
	 */
	private Manager getManagerByManagerId(String mangerId){
		return (Manager) this.commonHibernateDao.get(Manager.class, mangerId.trim().toLowerCase());
	}
}
