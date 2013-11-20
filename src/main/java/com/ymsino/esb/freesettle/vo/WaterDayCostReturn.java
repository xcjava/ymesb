package com.ymsino.esb.freesettle.vo;

import java.io.Serializable;

public class WaterDayCostReturn implements Serializable {

	/**
     * 水表日费用自增id
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
     * 1日费用
    */
    private Long cost1;
    /**
     * 2日费用
    */
    private Long cost2;
    /**
     * 3日费用
    */
    private Long cost3;
    /**
     * 4日费用
    */
    private Long cost4;
    /**
     * 5日费用
    */
    private Long cost5;
    /**
     * 6日费用
    */
    private Long cost6;
    /**
     * 7日费用
    */
    private Long cost7;
    /**
     * 8日费用
    */
    private Long cost8;
    /**
     * 9日费用
    */
    private Long cost9;
    /**
     * 10日费用
    */
    private Long cost10;
    /**
     * 11日费用
    */
    private Long cost11;
    /**
     * 12日费用
    */
    private Long cost12;
    /**
     * 13日费用
    */
    private Long cost13;
    /**
     * 14日费用
    */
    private Long cost14;
    /**
     * 15日费用
    */
    private Long cost15;
    /**
     * 16日费用
    */
    private Long cost16;
    /**
     * 17日费用
    */
    private Long cost17;
    /**
     * 18日费用
    */
    private Long cost18;
    /**
     * 19日费用
    */
    private Long cost19;
    /**
     * 20日费用
    */
    private Long cost20;
    /**
     * 21日费用
    */
    private Long cost21;
    /**
     * 22日费用
    */
    private Long cost22;
    /**
     * 23日费用
    */
    private Long cost23;
    /**
     * 24日费用
    */
    private Long cost24;
    /**
     * 25日费用
    */
    private Long cost25;
    /**
     * 26日费用
    */
    private Long cost26;
    /**
     * 27日费用
    */
    private Long cost27;
    /**
     * 28日费用
    */
    private Long cost28;
    /**
     * 29日费用
    */
    private Long cost29;
    /**
     * 30日费用
    */
    private Long cost30;
    /**
     * 31日费用
    */
    private Long cost31;
    /**
     * 月合计费用
    */
    private Long totalCost;
    /**
     * 支付状态-1:未支付;1已支付
    */
    private Short payStatus;
    /**
     * 扣费检查状态-1:未检查;1已检查
    */
    private Short checkPayStatus;
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
	public Long getCost13() {
		return cost13;
	}
	public void setCost13(Long cost13) {
		this.cost13 = cost13;
	}
	public Long getCost14() {
		return cost14;
	}
	public void setCost14(Long cost14) {
		this.cost14 = cost14;
	}
	public Long getCost15() {
		return cost15;
	}
	public void setCost15(Long cost15) {
		this.cost15 = cost15;
	}
	public Long getCost16() {
		return cost16;
	}
	public void setCost16(Long cost16) {
		this.cost16 = cost16;
	}
	public Long getCost17() {
		return cost17;
	}
	public void setCost17(Long cost17) {
		this.cost17 = cost17;
	}
	public Long getCost18() {
		return cost18;
	}
	public void setCost18(Long cost18) {
		this.cost18 = cost18;
	}
	public Long getCost19() {
		return cost19;
	}
	public void setCost19(Long cost19) {
		this.cost19 = cost19;
	}
	public Long getCost20() {
		return cost20;
	}
	public void setCost20(Long cost20) {
		this.cost20 = cost20;
	}
	public Long getCost21() {
		return cost21;
	}
	public void setCost21(Long cost21) {
		this.cost21 = cost21;
	}
	public Long getCost22() {
		return cost22;
	}
	public void setCost22(Long cost22) {
		this.cost22 = cost22;
	}
	public Long getCost23() {
		return cost23;
	}
	public void setCost23(Long cost23) {
		this.cost23 = cost23;
	}
	public Long getCost24() {
		return cost24;
	}
	public void setCost24(Long cost24) {
		this.cost24 = cost24;
	}
	public Long getCost25() {
		return cost25;
	}
	public void setCost25(Long cost25) {
		this.cost25 = cost25;
	}
	public Long getCost26() {
		return cost26;
	}
	public void setCost26(Long cost26) {
		this.cost26 = cost26;
	}
	public Long getCost27() {
		return cost27;
	}
	public void setCost27(Long cost27) {
		this.cost27 = cost27;
	}
	public Long getCost28() {
		return cost28;
	}
	public void setCost28(Long cost28) {
		this.cost28 = cost28;
	}
	public Long getCost29() {
		return cost29;
	}
	public void setCost29(Long cost29) {
		this.cost29 = cost29;
	}
	public Long getCost30() {
		return cost30;
	}
	public void setCost30(Long cost30) {
		this.cost30 = cost30;
	}
	public Long getCost31() {
		return cost31;
	}
	public void setCost31(Long cost31) {
		this.cost31 = cost31;
	}
	public Long getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}
	public Short getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Short payStatus) {
		this.payStatus = payStatus;
	}
	public Short getCheckPayStatus() {
		return checkPayStatus;
	}
	public void setCheckPayStatus(Short checkPayStatus) {
		this.checkPayStatus = checkPayStatus;
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
