package com.ymsino.esb.archives.model;



/**
 * WaterMeter entity. @author MyEclipse Persistence Tools
 */

public class WaterMeter  implements java.io.Serializable {


    // Fields    

     /**
      * 水表编号
     */
     private String hardwareId;
     /**
      * 用水用户编号
     */
     private String waterCustomerId;
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
      * 子表号
     */
     private String childHardwareId;
     /**
      * 数据类别
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
      * 对应集中器的序号
     */
     private Integer wmSn;
     /**
      * 初始表码
     */
     private String initialYards;
     /**
      * 适用水价、当前水价(单位：分)
     */
     private Long price;
     /**
      * 告警量
     */
     private String alarmVolume;
     /**
      * 无线频率
     */
     private String radioFrequency;
     /**
      * 水表类型：1,IC卡预付费水表;2,红外卡预付费水表;3,无线智能水表
     */
     private Short type;
     /**
      * 创建时间
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public WaterMeter() {
    }

	/** minimal constructor */
    public WaterMeter(String hardwareId) {
        this.hardwareId = hardwareId;
    }
    
    /** full constructor */
    public WaterMeter(String hardwareId, String waterCustomerId, Long uid, String userId, String userName, String chargingUnitId, String parentUnits, String nature, String purcAmount, String showWarn, String closeWarn, String childHardwareId, String dataType, Integer constant, String concHardwareId, Integer wmSn, String initialYards, Long price, String alarmVolume, String radioFrequency, Short type, Long createTimestamp) {
        this.hardwareId = hardwareId;
        this.waterCustomerId = waterCustomerId;
        this.uid = uid;
        this.userId = userId;
        this.userName = userName;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.nature = nature;
        this.purcAmount = purcAmount;
        this.showWarn = showWarn;
        this.closeWarn = closeWarn;
        this.childHardwareId = childHardwareId;
        this.dataType = dataType;
        this.constant = constant;
        this.concHardwareId = concHardwareId;
        this.wmSn = wmSn;
        this.initialYards = initialYards;
        this.price = price;
        this.alarmVolume = alarmVolume;
        this.radioFrequency = radioFrequency;
        this.type = type;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * 水表编号
     */

    public String getHardwareId() {
        return this.hardwareId;
    }
    
    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }
    /**       
     *      * 用水用户编号
     */

    public String getWaterCustomerId() {
        return this.waterCustomerId;
    }
    
    public void setWaterCustomerId(String waterCustomerId) {
        this.waterCustomerId = waterCustomerId;
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
     *      * 用水性质
     */

    public String getNature() {
        return this.nature;
    }
    
    public void setNature(String nature) {
        this.nature = nature;
    }
    /**       
     *      * 限购量
     */

    public String getPurcAmount() {
        return this.purcAmount;
    }
    
    public void setPurcAmount(String purcAmount) {
        this.purcAmount = purcAmount;
    }
    /**       
     *      * 显示告警
     */

    public String getShowWarn() {
        return this.showWarn;
    }
    
    public void setShowWarn(String showWarn) {
        this.showWarn = showWarn;
    }
    /**       
     *      * 关阀告警
     */

    public String getCloseWarn() {
        return this.closeWarn;
    }
    
    public void setCloseWarn(String closeWarn) {
        this.closeWarn = closeWarn;
    }
    /**       
     *      * 子表号
     */

    public String getChildHardwareId() {
        return this.childHardwareId;
    }
    
    public void setChildHardwareId(String childHardwareId) {
        this.childHardwareId = childHardwareId;
    }
    /**       
     *      * 数据类别
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
     *      * 对应集中器的序号
     */

    public Integer getWmSn() {
        return this.wmSn;
    }
    
    public void setWmSn(Integer wmSn) {
        this.wmSn = wmSn;
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
     *      * 适用水价、当前水价(单位：分)
     */

    public Long getPrice() {
        return this.price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
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
     *      * 水表类型：1,IC卡预付费水表;2,红外卡预付费水表;3,无线智能水表
     */

    public Short getType() {
        return this.type;
    }
    
    public void setType(Short type) {
        this.type = type;
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
		if ( !(other instanceof WaterMeter) ) return false;
		WaterMeter castOther = ( WaterMeter ) other;
		if( this.getHardwareId() == null || castOther.getHardwareId() == null){
			return false;
		}
		
		return ( (this.getHardwareId()==castOther.getHardwareId()) || ( this.getHardwareId()!=null && castOther.getHardwareId()!=null && this.getHardwareId().equals(castOther.getHardwareId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getHardwareId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getHardwareId().hashCode());
		return result;
	}





}