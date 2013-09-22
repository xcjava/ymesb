package com.ymsino.esb.archives.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.archives.vo.WirelessMeterModifyParam;
import com.ymsino.esb.archives.vo.WirelessMeterReturn;
import com.ymsino.esb.archives.vo.WirelessMeterSaveParam;

@WebService
public interface WirelessMeterService {

	/**
	 * 保存无线智能水表
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存无线智能水表")
	public Boolean save(@WebParam(name="wirelessMeterSaveParam")WirelessMeterSaveParam vo);
	
	/**
	 * 修改无线智能水表
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改无线智能水表")
	public Boolean modify(@WebParam(name="wirelessMeterModifyParam")WirelessMeterModifyParam vo);
	
	/**
	 * 根据水表号获取无线智能水表
	 * @param wmSn
	 * @return
	 */
	@WSDLDocumentation("根据水表号获取无线智能水表")
	public WirelessMeterReturn getBySn(@WebParam(name="wmSn")String wmSn);
	
	/**
	 * 根据查询参数获取无线智能水表分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取无线智能水表分页列表")
	public List<WirelessMeterReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取无线智能水表总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取无线智能水表总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
