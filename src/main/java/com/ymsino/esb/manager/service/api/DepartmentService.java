package com.ymsino.esb.manager.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.manager.vo.DepartmentModifyParam;
import com.ymsino.esb.manager.vo.DepartmentReturn;
import com.ymsino.esb.manager.vo.DepartmentSaveParam;

@WebService
public interface DepartmentService {

	/**
	 * 保存部门
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存部门")
	public Boolean save(@WebParam(name="departmentSaveParam")DepartmentSaveParam vo);
	
	/**
	 * 修改部门
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改部门")
	public Boolean modify(@WebParam(name="departmentModifyParam")DepartmentModifyParam vo);
	
	/**
	 * 启用或删除之后恢复
	 * @param deptId
	 * @return
	 */
	@WSDLDocumentation("启用或删除之后恢复")
	public Boolean openStatus(@WebParam(name="deptId")String deptId);
	
	/**
	 * 删除（有下级单位的不可删除）
	 * @param deptId
	 * @return
	 */
	@WSDLDocumentation("删除（又下级单位的不可删除）")
	public Boolean closeStatus(@WebParam(name="deptId")String deptId);
	
	/**
	 * 根据id获取部门实体
	 * @param deptId
	 * @return
	 */
	@WSDLDocumentation("根据id获取部门实体")
	public DepartmentReturn getByDeptId(@WebParam(name="deptId")String deptId);
	
	/**
	 * 根据查询参数获取部门分页列表
	 * @param queryParam		查询参数对象
	 * @param startRow			开始行数
	 * @param pageSize			每页数量
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取部门分页列表")
	public List<DepartmentReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取部门记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取部门记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
