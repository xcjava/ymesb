package com.ymsino.esb.manager.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.manager.vo.ManagerModifyParam;
import com.ymsino.esb.manager.vo.ManagerReturn;
import com.ymsino.esb.manager.vo.ManagerSaveParam;
import com.ymsino.esb.manager.vo.RoleReturn;

@WebService
public interface ManagerService {

	/**
	 * 保存管理员
	 * @param vo		保存管理员参数对象
	 * @param async		是否异步
	 * @return
	 */
	@WSDLDocumentation("保存管理员")
	public Boolean save(
			@WebParam(name="managerSaveParam")ManagerSaveParam vo,
			@WebParam(name="async")Boolean async);
	
	/**
	 * 修改管理员
	 * @param vo		修改管理员参数对象
	 * @param async		是否异步
	 * @return
	 */
	@WSDLDocumentation("修改管理员")
	public Boolean modify(
			@WebParam(name="managerModifyParam")ManagerModifyParam vo,
			@WebParam(name="async")Boolean async);
	
	/**
	 * 冻结帐号
	 * @param userId		冻结帐号userId
	 * @param mangerId		操作管理员id
	 * @param async			是否异步
	 * @return
	 */
	@WSDLDocumentation("冻结帐号")
	public Boolean frozenStatus(
			@WebParam(name="userId")String userId,
			@WebParam(name="mangerId")String mangerId,
			@WebParam(name="async")Boolean async);
	
	/**
	 * 开通帐号(审核通过)
	  * @param userId		开通帐号userId
	 * @param mangerId		操作管理员id
	 * @param async			是否异步
	 * @return
	 */
	@WSDLDocumentation("开通帐号(审核通过)")
	public Boolean openStatus(
			@WebParam(name="userId")String userId,
			@WebParam(name="mangerId")String mangerId,
			@WebParam(name="async")Boolean async);
	
	/**
	 * 关闭帐号(审核不通过)
	 * @param userId		关闭帐号userId
	 * @param mangerId		操作管理员id
	 * @param async			是否异步
	 * @return
	 */
	@WSDLDocumentation("关闭帐号(审核不通过)")
	public Boolean closeStatus(
			@WebParam(name="userId")String userId,
			@WebParam(name="mangerId")String mangerId,
			@WebParam(name="async")Boolean async);
	
	/**
	 * 根据管理员id获取管理员实体
	 * @param userId		管理员id
	 * @return
	 */
	@WSDLDocumentation("根据管理员id获取管理员实体")
	public ManagerReturn getByUserId(@WebParam(name="userId")String userId);
	
	/**
	 * 获取管理员角色(管理员绑定的合法可用的角色,登录权限验证需调用该方法)
	 * @param userId		管理员id
	 * @return
	 */
	@WSDLDocumentation("获取管理员角色(管理员绑定的合法可用的角色,登录权限验证需调用该方法)")
	public List<RoleReturn> getLegalRoles(@WebParam(name="userId")String userId);
	
	/**
	 * 获取管理员角色(管理员绑定的所有角色)
	 * @param userId		管理员id
	 * @return
	 */
	@WSDLDocumentation("获取管理员角色(管理员绑定的所有角色)")
	public List<RoleReturn> getRoles(@WebParam(name="userId")String userId);
	
	/**
	 * 登录(密码为明文密码,只有状态为开通的管理员才能登录)
	 * @param userId		管理员id
	 * @param password		明文密码
	 * @param loginIp		登录ip
	 * @return
	 */
	@WSDLDocumentation("登录(密码为明文密码,只有状态为开通的管理员才能登录)")
	public ManagerReturn login(
			@WebParam(name="userId")String userId,
			@WebParam(name="password")String password,
			@WebParam(name="loginIp")String loginIp);
	
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
