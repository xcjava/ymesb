package com.ymsino.esb.data.vo;

import java.io.Serializable;

public class WaterDayUsageAmountReturn implements Serializable {

	/**
     * 水表日用量自增id
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
     * 1日水用量
    */
    private Float usageAmount1;
    /**
     * 2日水用量
    */
    private Float usageAmount2;
    /**
     * 3日水用量
    */
    private Float usageAmount3;
    /**
     * 4日水用量
    */
    private Float usageAmount4;
    /**
     * 5日水用量
    */
    private Float usageAmount5;
    /**
     * 6日水用量
    */
    private Float usageAmount6;
    /**
     * 7日水用量
    */
    private Float usageAmount7;
    /**
     * 8日水用量
    */
    private Float usageAmount8;
    /**
     * 9日水用量
    */
    private Float usageAmount9;
    /**
     * 10日水用量
    */
    private Float usageAmount10;
    /**
     * 11日水用量
    */
    private Float usageAmount11;
    /**
     * 12日水用量
    */
    private Float usageAmount12;
    /**
     * 13日水用量
    */
    private Float usageAmount13;
    /**
     * 14日水用量
    */
    private Float usageAmount14;
    /**
     * 15日水用量
    */
    private Float usageAmount15;
    /**
     * 16日水用量
    */
    private Float usageAmount16;
    /**
     * 17日水用量
    */
    private Float usageAmount17;
    /**
     * 18日水用量
    */
    private Float usageAmount18;
    /**
     * 19日水用量
    */
    private Float usageAmount19;
    /**
     * 20日水用量
    */
    private Float usageAmount20;
    /**
     * 21日水用量
    */
    private Float usageAmount21;
    /**
     * 22日水用量
    */
    private Float usageAmount22;
    /**
     * 23日水用量
    */
    private Float usageAmount23;
    /**
     * 24日水用量
    */
    private Float usageAmount24;
    /**
     * 25日水用量
    */
    private Float usageAmount25;
    /**
     * 26日水用量
    */
    private Float usageAmount26;
    /**
     * 27日水用量
    */
    private Float usageAmount27;
    /**
     * 28日水用量
    */
    private Float usageAmount28;
    /**
     * 29日水用量
    */
    private Float usageAmount29;
    /**
     * 30日水用量
    */
    private Float usageAmount30;
    /**
     * 31日水用量
    */
    private Float usageAmount31;
    /**
     * 冻结时间(年)
    */
    private String freezeYear;
    /**
     * 冻结时间(月)
    */
    private String freezeMonth;
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
	public Float getUsageAmount13() {
		return usageAmount13;
	}
	public void setUsageAmount13(Float usageAmount13) {
		this.usageAmount13 = usageAmount13;
	}
	public Float getUsageAmount14() {
		return usageAmount14;
	}
	public void setUsageAmount14(Float usageAmount14) {
		this.usageAmount14 = usageAmount14;
	}
	public Float getUsageAmount15() {
		return usageAmount15;
	}
	public void setUsageAmount15(Float usageAmount15) {
		this.usageAmount15 = usageAmount15;
	}
	public Float getUsageAmount16() {
		return usageAmount16;
	}
	public void setUsageAmount16(Float usageAmount16) {
		this.usageAmount16 = usageAmount16;
	}
	public Float getUsageAmount17() {
		return usageAmount17;
	}
	public void setUsageAmount17(Float usageAmount17) {
		this.usageAmount17 = usageAmount17;
	}
	public Float getUsageAmount18() {
		return usageAmount18;
	}
	public void setUsageAmount18(Float usageAmount18) {
		this.usageAmount18 = usageAmount18;
	}
	public Float getUsageAmount19() {
		return usageAmount19;
	}
	public void setUsageAmount19(Float usageAmount19) {
		this.usageAmount19 = usageAmount19;
	}
	public Float getUsageAmount20() {
		return usageAmount20;
	}
	public void setUsageAmount20(Float usageAmount20) {
		this.usageAmount20 = usageAmount20;
	}
	public Float getUsageAmount21() {
		return usageAmount21;
	}
	public void setUsageAmount21(Float usageAmount21) {
		this.usageAmount21 = usageAmount21;
	}
	public Float getUsageAmount22() {
		return usageAmount22;
	}
	public void setUsageAmount22(Float usageAmount22) {
		this.usageAmount22 = usageAmount22;
	}
	public Float getUsageAmount23() {
		return usageAmount23;
	}
	public void setUsageAmount23(Float usageAmount23) {
		this.usageAmount23 = usageAmount23;
	}
	public Float getUsageAmount24() {
		return usageAmount24;
	}
	public void setUsageAmount24(Float usageAmount24) {
		this.usageAmount24 = usageAmount24;
	}
	public Float getUsageAmount25() {
		return usageAmount25;
	}
	public void setUsageAmount25(Float usageAmount25) {
		this.usageAmount25 = usageAmount25;
	}
	public Float getUsageAmount26() {
		return usageAmount26;
	}
	public void setUsageAmount26(Float usageAmount26) {
		this.usageAmount26 = usageAmount26;
	}
	public Float getUsageAmount27() {
		return usageAmount27;
	}
	public void setUsageAmount27(Float usageAmount27) {
		this.usageAmount27 = usageAmount27;
	}
	public Float getUsageAmount28() {
		return usageAmount28;
	}
	public void setUsageAmount28(Float usageAmount28) {
		this.usageAmount28 = usageAmount28;
	}
	public Float getUsageAmount29() {
		return usageAmount29;
	}
	public void setUsageAmount29(Float usageAmount29) {
		this.usageAmount29 = usageAmount29;
	}
	public Float getUsageAmount30() {
		return usageAmount30;
	}
	public void setUsageAmount30(Float usageAmount30) {
		this.usageAmount30 = usageAmount30;
	}
	public Float getUsageAmount31() {
		return usageAmount31;
	}
	public void setUsageAmount31(Float usageAmount31) {
		this.usageAmount31 = usageAmount31;
	}
	public String getFreezeYear() {
		return freezeYear;
	}
	public void setFreezeYear(String freezeYear) {
		this.freezeYear = freezeYear;
	}
	public String getFreezeMonth() {
		return freezeMonth;
	}
	public void setFreezeMonth(String freezeMonth) {
		this.freezeMonth = freezeMonth;
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
