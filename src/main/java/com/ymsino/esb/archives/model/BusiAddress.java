package com.ymsino.esb.archives.model;



/**
 * BusiAddress entity. @author MyEclipse Persistence Tools
 */

public class BusiAddress  implements java.io.Serializable {


    // Fields    

     /**
      * ҵ���ַ��ʶ������id
     */
     private Long id;
     /**
      * ʡ��
     */
     private String province;
     /**
      * ����
     */
     private String city;
     /**
      * ������
     */
     private String district;
     /**
      * �ֵ��루����
     */
     private String street;
     /**
      * ��ί���루�壩
     */
     private String village;
     /**
      * ��·��
     */
     private String road;
     /**
      * С����
     */
     private String residential;
     /**
      * ¥����
     */
     private String storiedBuilding;
     /**
      * ��Ԫ��
     */
     private String unit;
     /**
      * ¥����
     */
     private String floor;
     /**
      * ���ƺ�
     */
     private String roomNo;
     /**
      * ҵ����ϵ��
     */
     private String linkMan;
     /**
      * �û�id
     */
     private Long uid;
     /**
      * ����ʱ��
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
     *      * ҵ���ַ��ʶ������id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * ʡ��
     */

    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    /**       
     *      * ����
     */

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    /**       
     *      * ������
     */

    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    /**       
     *      * �ֵ��루����
     */

    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    /**       
     *      * ��ί���루�壩
     */

    public String getVillage() {
        return this.village;
    }
    
    public void setVillage(String village) {
        this.village = village;
    }
    /**       
     *      * ��·��
     */

    public String getRoad() {
        return this.road;
    }
    
    public void setRoad(String road) {
        this.road = road;
    }
    /**       
     *      * С����
     */

    public String getResidential() {
        return this.residential;
    }
    
    public void setResidential(String residential) {
        this.residential = residential;
    }
    /**       
     *      * ¥����
     */

    public String getStoriedBuilding() {
        return this.storiedBuilding;
    }
    
    public void setStoriedBuilding(String storiedBuilding) {
        this.storiedBuilding = storiedBuilding;
    }
    /**       
     *      * ��Ԫ��
     */

    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    /**       
     *      * ¥����
     */

    public String getFloor() {
        return this.floor;
    }
    
    public void setFloor(String floor) {
        this.floor = floor;
    }
    /**       
     *      * ���ƺ�
     */

    public String getRoomNo() {
        return this.roomNo;
    }
    
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
    /**       
     *      * ҵ����ϵ��
     */

    public String getLinkMan() {
        return this.linkMan;
    }
    
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
    /**       
     *      * �û�id
     */

    public Long getUid() {
        return this.uid;
    }
    
    public void setUid(Long uid) {
        this.uid = uid;
    }
    /**       
     *      * ����ʱ��
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