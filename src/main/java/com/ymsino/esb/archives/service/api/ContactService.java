package com.ymsino.esb.archives.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.archives.vo.ContactModifyParam;
import com.ymsino.esb.archives.vo.ContactReturn;
import com.ymsino.esb.archives.vo.ContactSaveParam;

@WebService
public interface ContactService {

	/**
	 * 保存联系信息
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存联系信息")
	public Long save(@WebParam(name="contactSaveParam")ContactSaveParam vo);
	
	/**
	 * 修改联系信息
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改联系信息")
	public Boolean modify(@WebParam(name="contactModifyParam")ContactModifyParam vo);
	
	/**
	 * 删除联系信息
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("删除联系信息")
	public Boolean delete(@WebParam(name="id")Long id);
	
	/**
	 * 根据id获取联系信息
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取联系信息")
	public ContactReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取联系信息分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取联系信息分页列表")
	public List<ContactReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取联系信息分页列表
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取联系信息分页列表")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
