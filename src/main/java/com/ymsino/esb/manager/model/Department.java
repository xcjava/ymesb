package com.ymsino.esb.manager.model;



/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department  implements java.io.Serializable {


    // Fields    

     /**
      * 部门编号
     */
     private String deptId;
     /**
      * 部门名称
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
      * 收费单位编号
     */
     private String chargingUnitId;
     /**
      * 上级部门编号
     */
     private String parentDeptId;
     /**
      * 备注
     */
     private String remark;
     /**
      * 权限json,格式为{"模块代号":""操作代号","模块代号":""操作代号,操作代号"},如,{"001":"001,002","002":"003"}
     */
     private String popedomJson;
     /**
      * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
     */
     private String parentUnits;


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(String deptId) {
        this.deptId = deptId;
    }
    
    /** full constructor */
    public Department(String deptId, String name, String linkMan, String linkTel, String linkAddr, Short status, Long createTimestamp, String chargingUnitId, String parentDeptId, String remark, String popedomJson, String parentUnits) {
        this.deptId = deptId;
        this.name = name;
        this.linkMan = linkMan;
        this.linkTel = linkTel;
        this.linkAddr = linkAddr;
        this.status = status;
        this.createTimestamp = createTimestamp;
        this.chargingUnitId = chargingUnitId;
        this.parentDeptId = parentDeptId;
        this.remark = remark;
        this.popedomJson = popedomJson;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * 部门编号
     */

    public String getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    /**       
     *      * 部门名称
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
     *      * 收费单位编号
     */

    public String getChargingUnitId() {
        return this.chargingUnitId;
    }
    
    public void setChargingUnitId(String chargingUnitId) {
        this.chargingUnitId = chargingUnitId;
    }
    /**       
     *      * 上级部门编号
     */

    public String getParentDeptId() {
        return this.parentDeptId;
    }
    
    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
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
     *      * 权限json,格式为{"模块代号":""操作代号","模块代号":""操作代号,操作代号"},如,{"001":"001,002","002":"003"}
     */

    public String getPopedomJson() {
        return this.popedomJson;
    }
    
    public void setPopedomJson(String popedomJson) {
        this.popedomJson = popedomJson;
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
		if ( !(other instanceof Department) ) return false;
		Department castOther = ( Department ) other;
		if( this.getDeptId() == null || castOther.getDeptId() == null){
			return false;
		}
		
		return ( (this.getDeptId()==castOther.getDeptId()) || ( this.getDeptId()!=null && castOther.getDeptId()!=null && this.getDeptId().equals(castOther.getDeptId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getDeptId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getDeptId().hashCode());
		return result;
	}





}