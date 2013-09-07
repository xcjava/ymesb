package com.ymsino.esb.archives.vo;

import java.io.Serializable;

public class BankReturn implements Serializable {

	/**
     * 银行帐号标识，自增id
    */
    private Long id;
    /**
     * 付费优先级
    */
    private String payPriority;
    /**
     * 银行代码
    */
    private String bankCode;
    /**
     * 银行帐号
    */
    private String bankAccount;
    /**
     * 账户名称
    */
    private String accountName;
    /**
     * 托收协议标识
    */
    private String collAgreementId;
    /**
     * 账户类型
    */
    private String accountType;
    /**
     * 用户id
    */
    private Long uid;
    /**
     * 收费单位编号
    */
    private String chargingUnitId;
    /**
     * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
    */
    private String parentUnits;
    /**
     * 创建时间
    */
    private Long createTimestamp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPayPriority() {
		return payPriority;
	}
	public void setPayPriority(String payPriority) {
		this.payPriority = payPriority;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCollAgreementId() {
		return collAgreementId;
	}
	public void setCollAgreementId(String collAgreementId) {
		this.collAgreementId = collAgreementId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getChargingUnitId() {
		return chargingUnitId;
	}
	public void setChargingUnitId(String chargingUnitId) {
		this.chargingUnitId = chargingUnitId;
	}
	public String getParentUnits() {
		return parentUnits;
	}
	public void setParentUnits(String parentUnits) {
		this.parentUnits = parentUnits;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
}
