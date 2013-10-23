package com.ymsino.esb.data.model;



/**
 * WaterMonthUsageAmount entity. @author MyEclipse Persistence Tools
 */

public class WaterMonthUsageAmount  implements java.io.Serializable {


    // Fields    

     /**
      * 水表月用量自增id
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
      * 1月水用量
     */
     private Integer usageAmount1;
     /**
      * 2月水用量
     */
     private Integer usageAmount2;
     /**
      * 3月水用量
     */
     private Integer usageAmount3;
     /**
      * 4月水用量
     */
     private Integer usageAmount4;
     /**
      * 5月水用量
     */
     private Integer usageAmount5;
     /**
      * 6月水用量
     */
     private Integer usageAmount6;
     /**
      * 7月水用量
     */
     private Integer usageAmount7;
     /**
      * 8月水用量
     */
     private Integer usageAmount8;
     /**
      * 9月水用量
     */
     private Integer usageAmount9;
     /**
      * 10月水用量
     */
     private Integer usageAmount10;
     /**
      * 11月水用量
     */
     private Integer usageAmount11;
     /**
      * 12月水用量
     */
     private Integer usageAmount12;
     /**
      * 冻结时间(年)
     */
     private String freezeYear;
     /**
      * 创建时间戳
     */
     private Long createTimestamp;
     /**
      * 客户编号
     */
     private String userId;
     /**
      * 用水用户编号
     */
     private String waterCustomerId;
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
    public WaterMonthUsageAmount() {
    }

    
    /** full constructor */
    public WaterMonthUsageAmount(String concHardwareId, String meterHardwareId, Integer usageAmount1, Integer usageAmount2, Integer usageAmount3, Integer usageAmount4, Integer usageAmount5, Integer usageAmount6, Integer usageAmount7, Integer usageAmount8, Integer usageAmount9, Integer usageAmount10, Integer usageAmount11, Integer usageAmount12, String freezeYear, Long createTimestamp, String userId, String waterCustomerId, String chargingUnitId, String parentUnits) {
        this.concHardwareId = concHardwareId;
        this.meterHardwareId = meterHardwareId;
        this.usageAmount1 = usageAmount1;
        this.usageAmount2 = usageAmount2;
        this.usageAmount3 = usageAmount3;
        this.usageAmount4 = usageAmount4;
        this.usageAmount5 = usageAmount5;
        this.usageAmount6 = usageAmount6;
        this.usageAmount7 = usageAmount7;
        this.usageAmount8 = usageAmount8;
        this.usageAmount9 = usageAmount9;
        this.usageAmount10 = usageAmount10;
        this.usageAmount11 = usageAmount11;
        this.usageAmount12 = usageAmount12;
        this.freezeYear = freezeYear;
        this.createTimestamp = createTimestamp;
        this.userId = userId;
        this.waterCustomerId = waterCustomerId;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * 水表月用量自增id
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
     *      * 1月水用量
     */

    public Integer getUsageAmount1() {
        return this.usageAmount1;
    }
    
    public void setUsageAmount1(Integer usageAmount1) {
        this.usageAmount1 = usageAmount1;
    }
    /**       
     *      * 2月水用量
     */

    public Integer getUsageAmount2() {
        return this.usageAmount2;
    }
    
    public void setUsageAmount2(Integer usageAmount2) {
        this.usageAmount2 = usageAmount2;
    }
    /**       
     *      * 3月水用量
     */

    public Integer getUsageAmount3() {
        return this.usageAmount3;
    }
    
    public void setUsageAmount3(Integer usageAmount3) {
        this.usageAmount3 = usageAmount3;
    }
    /**       
     *      * 4月水用量
     */

    public Integer getUsageAmount4() {
        return this.usageAmount4;
    }
    
    public void setUsageAmount4(Integer usageAmount4) {
        this.usageAmount4 = usageAmount4;
    }
    /**       
     *      * 5月水用量
     */

    public Integer getUsageAmount5() {
        return this.usageAmount5;
    }
    
    public void setUsageAmount5(Integer usageAmount5) {
        this.usageAmount5 = usageAmount5;
    }
    /**       
     *      * 6月水用量
     */

    public Integer getUsageAmount6() {
        return this.usageAmount6;
    }
    
    public void setUsageAmount6(Integer usageAmount6) {
        this.usageAmount6 = usageAmount6;
    }
    /**       
     *      * 7月水用量
     */

    public Integer getUsageAmount7() {
        return this.usageAmount7;
    }
    
    public void setUsageAmount7(Integer usageAmount7) {
        this.usageAmount7 = usageAmount7;
    }
    /**       
     *      * 8月水用量
     */

    public Integer getUsageAmount8() {
        return this.usageAmount8;
    }
    
    public void setUsageAmount8(Integer usageAmount8) {
        this.usageAmount8 = usageAmount8;
    }
    /**       
     *      * 9月水用量
     */

    public Integer getUsageAmount9() {
        return this.usageAmount9;
    }
    
    public void setUsageAmount9(Integer usageAmount9) {
        this.usageAmount9 = usageAmount9;
    }
    /**       
     *      * 10月水用量
     */

    public Integer getUsageAmount10() {
        return this.usageAmount10;
    }
    
    public void setUsageAmount10(Integer usageAmount10) {
        this.usageAmount10 = usageAmount10;
    }
    /**       
     *      * 11月水用量
     */

    public Integer getUsageAmount11() {
        return this.usageAmount11;
    }
    
    public void setUsageAmount11(Integer usageAmount11) {
        this.usageAmount11 = usageAmount11;
    }
    /**       
     *      * 12月水用量
     */

    public Integer getUsageAmount12() {
        return this.usageAmount12;
    }
    
    public void setUsageAmount12(Integer usageAmount12) {
        this.usageAmount12 = usageAmount12;
    }
    /**       
     *      * 冻结时间(年)
     */

    public String getFreezeYear() {
        return this.freezeYear;
    }
    
    public void setFreezeYear(String freezeYear) {
        this.freezeYear = freezeYear;
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
     *      * 用水用户编号
     */

    public String getWaterCustomerId() {
        return this.waterCustomerId;
    }
    
    public void setWaterCustomerId(String waterCustomerId) {
        this.waterCustomerId = waterCustomerId;
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
		if ( !(other instanceof WaterMonthUsageAmount) ) return false;
		WaterMonthUsageAmount castOther = ( WaterMonthUsageAmount ) other;
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