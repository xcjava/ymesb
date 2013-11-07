package com.ymsino.esb.archives.vo;

import java.io.Serializable;

public class WaterMeterModifyParam implements Serializable {

	/**
     * 水表编号
    */
    private String hardwareId;
    /**
     * 用水用户编号
    */
    private String waterCustomerId;
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
     * 用水性质
    */
    private String nature;
    /**
     * 限购量
    */
    private String purcAmount;
    /**
     * 显示告警
    */
    private String showWarn;
    /**
     * 关阀告警
    */
    private String closeWarn;
    /**
     * 子表号
    */
    private String childHardwareId;
    /**
     * 数据类别
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
    private Float initialYards;
    /**
     * 适用水价、当前水价(单位：分)
    */
    private Long price;
    /**
     * 告警量
    */
    private String alarmVolume;
    /**
     * 无线频率
    */
    private String radioFrequency;
	public String getHardwareId() {
		return hardwareId;
	}
	public void setHardwareId(String hardwareId) {
		this.hardwareId = hardwareId;
	}
	public String getWaterCustomerId() {
		return waterCustomerId;
	}
	public void setWaterCustomerId(String waterCustomerId) {
		this.waterCustomerId = waterCustomerId;
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
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getPurcAmount() {
		return purcAmount;
	}
	public void setPurcAmount(String purcAmount) {
		this.purcAmount = purcAmount;
	}
	public String getShowWarn() {
		return showWarn;
	}
	public void setShowWarn(String showWarn) {
		this.showWarn = showWarn;
	}
	public String getCloseWarn() {
		return closeWarn;
	}
	public void setCloseWarn(String closeWarn) {
		this.closeWarn = closeWarn;
	}
	public String getChildHardwareId() {
		return childHardwareId;
	}
	public void setChildHardwareId(String childHardwareId) {
		this.childHardwareId = childHardwareId;
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
	public Float getInitialYards() {
		return initialYards;
	}
	public void setInitialYards(Float initialYards) {
		this.initialYards = initialYards;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
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
