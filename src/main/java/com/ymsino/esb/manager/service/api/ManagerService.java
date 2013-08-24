package com.ymsino.esb.manager.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.manager.vo.ManagerModifyParam;
import com.ymsino.esb.manager.vo.ManagerReturn;
import com.ymsino.esb.manager.vo.ManagerSaveParam;

@WebService
public interface ManagerService {

	/**
	 * 保存管理员
	 * @param vo		保存管理员参数对象
	 * @return
	 */
	@WSDLDocumentation("保存管理员")
	public Boolean save(@WebParam(name="managerSaveParam")ManagerSaveParam vo);
	
	/**
	 * 修改管理员
	 * @param vo		修改管理员参数对象
	 * @return
	 */
	@WSDLDocumentation("修改管理员")
	public Boolean modify(@WebParam(name="managerModifyParam")ManagerModifyParam vo);
	
	/**
	 * 启用帐号(审核通过)
	 * @param mangerId		开通帐号id
	 * @return
	 */
	@WSDLDocumentation("启用帐号(审核通过)")
	public Boolean openStatus(
			@WebParam(name="managerId")String managerId);
	
	/**
	 * 停用帐号(审核不通过)
	 * @param mangerId		关闭帐号id
	 * @return
	 */
	@WSDLDocumentation("停用帐号(审核不通过)")
	public Boolean closeStatus(
			@WebParam(name="mangerId")String mangerId);
	
	/**
	 * 根据管理员id获取管理员实体
	 * @param mangerId		管理员id
	 * @return
	 */
	@WSDLDocumentation("根据管理员id获取管理员实体")
	public ManagerReturn getByManagerId(@WebParam(name="mangerId")String mangerId);
	
	/**
	 * 登录(密码为明文密码,只有状态为开通的管理员才能登录)
	 * @param userId		管理员id
	 * @param password		明文密码
	 * @return
	 */
	@WSDLDocumentation("登录(密码为明文密码,只有状态为开通的管理员才能登录)")
	public ManagerReturn login(
			@WebParam(name="mangerId")String mangerId,
			@WebParam(name="password")String password);
	
	/**
	 * 根据查询参数获取管理员分页列表
	 * @param queryParam		查询参数对象
	 * @param startRow			开始行数
	 * @param pageSize			每页数量
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取管理员分页列表")
	public List<ManagerReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取管理员记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取管理员记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
