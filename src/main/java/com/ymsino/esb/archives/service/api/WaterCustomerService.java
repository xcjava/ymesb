package com.ymsino.esb.archives.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.archives.vo.WaterCustomerModifyParam;
import com.ymsino.esb.archives.vo.WaterCustomerReturn;
import com.ymsino.esb.archives.vo.WaterCustomerSaveParam;

@WebService
public interface WaterCustomerService {

	/**
	 * 保存用水用户和供水点信息
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存用水用户和供水点信息")
	public Boolean save(@WebParam(name="waterCustomerSaveParam")WaterCustomerSaveParam vo);
	
	/**
	 * 修改用水用户及供水点信息
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改用水用户及供水点信息")
	public Boolean modidy(@WebParam(name="waterCustomerModifyParam")WaterCustomerModifyParam vo);
	
	/**
	 * 根据id获取用水用户和供水点信息
	 * @param customerId
	 * @return
	 */
	@WSDLDocumentation("根据id获取用水用户和供水点信息")
	public WaterCustomerReturn getById(@WebParam(name="customerId")String customerId);
	
	/**
	 * 根据查询参数获取用水用户和供水点信息分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取用水用户和供水点信息分页列表")
	public List<WaterCustomerReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取用水用户和供水点信息总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取用水用户和供水点信息总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
