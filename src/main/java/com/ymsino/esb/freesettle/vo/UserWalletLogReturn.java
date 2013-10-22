package com.ymsino.esb.freesettle.vo;

import java.io.Serializable;

public class UserWalletLogReturn implements Serializable {

	/**
     * 用户余额日志自增id
    */
    Long id;
    /**
     * 系统备注
    */
    String sysRemark;
    /**
     * 类型: -1:支出, 1收入
    */
    Short logType;
    /**
     * 创建时间戳
    */
    Long createTimestamp;
    /**
     * 使用金额(分),正数为收入,负数为支出
    */
    Long usePrice;
    /**
     * 用户ID
    */
    Long uid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSysRemark() {
		return sysRemark;
	}
	public void setSysRemark(String sysRemark) {
		this.sysRemark = sysRemark;
	}
	public Short getLogType() {
		return logType;
	}
	public void setLogType(Short logType) {
		this.logType = logType;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public Long getUsePrice() {
		return usePrice;
	}
	public void setUsePrice(Long usePrice) {
		this.usePrice = usePrice;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
}
