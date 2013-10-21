package com.ymsino.esb.archives.model;



/**
 * WaterCustomer entity. @author MyEclipse Persistence Tools
 */

public class WaterCustomer  implements java.io.Serializable {


    // Fields    

     /**
      * ��ˮ�û����
     */
     private String customerId;
     /**
      * ��ˮ�û�����
     */
     private String customerName;
     /**
      * �Զ����ѯ��
     */
     private String customNum;
     /**
      * �û�id
     */
     private Long uid;
     /**
      * �ͻ����
     */
     private String userId;
     /**
      * �ͻ�����
     */
     private String userName;
     /**
      * �շѵ�λ���
     */
     private String chargingUnitId;
     /**
      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */
     private String parentUnits;
     /**
      * ԭ�ͻ����
     */
     private String oldUserId;
     /**
      * �û�����
     */
     private String customerType;
     /**
      * �û�״̬
     */
     private String customerStatus;
     /**
      * ��ҵ����
     */
     private String category;
     /**
      * ҵ�����
     */
     private String businessType;
     /**
      * ��ͬ����
     */
     private String contractCapacity;
     /**
      * �ߺ�����ҵ���
     */
     private String highEnergySectors;
     /**
      * ��������
     */
     private Long openTimestamp;
     /**
      * ��������
     */
     private Long closeTimestamp;
     /**
      * ��������
     */
     private Long maturityTimestamp;
     /**
      * ˮ��֪ͨ��ʽ
     */
     private String notifyType;
     /**
      * ˮ�ѽ��㷽ʽ
     */
     private String settlementType;
     /**
      * Ʊ������
     */
     private String billType;
     /**
      * ͣˮ��־
     */
     private String withoutWaterMark;
     /**
      * ת����־
     */
     private String turnForMark;
     /**
      * ����α��
     */
     private String meterSegmentNum;
     /**
      * ҵ���ַ
     */
     private String busiAddress;
     /**
      * ��ˮ������
     */
     private String waterPointsName;
     /**
      * ��ˮ������
     */
     private String waterPointsType;
     /**
      * ����״̬
     */
     private String workStatus;
     /**
      * ���۲�������
     */
     private String pricStrategyType;
     /**
      * ����ˮ�Ѽ��㷽ʽ
     */
     private String basicWaterPriceCalc;
     /**
      * ˮ����ҵ���
     */
     private String waterPriceIndustry;
     /**
      * ��ˮ����
     */
     private String waterNature;
     /**
      * �Ƿ�ִ�н��ݱ�־
     */
     private String ladderFlag;
     /**
      * ��Ŀģ��id
     */
     private Long priceTemplateId;
     /**
      * ��ˮ�㱸ע
     */
     private String remark;
     /**
      * ����ʱ��
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
     *      * ��ˮ�û����
     */

    public String getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    /**       
     *      * ��ˮ�û�����
     */

    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    /**       
     *      * �Զ����ѯ��
     */

    public String getCustomNum() {
        return this.customNum;
    }
    
    public void setCustomNum(String customNum) {
        this.customNum = customNum;
    }
    /**       
     *      * �û�id
     */

    public Long getUid() {
        return this.uid;
    }
    
    public void setUid(Long uid) {
        this.uid = uid;
    }
    /**       
     *      * �ͻ����
     */

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**       
     *      * �ͻ�����
     */

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**       
     *      * �շѵ�λ���
     */

    public String getChargingUnitId() {
        return this.chargingUnitId;
    }
    
    public void setChargingUnitId(String chargingUnitId) {
        this.chargingUnitId = chargingUnitId;
    }
    /**       
     *      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */

    public String getParentUnits() {
        return this.parentUnits;
    }
    
    public void setParentUnits(String parentUnits) {
        this.parentUnits = parentUnits;
    }
    /**       
     *      * ԭ�ͻ����
     */

    public String getOldUserId() {
        return this.oldUserId;
    }
    
    public void setOldUserId(String oldUserId) {
        this.oldUserId = oldUserId;
    }
    /**       
     *      * �û�����
     */

    public String getCustomerType() {
        return this.customerType;
    }
    
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    /**       
     *      * �û�״̬
     */

    public String getCustomerStatus() {
        return this.customerStatus;
    }
    
    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
    /**       
     *      * ��ҵ����
     */

    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    /**       
     *      * ҵ�����
     */

    public String getBusinessType() {
        return this.businessType;
    }
    
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    /**       
     *      * ��ͬ����
     */

    public String getContractCapacity() {
        return this.contractCapacity;
    }
    
    public void setContractCapacity(String contractCapacity) {
        this.contractCapacity = contractCapacity;
    }
    /**       
     *      * �ߺ�����ҵ���
     */

    public String getHighEnergySectors() {
        return this.highEnergySectors;
    }
    
    public void setHighEnergySectors(String highEnergySectors) {
        this.highEnergySectors = highEnergySectors;
    }
    /**       
     *      * ��������
     */

    public Long getOpenTimestamp() {
        return this.openTimestamp;
    }
    
    public void setOpenTimestamp(Long openTimestamp) {
        this.openTimestamp = openTimestamp;
    }
    /**       
     *      * ��������
     */

    public Long getCloseTimestamp() {
        return this.closeTimestamp;
    }
    
    public void setCloseTimestamp(Long closeTimestamp) {
        this.closeTimestamp = closeTimestamp;
    }
    /**       
     *      * ��������
     */

    public Long getMaturityTimestamp() {
        return this.maturityTimestamp;
    }
    
    public void setMaturityTimestamp(Long maturityTimestamp) {
        this.maturityTimestamp = maturityTimestamp;
    }
    /**       
     *      * ˮ��֪ͨ��ʽ
     */

    public String getNotifyType() {
        return this.notifyType;
    }
    
    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }
    /**       
     *      * ˮ�ѽ��㷽ʽ
     */

    public String getSettlementType() {
        return this.settlementType;
    }
    
    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }
    /**       
     *      * Ʊ������
     */

    public String getBillType() {
        return this.billType;
    }
    
    public void setBillType(String billType) {
        this.billType = billType;
    }
    /**       
     *      * ͣˮ��־
     */

    public String getWithoutWaterMark() {
        return this.withoutWaterMark;
    }
    
    public void setWithoutWaterMark(String withoutWaterMark) {
        this.withoutWaterMark = withoutWaterMark;
    }
    /**       
     *      * ת����־
     */

    public String getTurnForMark() {
        return this.turnForMark;
    }
    
    public void setTurnForMark(String turnForMark) {
        this.turnForMark = turnForMark;
    }
    /**       
     *      * ����α��
     */

    public String getMeterSegmentNum() {
        return this.meterSegmentNum;
    }
    
    public void setMeterSegmentNum(String meterSegmentNum) {
        this.meterSegmentNum = meterSegmentNum;
    }
    /**       
     *      * ҵ���ַ
     */

    public String getBusiAddress() {
        return this.busiAddress;
    }
    
    public void setBusiAddress(String busiAddress) {
        this.busiAddress = busiAddress;
    }
    /**       
     *      * ��ˮ������
     */

    public String getWaterPointsName() {
        return this.waterPointsName;
    }
    
    public void setWaterPointsName(String waterPointsName) {
        this.waterPointsName = waterPointsName;
    }
    /**       
     *      * ��ˮ������
     */

    public String getWaterPointsType() {
        return this.waterPointsType;
    }
    
    public void setWaterPointsType(String waterPointsType) {
        this.waterPointsType = waterPointsType;
    }
    /**       
     *      * ����״̬
     */

    public String getWorkStatus() {
        return this.workStatus;
    }
    
    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
    /**       
     *      * ���۲�������
     */

    public String getPricStrategyType() {
        return this.pricStrategyType;
    }
    
    public void setPricStrategyType(String pricStrategyType) {
        this.pricStrategyType = pricStrategyType;
    }
    /**       
     *      * ����ˮ�Ѽ��㷽ʽ
     */

    public String getBasicWaterPriceCalc() {
        return this.basicWaterPriceCalc;
    }
    
    public void setBasicWaterPriceCalc(String basicWaterPriceCalc) {
        this.basicWaterPriceCalc = basicWaterPriceCalc;
    }
    /**       
     *      * ˮ����ҵ���
     */

    public String getWaterPriceIndustry() {
        return this.waterPriceIndustry;
    }
    
    public void setWaterPriceIndustry(String waterPriceIndustry) {
        this.waterPriceIndustry = waterPriceIndustry;
    }
    /**       
     *      * ��ˮ����
     */

    public String getWaterNature() {
        return this.waterNature;
    }
    
    public void setWaterNature(String waterNature) {
        this.waterNature = waterNature;
    }
    /**       
     *      * �Ƿ�ִ�н��ݱ�־
     */

    public String getLadderFlag() {
        return this.ladderFlag;
    }
    
    public void setLadderFlag(String ladderFlag) {
        this.ladderFlag = ladderFlag;
    }
    /**       
     *      * ��Ŀģ��id
     */

    public Long getPriceTemplateId() {
        return this.priceTemplateId;
    }
    
    public void setPriceTemplateId(Long priceTemplateId) {
        this.priceTemplateId = priceTemplateId;
    }
    /**       
     *      * ��ˮ�㱸ע
     */

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**       
     *      * ����ʱ��
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