package com.ymsino.esb.data.model;



/**
 * CheckingFreezeData entity. @author MyEclipse Persistence Tools
 */

public class CheckingFreezeData  implements java.io.Serializable {


    // Fields    

     /**
      * 水表冻结审核数据自增id
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
      * 1日表计读数
     */
     private Long meterReading1;
     /**
      * 2日表计读数
     */
     private Long meterReading2;
     /**
      * 3日表计读数
     */
     private Long meterReading3;
     /**
      * 4日表计读数
     */
     private Long meterReading4;
     /**
      * 5日表计读数
     */
     private Long meterReading5;
     /**
      * 6日表计读数
     */
     private Long meterReading6;
     /**
      * 7日表计读数
     */
     private Long meterReading7;
     /**
      * 8日表计读数
     */
     private Long meterReading8;
     /**
      * 9日表计读数
     */
     private Long meterReading9;
     /**
      * 10日表计读数
     */
     private Long meterReading10;
     /**
      * 11日表计读数
     */
     private Long meterReading11;
     /**
      * 12日表计读数
     */
     private Long meterReading12;
     /**
      * 13日表计读数
     */
     private Long meterReading13;
     /**
      * 14日表计读数
     */
     private Long meterReading14;
     /**
      * 15日表计读数
     */
     private Long meterReading15;
     /**
      * 16日表计读数
     */
     private Long meterReading16;
     /**
      * 17日表计读数
     */
     private Long meterReading17;
     /**
      * 18日表计读数
     */
     private Long meterReading18;
     /**
      * 19日表计读数
     */
     private Long meterReading19;
     /**
      * 20日表计读数
     */
     private Long meterReading20;
     /**
      * 21日表计读数
     */
     private Long meterReading21;
     /**
      * 22日表计读数
     */
     private Long meterReading22;
     /**
      * 23日表计读数
     */
     private Long meterReading23;
     /**
      * 24日表计读数
     */
     private Long meterReading24;
     /**
      * 25日表计读数
     */
     private Long meterReading25;
     /**
      * 26日表计读数
     */
     private Long meterReading26;
     /**
      * 27日表计读数
     */
     private Long meterReading27;
     /**
      * 28日表计读数
     */
     private Long meterReading28;
     /**
      * 29日表计读数
     */
     private Long meterReading29;
     /**
      * 30日表计读数
     */
     private Long meterReading30;
     /**
      * 31日表计读数
     */
     private Long meterReading31;
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
    public CheckingFreezeData() {
    }

    
    /** full constructor */
    public CheckingFreezeData(String concHardwareId, String meterHardwareId, Long meterReading1, Long meterReading2, Long meterReading3, Long meterReading4, Long meterReading5, Long meterReading6, Long meterReading7, Long meterReading8, Long meterReading9, Long meterReading10, Long meterReading11, Long meterReading12, Long meterReading13, Long meterReading14, Long meterReading15, Long meterReading16, Long meterReading17, Long meterReading18, Long meterReading19, Long meterReading20, Long meterReading21, Long meterReading22, Long meterReading23, Long meterReading24, Long meterReading25, Long meterReading26, Long meterReading27, Long meterReading28, Long meterReading29, Long meterReading30, Long meterReading31, String freezeYear, String freezeMonth, Long createTimestamp, String userId, String waterCustomerId, String chargingUnitId, String parentUnits) {
        this.concHardwareId = concHardwareId;
        this.meterHardwareId = meterHardwareId;
        this.meterReading1 = meterReading1;
        this.meterReading2 = meterReading2;
        this.meterReading3 = meterReading3;
        this.meterReading4 = meterReading4;
        this.meterReading5 = meterReading5;
        this.meterReading6 = meterReading6;
        this.meterReading7 = meterReading7;
        this.meterReading8 = meterReading8;
        this.meterReading9 = meterReading9;
        this.meterReading10 = meterReading10;
        this.meterReading11 = meterReading11;
        this.meterReading12 = meterReading12;
        this.meterReading13 = meterReading13;
        this.meterReading14 = meterReading14;
        this.meterReading15 = meterReading15;
        this.meterReading16 = meterReading16;
        this.meterReading17 = meterReading17;
        this.meterReading18 = meterReading18;
        this.meterReading19 = meterReading19;
        this.meterReading20 = meterReading20;
        this.meterReading21 = meterReading21;
        this.meterReading22 = meterReading22;
        this.meterReading23 = meterReading23;
        this.meterReading24 = meterReading24;
        this.meterReading25 = meterReading25;
        this.meterReading26 = meterReading26;
        this.meterReading27 = meterReading27;
        this.meterReading28 = meterReading28;
        this.meterReading29 = meterReading29;
        this.meterReading30 = meterReading30;
        this.meterReading31 = meterReading31;
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
     *      * 水表冻结审核数据自增id
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
     *      * 1日表计读数
     */

    public Long getMeterReading1() {
        return this.meterReading1;
    }
    
    public void setMeterReading1(Long meterReading1) {
        this.meterReading1 = meterReading1;
    }
    /**       
     *      * 2日表计读数
     */

    public Long getMeterReading2() {
        return this.meterReading2;
    }
    
    public void setMeterReading2(Long meterReading2) {
        this.meterReading2 = meterReading2;
    }
    /**       
     *      * 3日表计读数
     */

    public Long getMeterReading3() {
        return this.meterReading3;
    }
    
    public void setMeterReading3(Long meterReading3) {
        this.meterReading3 = meterReading3;
    }
    /**       
     *      * 4日表计读数
     */

    public Long getMeterReading4() {
        return this.meterReading4;
    }
    
    public void setMeterReading4(Long meterReading4) {
        this.meterReading4 = meterReading4;
    }
    /**       
     *      * 5日表计读数
     */

    public Long getMeterReading5() {
        return this.meterReading5;
    }
    
    public void setMeterReading5(Long meterReading5) {
        this.meterReading5 = meterReading5;
    }
    /**       
     *      * 6日表计读数
     */

    public Long getMeterReading6() {
        return this.meterReading6;
    }
    
    public void setMeterReading6(Long meterReading6) {
        this.meterReading6 = meterReading6;
    }
    /**       
     *      * 7日表计读数
     */

    public Long getMeterReading7() {
        return this.meterReading7;
    }
    
    public void setMeterReading7(Long meterReading7) {
        this.meterReading7 = meterReading7;
    }
    /**       
     *      * 8日表计读数
     */

    public Long getMeterReading8() {
        return this.meterReading8;
    }
    
    public void setMeterReading8(Long meterReading8) {
        this.meterReading8 = meterReading8;
    }
    /**       
     *      * 9日表计读数
     */

    public Long getMeterReading9() {
        return this.meterReading9;
    }
    
    public void setMeterReading9(Long meterReading9) {
        this.meterReading9 = meterReading9;
    }
    /**       
     *      * 10日表计读数
     */

    public Long getMeterReading10() {
        return this.meterReading10;
    }
    
    public void setMeterReading10(Long meterReading10) {
        this.meterReading10 = meterReading10;
    }
    /**       
     *      * 11日表计读数
     */

    public Long getMeterReading11() {
        return this.meterReading11;
    }
    
    public void setMeterReading11(Long meterReading11) {
        this.meterReading11 = meterReading11;
    }
    /**       
     *      * 12日表计读数
     */

    public Long getMeterReading12() {
        return this.meterReading12;
    }
    
    public void setMeterReading12(Long meterReading12) {
        this.meterReading12 = meterReading12;
    }
    /**       
     *      * 13日表计读数
     */

    public Long getMeterReading13() {
        return this.meterReading13;
    }
    
    public void setMeterReading13(Long meterReading13) {
        this.meterReading13 = meterReading13;
    }
    /**       
     *      * 14日表计读数
     */

    public Long getMeterReading14() {
        return this.meterReading14;
    }
    
    public void setMeterReading14(Long meterReading14) {
        this.meterReading14 = meterReading14;
    }
    /**       
     *      * 15日表计读数
     */

    public Long getMeterReading15() {
        return this.meterReading15;
    }
    
    public void setMeterReading15(Long meterReading15) {
        this.meterReading15 = meterReading15;
    }
    /**       
     *      * 16日表计读数
     */

    public Long getMeterReading16() {
        return this.meterReading16;
    }
    
    public void setMeterReading16(Long meterReading16) {
        this.meterReading16 = meterReading16;
    }
    /**       
     *      * 17日表计读数
     */

    public Long getMeterReading17() {
        return this.meterReading17;
    }
    
    public void setMeterReading17(Long meterReading17) {
        this.meterReading17 = meterReading17;
    }
    /**       
     *      * 18日表计读数
     */

    public Long getMeterReading18() {
        return this.meterReading18;
    }
    
    public void setMeterReading18(Long meterReading18) {
        this.meterReading18 = meterReading18;
    }
    /**       
     *      * 19日表计读数
     */

    public Long getMeterReading19() {
        return this.meterReading19;
    }
    
    public void setMeterReading19(Long meterReading19) {
        this.meterReading19 = meterReading19;
    }
    /**       
     *      * 20日表计读数
     */

    public Long getMeterReading20() {
        return this.meterReading20;
    }
    
    public void setMeterReading20(Long meterReading20) {
        this.meterReading20 = meterReading20;
    }
    /**       
     *      * 21日表计读数
     */

    public Long getMeterReading21() {
        return this.meterReading21;
    }
    
    public void setMeterReading21(Long meterReading21) {
        this.meterReading21 = meterReading21;
    }
    /**       
     *      * 22日表计读数
     */

    public Long getMeterReading22() {
        return this.meterReading22;
    }
    
    public void setMeterReading22(Long meterReading22) {
        this.meterReading22 = meterReading22;
    }
    /**       
     *      * 23日表计读数
     */

    public Long getMeterReading23() {
        return this.meterReading23;
    }
    
    public void setMeterReading23(Long meterReading23) {
        this.meterReading23 = meterReading23;
    }
    /**       
     *      * 24日表计读数
     */

    public Long getMeterReading24() {
        return this.meterReading24;
    }
    
    public void setMeterReading24(Long meterReading24) {
        this.meterReading24 = meterReading24;
    }
    /**       
     *      * 25日表计读数
     */

    public Long getMeterReading25() {
        return this.meterReading25;
    }
    
    public void setMeterReading25(Long meterReading25) {
        this.meterReading25 = meterReading25;
    }
    /**       
     *      * 26日表计读数
     */

    public Long getMeterReading26() {
        return this.meterReading26;
    }
    
    public void setMeterReading26(Long meterReading26) {
        this.meterReading26 = meterReading26;
    }
    /**       
     *      * 27日表计读数
     */

    public Long getMeterReading27() {
        return this.meterReading27;
    }
    
    public void setMeterReading27(Long meterReading27) {
        this.meterReading27 = meterReading27;
    }
    /**       
     *      * 28日表计读数
     */

    public Long getMeterReading28() {
        return this.meterReading28;
    }
    
    public void setMeterReading28(Long meterReading28) {
        this.meterReading28 = meterReading28;
    }
    /**       
     *      * 29日表计读数
     */

    public Long getMeterReading29() {
        return this.meterReading29;
    }
    
    public void setMeterReading29(Long meterReading29) {
        this.meterReading29 = meterReading29;
    }
    /**       
     *      * 30日表计读数
     */

    public Long getMeterReading30() {
        return this.meterReading30;
    }
    
    public void setMeterReading30(Long meterReading30) {
        this.meterReading30 = meterReading30;
    }
    /**       
     *      * 31日表计读数
     */

    public Long getMeterReading31() {
        return this.meterReading31;
    }
    
    public void setMeterReading31(Long meterReading31) {
        this.meterReading31 = meterReading31;
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
		if ( !(other instanceof CheckingFreezeData) ) return false;
		CheckingFreezeData castOther = ( CheckingFreezeData ) other;
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