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
    private Integer usageAmount1;
    /**
     * 2日水用量
    */
    private Integer usageAmount2;
    /**
     * 3日水用量
    */
    private Integer usageAmount3;
    /**
     * 4日水用量
    */
    private Integer usageAmount4;
    /**
     * 5日水用量
    */
    private Integer usageAmount5;
    /**
     * 6日水用量
    */
    private Integer usageAmount6;
    /**
     * 7日水用量
    */
    private Integer usageAmount7;
    /**
     * 8日水用量
    */
    private Integer usageAmount8;
    /**
     * 9日水用量
    */
    private Integer usageAmount9;
    /**
     * 10日水用量
    */
    private Integer usageAmount10;
    /**
     * 11日水用量
    */
    private Integer usageAmount11;
    /**
     * 12日水用量
    */
    private Integer usageAmount12;
    /**
     * 13日水用量
    */
    private Integer usageAmount13;
    /**
     * 14日水用量
    */
    private Integer usageAmount14;
    /**
     * 15日水用量
    */
    private Integer usageAmount15;
    /**
     * 16日水用量
    */
    private Integer usageAmount16;
    /**
     * 17日水用量
    */
    private Integer usageAmount17;
    /**
     * 18日水用量
    */
    private Integer usageAmount18;
    /**
     * 19日水用量
    */
    private Integer usageAmount19;
    /**
     * 20日水用量
    */
    private Integer usageAmount20;
    /**
     * 21日水用量
    */
    private Integer usageAmount21;
    /**
     * 22日水用量
    */
    private Integer usageAmount22;
    /**
     * 23日水用量
    */
    private Integer usageAmount23;
    /**
     * 24日水用量
    */
    private Integer usageAmount24;
    /**
     * 25日水用量
    */
    private Integer usageAmount25;
    /**
     * 26日水用量
    */
    private Integer usageAmount26;
    /**
     * 27日水用量
    */
    private Integer usageAmount27;
    /**
     * 28日水用量
    */
    private Integer usageAmount28;
    /**
     * 29日水用量
    */
    private Integer usageAmount29;
    /**
     * 30日水用量
    */
    private Integer usageAmount30;
    /**
     * 31日水用量
    */
    private Integer usageAmount31;
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
	public Integer getUsageAmount1() {
		return usageAmount1;
	}
	public void setUsageAmount1(Integer usageAmount1) {
		this.usageAmount1 = usageAmount1;
	}
	public Integer getUsageAmount2() {
		return usageAmount2;
	}
	public void setUsageAmount2(Integer usageAmount2) {
		this.usageAmount2 = usageAmount2;
	}
	public Integer getUsageAmount3() {
		return usageAmount3;
	}
	public void setUsageAmount3(Integer usageAmount3) {
		this.usageAmount3 = usageAmount3;
	}
	public Integer getUsageAmount4() {
		return usageAmount4;
	}
	public void setUsageAmount4(Integer usageAmount4) {
		this.usageAmount4 = usageAmount4;
	}
	public Integer getUsageAmount5() {
		return usageAmount5;
	}
	public void setUsageAmount5(Integer usageAmount5) {
		this.usageAmount5 = usageAmount5;
	}
	public Integer getUsageAmount6() {
		return usageAmount6;
	}
	public void setUsageAmount6(Integer usageAmount6) {
		this.usageAmount6 = usageAmount6;
	}
	public Integer getUsageAmount7() {
		return usageAmount7;
	}
	public void setUsageAmount7(Integer usageAmount7) {
		this.usageAmount7 = usageAmount7;
	}
	public Integer getUsageAmount8() {
		return usageAmount8;
	}
	public void setUsageAmount8(Integer usageAmount8) {
		this.usageAmount8 = usageAmount8;
	}
	public Integer getUsageAmount9() {
		return usageAmount9;
	}
	public void setUsageAmount9(Integer usageAmount9) {
		this.usageAmount9 = usageAmount9;
	}
	public Integer getUsageAmount10() {
		return usageAmount10;
	}
	public void setUsageAmount10(Integer usageAmount10) {
		this.usageAmount10 = usageAmount10;
	}
	public Integer getUsageAmount11() {
		return usageAmount11;
	}
	public void setUsageAmount11(Integer usageAmount11) {
		this.usageAmount11 = usageAmount11;
	}
	public Integer getUsageAmount12() {
		return usageAmount12;
	}
	public void setUsageAmount12(Integer usageAmount12) {
		this.usageAmount12 = usageAmount12;
	}
	public Integer getUsageAmount13() {
		return usageAmount13;
	}
	public void setUsageAmount13(Integer usageAmount13) {
		this.usageAmount13 = usageAmount13;
	}
	public Integer getUsageAmount14() {
		return usageAmount14;
	}
	public void setUsageAmount14(Integer usageAmount14) {
		this.usageAmount14 = usageAmount14;
	}
	public Integer getUsageAmount15() {
		return usageAmount15;
	}
	public void setUsageAmount15(Integer usageAmount15) {
		this.usageAmount15 = usageAmount15;
	}
	public Integer getUsageAmount16() {
		return usageAmount16;
	}
	public void setUsageAmount16(Integer usageAmount16) {
		this.usageAmount16 = usageAmount16;
	}
	public Integer getUsageAmount17() {
		return usageAmount17;
	}
	public void setUsageAmount17(Integer usageAmount17) {
		this.usageAmount17 = usageAmount17;
	}
	public Integer getUsageAmount18() {
		return usageAmount18;
	}
	public void setUsageAmount18(Integer usageAmount18) {
		this.usageAmount18 = usageAmount18;
	}
	public Integer getUsageAmount19() {
		return usageAmount19;
	}
	public void setUsageAmount19(Integer usageAmount19) {
		this.usageAmount19 = usageAmount19;
	}
	public Integer getUsageAmount20() {
		return usageAmount20;
	}
	public void setUsageAmount20(Integer usageAmount20) {
		this.usageAmount20 = usageAmount20;
	}
	public Integer getUsageAmount21() {
		return usageAmount21;
	}
	public void setUsageAmount21(Integer usageAmount21) {
		this.usageAmount21 = usageAmount21;
	}
	public Integer getUsageAmount22() {
		return usageAmount22;
	}
	public void setUsageAmount22(Integer usageAmount22) {
		this.usageAmount22 = usageAmount22;
	}
	public Integer getUsageAmount23() {
		return usageAmount23;
	}
	public void setUsageAmount23(Integer usageAmount23) {
		this.usageAmount23 = usageAmount23;
	}
	public Integer getUsageAmount24() {
		return usageAmount24;
	}
	public void setUsageAmount24(Integer usageAmount24) {
		this.usageAmount24 = usageAmount24;
	}
	public Integer getUsageAmount25() {
		return usageAmount25;
	}
	public void setUsageAmount25(Integer usageAmount25) {
		this.usageAmount25 = usageAmount25;
	}
	public Integer getUsageAmount26() {
		return usageAmount26;
	}
	public void setUsageAmount26(Integer usageAmount26) {
		this.usageAmount26 = usageAmount26;
	}
	public Integer getUsageAmount27() {
		return usageAmount27;
	}
	public void setUsageAmount27(Integer usageAmount27) {
		this.usageAmount27 = usageAmount27;
	}
	public Integer getUsageAmount28() {
		return usageAmount28;
	}
	public void setUsageAmount28(Integer usageAmount28) {
		this.usageAmount28 = usageAmount28;
	}
	public Integer getUsageAmount29() {
		return usageAmount29;
	}
	public void setUsageAmount29(Integer usageAmount29) {
		this.usageAmount29 = usageAmount29;
	}
	public Integer getUsageAmount30() {
		return usageAmount30;
	}
	public void setUsageAmount30(Integer usageAmount30) {
		this.usageAmount30 = usageAmount30;
	}
	public Integer getUsageAmount31() {
		return usageAmount31;
	}
	public void setUsageAmount31(Integer usageAmount31) {
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
