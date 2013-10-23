package com.ymsino.esb.data.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.data.vo.CollectTaskModifyParam;
import com.ymsino.esb.data.vo.CollectTaskReturn;
import com.ymsino.esb.data.vo.CollectTaskSaveParam;

@WebService
public interface CollectTaskService {

	/**
	 * 保存采集任务
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存采集任务")
	public Long save(@WebParam(name="collectTaskSaveParam")CollectTaskSaveParam vo);
	
	/**
	 * 修改采集任务
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改采集任务")
	public Boolean modify(@WebParam(name="collectTaskModifyParam")CollectTaskModifyParam vo);
	
	/**
	 * 根据id获取采集任务
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取采集任务")
	public CollectTaskReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取采集任务分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取采集任务分页列表")
	public List<CollectTaskReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取采集任务总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取采集任务总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
