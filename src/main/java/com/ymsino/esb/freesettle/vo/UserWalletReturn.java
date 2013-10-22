package com.ymsino.esb.freesettle.vo;

import java.io.Serializable;

public class UserWalletReturn implements Serializable {

	/**
     * 账户上一次变动时间戳
    */
    Long modifyTimestamp;
    /**
     * 账户余额,单位为分
    */
    Long cashAmount;
    /**
     * 账户签名
    */
    String healthSign;
    /**
     * 健康状态:1正常;-1警告
    */
    Short healthStatus;
	public Long getModifyTimestamp() {
		return modifyTimestamp;
	}
	public void setModifyTimestamp(Long modifyTimestamp) {
		this.modifyTimestamp = modifyTimestamp;
	}
	public Long getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(Long cashAmount) {
		this.cashAmount = cashAmount;
	}
	public String getHealthSign() {
		return healthSign;
	}
	public void setHealthSign(String healthSign) {
		this.healthSign = healthSign;
	}
	public Short getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(Short healthStatus) {
		this.healthStatus = healthStatus;
	}
}
