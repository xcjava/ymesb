package com.ymsino.esb.freesettle.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.security.MD5;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.freesettle.domain.UserWalletManager;
import com.ymsino.esb.freesettle.model.UserWallet;
import com.ymsino.esb.freesettle.service.api.UserWalletService;
import com.ymsino.esb.freesettle.vo.UserWalletReturn;

public class UserWalletServiceImpl implements UserWalletService {

	private Logger logger = Logger.getLogger(UserWalletServiceImpl.class);
	private UserWalletManager userWalletManager;
	private CommonHibernateDao commonHibernateDao;
	public void setUserWalletManager(UserWalletManager userWalletManager) {
		this.userWalletManager = userWalletManager;
	}
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}

	@Override
	public Boolean recharge(Long uid, Long price, String sysRemark) {
		
		if(uid == null){
			logger.error("recharge:用户id为空");
			throw new RuntimeException("用户id为空");
		}
		
		if(price == null || price < 0){
			logger.error("recharge:充值金额为空或者为非法数据");
			throw new RuntimeException("充值金额为空或者为非法数据");
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("uid", uid);
		param.put("price", price);
		param.put("sysRemark", sysRemark);
		
		return userWalletManager.recharge(param);
	}

	@Override
	public Boolean deduction(Long uid, Long price, String sysRemark) {
		
		if(uid == null){
			logger.error("deduction:用户id为空");
			throw new RuntimeException("用户id为空");
		}
		
		if(price == null || price < 0){
			logger.error("deduction:充值金额为空或者为非法数据");
			throw new RuntimeException("充值金额为空或者为非法数据");
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("uid", uid);
		param.put("price", price);
		param.put("sysRemark", sysRemark);
		
		return userWalletManager.deduction(param);
	}

	@Override
	public UserWalletReturn getByUid(Long uid) {
		
		if(uid == null)
			return null;
		
		UserWallet po = (UserWallet) this.commonHibernateDao.get(UserWallet.class, MD5.getMD5(uid.toString()));
		if(po == null)
			return null;
		
		if(!MD5.getMD5(
				MD5.getMD5(po.getCashAmount().toString()) + 
				po.getSignId() + 
				MD5.getMD5(po.getModifyTimestamp().toString())
				).equals(po.getHealthSign()))
			po.setHealthStatus(Short.valueOf("-1"));
		
		return (UserWalletReturn) ObjectMapping.objMapping(po, new UserWalletReturn());
	}

	
}
