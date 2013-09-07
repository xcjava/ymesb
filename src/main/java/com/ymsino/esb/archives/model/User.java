package com.ymsino.esb.archives.model;



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     /**
      * �ͻ���ʶ������id
     */
     private Long id;
     /**
      * �ͻ����
     */
     private String userId;
     /**
      * �ͻ�����
     */
     private String name;
     /**
      * ��������
     */
     private String economicType;
     /**
      * ��ҵ����
     */
     private String industrial;
     /**
      * �շѵ�λ���
     */
     private String chargingUnitId;
     /**
      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */
     private String parentUnits;
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
      * �ʱ�
     */
     private String postcode;
     /**
      * ��ַ����
     */
     private String addressType;
     /**
      * �ͻ���ַ
     */
     private String address;
     /**
      * ֤������
     */
     private String credType;
     /**
      * ֤������
     */
     private String credName;
     /**
      * ֤������
     */
     private String credNum;
     /**
      * ֤����Чʱ��
     */
     private Long credValidTimestamp;
     /**
      * ֤��ʧЧʱ��
     */
     private Long credInvalidTimestamp;
     /**
      * ɨ������λ������
     */
     private String credFilePath;
     /**
      * ����ʱ��
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String userId, String name, String economicType, String industrial, String chargingUnitId, String parentUnits, String province, String city, String district, String street, String village, String road, String residential, String storiedBuilding, String unit, String floor, String roomNo, String postcode, String addressType, String address, String credType, String credName, String credNum, Long credValidTimestamp, Long credInvalidTimestamp, String credFilePath, Long createTimestamp) {
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
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * �ͻ���ʶ������id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * �ͻ����
     */

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**       
     *      * �ͻ�����
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * ��������
     */

    public String getEconomicType() {
        return this.economicType;
    }
    
    public void setEconomicType(String economicType) {
        this.economicType = economicType;
    }
    /**       
     *      * ��ҵ����
     */

    public String getIndustrial() {
        return this.industrial;
    }
    
    public void setIndustrial(String industrial) {
        this.industrial = industrial;
    }
    /**       
     *      * �շѵ�λ���
     */

    public String getChargingUnitId() {
        return this.chargingUnitId;
    }
    
    public void setChargingUnitId(String chargingUnitId) {
        this.chargingUnitId = chargingUnitId;
    }
    /**       
     *      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */

    public String getParentUnits() {
        return this.parentUnits;
    }
    
    public void setParentUnits(String parentUnits) {
        this.parentUnits = parentUnits;
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
     *      * �ʱ�
     */

    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    /**       
     *      * ��ַ����
     */

    public String getAddressType() {
        return this.addressType;
    }
    
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    /**       
     *      * �ͻ���ַ
     */

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    /**       
     *      * ֤������
     */

    public String getCredType() {
        return this.credType;
    }
    
    public void setCredType(String credType) {
        this.credType = credType;
    }
    /**       
     *      * ֤������
     */

    public String getCredName() {
        return this.credName;
    }
    
    public void setCredName(String credName) {
        this.credName = credName;
    }
    /**       
     *      * ֤������
     */

    public String getCredNum() {
        return this.credNum;
    }
    
    public void setCredNum(String credNum) {
        this.credNum = credNum;
    }
    /**       
     *      * ֤����Чʱ��
     */

    public Long getCredValidTimestamp() {
        return this.credValidTimestamp;
    }
    
    public void setCredValidTimestamp(Long credValidTimestamp) {
        this.credValidTimestamp = credValidTimestamp;
    }
    /**       
     *      * ֤��ʧЧʱ��
     */

    public Long getCredInvalidTimestamp() {
        return this.credInvalidTimestamp;
    }
    
    public void setCredInvalidTimestamp(Long credInvalidTimestamp) {
        this.credInvalidTimestamp = credInvalidTimestamp;
    }
    /**       
     *      * ɨ������λ������
     */

    public String getCredFilePath() {
        return this.credFilePath;
    }
    
    public void setCredFilePath(String credFilePath) {
        this.credFilePath = credFilePath;
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