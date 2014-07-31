package com.ymsino.esb.archives.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.hql.OrderParamReader;
import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.hql.QueryParamReader;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.archives.model.Concentrator;
import com.ymsino.esb.archives.service.api.ConcentratorService;
import com.ymsino.esb.archives.vo.ConcentratorModifyParam;
import com.ymsino.esb.archives.vo.ConcentratorReturn;
import com.ymsino.esb.archives.vo.ConcentratorSaveParam;
import com.ymsino.esb.manager.domain.ChargingUnitManager;

public class ConcentratorServiceImpl implements ConcentratorService {

	private Logger logger = Logger.getLogger(ConcentratorServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
	private ChargingUnitManager chargingUnitManager;
	public void setChargingUnitManager(ChargingUnitManager chargingUnitManager) {
		this.chargingUnitManager = chargingUnitManager;
	}
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public Boolean save(ConcentratorSaveParam vo) {
		
		if(vo == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		if(StringUtils.isEmpty(vo.getLogicCode()) ||
				StringUtils.isEmpty(vo.getAreaCode())){
			logger.error("save:缺少必要属性");
			throw new RuntimeException("缺少必要属性");
		}
		
		String regex_area = "[0-9]{4}";
		String regex_logic = "[0-9]{1,4}";
		if(!this.isRegexValidate(vo.getAreaCode(), regex_area)){
			logger.error("save:区域码格式不正确");
			throw new RuntimeException("区域码格式不正确");
		}
		
		if(!this.isRegexValidate(vo.getLogicCode(), regex_logic)){
			logger.error("save:逻辑地址格式不正确");
			throw new RuntimeException("逻辑地址格式不正确");
		}
		
		//String hardwareId = vo.getAreaCode();
		String logicCode = vo.getLogicCode();
		int length = logicCode.length();
		for(int i = 0; i < 4 - length; i++){
			logicCode = "0" + logicCode;
		}
		//hardwareId = hardwareId + logicCode.substring(2, 4) + logicCode.substring(0, 2);
		String hardwareId = logicCode + vo.getAreaCode().substring(2, 4) + vo.getAreaCode().substring(0, 2);
		
		if(this.getById(hardwareId) != null){
			logger.error("save:集中器编码已经存在，不能重复添加");
			throw new RuntimeException("集中器编码已经存在，不能重复添加");
		}
		
		Concentrator model = (Concentrator) ObjectMapping.objMapping(vo, new Concentrator());
		model.setHardwareId(hardwareId);
		model.setCreateTimestamp(new Date().getTime());
		model.setStatus(Short.valueOf("-1"));
		if(!StringUtils.isEmpty(model.getChargingUnitId()))
			model.setParentUnits(chargingUnitManager.getParentUnitIds(model.getChargingUnitId()));
		
		this.commonHibernateDao.save(model);
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean modify(ConcentratorModifyParam vo) {
		
		if(vo == null || StringUtils.isEmpty(vo.getHardwareId())){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		Concentrator po = (Concentrator) this.commonHibernateDao.get(Concentrator.class, vo.getHardwareId().trim());
		if(po == null){
			logger.error("modify:集中器未持久化");
			throw new RuntimeException("集中器未持久化");
		}
		
		if(vo.getChargingUnitId() != null && !vo.getChargingUnitId().equals(po.getChargingUnitId())){
			if("".equals(vo.getChargingUnitId()))
				po.setParentUnits(null);
			else
				po.setParentUnits(chargingUnitManager.getParentUnitIds(vo.getChargingUnitId()));
			
		}
		vo.setHardwareId(null);
		ObjectMapping.objMapping(vo, po, false);
		
		return Boolean.TRUE;
	}

	@Override
	public ConcentratorReturn getById(String hardwareId) {
		
		if(StringUtils.isEmpty(hardwareId))
			return null;
		
		Concentrator po = (Concentrator) this.commonHibernateDao.get(Concentrator.class, hardwareId.trim());
		if(po == null)
			return null;
		
		return (ConcentratorReturn) ObjectMapping.objMapping(po, new ConcentratorReturn());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConcentratorReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		
		String hql = "from Concentrator model where 1=1 ";
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
		
		List<Concentrator> list = null;
		if(paramList.size()>0){
			list = this.commonHibernateDao.findBy(hql, paramList.toArray(), startRow, pageSize);
		}else{
			list = this.commonHibernateDao.find(hql, startRow, pageSize);
		}
		
		List<ConcentratorReturn> result = new ArrayList<ConcentratorReturn>();
		if(list != null && list.size() > 0){
			for(Concentrator item : list){
				ConcentratorReturn cr = (ConcentratorReturn) ObjectMapping.objMapping(item, new ConcentratorReturn());
				result.add(cr);
			}
		}
		return result;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		
		String hql = "select count(*) from Concentrator model where 1=1 ";
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
	 * 正则校验（内部使用）
	 * @param source
	 * @param regexp
	 * @return
	 */
	public boolean isRegexValidate(String source, String regexp){
		Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(source);
        return m.matches();
	}
}
