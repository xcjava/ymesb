package com.ymsino.esb.data.vo;

import java.io.Serializable;

public class WaterMonthUsageAmountReturn implements Serializable {

	/**
     * 水表月用量自增id
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
     * 1月水用量
    */
    private Float usageAmount1;
    /**
     * 2月水用量
    */
    private Float usageAmount2;
    /**
     * 3月水用量
    */
    private Float usageAmount3;
    /**
     * 4月水用量
    */
    private Float usageAmount4;
    /**
     * 5月水用量
    */
    private Float usageAmount5;
    /**
     * 6月水用量
    */
    private Float usageAmount6;
    /**
     * 7月水用量
    */
    private Float usageAmount7;
    /**
     * 8月水用量
    */
    private Float usageAmount8;
    /**
     * 9月水用量
    */
    private Float usageAmount9;
    /**
     * 10月水用量
    */
    private Float usageAmount10;
    /**
     * 11月水用量
    */
    private Float usageAmount11;
    /**
     * 12月水用量
    */
    private Float usageAmount12;
    /**
     * 冻结时间(年)
    */
    private String freezeYear;
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
	public Float getUsageAmount1() {
		return usageAmount1;
	}
	public void setUsageAmount1(Float usageAmount1) {
		this.usageAmount1 = usageAmount1;
	}
	public Float getUsageAmount2() {
		return usageAmount2;
	}
	public void setUsageAmount2(Float usageAmount2) {
		this.usageAmount2 = usageAmount2;
	}
	public Float getUsageAmount3() {
		return usageAmount3;
	}
	public void setUsageAmount3(Float usageAmount3) {
		this.usageAmount3 = usageAmount3;
	}
	public Float getUsageAmount4() {
		return usageAmount4;
	}
	public void setUsageAmount4(Float usageAmount4) {
		this.usageAmount4 = usageAmount4;
	}
	public Float getUsageAmount5() {
		return usageAmount5;
	}
	public void setUsageAmount5(Float usageAmount5) {
		this.usageAmount5 = usageAmount5;
	}
	public Float getUsageAmount6() {
		return usageAmount6;
	}
	public void setUsageAmount6(Float usageAmount6) {
		this.usageAmount6 = usageAmount6;
	}
	public Float getUsageAmount7() {
		return usageAmount7;
	}
	public void setUsageAmount7(Float usageAmount7) {
		this.usageAmount7 = usageAmount7;
	}
	public Float getUsageAmount8() {
		return usageAmount8;
	}
	public void setUsageAmount8(Float usageAmount8) {
		this.usageAmount8 = usageAmount8;
	}
	public Float getUsageAmount9() {
		return usageAmount9;
	}
	public void setUsageAmount9(Float usageAmount9) {
		this.usageAmount9 = usageAmount9;
	}
	public Float getUsageAmount10() {
		return usageAmount10;
	}
	public void setUsageAmount10(Float usageAmount10) {
		this.usageAmount10 = usageAmount10;
	}
	public Float getUsageAmount11() {
		return usageAmount11;
	}
	public void setUsageAmount11(Float usageAmount11) {
		this.usageAmount11 = usageAmount11;
	}
	public Float getUsageAmount12() {
		return usageAmount12;
	}
	public void setUsageAmount12(Float usageAmount12) {
		this.usageAmount12 = usageAmount12;
	}
	public String getFreezeYear() {
		return freezeYear;
	}
	public void setFreezeYear(String freezeYear) {
		this.freezeYear = freezeYear;
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
