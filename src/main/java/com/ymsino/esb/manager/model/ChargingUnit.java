package com.ymsino.esb.manager.model;



/**
 * ChargingUnit entity. @author MyEclipse Persistence Tools
 */

public class ChargingUnit  implements java.io.Serializable {


    // Fields    

     /**
      * 收费单位编号
     */
     private String unitId;
     /**
      * 收费单位名称
     */
     private String name;
     /**
      * 联系人
     */
     private String linkMan;
     /**
      * 联系电话
     */
     private String linkTel;
     /**
      * 联系地址
     */
     private String linkAddr;
     /**
      * 状态: 1正常, -1删除
     */
     private Short status;
     /**
      * 创建时间
     */
     private Long createTimestamp;
     /**
      * 创建人ID
     */
     private String createrId;
     /**
      * 上级收费单位编号
     */
     private String parentUnitId;
     /**
      * 备注
     */
     private String remark;
     /**
      * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
     */
     private String parentUnits;


    // Constructors

    /** default constructor */
    public ChargingUnit() {
    }

	/** minimal constructor */
    public ChargingUnit(String unitId) {
        this.unitId = unitId;
    }
    
    /** full constructor */
    public ChargingUnit(String unitId, String name, String linkMan, String linkTel, String linkAddr, Short status, Long createTimestamp, String createrId, String parentUnitId, String remark, String parentUnits) {
        this.unitId = unitId;
        this.name = name;
        this.linkMan = linkMan;
        this.linkTel = linkTel;
        this.linkAddr = linkAddr;
        this.status = status;
        this.createTimestamp = createTimestamp;
        this.createrId = createrId;
        this.parentUnitId = parentUnitId;
        this.remark = remark;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * 收费单位编号
     */

    public String getUnitId() {
        return this.unitId;
    }
    
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
    /**       
     *      * 收费单位名称
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 联系人
     */

    public String getLinkMan() {
        return this.linkMan;
    }
    
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
    /**       
     *      * 联系电话
     */

    public String getLinkTel() {
        return this.linkTel;
    }
    
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }
    /**       
     *      * 联系地址
     */

    public String getLinkAddr() {
        return this.linkAddr;
    }
    
    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr;
    }
    /**       
     *      * 状态: 1正常, -1删除
     */

    public Short getStatus() {
        return this.status;
    }
    
    public void setStatus(Short status) {
        this.status = status;
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
    /**       
     *      * 创建人ID
     */

    public String getCreaterId() {
        return this.createrId;
    }
    
    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }
    /**       
     *      * 上级收费单位编号
     */

    public String getParentUnitId() {
        return this.parentUnitId;
    }
    
    public void setParentUnitId(String parentUnitId) {
        this.parentUnitId = parentUnitId;
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
		if ( !(other instanceof ChargingUnit) ) return false;
		ChargingUnit castOther = ( ChargingUnit ) other;
		if( this.getUnitId() == null || castOther.getUnitId() == null){
			return false;
		}
		
		return ( (this.getUnitId()==castOther.getUnitId()) || ( this.getUnitId()!=null && castOther.getUnitId()!=null && this.getUnitId().equals(castOther.getUnitId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getUnitId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getUnitId().hashCode());
		return result;
	}





}