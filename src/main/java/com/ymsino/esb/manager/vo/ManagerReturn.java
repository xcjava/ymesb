package com.ymsino.esb.manager.vo;

import java.io.Serializable;

public class ManagerReturn implements Serializable {

	/**
     * 管理员id
    */
    String managerId;
    /**
     * 姓名
    */
    String name;
    /**
     * 邮箱
    */
    String email;
    /**
     * 电话
    */
    String tel;
    /**
     * 状态: -1停用, 0新建, 1启用
    */
    Short status;
    /**
     * 创建时间
    */
    Long createTimestamp;
    /**
     * 收费单位编号
    */
    String chargingUnitId;
    /**
     * 部门编号
    */
    String departmentId;
    /**
     * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
    */
    String parentUnits;
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public String getChargingUnitId() {
		return chargingUnitId;
	}
	public void setChargingUnitId(String chargingUnitId) {
		this.chargingUnitId = chargingUnitId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getParentUnits() {
		return parentUnits;
	}
	public void setParentUnits(String parentUnits) {
		this.parentUnits = parentUnits;
	}
}
