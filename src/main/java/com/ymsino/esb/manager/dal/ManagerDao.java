package com.ymsino.esb.manager.dal;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmail.xcjava.base.dataMapping.MapMapping;
import com.gmail.xcjava.base.security.MD5;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.manager.model.Manager;

public class ManagerDao {

	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	public Boolean insert(Map<String, Object> param){
		
		Manager model = (Manager) MapMapping.map2obj(param, new Manager());
		model.setUserId(model.getUserId().trim().toLowerCase());
		if(!StringUtils.isEmpty(model.getCreaterId()))
			model.setCreaterId(model.getCreaterId().trim().toLowerCase());
		model.setCheckerId(null);
		model.setCheckTimestamp(null);
		model.setCreateTimestamp(new Date().getTime());
		model.setLastLoginTimestamp(null);
		model.setLoginIp(null);
		model.setModifierId(null);
		model.setModifiyTimestamp(null);
		model.setStatus(Short.valueOf("0"));
		model.setPassword(MD5.getMD5(model.getPassword().trim()));
		
		this.commonHibernateDao.save(model);
		return Boolean.TRUE;
	}
	
	public Boolean update(Map<String, Object> param){
		
		Manager po = (Manager) this.commonHibernateDao.get(Manager.class, ((String)param.get("userId")).trim().toLowerCase());
		if(param.get("name") != null)
			po.setName((String) param.get("name"));
		if(param.get("dept") != null)
			po.setDept((String) param.get("dept"));
		if(param.get("password") != null)
			po.setPassword(MD5.getMD5(((String)param.get("password"))).trim());
		if(param.get("position") != null)
			po.setPosition((String) param.get("position"));
		if(param.get("email") != null)
			po.setEmail((String) param.get("email"));
		if(param.get("tel") != null)
			po.setTel((String) param.get("tel"));
		if(param.get("modifierId") != null)
			po.setModifierId(((String) param.get("modifierId")).trim().toLowerCase());
		if(param.get("roles") != null)
			po.setRoles((String) param.get("roles"));
		po.setModifiyTimestamp(new Date().getTime());
		
		return Boolean.TRUE;
	}
	
	public Boolean updateStatus(Map<String, Object> param){
		
		Manager po = (Manager) this.commonHibernateDao.get(Manager.class, ((String)param.get("userId")).trim().toLowerCase());
		if(param.get("status") != null)
			po.setStatus((Short) param.get("status"));
		if(param.get("checkerId") != null)
			po.setCheckerId(((String) param.get("checkerId")).trim().toLowerCase());
		po.setCheckTimestamp(new Date().getTime());
		
		return Boolean.TRUE;
	}
}
