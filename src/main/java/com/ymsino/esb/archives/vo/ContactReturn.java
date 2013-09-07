package com.ymsino.esb.archives.vo;

import java.io.Serializable;

public class ContactReturn implements Serializable {

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getChargingUnitId() {
		return chargingUnitId;
	}
	public void setChargingUnitId(String chargingUnitId) {
		this.chargingUnitId = chargingUnitId;
	}
	public String getParentUnits() {
		return parentUnits;
	}
	public void setParentUnits(String parentUnits) {
		this.parentUnits = parentUnits;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
}
