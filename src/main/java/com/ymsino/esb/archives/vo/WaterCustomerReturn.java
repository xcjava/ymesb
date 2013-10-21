package com.ymsino.esb.archives.vo;

import java.io.Serializable;

public class WaterCustomerReturn implements Serializable {

	/**
     * 用水用户编号
    */
    String customerId;
    /**
     * 用水用户名称
    */
    String customerName;
    /**
     * 自定义查询号
    */
    String customNum;
    /**
     * 用户id
    */
    Long uid;
    /**
     * 客户编号
    */
    String userId;
    /**
     * 客户名称
    */
    String userName;
    /**
     * 收费单位编号
    */
    String chargingUnitId;
    /**
     * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
    */
    String parentUnits;
    /**
     * 原客户编号
    */
    String oldUserId;
    /**
     * 用户分类
    */
    String customerType;
    /**
     * 用户状态
    */
    String customerStatus;
    /**
     * 行业分类
    */
    String category;
    /**
     * 业务类别
    */
    String businessType;
    /**
     * 合同容量
    */
    String contractCapacity;
    /**
     * 高耗能行业类别
    */
    String highEnergySectors;
    /**
     * 开户日期
    */
    Long openTimestamp;
    /**
     * 销户日期
    */
    Long closeTimestamp;
    /**
     * 到期日期
    */
    Long maturityTimestamp;
    /**
     * 水费通知方式
    */
    String notifyType;
    /**
     * 水费结算方式
    */
    String settlementType;
    /**
     * 票据类型
    */
    String billType;
    /**
     * 停水标志
    */
    String withoutWaterMark;
    /**
     * 转供标志
    */
    String turnForMark;
    /**
     * 抄表段编号
    */
    String meterSegmentNum;
    /**
     * 业务地址
    */
    String busiAddress;
    /**
     * 供水点名称
    */
    String waterPointsName;
    /**
     * 供水点类型
    */
    String waterPointsType;
    /**
     * 运行状态
    */
    String workStatus;
    /**
     * 定价策略类型
    */
    String pricStrategyType;
    /**
     * 基本水费计算方式
    */
    String basicWaterPriceCalc;
    /**
     * 水价行业类别
    */
    String waterPriceIndustry;
    /**
     * 用水性质
    */
    String waterNature;
    /**
     * 是否执行阶梯标志
    */
    String ladderFlag;
    /**
     * 价目模版id
    */
    Long priceTemplateId;
    /**
     * 供水点备注
    */
    String remark;
    /**
     * 创建时间
    */
    Long createTimestamp;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomNum() {
		return customNum;
	}
	public void setCustomNum(String customNum) {
		this.customNum = customNum;
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
	public String getOldUserId() {
		return oldUserId;
	}
	public void setOldUserId(String oldUserId) {
		this.oldUserId = oldUserId;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getContractCapacity() {
		return contractCapacity;
	}
	public void setContractCapacity(String contractCapacity) {
		this.contractCapacity = contractCapacity;
	}
	public String getHighEnergySectors() {
		return highEnergySectors;
	}
	public void setHighEnergySectors(String highEnergySectors) {
		this.highEnergySectors = highEnergySectors;
	}
	public Long getOpenTimestamp() {
		return openTimestamp;
	}
	public void setOpenTimestamp(Long openTimestamp) {
		this.openTimestamp = openTimestamp;
	}
	public Long getCloseTimestamp() {
		return closeTimestamp;
	}
	public void setCloseTimestamp(Long closeTimestamp) {
		this.closeTimestamp = closeTimestamp;
	}
	public Long getMaturityTimestamp() {
		return maturityTimestamp;
	}
	public void setMaturityTimestamp(Long maturityTimestamp) {
		this.maturityTimestamp = maturityTimestamp;
	}
	public String getNotifyType() {
		return notifyType;
	}
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	public String getSettlementType() {
		return settlementType;
	}
	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getWithoutWaterMark() {
		return withoutWaterMark;
	}
	public void setWithoutWaterMark(String withoutWaterMark) {
		this.withoutWaterMark = withoutWaterMark;
	}
	public String getTurnForMark() {
		return turnForMark;
	}
	public void setTurnForMark(String turnForMark) {
		this.turnForMark = turnForMark;
	}
	public String getMeterSegmentNum() {
		return meterSegmentNum;
	}
	public void setMeterSegmentNum(String meterSegmentNum) {
		this.meterSegmentNum = meterSegmentNum;
	}
	public String getBusiAddress() {
		return busiAddress;
	}
	public void setBusiAddress(String busiAddress) {
		this.busiAddress = busiAddress;
	}
	public String getWaterPointsName() {
		return waterPointsName;
	}
	public void setWaterPointsName(String waterPointsName) {
		this.waterPointsName = waterPointsName;
	}
	public String getWaterPointsType() {
		return waterPointsType;
	}
	public void setWaterPointsType(String waterPointsType) {
		this.waterPointsType = waterPointsType;
	}
	public String getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public String getPricStrategyType() {
		return pricStrategyType;
	}
	public void setPricStrategyType(String pricStrategyType) {
		this.pricStrategyType = pricStrategyType;
	}
	public String getBasicWaterPriceCalc() {
		return basicWaterPriceCalc;
	}
	public void setBasicWaterPriceCalc(String basicWaterPriceCalc) {
		this.basicWaterPriceCalc = basicWaterPriceCalc;
	}
	public String getWaterPriceIndustry() {
		return waterPriceIndustry;
	}
	public void setWaterPriceIndustry(String waterPriceIndustry) {
		this.waterPriceIndustry = waterPriceIndustry;
	}
	public String getWaterNature() {
		return waterNature;
	}
	public void setWaterNature(String waterNature) {
		this.waterNature = waterNature;
	}
	public String getLadderFlag() {
		return ladderFlag;
	}
	public void setLadderFlag(String ladderFlag) {
		this.ladderFlag = ladderFlag;
	}
	public Long getPriceTemplateId() {
		return priceTemplateId;
	}
	public void setPriceTemplateId(Long priceTemplateId) {
		this.priceTemplateId = priceTemplateId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
}
