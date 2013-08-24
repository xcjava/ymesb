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
import com.ymsino.esb.manager.model.Department;
import com.ymsino.esb.manager.service.api.DepartmentService;
import com.ymsino.esb.manager.vo.ChargingUnitReturn;
import com.ymsino.esb.manager.vo.DepartmentModifyParam;
import com.ymsino.esb.manager.vo.DepartmentReturn;
import com.ymsino.esb.manager.vo.DepartmentSaveParam;

public class DepartmentServiceImpl implements DepartmentService {

	private Logger logger = Logger.getLogger(DepartmentServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ChargingUnitManager chargingUnitManager;
	public void setChargingUnitManager(ChargingUnitManager chargingUnitManager) {
		this.chargingUnitManager = chargingUnitManager;
	}
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public Boolean save(DepartmentSaveParam vo) {
		
		if(vo == null){
			logger.error("save:部门参数对象为空");
			throw new RuntimeException("部门参数对象为空");
		}
		
		if(StringUtils.isEmpty(vo.getDeptId())){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		Department po = (Department) this.commonHibernateDao.get(Department.class, vo.getDeptId().trim());
		if(po != null){
			logger.error("save:部门编码已经存在，不能重复添加");
			throw new RuntimeException("部门编码已经存在，不能重复添加");
		}
		
		Department model = (Department) ObjectMapping.objMapping(vo, new Department());
		model.setCreateTimestamp(new Date().getTime());
		model.setStatus(Short.valueOf("0"));
		if(model.getChargingUnitId() != null){
			model.setParentUnits(chargingUnitManager.getParentUnitIds(model.getChargingUnitId()));
		}
		this.commonHibernateDao.save(model);
		return Boolean.TRUE;
	}

	@Override
	public Boolean modify(DepartmentModifyParam vo) {
		
		if(vo == null || StringUtils.isEmpty(vo.getDeptId())){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		Department po = (Department) this.commonHibernateDao.get(Department.class, vo.getDeptId().trim());
		if(po == null){
			logger.error("modify:部门未持久化");
			throw new RuntimeException("部门未持久化");
		}
		
		if(vo.getLinkAddr() != null)
			po.setLinkAddr(vo.getLinkAddr());
		if(vo.getLinkMan() != null)
			po.setLinkMan(vo.getLinkMan());
		if(vo.getLinkTel() != null)
			po.setLinkTel(vo.getLinkTel());
		if(vo.getName() != null)
			po.setName(vo.getName());
		if(vo.getPopedomJson() != null)
			po.setPopedomJson(vo.getPopedomJson());
		if(vo.getRemark() != null)
			po.setRemark(vo.getRemark());
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean openStatus(String deptId) {
		
		if(StringUtils.isEmpty(deptId)){
			logger.error("openStatus:部门编码为空");
			throw new RuntimeException("部门编码为空");
		}
		
		Department po = (Department) this.commonHibernateDao.get(Department.class, deptId.trim());
		if(po == null){
			logger.error("openStatus:部门未持久化");
			throw new RuntimeException("部门未持久化");
		}
		
		po.setStatus(Short.valueOf("1"));
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean closeStatus(String deptId) {
		
		if(StringUtils.isEmpty(deptId)){
			logger.error("closeStatus:部门编码为空");
			throw new RuntimeException("部门编码为空");
		}
		
		Department po = (Department) this.commonHibernateDao.get(Department.class, deptId.trim());
		if(po == null){
			logger.error("closeStatus:部门未持久化");
			throw new RuntimeException("部门未持久化");
		}
		
		String hql = "select count(*) from Department model where model.parentDeptId = ?";
		int count = this.commonHibernateDao.countBy(hql, deptId.trim());
		if(count > 0){
			logger.error("closeStatus:部门有下级部门，不可删除");
			throw new RuntimeException("部门有下级部门，不可删除");
		}
		
		po.setStatus(Short.valueOf("1"));
		
		return Boolean.TRUE;
	}

	@Override
	public DepartmentReturn getByDeptId(String deptId) {
		
		if(StringUtils.isEmpty(deptId))
			return null;
		
		Department po = (Department) this.commonHibernateDao.get(Department.class, deptId.trim());
		if(po == null)
			return null;
		
		return (DepartmentReturn) ObjectMapping.objMapping(po, new DepartmentReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		String hql = "from Department model where 1=1 ";
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
		
		List<Department> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<DepartmentReturn> result = new ArrayList<DepartmentReturn> ();
		if(list != null && list.size() > 0){
			for(Department item : list){
				DepartmentReturn dr = (DepartmentReturn) ObjectMapping.objMapping(item, new ChargingUnitReturn());
				result.add(dr);
			}
		}
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		String hql = "select count(*) from Department model where 1=1 ";
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
