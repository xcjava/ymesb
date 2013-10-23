package com.ymsino.esb.data.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.data.vo.CheckingFreezeDataModifyParam;
import com.ymsino.esb.data.vo.CheckingFreezeDataReturn;

@WebService
public interface CheckingFreezeDataService {

	/**
	 * 修改水表冻结审核数据
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改水表冻结审核数据")
	public Boolean modify(@WebParam(name="checkingFreezeDataModifyParam")CheckingFreezeDataModifyParam vo);
	
	/**
	 * 根据id获取水表冻结审核数据
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取水表冻结审核数据")
	public CheckingFreezeDataReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取水表冻结审核数据分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取水表冻结审核数据分页列表")
	public List<CheckingFreezeDataReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取水表冻结审核数据总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取水表冻结审核数据总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
