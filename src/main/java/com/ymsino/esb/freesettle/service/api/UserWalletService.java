package com.ymsino.esb.freesettle.service.api;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.ymsino.esb.freesettle.vo.UserWalletReturn;

@WebService
public interface UserWalletService {

	/**
	 * 充值
	 * @param uid
	 * @param price
	 * @param sysRemark
	 * @return
	 */
	@WSDLDocumentation("充值")
	public Boolean recharge(
			@WebParam(name="uid")Long uid,
			@WebParam(name="price")Long price,
			@WebParam(name="sysRemark")String sysRemark);
	
	/**
	 * 扣费
	 * @param uid
	 * @param price
	 * @param sysRemark
	 * @return
	 */
	@WSDLDocumentation("扣费")
	public Boolean deduction(
			@WebParam(name="uid")Long uid,
			@WebParam(name="price")Long price,
			@WebParam(name="sysRemark")String sysRemark);
	
	/**
	 * 根据用户id获取用户钱包
	 * @param uid
	 * @return
	 */
	@WSDLDocumentation("根据用户id获取用户钱包")
	public UserWalletReturn getByUid(@WebParam(name="uid")Long uid);
}
