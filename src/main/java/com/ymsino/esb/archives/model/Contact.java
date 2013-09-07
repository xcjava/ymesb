package com.ymsino.esb.archives.model;



/**
 * Contact entity. @author MyEclipse Persistence Tools
 */

public class Contact  implements java.io.Serializable {


    // Fields    

     /**
      * 联系信息标识，自增id
     */
     private Long id;
     /**
      * 联系类型
     */
     private String type;
     /**
      * 联系信息来源
     */
     private String source;
     /**
      * 联系优先级
     */
     private String priority;
     /**
      * 联系人
     */
     private String linkMan;
     /**
      * 性别
     */
     private String sex;
     /**
      * 部门编号
     */
     private String departmentId;
     /**
      * 职务/职称
     */
     private String position;
     /**
      * 办公电话
     */
     private String officePhone;
     /**
      * 移动电话
     */
     private String mobile;
     /**
      * 传真号码
     */
     private String fax;
     /**
      * 邮编
     */
     private String postcode;
     /**
      * 电子邮箱
     */
     private String email;
     /**
      * 联系备注
     */
     private String remark;
     /**
      * 联系地址
     */
     private String address;
     /**
      * 用户id
     */
     private Long uid;
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
    public Contact() {
    }

    
    /** full constructor */
    public Contact(String type, String source, String priority, String linkMan, String sex, String departmentId, String position, String officePhone, String mobile, String fax, String postcode, String email, String remark, String address, Long uid, String chargingUnitId, String parentUnits, Long createTimestamp) {
        this.type = type;
        this.source = source;
        this.priority = priority;
        this.linkMan = linkMan;
        this.sex = sex;
        this.departmentId = departmentId;
        this.position = position;
        this.officePhone = officePhone;
        this.mobile = mobile;
        this.fax = fax;
        this.postcode = postcode;
        this.email = email;
        this.remark = remark;
        this.address = address;
        this.uid = uid;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * 联系信息标识，自增id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * 联系类型
     */

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    /**       
     *      * 联系信息来源
     */

    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    /**       
     *      * 联系优先级
     */

    public String getPriority() {
        return this.priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
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
     *      * 性别
     */

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
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
     *      * 职务/职称
     */

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    /**       
     *      * 办公电话
     */

    public String getOfficePhone() {
        return this.officePhone;
    }
    
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }
    /**       
     *      * 移动电话
     */

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**       
     *      * 传真号码
     */

    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**       
     *      * 邮编
     */

    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    /**       
     *      * 电子邮箱
     */

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    /**       
     *      * 联系备注
     */

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**       
     *      * 联系地址
     */

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
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
		if ( !(other instanceof Contact) ) return false;
		Contact castOther = ( Contact ) other;
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