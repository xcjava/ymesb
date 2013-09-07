package com.ymsino.esb.archives.vo;

import java.io.Serializable;

public class BusiAddressSaveParam implements Serializable {

	/**
     * 省码
    */
    private String province;
    /**
     * 市码
    */
    private String city;
    /**
     * 区县码
    */
    private String district;
    /**
     * 街道码（乡镇）
    */
    private String street;
    /**
     * 居委会码（村）
    */
    private String village;
    /**
     * 道路码
    */
    private String road;
    /**
     * 小区码
    */
    private String residential;
    /**
     * 楼栋码
    */
    private String storiedBuilding;
    /**
     * 单元码
    */
    private String unit;
    /**
     * 楼层码
    */
    private String floor;
    /**
     * 门牌号
    */
    private String roomNo;
    /**
     * 业务联系人
    */
    private String linkMan;
    /**
     * 用户id
    */
    private Long uid;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getResidential() {
		return residential;
	}
	public void setResidential(String residential) {
		this.residential = residential;
	}
	public String getStoriedBuilding() {
		return storiedBuilding;
	}
	public void setStoriedBuilding(String storiedBuilding) {
		this.storiedBuilding = storiedBuilding;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
}
