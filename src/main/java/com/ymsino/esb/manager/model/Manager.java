package com.ymsino.esb.manager.model;



/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager  implements java.io.Serializable {


    // Fields    

     /**
      * 管理员id
     */
     private String managerId;
     /**
      * 姓名
     */
     private String name;
     /**
      * 密码(MD5加密)
     */
     private String password;
     /**
      * 邮箱
     */
     private String email;
     /**
      * 电话
     */
     private String tel;
     /**
      * 状态: -1停用, 0新建, 1启用
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
      * 部门编号
     */
     private String departmentId;
     /**
      * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
     */
     private String parentUnits;


    // Constructors

    /** default constructor */
    public Manager() {
    }

	/** minimal constructor */
    public Manager(String managerId) {
        this.managerId = managerId;
    }
    
    /** full constructor */
    public Manager(String managerId, String name, String password, String email, String tel, Short status, Long createTimestamp, String chargingUnitId, String departmentId, String parentUnits) {
        this.managerId = managerId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.status = status;
        this.createTimestamp = createTimestamp;
        this.chargingUnitId = chargingUnitId;
        this.departmentId = departmentId;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * 管理员id
     */

    public String getManagerId() {
        return this.managerId;
    }
    
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    /**       
     *      * 姓名
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 密码(MD5加密)
     */

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    /**       
     *      * 邮箱
     */

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    /**       
     *      * 电话
     */

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**       
     *      * 状态: -1停用, 0新建, 1启用
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
     *      * 部门编号
     */

    public String getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
		if ( !(other instanceof Manager) ) return false;
		Manager castOther = ( Manager ) other;
		if( this.getManagerId() == null || castOther.getManagerId() == null){
			return false;
		}
		
		return ( (this.getManagerId()==castOther.getManagerId()) || ( this.getManagerId()!=null && castOther.getManagerId()!=null && this.getManagerId().equals(castOther.getManagerId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getManagerId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getManagerId().hashCode());
		return result;
	}





}