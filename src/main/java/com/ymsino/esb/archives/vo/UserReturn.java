package com.ymsino.esb.archives.vo;

import java.io.Serializable;

public class UserReturn implements Serializable {

	/**
     * 客户标识，自增id
    */
    private Long id;
    /**
     * 客户编号
    */
    private String userId;
    /**
     * 客户名称
    */
    private String name;
    /**
     * 经济类型
    */
    private String economicType;
    /**
     * 产业分类
    */
    private String industrial;
    /**
     * 收费单位编号
    */
    private String chargingUnitId;
    /**
     * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
    */
    private String parentUnits;
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
     * 邮编
    */
    private String postcode;
    /**
     * 地址类型
    */
    private String addressType;
    /**
     * 客户地址
    */
    private String address;
    /**
     * 证件类型
    */
    private String credType;
    /**
     * 证件名称
    */
    private String credName;
    /**
     * 证件号码
    */
    private String credNum;
    /**
     * 证件生效时间
    */
    private Long credValidTimestamp;
    /**
     * 证件失效时间
    */
    private Long credInvalidTimestamp;
    /**
     * 扫描件存放位置索引
    */
    private String credFilePath;
    /**
     * 预警金额，单位毫
    */
    private Long warnPrice;
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
	public String getEconomicType() {
		return economicType;
	}
	public void setEconomicType(String economicType) {
		this.economicType = economicType;
	}
	public String getIndustrial() {
		return industrial;
	}
	public void setIndustrial(String industrial) {
		this.industrial = industrial;
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
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCredType() {
		return credType;
	}
	public void setCredType(String credType) {
		this.credType = credType;
	}
	public String getCredName() {
		return credName;
	}
	public void setCredName(String credName) {
		this.credName = credName;
	}
	public String getCredNum() {
		return credNum;
	}
	public void setCredNum(String credNum) {
		this.credNum = credNum;
	}
	public Long getCredValidTimestamp() {
		return credValidTimestamp;
	}
	public void setCredValidTimestamp(Long credValidTimestamp) {
		this.credValidTimestamp = credValidTimestamp;
	}
	public Long getCredInvalidTimestamp() {
		return credInvalidTimestamp;
	}
	public void setCredInvalidTimestamp(Long credInvalidTimestamp) {
		this.credInvalidTimestamp = credInvalidTimestamp;
	}
	public String getCredFilePath() {
		return credFilePath;
	}
	public void setCredFilePath(String credFilePath) {
		this.credFilePath = credFilePath;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public Long getWarnPrice() {
		return warnPrice;
	}
	public void setWarnPrice(Long warnPrice) {
		this.warnPrice = warnPrice;
	}
}
