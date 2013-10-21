package com.ymsino.esb.archives.model;



/**
 * WaterCustomer entity. @author MyEclipse Persistence Tools
 */

public class WaterCustomer  implements java.io.Serializable {


    // Fields    

     /**
      * 用水用户编号
     */
     private String customerId;
     /**
      * 用水用户名称
     */
     private String customerName;
     /**
      * 自定义查询号
     */
     private String customNum;
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
      * 原客户编号
     */
     private String oldUserId;
     /**
      * 用户分类
     */
     private String customerType;
     /**
      * 用户状态
     */
     private String customerStatus;
     /**
      * 行业分类
     */
     private String category;
     /**
      * 业务类别
     */
     private String businessType;
     /**
      * 合同容量
     */
     private String contractCapacity;
     /**
      * 高耗能行业类别
     */
     private String highEnergySectors;
     /**
      * 开户日期
     */
     private Long openTimestamp;
     /**
      * 销户日期
     */
     private Long closeTimestamp;
     /**
      * 到期日期
     */
     private Long maturityTimestamp;
     /**
      * 水费通知方式
     */
     private String notifyType;
     /**
      * 水费结算方式
     */
     private String settlementType;
     /**
      * 票据类型
     */
     private String billType;
     /**
      * 停水标志
     */
     private String withoutWaterMark;
     /**
      * 转供标志
     */
     private String turnForMark;
     /**
      * 抄表段编号
     */
     private String meterSegmentNum;
     /**
      * 业务地址
     */
     private String busiAddress;
     /**
      * 供水点名称
     */
     private String waterPointsName;
     /**
      * 供水点类型
     */
     private String waterPointsType;
     /**
      * 运行状态
     */
     private String workStatus;
     /**
      * 定价策略类型
     */
     private String pricStrategyType;
     /**
      * 基本水费计算方式
     */
     private String basicWaterPriceCalc;
     /**
      * 水价行业类别
     */
     private String waterPriceIndustry;
     /**
      * 用水性质
     */
     private String waterNature;
     /**
      * 是否执行阶梯标志
     */
     private String ladderFlag;
     /**
      * 价目模版id
     */
     private Long priceTemplateId;
     /**
      * 供水点备注
     */
     private String remark;
     /**
      * 创建时间
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public WaterCustomer() {
    }

	/** minimal constructor */
    public WaterCustomer(String customerId) {
        this.customerId = customerId;
    }
    
    /** full constructor */
    public WaterCustomer(String customerId, String customerName, String customNum, Long uid, String userId, String userName, String chargingUnitId, String parentUnits, String oldUserId, String customerType, String customerStatus, String category, String businessType, String contractCapacity, String highEnergySectors, Long openTimestamp, Long closeTimestamp, Long maturityTimestamp, String notifyType, String settlementType, String billType, String withoutWaterMark, String turnForMark, String meterSegmentNum, String busiAddress, String waterPointsName, String waterPointsType, String workStatus, String pricStrategyType, String basicWaterPriceCalc, String waterPriceIndustry, String waterNature, String ladderFlag, Long priceTemplateId, String remark, Long createTimestamp) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customNum = customNum;
        this.uid = uid;
        this.userId = userId;
        this.userName = userName;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.oldUserId = oldUserId;
        this.customerType = customerType;
        this.customerStatus = customerStatus;
        this.category = category;
        this.businessType = businessType;
        this.contractCapacity = contractCapacity;
        this.highEnergySectors = highEnergySectors;
        this.openTimestamp = openTimestamp;
        this.closeTimestamp = closeTimestamp;
        this.maturityTimestamp = maturityTimestamp;
        this.notifyType = notifyType;
        this.settlementType = settlementType;
        this.billType = billType;
        this.withoutWaterMark = withoutWaterMark;
        this.turnForMark = turnForMark;
        this.meterSegmentNum = meterSegmentNum;
        this.busiAddress = busiAddress;
        this.waterPointsName = waterPointsName;
        this.waterPointsType = waterPointsType;
        this.workStatus = workStatus;
        this.pricStrategyType = pricStrategyType;
        this.basicWaterPriceCalc = basicWaterPriceCalc;
        this.waterPriceIndustry = waterPriceIndustry;
        this.waterNature = waterNature;
        this.ladderFlag = ladderFlag;
        this.priceTemplateId = priceTemplateId;
        this.remark = remark;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * 用水用户编号
     */

    public String getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    /**       
     *      * 用水用户名称
     */

    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    /**       
     *      * 自定义查询号
     */

    public String getCustomNum() {
        return this.customNum;
    }
    
    public void setCustomNum(String customNum) {
        this.customNum = customNum;
    }
    /**       
     *      * 用户id
     */

    public Long getUid() {
        return this.uid;
    }
    
    public void setUid(Long uid) {
        this.uid = uid;
    }
    /**       
     *      * 客户编号
     */

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**       
     *      * 客户名称
     */

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**       
     *      * 收费单位编号
     */

    public String getChargingUnitId() {
        return this.chargingUnitId;
    }
    
    public void setChargingUnitId(String chargingUnitId) {
        this.chargingUnitId = chargingUnitId;
    }
    /**       
     *      * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
     */

    public String getParentUnits() {
        return this.parentUnits;
    }
    
    public void setParentUnits(String parentUnits) {
        this.parentUnits = parentUnits;
    }
    /**       
     *      * 原客户编号
     */

    public String getOldUserId() {
        return this.oldUserId;
    }
    
    public void setOldUserId(String oldUserId) {
        this.oldUserId = oldUserId;
    }
    /**       
     *      * 用户分类
     */

    public String getCustomerType() {
        return this.customerType;
    }
    
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    /**       
     *      * 用户状态
     */

    public String getCustomerStatus() {
        return this.customerStatus;
    }
    
    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
    /**       
     *      * 行业分类
     */

    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    /**       
     *      * 业务类别
     */

    public String getBusinessType() {
        return this.businessType;
    }
    
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    /**       
     *      * 合同容量
     */

    public String getContractCapacity() {
        return this.contractCapacity;
    }
    
    public void setContractCapacity(String contractCapacity) {
        this.contractCapacity = contractCapacity;
    }
    /**       
     *      * 高耗能行业类别
     */

    public String getHighEnergySectors() {
        return this.highEnergySectors;
    }
    
    public void setHighEnergySectors(String highEnergySectors) {
        this.highEnergySectors = highEnergySectors;
    }
    /**       
     *      * 开户日期
     */

    public Long getOpenTimestamp() {
        return this.openTimestamp;
    }
    
    public void setOpenTimestamp(Long openTimestamp) {
        this.openTimestamp = openTimestamp;
    }
    /**       
     *      * 销户日期
     */

    public Long getCloseTimestamp() {
        return this.closeTimestamp;
    }
    
    public void setCloseTimestamp(Long closeTimestamp) {
        this.closeTimestamp = closeTimestamp;
    }
    /**       
     *      * 到期日期
     */

    public Long getMaturityTimestamp() {
        return this.maturityTimestamp;
    }
    
    public void setMaturityTimestamp(Long maturityTimestamp) {
        this.maturityTimestamp = maturityTimestamp;
    }
    /**       
     *      * 水费通知方式
     */

    public String getNotifyType() {
        return this.notifyType;
    }
    
    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }
    /**       
     *      * 水费结算方式
     */

    public String getSettlementType() {
        return this.settlementType;
    }
    
    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }
    /**       
     *      * 票据类型
     */

    public String getBillType() {
        return this.billType;
    }
    
    public void setBillType(String billType) {
        this.billType = billType;
    }
    /**       
     *      * 停水标志
     */

    public String getWithoutWaterMark() {
        return this.withoutWaterMark;
    }
    
    public void setWithoutWaterMark(String withoutWaterMark) {
        this.withoutWaterMark = withoutWaterMark;
    }
    /**       
     *      * 转供标志
     */

    public String getTurnForMark() {
        return this.turnForMark;
    }
    
    public void setTurnForMark(String turnForMark) {
        this.turnForMark = turnForMark;
    }
    /**       
     *      * 抄表段编号
     */

    public String getMeterSegmentNum() {
        return this.meterSegmentNum;
    }
    
    public void setMeterSegmentNum(String meterSegmentNum) {
        this.meterSegmentNum = meterSegmentNum;
    }
    /**       
     *      * 业务地址
     */

    public String getBusiAddress() {
        return this.busiAddress;
    }
    
    public void setBusiAddress(String busiAddress) {
        this.busiAddress = busiAddress;
    }
    /**       
     *      * 供水点名称
     */

    public String getWaterPointsName() {
        return this.waterPointsName;
    }
    
    public void setWaterPointsName(String waterPointsName) {
        this.waterPointsName = waterPointsName;
    }
    /**       
     *      * 供水点类型
     */

    public String getWaterPointsType() {
        return this.waterPointsType;
    }
    
    public void setWaterPointsType(String waterPointsType) {
        this.waterPointsType = waterPointsType;
    }
    /**       
     *      * 运行状态
     */

    public String getWorkStatus() {
        return this.workStatus;
    }
    
    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
    /**       
     *      * 定价策略类型
     */

    public String getPricStrategyType() {
        return this.pricStrategyType;
    }
    
    public void setPricStrategyType(String pricStrategyType) {
        this.pricStrategyType = pricStrategyType;
    }
    /**       
     *      * 基本水费计算方式
     */

    public String getBasicWaterPriceCalc() {
        return this.basicWaterPriceCalc;
    }
    
    public void setBasicWaterPriceCalc(String basicWaterPriceCalc) {
        this.basicWaterPriceCalc = basicWaterPriceCalc;
    }
    /**       
     *      * 水价行业类别
     */

    public String getWaterPriceIndustry() {
        return this.waterPriceIndustry;
    }
    
    public void setWaterPriceIndustry(String waterPriceIndustry) {
        this.waterPriceIndustry = waterPriceIndustry;
    }
    /**       
     *      * 用水性质
     */

    public String getWaterNature() {
        return this.waterNature;
    }
    
    public void setWaterNature(String waterNature) {
        this.waterNature = waterNature;
    }
    /**       
     *      * 是否执行阶梯标志
     */

    public String getLadderFlag() {
        return this.ladderFlag;
    }
    
    public void setLadderFlag(String ladderFlag) {
        this.ladderFlag = ladderFlag;
    }
    /**       
     *      * 价目模版id
     */

    public Long getPriceTemplateId() {
        return this.priceTemplateId;
    }
    
    public void setPriceTemplateId(Long priceTemplateId) {
        this.priceTemplateId = priceTemplateId;
    }
    /**       
     *      * 供水点备注
     */

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**       
     *      * 创建时间
     */

    public Long getCreateTimestamp() {
        return this.createTimestamp;
    }
    
    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
   



	public boolean equals(Object other) {
		if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof WaterCustomer) ) return false;
		WaterCustomer castOther = ( WaterCustomer ) other;
		if( this.getCustomerId() == null || castOther.getCustomerId() == null){
			return false;
		}
		
		return ( (this.getCustomerId()==castOther.getCustomerId()) || ( this.getCustomerId()!=null && castOther.getCustomerId()!=null && this.getCustomerId().equals(castOther.getCustomerId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getCustomerId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getCustomerId().hashCode());
		return result;
	}





}