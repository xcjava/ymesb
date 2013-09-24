package com.ymsino.esb.archives.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.archives.vo.WaterMeterModifyParam;
import com.ymsino.esb.archives.vo.WaterMeterReturn;
import com.ymsino.esb.archives.vo.WaterMeterSaveParam;

@WebService
public interface WaterMeterService {

	/**
	 * 保存水表
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存水表")
	public Boolean save(@WebParam(name="waterMeterSaveParam")WaterMeterSaveParam vo);
	
	/**
	 * 修改水表
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改水表")
	public Boolean modify(@WebParam(name="waterMeterModifyParam")WaterMeterModifyParam vo);
	
	/**
	 * 根据水表号获取水表
	 * @param hardwareId
	 * @return
	 */
	@WSDLDocumentation("根据水表号获取水表")
	public WaterMeterReturn getById(@WebParam(name="hardwareId")String hardwareId);
	
	/**
	 * 根据查询参数获取水表分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取水表分页列表")
	public List<WaterMeterReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取水表总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取水表总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
