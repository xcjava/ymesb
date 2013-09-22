package com.ymsino.esb.archives.vo;

import java.io.Serializable;

public class PrepaidMeterReturn implements Serializable {

	/**
     * 预付费水表编号
    */
    private String pmSn;
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
     * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
    */
    private String parentUnits;
    /**
     * 子表号
    */
    private String childPmSn;
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
     * 当前水价(单位：分)
    */
    private Long currentPrice;
    /**
     * 水表类型：1,IC卡预付费水表;2,红外卡预付费水表
    */
    private Short type;
    /**
     * 创建时间
    */
    private Long createTimestamp;
	public String getPmSn() {
		return pmSn;
	}
	public void setPmSn(String pmSn) {
		this.pmSn = pmSn;
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
	public String getParentUnits() {
		return parentUnits;
	}
	public void setParentUnits(String parentUnits) {
		this.parentUnits = parentUnits;
	}
	public String getChildPmSn() {
		return childPmSn;
	}
	public void setChildPmSn(String childPmSn) {
		this.childPmSn = childPmSn;
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
	public Long getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Long currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
}
