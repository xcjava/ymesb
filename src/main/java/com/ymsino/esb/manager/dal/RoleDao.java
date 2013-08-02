package com.ymsino.esb.manager.dal;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmail.xcjava.base.dataMapping.MapMapping;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.manager.model.Manager;
import com.ymsino.esb.manager.model.Role;

public class RoleDao {

	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	public Long insert(Map<String, Object> param){
		
		Role model = (Role) MapMapping.map2obj(param, new Role());
		if(!StringUtils.isEmpty(model.getCreaterId()))
			model.setCreaterId(model.getCreaterId().trim().toLowerCase());
		model.setCreateTimestamp(new Date().getTime());
		model.setStatus(Short.valueOf("0"));
		
		return (Long) this.commonHibernateDao.save(model);
	}
	
	public Boolean update(Map<String, Object> param){
		
		Role po = (Role) this.commonHibernateDao.get(Role.class, (Long)param.get("id"));
		if(param.get("name") != null)
			po.setName((String) param.get("name"));
		if(param.get("description") != null)
			po.setDescription((String) param.get("description"));
		if(param.get("popedomJson") != null)
			po.setPopedomJson((String) param.get("popedomJson"));
		
		return Boolean.TRUE;
	}
	
	public Boolean delete(Long id){
		
		Role po = (Role) this.commonHibernateDao.get(Role.class, id);
		this.commonHibernateDao.delete(po);
		this.clearRoleForManager(id);
		
		return Boolean.TRUE;
	}
	
	public Boolean updateStatus(Map<String, Object> param){
		
		Role po = (Role) this.commonHibernateDao.get(Role.class, (Long)param.get("id"));
		if(param.get("status") != null)
			po.setStatus((Short) param.get("status"));
		
		return Boolean.TRUE;
	}
	
	/**
	 * 清除管理员绑定的已删除的角色信息
	 * @param roleId
	 */
	@SuppressWarnings("unchecked")
	private void clearRoleForManager(Long roleId){
		
		String hql = "from Manager model where 1=1";
		List<Manager> list = this.commonHibernateDao.find(hql);
		for(Manager item : list){
			String roles = item.getRoles();
			if(StringUtils.isEmpty(roles))continue;
			
			if(roles.contains(roleId.toString())){
				roles = roles.replace("|" + roleId + "|", "");
				item.setRoles(roles);
			}
			
		}
	}
}
