package com.ymsino.esb.archives.model;



/**
 * WirelessMeter entity. @author MyEclipse Persistence Tools
 */

public class WirelessMeter  implements java.io.Serializable {


    // Fields    

     /**
      * 无线智能水表编号
     */
     private String wmSn;
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
     private String childWmSn;
     /**
      * 水表类型
     */
     private String dataType;
     /**
      * 脉冲常数
     */
     private Integer constant;
     /**
      * 集中器ID
     */
     private String concHardwareId;
     /**
      * 初始表码
     */
     private String initialYards;
     /**
      * 适用水价(单位：分)
     */
     private Long suitablePrice;
     /**
      * 告警量
     */
     private String alarmVolume;
     /**
      * 无线频率
     */
     private String radioFrequency;
     /**
      * 创建时间
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public WirelessMeter() {
    }

	/** minimal constructor */
    public WirelessMeter(String wmSn) {
        this.wmSn = wmSn;
    }
    
    /** full constructor */
    public WirelessMeter(String wmSn, Long uid, String userId, String userName, String chargingUnitId, String parentUnits, String childWmSn, String dataType, Integer constant, String concHardwareId, String initialYards, Long suitablePrice, String alarmVolume, String radioFrequency, Long createTimestamp) {
        this.wmSn = wmSn;
        this.uid = uid;
        this.userId = userId;
        this.userName = userName;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.childWmSn = childWmSn;
        this.dataType = dataType;
        this.constant = constant;
        this.concHardwareId = concHardwareId;
        this.initialYards = initialYards;
        this.suitablePrice = suitablePrice;
        this.alarmVolume = alarmVolume;
        this.radioFrequency = radioFrequency;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * 无线智能水表编号
     */

    public String getWmSn() {
        return this.wmSn;
    }
    
    public void setWmSn(String wmSn) {
        this.wmSn = wmSn;
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
     *      * 子表号
     */

    public String getChildWmSn() {
        return this.childWmSn;
    }
    
    public void setChildWmSn(String childWmSn) {
        this.childWmSn = childWmSn;
    }
    /**       
     *      * 水表类型
     */

    public String getDataType() {
        return this.dataType;
    }
    
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    /**       
     *      * 脉冲常数
     */

    public Integer getConstant() {
        return this.constant;
    }
    
    public void setConstant(Integer constant) {
        this.constant = constant;
    }
    /**       
     *      * 集中器ID
     */

    public String getConcHardwareId() {
        return this.concHardwareId;
    }
    
    public void setConcHardwareId(String concHardwareId) {
        this.concHardwareId = concHardwareId;
    }
    /**       
     *      * 初始表码
     */

    public String getInitialYards() {
        return this.initialYards;
    }
    
    public void setInitialYards(String initialYards) {
        this.initialYards = initialYards;
    }
    /**       
     *      * 适用水价(单位：分)
     */

    public Long getSuitablePrice() {
        return this.suitablePrice;
    }
    
    public void setSuitablePrice(Long suitablePrice) {
        this.suitablePrice = suitablePrice;
    }
    /**       
     *      * 告警量
     */

    public String getAlarmVolume() {
        return this.alarmVolume;
    }
    
    public void setAlarmVolume(String alarmVolume) {
        this.alarmVolume = alarmVolume;
    }
    /**       
     *      * 无线频率
     */

    public String getRadioFrequency() {
        return this.radioFrequency;
    }
    
    public void setRadioFrequency(String radioFrequency) {
        this.radioFrequency = radioFrequency;
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
		if ( !(other instanceof WirelessMeter) ) return false;
		WirelessMeter castOther = ( WirelessMeter ) other;
		if( this.getWmSn() == null || castOther.getWmSn() == null){
			return false;
		}
		
		return ( (this.getWmSn()==castOther.getWmSn()) || ( this.getWmSn()!=null && castOther.getWmSn()!=null && this.getWmSn().equals(castOther.getWmSn()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getWmSn() == null ? random.nextInt(Integer.MAX_VALUE) : this.getWmSn().hashCode());
		return result;
	}





}