package com.ymsino.esb.archives.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.archives.vo.ConcentratorModifyParam;
import com.ymsino.esb.archives.vo.ConcentratorReturn;
import com.ymsino.esb.archives.vo.ConcentratorSaveParam;

@WebService
public interface ConcentratorService {

	/**
	 * 保存集中器
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存集中器")
	public Boolean save(@WebParam(name="concentratorSaveParam")ConcentratorSaveParam vo);
	
	/**
	 * 修改集中器
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改集中器")
	public Boolean modify(@WebParam(name="concentratorModifyParam")ConcentratorModifyParam vo);
	
	/**
	 * 根据集中器编号获取集中器
	 * @param hardwareId
	 * @return
	 */
	@WSDLDocumentation("根据集中器编号获取集中器")
	public ConcentratorReturn getById(@WebParam(name="hardwareId")String hardwareId);
	
	/**
	 * 根据查询参数获取集中器分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取集中器分页列表")
	public List<ConcentratorReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取集中器总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取集中器总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
