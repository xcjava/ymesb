package com.ymsino.esb.archives.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.archives.vo.PrepaidMeterModifyParam;
import com.ymsino.esb.archives.vo.PrepaidMeterReturn;
import com.ymsino.esb.archives.vo.PrepaidMeterSaveParam;

@WebService
public interface PrepaidMeterService {

	/**
	 * 保存预付费水表
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存预付费水表")
	public Boolean save(@WebParam(name="prepaidMeterSaveParam")PrepaidMeterSaveParam vo);
	
	/**
	 * 修改预付费水表
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改预付费水表")
	public Boolean modify(@WebParam(name="prepaidMeterModifyParam")PrepaidMeterModifyParam vo);
	
	/**
	 * 根据水表号获取预付费水表
	 * @param pmSn
	 * @return
	 */
	@WSDLDocumentation("根据水表号获取预付费水表")
	public PrepaidMeterReturn getBySn(@WebParam(name="pmSn")String pmSn);
	
	/**
	 * 根据查询参数获取预付费水表分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取预付费水表分页列表")
	public List<PrepaidMeterReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取预付费水表总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取预付费水表总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
