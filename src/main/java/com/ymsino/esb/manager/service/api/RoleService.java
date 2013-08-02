package com.ymsino.esb.manager.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.manager.vo.RoleModifyParam;
import com.ymsino.esb.manager.vo.RoleReturn;
import com.ymsino.esb.manager.vo.RoleSaveParam;

@WebService
public interface RoleService {

	/**
	 * 保存角色
	 * @param vo		保存角色参数对象
	 * @param async		是否异步
	 * @return
	 */
	@WSDLDocumentation("保存角色")
	public Long save(
			@WebParam(name="roleSaveParam")RoleSaveParam vo,
			@WebParam(name="async")Boolean async);
	
	/**
	 * 修改角色
	 * @param vo		修改角色参数对象
	 * @param async		是否异步
	 * @return
	 */
	@WSDLDocumentation("修改角色")
	public Boolean modify(
			@WebParam(name="roleModifyParam")RoleModifyParam vo,
			@WebParam(name="async")Boolean async);
	
	/**
	 * 删除角色
	 * @param id		角色id
	 * @param async		是否异步
	 * @return
	 */
	@WSDLDocumentation("删除角色")
	public Boolean delete(
			@WebParam(name="roleId")Long id,
			@WebParam(name="async")Boolean async);
	
	/**
	 * 根据id获取角色实体
	 * @param id		角色id
	 * @return
	 */
	@WSDLDocumentation("根据id获取角色实体")
	public RoleReturn getById(@WebParam(name="roleId")Long id);
	
	/**
	 * 根据查询参数获取角色分页列表
	 * @param queryParam		查询参数对象
	 * @param startRow			开始行数
	 * @param pageSize			每页数量
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取角色分页列表")
	public List<RoleReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取角色记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取角色记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
	
	/**
	 * 启用角色
	 * @param id		角色id
	 * @param async		是否异步
	 * @return
	 */
	@WSDLDocumentation("启用角色")
	public Boolean openStatus(
			@WebParam(name="roleId")Long id,
			@WebParam(name="async")Boolean async);
	
	/**
	 * 停用角色
	 * @param id		角色id
	 * @param async		是否异步
	 * @return
	 */
	@WSDLDocumentation("停用角色")
	public Boolean closeStatus(
			@WebParam(name="roleId")Long id,
			@WebParam(name="async")Boolean async);
}
