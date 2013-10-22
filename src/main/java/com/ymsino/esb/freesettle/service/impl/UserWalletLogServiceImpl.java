package com.ymsino.esb.freesettle.service.impl;

import java.util.List;

import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.freesettle.service.api.UserWalletLogService;
import com.ymsino.esb.freesettle.vo.UserWalletLogReturn;

public class UserWalletLogServiceImpl implements UserWalletLogService {

	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	@Override
	public List<UserWalletLogReturn> getListpager(QueryParam queryParam,
			Integer startRow, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(QueryParam queryParam) {
		// TODO Auto-generated method stub
		return null;
	}

}
