package com.ymsino.esb.manager.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.gmail.xcjava.base.str.StringTool;
import com.ymsino.esb.manager.model.ChargingUnit;

public class ChargingUnitManager {

	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	private List<String> unitIds = null;
	
	public String getParentUnitIds(String unitId){
		
		this.unitIds = new ArrayList<String> ();
		this.getUnitIds(unitId);
		
		if(unitIds.size() == 0)
			return null;
		
		String parentUnits = StringTool.mergeList(unitIds, "|");
		return parentUnits;
	}
	
	/**
	 * 递归获取上级收费单位(内部使用)
	 * @param unitId
	 */
	@SuppressWarnings("unchecked")
	private void getUnitIds(String unitId){
		
		if(StringUtils.isEmpty(unitId))
			return;
		
		String hql = "from ChargingUnit model where unitId = ?";
		List<ChargingUnit> list = this.commonHibernateDao.findBy(hql, unitId.trim());
		if(list == null || list.size() == 0)
			return;
		
		this.unitIds.add(list.get(0).getUnitId());
		
		String parentUnitId = list.get(0).getParentUnitId();
		if(StringUtils.isEmpty(parentUnitId)){
			this.getParentUnitIds(parentUnitId);
		}
		
		return;
	}
}
