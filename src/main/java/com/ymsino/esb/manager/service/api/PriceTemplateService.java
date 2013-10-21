package com.ymsino.esb.manager.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.manager.vo.PriceTemplateModifyParam;
import com.ymsino.esb.manager.vo.PriceTemplateReturn;
import com.ymsino.esb.manager.vo.PriceTemplateSaveParam;

@WebService
public interface PriceTemplateService {

	/**
	 * 保存价目
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存价目")
	public Long save(@WebParam(name="priceTemplateSaveParam")PriceTemplateSaveParam vo);
	
	/**
	 * 修改价目
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改价目")
	public Boolean modify(@WebParam(name="priceTemplateModifyParam")PriceTemplateModifyParam vo);
	
	/**
	 * 根据id获取价目
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取价目")
	public PriceTemplateReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取价目分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取价目分页列表")
	public List<PriceTemplateReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取价目总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取价目总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
