package com.ymsino.esb.archives.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.archives.vo.BusiAddressModifyParam;
import com.ymsino.esb.archives.vo.BusiAddressReturn;
import com.ymsino.esb.archives.vo.BusiAddressSaveParam;

@WebService
public interface BusiAddressService {

	/**
	 * 保存业务地址
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存业务地址")
	public Long save(@WebParam(name="busiAddressSaveParam")BusiAddressSaveParam vo);
	
	/**
	 * 修改业务地址
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改业务地址")
	public Boolean modify(@WebParam(name="busiAddressModifyParam")BusiAddressModifyParam vo);
	
	/**
	 * 删除业务地址
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("删除业务地址")
	public Boolean delete(@WebParam(name="id")Long id);
	
	/**
	 * 根据id获取业务地址
	 * @param id
	 * @return
	 */
	@WSDLDocumentation("根据id获取业务地址")
	public BusiAddressReturn getById(@WebParam(name="id")Long id);
	
	/**
	 * 根据查询参数获取业务地址分页列表
	 * @param queryParam
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取业务地址分页列表")
	public List<BusiAddressReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取业务地址总记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取业务地址总记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
