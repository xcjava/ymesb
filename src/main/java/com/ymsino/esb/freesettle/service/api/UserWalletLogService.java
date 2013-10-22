package com.ymsino.esb.freesettle.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.freesettle.vo.UserWalletLogReturn;

@WebService
public interface UserWalletLogService {

	/**
	 * 根据查询参数获取用户余额日志分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取用户余额日志分页列表")
	public List<UserWalletLogReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取用户余额日志总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取用户余额日志总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
