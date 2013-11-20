package com.ymsino.esb.manager.vo;

import java.io.Serializable;

public class PriceTemplateReturn implements Serializable {

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
    Float level1Num;
    /**
     * 1阶价格，单位毫
    */
    Long level1Cost;
    /**
     * 2阶最大值
    */
    Float level2Num;
    /**
     * 2阶价格，单位毫
    */
    Long level2Cost;
    /**
     * 3阶最大值
    */
    Float level3Num;
    /**
     * 3阶价格，单位毫
    */
    Long level3Cost;
    /**
     * 4阶最大值
    */
    Float level4Num;
    /**
     * 4阶价格，单位毫
    */
    Long level4Cost;
    /**
     * 结算周期
    */
    String billingPeriod;
    /**
     * 开始日期
    */
    Long startTimestamp;
    /**
     * 结束日期
    */
    Long endTimestamp;
    /**
     * 备注
    */
    String remark;
    /**
     * 收费单位编号
    */
    String chargingUnitId;
    /**
     * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
    */
    String parentUnits;
    /**
     * 创建时间
    */
    Long createTimestamp;
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
	public Float getLevel1Num() {
		return level1Num;
	}
	public void setLevel1Num(Float level1Num) {
		this.level1Num = level1Num;
	}
	public Long getLevel1Cost() {
		return level1Cost;
	}
	public void setLevel1Cost(Long level1Cost) {
		this.level1Cost = level1Cost;
	}
	public Float getLevel2Num() {
		return level2Num;
	}
	public void setLevel2Num(Float level2Num) {
		this.level2Num = level2Num;
	}
	public Long getLevel2Cost() {
		return level2Cost;
	}
	public void setLevel2Cost(Long level2Cost) {
		this.level2Cost = level2Cost;
	}
	public Float getLevel3Num() {
		return level3Num;
	}
	public void setLevel3Num(Float level3Num) {
		this.level3Num = level3Num;
	}
	public Long getLevel3Cost() {
		return level3Cost;
	}
	public void setLevel3Cost(Long level3Cost) {
		this.level3Cost = level3Cost;
	}
	public Float getLevel4Num() {
		return level4Num;
	}
	public void setLevel4Num(Float level4Num) {
		this.level4Num = level4Num;
	}
	public Long getLevel4Cost() {
		return level4Cost;
	}
	public void setLevel4Cost(Long level4Cost) {
		this.level4Cost = level4Cost;
	}
	public String getBillingPeriod() {
		return billingPeriod;
	}
	public void setBillingPeriod(String billingPeriod) {
		this.billingPeriod = billingPeriod;
	}
	public Long getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(Long startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	public Long getEndTimestamp() {
		return endTimestamp;
	}
	public void setEndTimestamp(Long endTimestamp) {
		this.endTimestamp = endTimestamp;
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
	public String getParentUnits() {
		return parentUnits;
	}
	public void setParentUnits(String parentUnits) {
		this.parentUnits = parentUnits;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
}
