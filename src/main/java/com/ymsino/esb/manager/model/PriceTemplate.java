package com.ymsino.esb.manager.model;



/**
 * PriceTemplate entity. @author MyEclipse Persistence Tools
 */

public class PriceTemplate  implements java.io.Serializable {


    // Fields    

     /**
      * 价目id
     */
     private Long id;
     /**
      * 价目名称
     */
     private String name;
     /**
      * 价目类型
     */
     private String type;
     /**
      * 1阶最大值
     */
     private Long level1Num;
     /**
      * 1阶价格，单位分
     */
     private Long level1Cost;
     /**
      * 2阶最大值
     */
     private Long level2Num;
     /**
      * 2阶价格，单位分
     */
     private Long level2Cost;
     /**
      * 3阶最大值
     */
     private Long level3Num;
     /**
      * 3阶价格，单位分
     */
     private Long level3Cost;
     /**
      * 4阶最大值
     */
     private Long level4Num;
     /**
      * 4阶价格，单位分
     */
     private Long level4Cost;
     /**
      * 结算周期
     */
     private String billingPeriod;
     /**
      * 开始日期
     */
     private Long startTimestamp;
     /**
      * 结束日期
     */
     private Long endTimestamp;
     /**
      * 备注
     */
     private String remark;
     /**
      * 收费单位编号
     */
     private String chargingUnitId;
     /**
      * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
     */
     private String parentUnits;
     /**
      * 创建时间
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public PriceTemplate() {
    }

    
    /** full constructor */
    public PriceTemplate(String name, String type, Long level1Num, Long level1Cost, Long level2Num, Long level2Cost, Long level3Num, Long level3Cost, Long level4Num, Long level4Cost, String billingPeriod, Long startTimestamp, Long endTimestamp, String remark, String chargingUnitId, String parentUnits, Long createTimestamp) {
        this.name = name;
        this.type = type;
        this.level1Num = level1Num;
        this.level1Cost = level1Cost;
        this.level2Num = level2Num;
        this.level2Cost = level2Cost;
        this.level3Num = level3Num;
        this.level3Cost = level3Cost;
        this.level4Num = level4Num;
        this.level4Cost = level4Cost;
        this.billingPeriod = billingPeriod;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.remark = remark;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * 价目id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * 价目名称
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 价目类型
     */

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    /**       
     *      * 1阶最大值
     */

    public Long getLevel1Num() {
        return this.level1Num;
    }
    
    public void setLevel1Num(Long level1Num) {
        this.level1Num = level1Num;
    }
    /**       
     *      * 1阶价格，单位分
     */

    public Long getLevel1Cost() {
        return this.level1Cost;
    }
    
    public void setLevel1Cost(Long level1Cost) {
        this.level1Cost = level1Cost;
    }
    /**       
     *      * 2阶最大值
     */

    public Long getLevel2Num() {
        return this.level2Num;
    }
    
    public void setLevel2Num(Long level2Num) {
        this.level2Num = level2Num;
    }
    /**       
     *      * 2阶价格，单位分
     */

    public Long getLevel2Cost() {
        return this.level2Cost;
    }
    
    public void setLevel2Cost(Long level2Cost) {
        this.level2Cost = level2Cost;
    }
    /**       
     *      * 3阶最大值
     */

    public Long getLevel3Num() {
        return this.level3Num;
    }
    
    public void setLevel3Num(Long level3Num) {
        this.level3Num = level3Num;
    }
    /**       
     *      * 3阶价格，单位分
     */

    public Long getLevel3Cost() {
        return this.level3Cost;
    }
    
    public void setLevel3Cost(Long level3Cost) {
        this.level3Cost = level3Cost;
    }
    /**       
     *      * 4阶最大值
     */

    public Long getLevel4Num() {
        return this.level4Num;
    }
    
    public void setLevel4Num(Long level4Num) {
        this.level4Num = level4Num;
    }
    /**       
     *      * 4阶价格，单位分
     */

    public Long getLevel4Cost() {
        return this.level4Cost;
    }
    
    public void setLevel4Cost(Long level4Cost) {
        this.level4Cost = level4Cost;
    }
    /**       
     *      * 结算周期
     */

    public String getBillingPeriod() {
        return this.billingPeriod;
    }
    
    public void setBillingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
    }
    /**       
     *      * 开始日期
     */

    public Long getStartTimestamp() {
        return this.startTimestamp;
    }
    
    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }
    /**       
     *      * 结束日期
     */

    public Long getEndTimestamp() {
        return this.endTimestamp;
    }
    
    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }
    /**       
     *      * 备注
     */

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
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
		if ( !(other instanceof PriceTemplate) ) return false;
		PriceTemplate castOther = ( PriceTemplate ) other;
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