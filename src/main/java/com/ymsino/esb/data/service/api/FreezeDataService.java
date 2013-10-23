package com.ymsino.esb.data.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.data.vo.FreezeDataReturn;

@WebService
public interface FreezeDataService {

	/**
	 * 根据id获取水表冻结数据
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取水表冻结数据")
	public FreezeDataReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取水表冻结数据分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取水表冻结数据分页列表")
	public List<FreezeDataReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取水表冻结数据总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取水表冻结数据总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
