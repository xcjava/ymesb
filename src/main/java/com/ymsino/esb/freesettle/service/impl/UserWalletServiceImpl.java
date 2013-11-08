package com.ymsino.esb.freesettle.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;

import com.amazonaws.services.identitymanagement.model.User;
import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.security.MD5;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.freesettle.model.UserWallet;
import com.ymsino.esb.freesettle.model.UserWalletLog;
import com.ymsino.esb.freesettle.service.api.UserWalletService;
import com.ymsino.esb.freesettle.vo.UserWalletReturn;

public class UserWalletServiceImpl implements UserWalletService {

	private Logger logger = Logger.getLogger(UserWalletServiceImpl.class);
	private CommonHibernateDao commonHibernateDao;
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
		
		User user = (User) this.commonHibernateDao.get(User.class, uid);
		if(user == null){
			logger.error("recharge:用户不存在");
			throw new RuntimeException("用户不存在");
		}
		
		UserWallet wallet = (UserWallet) this.commonHibernateDao.get(UserWallet.class, MD5.getMD5(uid.toString()));
		//第一次初始化钱包
		if(wallet == null){
			wallet = new UserWallet();
			wallet.setSignId(MD5.getMD5(uid.toString()));
			wallet.setCashAmount(Long.valueOf(0));
			wallet.setHealthStatus(Short.valueOf("1"));
			wallet.setModifyTimestamp(new Date().getTime());
			wallet.setHealthSign(MD5.getMD5(
					MD5.getMD5(wallet.getCashAmount().toString()) + 
					wallet.getSignId() + 
					MD5.getMD5(wallet.getModifyTimestamp().toString())
					));
			this.commonHibernateDao.save(wallet);
			wallet = (UserWallet) this.commonHibernateDao.get(UserWallet.class, MD5.getMD5(uid.toString()));
		}
		
		if(!wallet.getHealthStatus().equals(Short.valueOf("1"))){
			logger.error("recharge:用户钱包为警告状态，不可充值");
			throw new RuntimeException("用户钱包为警告状态，不可充值");
		}
		
		Long cashAmount = wallet.getCashAmount() + price;
		wallet.setCashAmount(cashAmount);
		wallet.setModifyTimestamp(new Date().getTime());
		wallet.setHealthSign(MD5.getMD5(
				MD5.getMD5(wallet.getCashAmount().toString()) + 
				wallet.getSignId() + 
				MD5.getMD5(wallet.getModifyTimestamp().toString())
				));
		
		this.saveLog(uid, Short.valueOf("1"), price, sysRemark);
		
		return Boolean.TRUE;
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
		
		UserWallet po = (UserWallet) this.commonHibernateDao.get(UserWallet.class, MD5.getMD5(uid.toString()));
		if(po == null){
			logger.error("deduction:用户钱包不存在");
			throw new RuntimeException("用户钱包不存在");
		}
		
		if(!po.getHealthStatus().equals(Short.valueOf("1"))){
			logger.error("recharge:用户钱包为警告状态，不可扣费");
			throw new RuntimeException("用户钱包为警告状态，不可扣费");
		}
		
		Long cashAmount = po.getCashAmount() - price;
		if(cashAmount < 0){
			logger.error("recharge:扣除金额超过帐号余额");
			throw new RuntimeException("扣除金额超过帐号余额");
		}
		
		po.setCashAmount(cashAmount);
		po.setModifyTimestamp(new Date().getTime());
		po.setHealthSign(MD5.getMD5(
				MD5.getMD5(po.getCashAmount().toString()) + 
				po.getSignId() + 
				MD5.getMD5(po.getModifyTimestamp().toString())
				));
		
		this.saveLog(uid, Short.valueOf("-1"), price * -1, sysRemark);
		
		return Boolean.TRUE;
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

	private void saveLog(Long uid, Short logType, Long usePrice, String sysRemark){
		
		UserWalletLog model = new UserWalletLog();
		model.setLogType(logType);
		model.setSysRemark(sysRemark);
		model.setUid(uid);
		model.setUsePrice(usePrice);
		model.setCreateTimestamp(new Date().getTime());
		
		this.commonHibernateDao.save(model);
	}
}
