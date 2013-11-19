package com.ymsino.esb.freesettle.model;



/**
 * WaterMonthCost entity. @author MyEclipse Persistence Tools
 */

public class WaterMonthCost  implements java.io.Serializable {


    // Fields    

     /**
      * 水表月费用自增id
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
      * 1月费用
     */
     private Long cost1;
     /**
      * 2月费用
     */
     private Long cost2;
     /**
      * 3月费用
     */
     private Long cost3;
     /**
      * 4月费用
     */
     private Long cost4;
     /**
      * 5月费用
     */
     private Long cost5;
     /**
      * 6月费用
     */
     private Long cost6;
     /**
      * 7月费用
     */
     private Long cost7;
     /**
      * 8月费用
     */
     private Long cost8;
     /**
      * 9月费用
     */
     private Long cost9;
     /**
      * 10月费用
     */
     private Long cost10;
     /**
      * 11月费用
     */
     private Long cost11;
     /**
      * 12月费用
     */
     private Long cost12;
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
    public WaterMonthCost() {
    }

    
    /** full constructor */
    public WaterMonthCost(String concHardwareId, String meterHardwareId, Long cost1, Long cost2, Long cost3, Long cost4, Long cost5, Long cost6, Long cost7, Long cost8, Long cost9, Long cost10, Long cost11, Long cost12, String freezeYear, Long createTimestamp, String userId, String waterCustomerId, String chargingUnitId, String parentUnits) {
        this.concHardwareId = concHardwareId;
        this.meterHardwareId = meterHardwareId;
        this.cost1 = cost1;
        this.cost2 = cost2;
        this.cost3 = cost3;
        this.cost4 = cost4;
        this.cost5 = cost5;
        this.cost6 = cost6;
        this.cost7 = cost7;
        this.cost8 = cost8;
        this.cost9 = cost9;
        this.cost10 = cost10;
        this.cost11 = cost11;
        this.cost12 = cost12;
        this.freezeYear = freezeYear;
        this.createTimestamp = createTimestamp;
        this.userId = userId;
        this.waterCustomerId = waterCustomerId;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * 水表月费用自增id
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
     *      * 1月费用
     */

    public Long getCost1() {
        return this.cost1;
    }
    
    public void setCost1(Long cost1) {
        this.cost1 = cost1;
    }
    /**       
     *      * 2月费用
     */

    public Long getCost2() {
        return this.cost2;
    }
    
    public void setCost2(Long cost2) {
        this.cost2 = cost2;
    }
    /**       
     *      * 3月费用
     */

    public Long getCost3() {
        return this.cost3;
    }
    
    public void setCost3(Long cost3) {
        this.cost3 = cost3;
    }
    /**       
     *      * 4月费用
     */

    public Long getCost4() {
        return this.cost4;
    }
    
    public void setCost4(Long cost4) {
        this.cost4 = cost4;
    }
    /**       
     *      * 5月费用
     */

    public Long getCost5() {
        return this.cost5;
    }
    
    public void setCost5(Long cost5) {
        this.cost5 = cost5;
    }
    /**       
     *      * 6月费用
     */

    public Long getCost6() {
        return this.cost6;
    }
    
    public void setCost6(Long cost6) {
        this.cost6 = cost6;
    }
    /**       
     *      * 7月费用
     */

    public Long getCost7() {
        return this.cost7;
    }
    
    public void setCost7(Long cost7) {
        this.cost7 = cost7;
    }
    /**       
     *      * 8月费用
     */

    public Long getCost8() {
        return this.cost8;
    }
    
    public void setCost8(Long cost8) {
        this.cost8 = cost8;
    }
    /**       
     *      * 9月费用
     */

    public Long getCost9() {
        return this.cost9;
    }
    
    public void setCost9(Long cost9) {
        this.cost9 = cost9;
    }
    /**       
     *      * 10月费用
     */

    public Long getCost10() {
        return this.cost10;
    }
    
    public void setCost10(Long cost10) {
        this.cost10 = cost10;
    }
    /**       
     *      * 11月费用
     */

    public Long getCost11() {
        return this.cost11;
    }
    
    public void setCost11(Long cost11) {
        this.cost11 = cost11;
    }
    /**       
     *      * 12月费用
     */

    public Long getCost12() {
        return this.cost12;
    }
    
    public void setCost12(Long cost12) {
        this.cost12 = cost12;
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
		if ( !(other instanceof WaterMonthCost) ) return false;
		WaterMonthCost castOther = ( WaterMonthCost ) other;
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