package com.ymsino.esb.freesettle.service.impl;

import org.apache.log4j.Logger;

import com.gmail.xcjava.base.spring.CommonHibernateDao;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deduction(Long uid, Long price, String sysRemark) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserWalletReturn getByUid(Long uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
