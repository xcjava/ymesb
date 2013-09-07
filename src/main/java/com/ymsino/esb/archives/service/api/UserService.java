package com.ymsino.esb.archives.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.archives.vo.UserModifyParam;
import com.ymsino.esb.archives.vo.UserReturn;
import com.ymsino.esb.archives.vo.UserSaveParam;

@WebService
public interface UserService {

	/**
	 * 保存用户
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存用户")
	public Long save(@WebParam(name="userSaveParam")UserSaveParam vo);
	
	/**
	 * 修改用户
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改用户")
	public Boolean modify(@WebParam(name="userModifyParam")UserModifyParam vo);
	
	/**
	 * 根据id获得用户实体对象
	 * @param uid
	 * @return
	 */
	@WSDLDocumentation("根据id获得用户实体对象")
	public UserReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据用户编码获得用户实体对象
	 * @param userId
	 * @return
	 */
	@WSDLDocumentation("根据用户编码获得用户实体对象")
	public UserReturn getByUserId(@WebParam(name="userId")String userId);
	
	/**
	 * 根据查询参数获取用户分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取用户分页列表")
	public List<UserReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取用户记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取用户记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
