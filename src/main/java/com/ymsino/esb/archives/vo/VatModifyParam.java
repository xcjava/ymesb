package com.ymsino.esb.archives.vo;

import java.io.Serializable;

public class VatModifyParam implements Serializable {

	/**
     * 增值税标识，自增id
    */
    private Long id;
    /**
     * 增值税名
    */
    private String vatName;
    /**
     * 增值税号
    */
    private String vatNum;
    /**
     * 增值税帐号
    */
    private String vatAccount;
    /**
     * 增值税银行
    */
    private String vatBank;
    /**
     * 电话号码
    */
    private String tel;
    /**
     * 注册地址
    */
    private String regAddress;
    /**
     * 收费单位编号
    */
    private String chargingUnitId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVatName() {
		return vatName;
	}
	public void setVatName(String vatName) {
		this.vatName = vatName;
	}
	public String getVatNum() {
		return vatNum;
	}
	public void setVatNum(String vatNum) {
		this.vatNum = vatNum;
	}
	public String getVatAccount() {
		return vatAccount;
	}
	public void setVatAccount(String vatAccount) {
		this.vatAccount = vatAccount;
	}
	public String getVatBank() {
		return vatBank;
	}
	public void setVatBank(String vatBank) {
		this.vatBank = vatBank;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRegAddress() {
		return regAddress;
	}
	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}
	public String getChargingUnitId() {
		return chargingUnitId;
	}
	public void setChargingUnitId(String chargingUnitId) {
		this.chargingUnitId = chargingUnitId;
	}
}
