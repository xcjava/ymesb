package com.ymsino.esb.manager.vo;

import java.io.Serializable;

public class PriceTemplateModifyParam implements Serializable {

	/**
     * 价目id
    */
    Long id;
    /**
     * 价目名称
    */
    String name;
    /**
     * 价目类型
    */
    String type;
    /**
     * 1阶最大值
    */
    Long level1Num;
    /**
     * 1阶价格，单位分
    */
    Long level1Cost;
    /**
     * 2阶最大值
    */
    Long level2Num;
    /**
     * 2阶价格，单位分
    */
    Long level2Cost;
    /**
     * 3阶最大值
    */
    Long level3Num;
    /**
     * 3阶价格，单位分
    */
    Long level3Cost;
    /**
     * 4阶最大值
    */
    Long level4Num;
    /**
     * 结算周期
    */
    String billingPeriod;
    /**
     * 开始日期
    */
    String startDate;
    /**
     * 结束日期
    */
    String endDate;
    /**
     * 备注
    */
    String remark;
    /**
     * 收费单位编号
    */
    String chargingUnitId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getLevel1Num() {
		return level1Num;
	}
	public void setLevel1Num(Long level1Num) {
		this.level1Num = level1Num;
	}
	public Long getLevel1Cost() {
		return level1Cost;
	}
	public void setLevel1Cost(Long level1Cost) {
		this.level1Cost = level1Cost;
	}
	public Long getLevel2Num() {
		return level2Num;
	}
	public void setLevel2Num(Long level2Num) {
		this.level2Num = level2Num;
	}
	public Long getLevel2Cost() {
		return level2Cost;
	}
	public void setLevel2Cost(Long level2Cost) {
		this.level2Cost = level2Cost;
	}
	public Long getLevel3Num() {
		return level3Num;
	}
	public void setLevel3Num(Long level3Num) {
		this.level3Num = level3Num;
	}
	public Long getLevel3Cost() {
		return level3Cost;
	}
	public void setLevel3Cost(Long level3Cost) {
		this.level3Cost = level3Cost;
	}
	public Long getLevel4Num() {
		return level4Num;
	}
	public void setLevel4Num(Long level4Num) {
		this.level4Num = level4Num;
	}
	public String getBillingPeriod() {
		return billingPeriod;
	}
	public void setBillingPeriod(String billingPeriod) {
		this.billingPeriod = billingPeriod;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getChargingUnitId() {
		return chargingUnitId;
	}
	public void setChargingUnitId(String chargingUnitId) {
		this.chargingUnitId = chargingUnitId;
	}
}
