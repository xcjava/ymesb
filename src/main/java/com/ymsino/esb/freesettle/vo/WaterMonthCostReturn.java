package com.ymsino.esb.freesettle.vo;

import java.io.Serializable;

public class WaterMonthCostReturn implements Serializable {

	/**
     * 水表月费用自增id
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
     * 1月费用
    */
    private Long cost1;
    /**
     * 2月费用
    */
    private Long cost2;
    /**
     * 3月费用
    */
    private Long cost3;
    /**
     * 4月费用
    */
    private Long cost4;
    /**
     * 5月费用
    */
    private Long cost5;
    /**
     * 6月费用
    */
    private Long cost6;
    /**
     * 7月费用
    */
    private Long cost7;
    /**
     * 8月费用
    */
    private Long cost8;
    /**
     * 9月费用
    */
    private Long cost9;
    /**
     * 10月费用
    */
    private Long cost10;
    /**
     * 11月费用
    */
    private Long cost11;
    /**
     * 12月费用
    */
    private Long cost12;
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
	public Long getCost1() {
		return cost1;
	}
	public void setCost1(Long cost1) {
		this.cost1 = cost1;
	}
	public Long getCost2() {
		return cost2;
	}
	public void setCost2(Long cost2) {
		this.cost2 = cost2;
	}
	public Long getCost3() {
		return cost3;
	}
	public void setCost3(Long cost3) {
		this.cost3 = cost3;
	}
	public Long getCost4() {
		return cost4;
	}
	public void setCost4(Long cost4) {
		this.cost4 = cost4;
	}
	public Long getCost5() {
		return cost5;
	}
	public void setCost5(Long cost5) {
		this.cost5 = cost5;
	}
	public Long getCost6() {
		return cost6;
	}
	public void setCost6(Long cost6) {
		this.cost6 = cost6;
	}
	public Long getCost7() {
		return cost7;
	}
	public void setCost7(Long cost7) {
		this.cost7 = cost7;
	}
	public Long getCost8() {
		return cost8;
	}
	public void setCost8(Long cost8) {
		this.cost8 = cost8;
	}
	public Long getCost9() {
		return cost9;
	}
	public void setCost9(Long cost9) {
		this.cost9 = cost9;
	}
	public Long getCost10() {
		return cost10;
	}
	public void setCost10(Long cost10) {
		this.cost10 = cost10;
	}
	public Long getCost11() {
		return cost11;
	}
	public void setCost11(Long cost11) {
		this.cost11 = cost11;
	}
	public Long getCost12() {
		return cost12;
	}
	public void setCost12(Long cost12) {
		this.cost12 = cost12;
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
