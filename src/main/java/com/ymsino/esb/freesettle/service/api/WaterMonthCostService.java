package com.ymsino.esb.freesettle.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.freesettle.vo.WaterMonthCostReturn;

@WebService
public interface WaterMonthCostService {

	/**
	 * 根据id获取水表月费用对象
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取水表月费用对象")
	public WaterMonthCostReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取水表月费用分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取水表月费用分页列表")
	public List<WaterMonthCostReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取水表月费用总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取水表月费用总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
