package com.ymsino.esb.freesettle.model;



/**
 * WaterDayCost entity. @author MyEclipse Persistence Tools
 */

public class WaterDayCost  implements java.io.Serializable {


    // Fields    

     /**
      * 水表日费用自增id
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
      * 1日费用
     */
     private Long cost1;
     /**
      * 2日费用
     */
     private Long cost2;
     /**
      * 3日费用
     */
     private Long cost3;
     /**
      * 4日费用
     */
     private Long cost4;
     /**
      * 5日费用
     */
     private Long cost5;
     /**
      * 6日费用
     */
     private Long cost6;
     /**
      * 7日费用
     */
     private Long cost7;
     /**
      * 8日费用
     */
     private Long cost8;
     /**
      * 9日费用
     */
     private Long cost9;
     /**
      * 10日费用
     */
     private Long cost10;
     /**
      * 11日费用
     */
     private Long cost11;
     /**
      * 12日费用
     */
     private Long cost12;
     /**
      * 13日费用
     */
     private Long cost13;
     /**
      * 14日费用
     */
     private Long cost14;
     /**
      * 15日费用
     */
     private Long cost15;
     /**
      * 16日费用
     */
     private Long cost16;
     /**
      * 17日费用
     */
     private Long cost17;
     /**
      * 18日费用
     */
     private Long cost18;
     /**
      * 19日费用
     */
     private Long cost19;
     /**
      * 20日费用
     */
     private Long cost20;
     /**
      * 21日费用
     */
     private Long cost21;
     /**
      * 22日费用
     */
     private Long cost22;
     /**
      * 23日费用
     */
     private Long cost23;
     /**
      * 24日费用
     */
     private Long cost24;
     /**
      * 25日费用
     */
     private Long cost25;
     /**
      * 26日费用
     */
     private Long cost26;
     /**
      * 27日费用
     */
     private Long cost27;
     /**
      * 28日费用
     */
     private Long cost28;
     /**
      * 29日费用
     */
     private Long cost29;
     /**
      * 30日费用
     */
     private Long cost30;
     /**
      * 31日费用
     */
     private Long cost31;
     /**
      * 月合计费用
     */
     private Long totalCost;
     /**
      * 支付状态-1:未支付;1已支付
     */
     private Short payStatus;
     /**
      * 扣费检查状态-1:未检查;1已检查
     */
     private Short checkPayStatus;
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
    public WaterDayCost() {
    }

    
    /** full constructor */
    public WaterDayCost(String concHardwareId, String meterHardwareId, Long cost1, Long cost2, Long cost3, Long cost4, Long cost5, Long cost6, Long cost7, Long cost8, Long cost9, Long cost10, Long cost11, Long cost12, Long cost13, Long cost14, Long cost15, Long cost16, Long cost17, Long cost18, Long cost19, Long cost20, Long cost21, Long cost22, Long cost23, Long cost24, Long cost25, Long cost26, Long cost27, Long cost28, Long cost29, Long cost30, Long cost31, Long totalCost, Short payStatus, Short checkPayStatus, String freezeYear, String freezeMonth, Long createTimestamp, String userId, String waterCustomerId, String chargingUnitId, String parentUnits) {
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
        this.cost13 = cost13;
        this.cost14 = cost14;
        this.cost15 = cost15;
        this.cost16 = cost16;
        this.cost17 = cost17;
        this.cost18 = cost18;
        this.cost19 = cost19;
        this.cost20 = cost20;
        this.cost21 = cost21;
        this.cost22 = cost22;
        this.cost23 = cost23;
        this.cost24 = cost24;
        this.cost25 = cost25;
        this.cost26 = cost26;
        this.cost27 = cost27;
        this.cost28 = cost28;
        this.cost29 = cost29;
        this.cost30 = cost30;
        this.cost31 = cost31;
        this.totalCost = totalCost;
        this.payStatus = payStatus;
        this.checkPayStatus = checkPayStatus;
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
     *      * 水表日费用自增id
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
     *      * 1日费用
     */

    public Long getCost1() {
        return this.cost1;
    }
    
    public void setCost1(Long cost1) {
        this.cost1 = cost1;
    }
    /**       
     *      * 2日费用
     */

    public Long getCost2() {
        return this.cost2;
    }
    
    public void setCost2(Long cost2) {
        this.cost2 = cost2;
    }
    /**       
     *      * 3日费用
     */

    public Long getCost3() {
        return this.cost3;
    }
    
    public void setCost3(Long cost3) {
        this.cost3 = cost3;
    }
    /**       
     *      * 4日费用
     */

    public Long getCost4() {
        return this.cost4;
    }
    
    public void setCost4(Long cost4) {
        this.cost4 = cost4;
    }
    /**       
     *      * 5日费用
     */

    public Long getCost5() {
        return this.cost5;
    }
    
    public void setCost5(Long cost5) {
        this.cost5 = cost5;
    }
    /**       
     *      * 6日费用
     */

    public Long getCost6() {
        return this.cost6;
    }
    
    public void setCost6(Long cost6) {
        this.cost6 = cost6;
    }
    /**       
     *      * 7日费用
     */

    public Long getCost7() {
        return this.cost7;
    }
    
    public void setCost7(Long cost7) {
        this.cost7 = cost7;
    }
    /**       
     *      * 8日费用
     */

    public Long getCost8() {
        return this.cost8;
    }
    
    public void setCost8(Long cost8) {
        this.cost8 = cost8;
    }
    /**       
     *      * 9日费用
     */

    public Long getCost9() {
        return this.cost9;
    }
    
    public void setCost9(Long cost9) {
        this.cost9 = cost9;
    }
    /**       
     *      * 10日费用
     */

    public Long getCost10() {
        return this.cost10;
    }
    
    public void setCost10(Long cost10) {
        this.cost10 = cost10;
    }
    /**       
     *      * 11日费用
     */

    public Long getCost11() {
        return this.cost11;
    }
    
    public void setCost11(Long cost11) {
        this.cost11 = cost11;
    }
    /**       
     *      * 12日费用
     */

    public Long getCost12() {
        return this.cost12;
    }
    
    public void setCost12(Long cost12) {
        this.cost12 = cost12;
    }
    /**       
     *      * 13日费用
     */

    public Long getCost13() {
        return this.cost13;
    }
    
    public void setCost13(Long cost13) {
        this.cost13 = cost13;
    }
    /**       
     *      * 14日费用
     */

    public Long getCost14() {
        return this.cost14;
    }
    
    public void setCost14(Long cost14) {
        this.cost14 = cost14;
    }
    /**       
     *      * 15日费用
     */

    public Long getCost15() {
        return this.cost15;
    }
    
    public void setCost15(Long cost15) {
        this.cost15 = cost15;
    }
    /**       
     *      * 16日费用
     */

    public Long getCost16() {
        return this.cost16;
    }
    
    public void setCost16(Long cost16) {
        this.cost16 = cost16;
    }
    /**       
     *      * 17日费用
     */

    public Long getCost17() {
        return this.cost17;
    }
    
    public void setCost17(Long cost17) {
        this.cost17 = cost17;
    }
    /**       
     *      * 18日费用
     */

    public Long getCost18() {
        return this.cost18;
    }
    
    public void setCost18(Long cost18) {
        this.cost18 = cost18;
    }
    /**       
     *      * 19日费用
     */

    public Long getCost19() {
        return this.cost19;
    }
    
    public void setCost19(Long cost19) {
        this.cost19 = cost19;
    }
    /**       
     *      * 20日费用
     */

    public Long getCost20() {
        return this.cost20;
    }
    
    public void setCost20(Long cost20) {
        this.cost20 = cost20;
    }
    /**       
     *      * 21日费用
     */

    public Long getCost21() {
        return this.cost21;
    }
    
    public void setCost21(Long cost21) {
        this.cost21 = cost21;
    }
    /**       
     *      * 22日费用
     */

    public Long getCost22() {
        return this.cost22;
    }
    
    public void setCost22(Long cost22) {
        this.cost22 = cost22;
    }
    /**       
     *      * 23日费用
     */

    public Long getCost23() {
        return this.cost23;
    }
    
    public void setCost23(Long cost23) {
        this.cost23 = cost23;
    }
    /**       
     *      * 24日费用
     */

    public Long getCost24() {
        return this.cost24;
    }
    
    public void setCost24(Long cost24) {
        this.cost24 = cost24;
    }
    /**       
     *      * 25日费用
     */

    public Long getCost25() {
        return this.cost25;
    }
    
    public void setCost25(Long cost25) {
        this.cost25 = cost25;
    }
    /**       
     *      * 26日费用
     */

    public Long getCost26() {
        return this.cost26;
    }
    
    public void setCost26(Long cost26) {
        this.cost26 = cost26;
    }
    /**       
     *      * 27日费用
     */

    public Long getCost27() {
        return this.cost27;
    }
    
    public void setCost27(Long cost27) {
        this.cost27 = cost27;
    }
    /**       
     *      * 28日费用
     */

    public Long getCost28() {
        return this.cost28;
    }
    
    public void setCost28(Long cost28) {
        this.cost28 = cost28;
    }
    /**       
     *      * 29日费用
     */

    public Long getCost29() {
        return this.cost29;
    }
    
    public void setCost29(Long cost29) {
        this.cost29 = cost29;
    }
    /**       
     *      * 30日费用
     */

    public Long getCost30() {
        return this.cost30;
    }
    
    public void setCost30(Long cost30) {
        this.cost30 = cost30;
    }
    /**       
     *      * 31日费用
     */

    public Long getCost31() {
        return this.cost31;
    }
    
    public void setCost31(Long cost31) {
        this.cost31 = cost31;
    }
    /**       
     *      * 月合计费用
     */

    public Long getTotalCost() {
        return this.totalCost;
    }
    
    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }
    /**       
     *      * 支付状态-1:未支付;1已支付
     */

    public Short getPayStatus() {
        return this.payStatus;
    }
    
    public void setPayStatus(Short payStatus) {
        this.payStatus = payStatus;
    }
    /**       
     *      * 扣费检查状态-1:未检查;1已检查
     */

    public Short getCheckPayStatus() {
        return this.checkPayStatus;
    }
    
    public void setCheckPayStatus(Short checkPayStatus) {
        this.checkPayStatus = checkPayStatus;
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
		if ( !(other instanceof WaterDayCost) ) return false;
		WaterDayCost castOther = ( WaterDayCost ) other;
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