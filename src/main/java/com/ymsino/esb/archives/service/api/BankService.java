package com.ymsino.esb.archives.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.archives.vo.BankModifyParam;
import com.ymsino.esb.archives.vo.BankReturn;
import com.ymsino.esb.archives.vo.BankSaveParam;

@WebService
public interface BankService {

	/**
	 * 保存银行信息
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存银行信息")
	public Long save(@WebParam(name="bankSaveParam")BankSaveParam vo);
	
	/**
	 * 修改银行信息
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改银行信息")
	public Boolean modify(@WebParam(name="bankModifyParam")BankModifyParam vo);
	
	/**
	 * 删除银行信息
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("删除银行信息")
	public Boolean delete(@WebParam(name="id")Long id);
	
	/**
	 * 根据id获取银行信息
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取银行信息")
	public BankReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取银行信息分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取银行信息分页列表")
	public List<BankReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取银行信息分页列表
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取银行信息分页列表")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
