package com.ymsino.esb.manager.vo;

import java.io.Serializable;

public class ChargingUnitSaveParam implements Serializable {

	/**
     * 收费单位编号
    */
    String unitId;
    /**
     * 收费单位名称
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
     * 创建人ID
    */
    String createrId;
    /**
     * 上级收费单位编号
    */
    String parentUnitId;
    /**
     * 备注
    */
    String remark;
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
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
	public String getCreaterId() {
		return createrId;
	}
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	public String getParentUnitId() {
		return parentUnitId;
	}
	public void setParentUnitId(String parentUnitId) {
		this.parentUnitId = parentUnitId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
