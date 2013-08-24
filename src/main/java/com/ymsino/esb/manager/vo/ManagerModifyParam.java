package com.ymsino.esb.manager.vo;

import java.io.Serializable;

public class ManagerModifyParam implements Serializable {

	/**
     * 管理员id
    */
    String managerId;
    /**
     * 姓名
    */
    String name;
    /**
     * 密码(明文)
    */
    String password;
    /**
     * 邮箱
    */
    String email;
    /**
     * 电话
    */
    String tel;
    /**
     * 收费单位编号
    */
    String chargingUnitId;
    /**
     * 部门编号
    */
    String departmentId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
}
