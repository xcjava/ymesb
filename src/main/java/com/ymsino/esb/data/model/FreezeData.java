package com.ymsino.esb.data.model;

import java.util.Date;


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
      * 冻结时间
     */
     private Date freezeDate;
     /**
      * 创建时间
     */
     private Date createDate;
     /**
      * 客户编号
     */
     private String userId;
     /**
      * 用户姓名
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


    // Constructors

    /** default constructor */
    public FreezeData() {
    }

    
    /** full constructor */
    public FreezeData(String concHardwareId, String meterHardwareId, Long meterReading, Date freezeDate, Date createDate, String userId, String userName, String chargingUnitId, String parentUnits) {
        this.concHardwareId = concHardwareId;
        this.meterHardwareId = meterHardwareId;
        this.meterReading = meterReading;
        this.freezeDate = freezeDate;
        this.createDate = createDate;
        this.userId = userId;
        this.userName = userName;
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
     *      * 冻结时间
     */

    public Date getFreezeDate() {
        return this.freezeDate;
    }
    
    public void setFreezeDate(Date freezeDate) {
        this.freezeDate = freezeDate;
    }
    /**       
     *      * 创建时间
     */

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
     *      * 用户姓名
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