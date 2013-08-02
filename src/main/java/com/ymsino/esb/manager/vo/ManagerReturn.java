package com.ymsino.esb.manager.vo;

import java.io.Serializable;

public class ManagerReturn implements Serializable {

	/**
     * 管理员id
    */
    String userId;
    /**
     * 登录ip
    */
    String loginIp;
    /**
     * 最后登录时间
    */
    Long lastLoginTimestamp;
    /**
     * 姓名
    */
    String name;
    /**
     * 部门
    */
    String dept;
    /**
     * 密码(MD5加密)
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
     * 状态: -2冻结, -1不通过审核, 0新建, 1审核
    */
    Short status;
    /**
     * 创建时间
    */
    Long createTimestamp;
    /**
     * 修改时间
    */
    Long modifiyTimestamp;
    /**
     * 审核时间
    */
    Long checkTimestamp;
    /**
     * 创建人ID
    */
    String createrId;
    /**
     * 修改人ID
    */
    String modifierId;
    /**
     * 审核人ID
    */
    String checkerId;
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
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Long getLastLoginTimestamp() {
		return lastLoginTimestamp;
	}
	public void setLastLoginTimestamp(Long lastLoginTimestamp) {
		this.lastLoginTimestamp = lastLoginTimestamp;
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
	public Long getModifiyTimestamp() {
		return modifiyTimestamp;
	}
	public void setModifiyTimestamp(Long modifiyTimestamp) {
		this.modifiyTimestamp = modifiyTimestamp;
	}
	public Long getCheckTimestamp() {
		return checkTimestamp;
	}
	public void setCheckTimestamp(Long checkTimestamp) {
		this.checkTimestamp = checkTimestamp;
	}
	public String getCreaterId() {
		return createrId;
	}
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	public String getModifierId() {
		return modifierId;
	}
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}
	public String getCheckerId() {
		return checkerId;
	}
	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
}
