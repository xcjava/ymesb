package com.ymsino.esb.archives.model;



/**
 * PrepaidMeter entity. @author MyEclipse Persistence Tools
 */

public class PrepaidMeter  implements java.io.Serializable {


    // Fields    

     /**
      * 预付费水表编号
     */
     private String pmSn;
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
     private String childPmSn;
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
      * 当前水价(单位：分)
     */
     private Long currentPrice;
     /**
      * 水表类型：1,IC卡预付费水表;2,红外卡预付费水表
     */
     private Short type;
     /**
      * 创建时间
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public PrepaidMeter() {
    }

	/** minimal constructor */
    public PrepaidMeter(String pmSn) {
        this.pmSn = pmSn;
    }
    
    /** full constructor */
    public PrepaidMeter(String pmSn, Long uid, String userId, String userName, String chargingUnitId, String parentUnits, String childPmSn, String nature, String purcAmount, String showWarn, String closeWarn, Long currentPrice, Short type, Long createTimestamp) {
        this.pmSn = pmSn;
        this.uid = uid;
        this.userId = userId;
        this.userName = userName;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.childPmSn = childPmSn;
        this.nature = nature;
        this.purcAmount = purcAmount;
        this.showWarn = showWarn;
        this.closeWarn = closeWarn;
        this.currentPrice = currentPrice;
        this.type = type;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * 预付费水表编号
     */

    public String getPmSn() {
        return this.pmSn;
    }
    
    public void setPmSn(String pmSn) {
        this.pmSn = pmSn;
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

    public String getChildPmSn() {
        return this.childPmSn;
    }
    
    public void setChildPmSn(String childPmSn) {
        this.childPmSn = childPmSn;
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
     *      * 当前水价(单位：分)
     */

    public Long getCurrentPrice() {
        return this.currentPrice;
    }
    
    public void setCurrentPrice(Long currentPrice) {
        this.currentPrice = currentPrice;
    }
    /**       
     *      * 水表类型：1,IC卡预付费水表;2,红外卡预付费水表
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
		if ( !(other instanceof PrepaidMeter) ) return false;
		PrepaidMeter castOther = ( PrepaidMeter ) other;
		if( this.getPmSn() == null || castOther.getPmSn() == null){
			return false;
		}
		
		return ( (this.getPmSn()==castOther.getPmSn()) || ( this.getPmSn()!=null && castOther.getPmSn()!=null && this.getPmSn().equals(castOther.getPmSn()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getPmSn() == null ? random.nextInt(Integer.MAX_VALUE) : this.getPmSn().hashCode());
		return result;
	}





}