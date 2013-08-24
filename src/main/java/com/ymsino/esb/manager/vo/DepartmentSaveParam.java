package com.ymsino.esb.manager.vo;

import java.io.Serializable;

public class DepartmentSaveParam implements Serializable {

	/**
     * 部门编号
    */
    String deptId;
    /**
     * 部门名称
    */
    String name;
    /**
     * 联系人
    */
    String linkMan;
    /**
     * 联系电话
    */
    String linkTel;
    /**
     * 联系地址
    */
    String linkAddr;
    /**
     * 收费单位编号
    */
    String chargingUnitId;
    /**
     * 上级部门编号
    */
    String parentDeptId;
    /**
     * 备注
    */
    String remark;
    /**
     * 权限json,格式为{"模块代号":""操作代号","模块代号":""操作代号,操作代号"},如,{"001":"001,002","002":"003"}
    */
    String popedomJson;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getLinkAddr() {
		return linkAddr;
	}
	public void setLinkAddr(String linkAddr) {
		this.linkAddr = linkAddr;
	}
	public String getChargingUnitId() {
		return chargingUnitId;
	}
	public void setChargingUnitId(String chargingUnitId) {
		this.chargingUnitId = chargingUnitId;
	}
	public String getParentDeptId() {
		return parentDeptId;
	}
	public void setParentDeptId(String parentDeptId) {
		this.parentDeptId = parentDeptId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPopedomJson() {
		return popedomJson;
	}
	public void setPopedomJson(String popedomJson) {
		this.popedomJson = popedomJson;
	}
}
