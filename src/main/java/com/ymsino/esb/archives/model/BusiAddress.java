package com.ymsino.esb.archives.model;



/**
 * BusiAddress entity. @author MyEclipse Persistence Tools
 */

public class BusiAddress  implements java.io.Serializable {


    // Fields    

     /**
      * 业务地址标识，自增id
     */
     private Long id;
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
     /**
      * 创建时间
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public BusiAddress() {
    }

    
    /** full constructor */
    public BusiAddress(String province, String city, String district, String street, String village, String road, String residential, String storiedBuilding, String unit, String floor, String roomNo, String linkMan, Long uid, Long createTimestamp) {
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
        this.linkMan = linkMan;
        this.uid = uid;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * 业务地址标识，自增id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
     *      * 业务联系人
     */

    public String getLinkMan() {
        return this.linkMan;
    }
    
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
    /**       
     *      * 用户id
     */

    public Long getUid() {
        return this.uid;
    }
    
    public void setUid(Long uid) {
        this.uid = uid;
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
		if ( !(other instanceof BusiAddress) ) return false;
		BusiAddress castOther = ( BusiAddress ) other;
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