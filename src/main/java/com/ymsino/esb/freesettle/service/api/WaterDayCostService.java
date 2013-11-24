package com.ymsino.esb.freesettle.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.freesettle.vo.WaterDayCostReturn;

@WebService
public interface WaterDayCostService {

	/**
	 * 根据id获取水表日费用对象
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取水表日费用对象")
	public WaterDayCostReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取水表日费用分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取水表日费用分页列表")
	public List<WaterDayCostReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取水表日费用总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取水表日费用总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
	
	/**
	 * 结算本月水费
	 * @param dayCostId		本月水费id
	 * @return
	 */
	@WSDLDocumentation("结算本月水费")
	public Boolean settleCost(@WebParam(name="dayCostId")Long dayCostId);
}
