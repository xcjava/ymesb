package com.ymsino.esb.data.model;



/**
 * FreezeData entity. @author MyEclipse Persistence Tools
 */

public class FreezeData  implements java.io.Serializable {


    // Fields    

     /**
      * 水表冻结数据自增id
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
      * 表计读数
     */
     private Long meterReading;
     /**
      * 电池电压
     */
     private Float batteryVoltage;
     /**
      * 			阀门
 * 			01=半阀 10=开阀
 * 			11=关阀 00=未知
 * 			
     */
     private String valveStatus;
     /**
      * 数据类型:0=光电,1=脉冲
     */
     private String dataType;
     /**
      * 磁攻击:0无磁攻击, 1有磁攻击
     */
     private String magneticAttack;
     /**
      * 错误状态:0=正确, 1=错误
     */
     private String errorStatus;
     /**
      * 应答状态: 0=有应答, 1=无应答
     */
     private String replyStatus;
     /**
      * 冻结时间YYMMDD
     */
     private String freezeDateStr;
     /**
      * 创建时间戳
     */
     private Long createTimestamp;
     /**
      * 客户编号
     */
     private String userId;
     /**
      * 收费单位编号
     */
     private String chargingUnitId;
     /**
      * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
     */
     private String parentUnits;


    // Constructors

    /** default constructor */
    public FreezeData() {
    }

    
    /** full constructor */
    public FreezeData(String concHardwareId, String meterHardwareId, Long meterReading, Float batteryVoltage, String valveStatus, String dataType, String magneticAttack, String errorStatus, String replyStatus, String freezeDateStr, Long createTimestamp, String userId, String chargingUnitId, String parentUnits) {
        this.concHardwareId = concHardwareId;
        this.meterHardwareId = meterHardwareId;
        this.meterReading = meterReading;
        this.batteryVoltage = batteryVoltage;
        this.valveStatus = valveStatus;
        this.dataType = dataType;
        this.magneticAttack = magneticAttack;
        this.errorStatus = errorStatus;
        this.replyStatus = replyStatus;
        this.freezeDateStr = freezeDateStr;
        this.createTimestamp = createTimestamp;
        this.userId = userId;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * 水表冻结数据自增id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * 集中器逻辑地址
     */

    public String getConcHardwareId() {
        return this.concHardwareId;
    }
    
    public void setConcHardwareId(String concHardwareId) {
        this.concHardwareId = concHardwareId;
    }
    /**       
     *      * 无线智能水表ID
     */

    public String getMeterHardwareId() {
        return this.meterHardwareId;
    }
    
    public void setMeterHardwareId(String meterHardwareId) {
        this.meterHardwareId = meterHardwareId;
    }
    /**       
     *      * 表计读数
     */

    public Long getMeterReading() {
        return this.meterReading;
    }
    
    public void setMeterReading(Long meterReading) {
        this.meterReading = meterReading;
    }
    /**       
     *      * 电池电压
     */

    public Float getBatteryVoltage() {
        return this.batteryVoltage;
    }
    
    public void setBatteryVoltage(Float batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }
    /**       
     *      * 			阀门
     * 			01=半阀 10=开阀
     * 			11=关阀 00=未知
     * 			
     */

    public String getValveStatus() {
        return this.valveStatus;
    }
    
    public void setValveStatus(String valveStatus) {
        this.valveStatus = valveStatus;
    }
    /**       
     *      * 数据类型:0=光电,1=脉冲
     */

    public String getDataType() {
        return this.dataType;
    }
    
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    /**       
     *      * 磁攻击:0无磁攻击, 1有磁攻击
     */

    public String getMagneticAttack() {
        return this.magneticAttack;
    }
    
    public void setMagneticAttack(String magneticAttack) {
        this.magneticAttack = magneticAttack;
    }
    /**       
     *      * 错误状态:0=正确, 1=错误
     */

    public String getErrorStatus() {
        return this.errorStatus;
    }
    
    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }
    /**       
     *      * 应答状态: 0=有应答, 1=无应答
     */

    public String getReplyStatus() {
        return this.replyStatus;
    }
    
    public void setReplyStatus(String replyStatus) {
        this.replyStatus = replyStatus;
    }
    /**       
     *      * 冻结时间YYMMDD
     */

    public String getFreezeDateStr() {
        return this.freezeDateStr;
    }
    
    public void setFreezeDateStr(String freezeDateStr) {
        this.freezeDateStr = freezeDateStr;
    }
    /**       
     *      * 创建时间戳
     */

    public Long getCreateTimestamp() {
        return this.createTimestamp;
    }
    
    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
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
   



	public boolean equals(Object other) {
		if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof FreezeData) ) return false;
		FreezeData castOther = ( FreezeData ) other;
		if( this.getId() == null || castOther.getId() == null){
			return false;
		}
		
		return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getId().hashCode());
		return result;
	}





}