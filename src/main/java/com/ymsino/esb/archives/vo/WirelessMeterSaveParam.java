package com.ymsino.esb.archives.vo;

import java.io.Serializable;

public class WirelessMeterSaveParam implements Serializable {

	/**
     * 无线智能水表编号
    */
    private String wmSn;
    /**
     * 用户id
    */
    private Long uid;
    /**
     * 客户编号
    */
    private String userId;
    /**
     * 客户名称
    */
    private String userName;
    /**
     * 收费单位编号
    */
    private String chargingUnitId;
    /**
     * 子表号
    */
    private String childWmSn;
    /**
     * 水表类型
    */
    private String dataType;
    /**
     * 脉冲常数
    */
    private Integer constant;
    /**
     * 集中器ID
    */
    private String concHardwareId;
    /**
     * 初始表码
    */
    private String initialYards;
    /**
     * 适用水价(单位：分)
    */
    private Long suitablePrice;
    /**
     * 告警量
    */
    private String alarmVolume;
    /**
     * 无线频率
    */
    private String radioFrequency;
	public String getWmSn() {
		return wmSn;
	}
	public void setWmSn(String wmSn) {
		this.wmSn = wmSn;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getChargingUnitId() {
		return chargingUnitId;
	}
	public void setChargingUnitId(String chargingUnitId) {
		this.chargingUnitId = chargingUnitId;
	}
	public String getChildWmSn() {
		return childWmSn;
	}
	public void setChildWmSn(String childWmSn) {
		this.childWmSn = childWmSn;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public Integer getConstant() {
		return constant;
	}
	public void setConstant(Integer constant) {
		this.constant = constant;
	}
	public String getConcHardwareId() {
		return concHardwareId;
	}
	public void setConcHardwareId(String concHardwareId) {
		this.concHardwareId = concHardwareId;
	}
	public String getInitialYards() {
		return initialYards;
	}
	public void setInitialYards(String initialYards) {
		this.initialYards = initialYards;
	}
	public Long getSuitablePrice() {
		return suitablePrice;
	}
	public void setSuitablePrice(Long suitablePrice) {
		this.suitablePrice = suitablePrice;
	}
	public String getAlarmVolume() {
		return alarmVolume;
	}
	public void setAlarmVolume(String alarmVolume) {
		this.alarmVolume = alarmVolume;
	}
	public String getRadioFrequency() {
		return radioFrequency;
	}
	public void setRadioFrequency(String radioFrequency) {
		this.radioFrequency = radioFrequency;
	}
}
