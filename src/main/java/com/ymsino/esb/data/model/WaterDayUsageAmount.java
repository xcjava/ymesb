package com.ymsino.esb.data.model;



/**
 * WaterDayUsageAmount entity. @author MyEclipse Persistence Tools
 */

public class WaterDayUsageAmount  implements java.io.Serializable {


    // Fields    

     /**
      * 水表日用量自增id
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
      * 1日水用量
     */
     private Float usageAmount1;
     /**
      * 2日水用量
     */
     private Float usageAmount2;
     /**
      * 3日水用量
     */
     private Float usageAmount3;
     /**
      * 4日水用量
     */
     private Float usageAmount4;
     /**
      * 5日水用量
     */
     private Float usageAmount5;
     /**
      * 6日水用量
     */
     private Float usageAmount6;
     /**
      * 7日水用量
     */
     private Float usageAmount7;
     /**
      * 8日水用量
     */
     private Float usageAmount8;
     /**
      * 9日水用量
     */
     private Float usageAmount9;
     /**
      * 10日水用量
     */
     private Float usageAmount10;
     /**
      * 11日水用量
     */
     private Float usageAmount11;
     /**
      * 12日水用量
     */
     private Float usageAmount12;
     /**
      * 13日水用量
     */
     private Float usageAmount13;
     /**
      * 14日水用量
     */
     private Float usageAmount14;
     /**
      * 15日水用量
     */
     private Float usageAmount15;
     /**
      * 16日水用量
     */
     private Float usageAmount16;
     /**
      * 17日水用量
     */
     private Float usageAmount17;
     /**
      * 18日水用量
     */
     private Float usageAmount18;
     /**
      * 19日水用量
     */
     private Float usageAmount19;
     /**
      * 20日水用量
     */
     private Float usageAmount20;
     /**
      * 21日水用量
     */
     private Float usageAmount21;
     /**
      * 22日水用量
     */
     private Float usageAmount22;
     /**
      * 23日水用量
     */
     private Float usageAmount23;
     /**
      * 24日水用量
     */
     private Float usageAmount24;
     /**
      * 25日水用量
     */
     private Float usageAmount25;
     /**
      * 26日水用量
     */
     private Float usageAmount26;
     /**
      * 27日水用量
     */
     private Float usageAmount27;
     /**
      * 28日水用量
     */
     private Float usageAmount28;
     /**
      * 29日水用量
     */
     private Float usageAmount29;
     /**
      * 30日水用量
     */
     private Float usageAmount30;
     /**
      * 31日水用量
     */
     private Float usageAmount31;
     /**
      * 冻结时间(年)
     */
     private String freezeYear;
     /**
      * 冻结时间(月)
     */
     private String freezeMonth;
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
    public WaterDayUsageAmount() {
    }

    
    /** full constructor */
    public WaterDayUsageAmount(String concHardwareId, String meterHardwareId, Float usageAmount1, Float usageAmount2, Float usageAmount3, Float usageAmount4, Float usageAmount5, Float usageAmount6, Float usageAmount7, Float usageAmount8, Float usageAmount9, Float usageAmount10, Float usageAmount11, Float usageAmount12, Float usageAmount13, Float usageAmount14, Float usageAmount15, Float usageAmount16, Float usageAmount17, Float usageAmount18, Float usageAmount19, Float usageAmount20, Float usageAmount21, Float usageAmount22, Float usageAmount23, Float usageAmount24, Float usageAmount25, Float usageAmount26, Float usageAmount27, Float usageAmount28, Float usageAmount29, Float usageAmount30, Float usageAmount31, String freezeYear, String freezeMonth, Long createTimestamp, String userId, String waterCustomerId, String chargingUnitId, String parentUnits) {
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
        this.usageAmount13 = usageAmount13;
        this.usageAmount14 = usageAmount14;
        this.usageAmount15 = usageAmount15;
        this.usageAmount16 = usageAmount16;
        this.usageAmount17 = usageAmount17;
        this.usageAmount18 = usageAmount18;
        this.usageAmount19 = usageAmount19;
        this.usageAmount20 = usageAmount20;
        this.usageAmount21 = usageAmount21;
        this.usageAmount22 = usageAmount22;
        this.usageAmount23 = usageAmount23;
        this.usageAmount24 = usageAmount24;
        this.usageAmount25 = usageAmount25;
        this.usageAmount26 = usageAmount26;
        this.usageAmount27 = usageAmount27;
        this.usageAmount28 = usageAmount28;
        this.usageAmount29 = usageAmount29;
        this.usageAmount30 = usageAmount30;
        this.usageAmount31 = usageAmount31;
        this.freezeYear = freezeYear;
        this.freezeMonth = freezeMonth;
        this.createTimestamp = createTimestamp;
        this.userId = userId;
        this.waterCustomerId = waterCustomerId;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * 水表日用量自增id
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
     *      * 1日水用量
     */

    public Float getUsageAmount1() {
        return this.usageAmount1;
    }
    
    public void setUsageAmount1(Float usageAmount1) {
        this.usageAmount1 = usageAmount1;
    }
    /**       
     *      * 2日水用量
     */

    public Float getUsageAmount2() {
        return this.usageAmount2;
    }
    
    public void setUsageAmount2(Float usageAmount2) {
        this.usageAmount2 = usageAmount2;
    }
    /**       
     *      * 3日水用量
     */

    public Float getUsageAmount3() {
        return this.usageAmount3;
    }
    
    public void setUsageAmount3(Float usageAmount3) {
        this.usageAmount3 = usageAmount3;
    }
    /**       
     *      * 4日水用量
     */

    public Float getUsageAmount4() {
        return this.usageAmount4;
    }
    
    public void setUsageAmount4(Float usageAmount4) {
        this.usageAmount4 = usageAmount4;
    }
    /**       
     *      * 5日水用量
     */

    public Float getUsageAmount5() {
        return this.usageAmount5;
    }
    
    public void setUsageAmount5(Float usageAmount5) {
        this.usageAmount5 = usageAmount5;
    }
    /**       
     *      * 6日水用量
     */

    public Float getUsageAmount6() {
        return this.usageAmount6;
    }
    
    public void setUsageAmount6(Float usageAmount6) {
        this.usageAmount6 = usageAmount6;
    }
    /**       
     *      * 7日水用量
     */

    public Float getUsageAmount7() {
        return this.usageAmount7;
    }
    
    public void setUsageAmount7(Float usageAmount7) {
        this.usageAmount7 = usageAmount7;
    }
    /**       
     *      * 8日水用量
     */

    public Float getUsageAmount8() {
        return this.usageAmount8;
    }
    
    public void setUsageAmount8(Float usageAmount8) {
        this.usageAmount8 = usageAmount8;
    }
    /**       
     *      * 9日水用量
     */

    public Float getUsageAmount9() {
        return this.usageAmount9;
    }
    
    public void setUsageAmount9(Float usageAmount9) {
        this.usageAmount9 = usageAmount9;
    }
    /**       
     *      * 10日水用量
     */

    public Float getUsageAmount10() {
        return this.usageAmount10;
    }
    
    public void setUsageAmount10(Float usageAmount10) {
        this.usageAmount10 = usageAmount10;
    }
    /**       
     *      * 11日水用量
     */

    public Float getUsageAmount11() {
        return this.usageAmount11;
    }
    
    public void setUsageAmount11(Float usageAmount11) {
        this.usageAmount11 = usageAmount11;
    }
    /**       
     *      * 12日水用量
     */

    public Float getUsageAmount12() {
        return this.usageAmount12;
    }
    
    public void setUsageAmount12(Float usageAmount12) {
        this.usageAmount12 = usageAmount12;
    }
    /**       
     *      * 13日水用量
     */

    public Float getUsageAmount13() {
        return this.usageAmount13;
    }
    
    public void setUsageAmount13(Float usageAmount13) {
        this.usageAmount13 = usageAmount13;
    }
    /**       
     *      * 14日水用量
     */

    public Float getUsageAmount14() {
        return this.usageAmount14;
    }
    
    public void setUsageAmount14(Float usageAmount14) {
        this.usageAmount14 = usageAmount14;
    }
    /**       
     *      * 15日水用量
     */

    public Float getUsageAmount15() {
        return this.usageAmount15;
    }
    
    public void setUsageAmount15(Float usageAmount15) {
        this.usageAmount15 = usageAmount15;
    }
    /**       
     *      * 16日水用量
     */

    public Float getUsageAmount16() {
        return this.usageAmount16;
    }
    
    public void setUsageAmount16(Float usageAmount16) {
        this.usageAmount16 = usageAmount16;
    }
    /**       
     *      * 17日水用量
     */

    public Float getUsageAmount17() {
        return this.usageAmount17;
    }
    
    public void setUsageAmount17(Float usageAmount17) {
        this.usageAmount17 = usageAmount17;
    }
    /**       
     *      * 18日水用量
     */

    public Float getUsageAmount18() {
        return this.usageAmount18;
    }
    
    public void setUsageAmount18(Float usageAmount18) {
        this.usageAmount18 = usageAmount18;
    }
    /**       
     *      * 19日水用量
     */

    public Float getUsageAmount19() {
        return this.usageAmount19;
    }
    
    public void setUsageAmount19(Float usageAmount19) {
        this.usageAmount19 = usageAmount19;
    }
    /**       
     *      * 20日水用量
     */

    public Float getUsageAmount20() {
        return this.usageAmount20;
    }
    
    public void setUsageAmount20(Float usageAmount20) {
        this.usageAmount20 = usageAmount20;
    }
    /**       
     *      * 21日水用量
     */

    public Float getUsageAmount21() {
        return this.usageAmount21;
    }
    
    public void setUsageAmount21(Float usageAmount21) {
        this.usageAmount21 = usageAmount21;
    }
    /**       
     *      * 22日水用量
     */

    public Float getUsageAmount22() {
        return this.usageAmount22;
    }
    
    public void setUsageAmount22(Float usageAmount22) {
        this.usageAmount22 = usageAmount22;
    }
    /**       
     *      * 23日水用量
     */

    public Float getUsageAmount23() {
        return this.usageAmount23;
    }
    
    public void setUsageAmount23(Float usageAmount23) {
        this.usageAmount23 = usageAmount23;
    }
    /**       
     *      * 24日水用量
     */

    public Float getUsageAmount24() {
        return this.usageAmount24;
    }
    
    public void setUsageAmount24(Float usageAmount24) {
        this.usageAmount24 = usageAmount24;
    }
    /**       
     *      * 25日水用量
     */

    public Float getUsageAmount25() {
        return this.usageAmount25;
    }
    
    public void setUsageAmount25(Float usageAmount25) {
        this.usageAmount25 = usageAmount25;
    }
    /**       
     *      * 26日水用量
     */

    public Float getUsageAmount26() {
        return this.usageAmount26;
    }
    
    public void setUsageAmount26(Float usageAmount26) {
        this.usageAmount26 = usageAmount26;
    }
    /**       
     *      * 27日水用量
     */

    public Float getUsageAmount27() {
        return this.usageAmount27;
    }
    
    public void setUsageAmount27(Float usageAmount27) {
        this.usageAmount27 = usageAmount27;
    }
    /**       
     *      * 28日水用量
     */

    public Float getUsageAmount28() {
        return this.usageAmount28;
    }
    
    public void setUsageAmount28(Float usageAmount28) {
        this.usageAmount28 = usageAmount28;
    }
    /**       
     *      * 29日水用量
     */

    public Float getUsageAmount29() {
        return this.usageAmount29;
    }
    
    public void setUsageAmount29(Float usageAmount29) {
        this.usageAmount29 = usageAmount29;
    }
    /**       
     *      * 30日水用量
     */

    public Float getUsageAmount30() {
        return this.usageAmount30;
    }
    
    public void setUsageAmount30(Float usageAmount30) {
        this.usageAmount30 = usageAmount30;
    }
    /**       
     *      * 31日水用量
     */

    public Float getUsageAmount31() {
        return this.usageAmount31;
    }
    
    public void setUsageAmount31(Float usageAmount31) {
        this.usageAmount31 = usageAmount31;
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
     *      * 冻结时间(月)
     */

    public String getFreezeMonth() {
        return this.freezeMonth;
    }
    
    public void setFreezeMonth(String freezeMonth) {
        this.freezeMonth = freezeMonth;
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
		if ( !(other instanceof WaterDayUsageAmount) ) return false;
		WaterDayUsageAmount castOther = ( WaterDayUsageAmount ) other;
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