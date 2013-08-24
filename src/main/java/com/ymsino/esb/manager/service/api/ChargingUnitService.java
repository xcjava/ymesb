package com.ymsino.esb.manager.service.api;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.gmail.xcjava.base.hql.QueryParam;
import com.ymsino.esb.manager.vo.ChargingUnitModifyParam;
import com.ymsino.esb.manager.vo.ChargingUnitReturn;
import com.ymsino.esb.manager.vo.ChargingUnitSaveParam;

@WebService
public interface ChargingUnitService {

	/**
	 * 保存收费单位
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("保存收费单位")
	public Long save(@WebParam(name="chargingUnitSaveParam")ChargingUnitSaveParam vo);
	
	/**
	 * 修改收费单位
	 * @param vo
	 * @return
	 */
	@WSDLDocumentation("修改收费单位")
	public Boolean modify(@WebParam(name="chargingUnitModifyParam")ChargingUnitModifyParam vo);
	
	/**
	 * 恢复（收费单位删除之后恢复）
	 * @return
	 */
	@WSDLDocumentation("恢复（收费单位删除之后恢复）")
	public Boolean openStatus(@WebParam(name="unitId")String unitId);
	
	/**
	 * 删除（又下级单位的不可删除）
	 * @param unitId
	 * @return
	 */
	@WSDLDocumentation("删除（又下级单位的不可删除）")
	public Boolean closeStatus(@WebParam(name="unitId")String unitId);
	
	/**
	 * 删除（真实删除，只有新建状态的收费单位可删除）
	 * @param unitId
	 * @return
	 */
	@WSDLDocumentation("删除（真实删除，只有新建状态的收费单位可删除）")
	public Boolean delete(@WebParam(name="unitId")String unitId);
	
	/**
	 * 根据id获取收费单位实体
	 * @param unitId
	 * @return
	 */
	@WSDLDocumentation("根据id获取收费单位实体")
	public ChargingUnitReturn getByUnitId(@WebParam(name="unitId")String unitId);
	
	/**
	 * 根据查询参数获取收费单位分页列表
	 * @param queryParam		查询参数对象
	 * @param startRow			开始行数
	 * @param pageSize			每页数量
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取收费单位分页列表")
	public List<ChargingUnitReturn> getListpager(
			@WebParam(name="queryParam")QueryParam queryParam,
			@WebParam(name="startRow")Integer startRow,
			@WebParam(name="pageSize")Integer pageSize);
	
	/**
	 * 根据查询参数获取收费单位记录数
	 * @param queryParam				查询参数对象;
	 * @return
	 */
	@WSDLDocumentation("根据查询参数获取收费单位记录数")
	public Integer getCount(@WebParam(name="queryParam")QueryParam queryParam);
}
