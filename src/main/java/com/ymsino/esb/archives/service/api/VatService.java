package com.ymsino.esb.archives.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.archives.vo.VatModifyParam;
import com.ymsino.esb.archives.vo.VatReturn;
import com.ymsino.esb.archives.vo.VatSaveParam;

@WebService
public interface VatService {

	/**
	 * 保存增值税
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存增值税")
	public Long save(@WebParam(name="vatSaveParam")VatSaveParam vo);
	
	/**
	 * 修改增值税
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改增值税")
	public Boolean modify(@WebParam(name="vatModifyParam")VatModifyParam vo);
	
	/**
	 * 删除增值税
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("删除增值税")
	public Boolean delete(@WebParam(name="id")Long id);
	
	/**
	 * 根据id获取增值税
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取增值税")
	public VatReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取增值税分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取增值税分页列表")
	public List<VatReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取增值税总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取增值税总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
