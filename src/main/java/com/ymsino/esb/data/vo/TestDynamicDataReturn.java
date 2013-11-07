package com.ymsino.esb.data.vo;

import java.io.Serializable;

public class TestDynamicDataReturn implements Serializable {

	/**
     * 召测本机动态数据自增id
    */
    private Long id;
    /**
     * 集中器逻辑地址
    */
    private String concHardwareId;
    /**
     * 无线智能水表ID
    */
    private String meterHardwareId;
    /**
     * 表计读数
    */
    private Float meterReading;
    /**
     * 电池电压
    */
    private Float batteryVoltage;
    /**
     * 			阀门
* 			01=半阀 10=开阀
* 			11=关阀 00=未知
* 			
    */
    private String valveStatus;
    /**
     * 数据类型:0=光电,1=脉冲
    */
    private String dataType;
    /**
     * 磁攻击:0无磁攻击, 1有磁攻击
    */
    private String magneticAttack;
    /**
     * 错误状态:0=正确, 1=错误
    */
    private String errorStatus;
    /**
     * 应答状态: 0=有应答, 1=无应答
    */
    private String replyStatus;
    /**
     * 创建时间戳
    */
    private Long createTimestamp;
    /**
     * 客户编号
    */
    private String userId;
    /**
     * 用水用户编号
    */
    private String waterCustomerId;
    /**
     * 收费单位编号
    */
    private String chargingUnitId;
    /**
     * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
    */
    private String parentUnits;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConcHardwareId() {
		return concHardwareId;
	}
	public void setConcHardwareId(String concHardwareId) {
		this.concHardwareId = concHardwareId;
	}
	public String getMeterHardwareId() {
		return meterHardwareId;
	}
	public void setMeterHardwareId(String meterHardwareId) {
		this.meterHardwareId = meterHardwareId;
	}
	public Float getMeterReading() {
		return meterReading;
	}
	public void setMeterReading(Float meterReading) {
		this.meterReading = meterReading;
	}
	public Float getBatteryVoltage() {
		return batteryVoltage;
	}
	public void setBatteryVoltage(Float batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}
	public String getValveStatus() {
		return valveStatus;
	}
	public void setValveStatus(String valveStatus) {
		this.valveStatus = valveStatus;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getMagneticAttack() {
		return magneticAttack;
	}
	public void setMagneticAttack(String magneticAttack) {
		this.magneticAttack = magneticAttack;
	}
	public String getErrorStatus() {
		return errorStatus;
	}
	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}
	public String getReplyStatus() {
		return replyStatus;
	}
	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getWaterCustomerId() {
		return waterCustomerId;
	}
	public void setWaterCustomerId(String waterCustomerId) {
		this.waterCustomerId = waterCustomerId;
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
}
