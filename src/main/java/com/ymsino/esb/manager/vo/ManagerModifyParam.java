package com.ymsino.esb.manager.vo;

import java.io.Serializable;

public class ManagerModifyParam implements Serializable {

	/**
     * 管理员id
    */
    String userId;
    /**
     * 姓名
    */
    String name;
    /**
     * 部门
    */
    String dept;
    /**
     * 密码(明文)
    */
    String password;
    /**
     * 职位
    */
    String position;
    /**
     * 邮箱
    */
    String email;
    /**
     * 电话
    */
    String tel;
    /**
     * 修改人ID
    */
    String modifierId;
    /**
     * 角色id，多个用"||"包住，如|123||456|
    */
    String roles;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
	public String getModifierId() {
		return modifierId;
	}
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
}
