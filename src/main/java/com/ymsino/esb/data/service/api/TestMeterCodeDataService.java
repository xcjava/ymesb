package com.ymsino.esb.data.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.data.vo.TestMeterCodeDataReturn;

@WebService
public interface TestMeterCodeDataService {

	/**
	 * 根据id获取集中器实时召测表码
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取集中器实时召测表码")
	public TestMeterCodeDataReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取集中器实时召测表码分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取集中器实时召测表码分页列表")
	public List<TestMeterCodeDataReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取集中器实时召测表码总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取集中器实时召测表码总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
