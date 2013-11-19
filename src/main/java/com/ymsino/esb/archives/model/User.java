package com.ymsino.esb.archives.model;



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

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


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String userId, String name, String economicType, String industrial, String chargingUnitId, String parentUnits, String province, String city, String district, String street, String village, String road, String residential, String storiedBuilding, String unit, String floor, String roomNo, String postcode, String addressType, String address, String credType, String credName, String credNum, Long credValidTimestamp, Long credInvalidTimestamp, String credFilePath, Long warnPrice, Long createTimestamp) {
        this.userId = userId;
        this.name = name;
        this.economicType = economicType;
        this.industrial = industrial;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.village = village;
        this.road = road;
        this.residential = residential;
        this.storiedBuilding = storiedBuilding;
        this.unit = unit;
        this.floor = floor;
        this.roomNo = roomNo;
        this.postcode = postcode;
        this.addressType = addressType;
        this.address = address;
        this.credType = credType;
        this.credName = credName;
        this.credNum = credNum;
        this.credValidTimestamp = credValidTimestamp;
        this.credInvalidTimestamp = credInvalidTimestamp;
        this.credFilePath = credFilePath;
        this.warnPrice = warnPrice;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * 客户标识，自增id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * 客户编号
     */

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**       
     *      * 客户名称
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 经济类型
     */

    public String getEconomicType() {
        return this.economicType;
    }
    
    public void setEconomicType(String economicType) {
        this.economicType = economicType;
    }
    /**       
     *      * 产业分类
     */

    public String getIndustrial() {
        return this.industrial;
    }
    
    public void setIndustrial(String industrial) {
        this.industrial = industrial;
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
     *      * 省码
     */

    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    /**       
     *      * 市码
     */

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    /**       
     *      * 区县码
     */

    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    /**       
     *      * 街道码（乡镇）
     */

    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    /**       
     *      * 居委会码（村）
     */

    public String getVillage() {
        return this.village;
    }
    
    public void setVillage(String village) {
        this.village = village;
    }
    /**       
     *      * 道路码
     */

    public String getRoad() {
        return this.road;
    }
    
    public void setRoad(String road) {
        this.road = road;
    }
    /**       
     *      * 小区码
     */

    public String getResidential() {
        return this.residential;
    }
    
    public void setResidential(String residential) {
        this.residential = residential;
    }
    /**       
     *      * 楼栋码
     */

    public String getStoriedBuilding() {
        return this.storiedBuilding;
    }
    
    public void setStoriedBuilding(String storiedBuilding) {
        this.storiedBuilding = storiedBuilding;
    }
    /**       
     *      * 单元码
     */

    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    /**       
     *      * 楼层码
     */

    public String getFloor() {
        return this.floor;
    }
    
    public void setFloor(String floor) {
        this.floor = floor;
    }
    /**       
     *      * 门牌号
     */

    public String getRoomNo() {
        return this.roomNo;
    }
    
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
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
     *      * 地址类型
     */

    public String getAddressType() {
        return this.addressType;
    }
    
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    /**       
     *      * 客户地址
     */

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    /**       
     *      * 证件类型
     */

    public String getCredType() {
        return this.credType;
    }
    
    public void setCredType(String credType) {
        this.credType = credType;
    }
    /**       
     *      * 证件名称
     */

    public String getCredName() {
        return this.credName;
    }
    
    public void setCredName(String credName) {
        this.credName = credName;
    }
    /**       
     *      * 证件号码
     */

    public String getCredNum() {
        return this.credNum;
    }
    
    public void setCredNum(String credNum) {
        this.credNum = credNum;
    }
    /**       
     *      * 证件生效时间
     */

    public Long getCredValidTimestamp() {
        return this.credValidTimestamp;
    }
    
    public void setCredValidTimestamp(Long credValidTimestamp) {
        this.credValidTimestamp = credValidTimestamp;
    }
    /**       
     *      * 证件失效时间
     */

    public Long getCredInvalidTimestamp() {
        return this.credInvalidTimestamp;
    }
    
    public void setCredInvalidTimestamp(Long credInvalidTimestamp) {
        this.credInvalidTimestamp = credInvalidTimestamp;
    }
    /**       
     *      * 扫描件存放位置索引
     */

    public String getCredFilePath() {
        return this.credFilePath;
    }
    
    public void setCredFilePath(String credFilePath) {
        this.credFilePath = credFilePath;
    }
    /**       
     *      * 预警金额，单位毫
     */

    public Long getWarnPrice() {
        return this.warnPrice;
    }
    
    public void setWarnPrice(Long warnPrice) {
        this.warnPrice = warnPrice;
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
		if ( !(other instanceof User) ) return false;
		User castOther = ( User ) other;
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