package com.ymsino.esb.archives.model;



/**
 * WirelessMeter entity. @author MyEclipse Persistence Tools
 */

public class WirelessMeter  implements java.io.Serializable {


    // Fields    

     /**
      * ��������ˮ����
     */
     private String wmSn;
     /**
      * �û�id
     */
     private Long uid;
     /**
      * �ͻ����
     */
     private String userId;
     /**
      * �ͻ�����
     */
     private String userName;
     /**
      * �շѵ�λ���
     */
     private String chargingUnitId;
     /**
      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */
     private String parentUnits;
     /**
      * �ӱ��
     */
     private String childWmSn;
     /**
      * ˮ������
     */
     private String dataType;
     /**
      * ���峣��
     */
     private Integer constant;
     /**
      * ������ID
     */
     private String concHardwareId;
     /**
      * ��ʼ����
     */
     private String initialYards;
     /**
      * ����ˮ��(��λ����)
     */
     private Long suitablePrice;
     /**
      * �澯��
     */
     private String alarmVolume;
     /**
      * ����Ƶ��
     */
     private String radioFrequency;
     /**
      * ����ʱ��
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public WirelessMeter() {
    }

	/** minimal constructor */
    public WirelessMeter(String wmSn) {
        this.wmSn = wmSn;
    }
    
    /** full constructor */
    public WirelessMeter(String wmSn, Long uid, String userId, String userName, String chargingUnitId, String parentUnits, String childWmSn, String dataType, Integer constant, String concHardwareId, String initialYards, Long suitablePrice, String alarmVolume, String radioFrequency, Long createTimestamp) {
        this.wmSn = wmSn;
        this.uid = uid;
        this.userId = userId;
        this.userName = userName;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.childWmSn = childWmSn;
        this.dataType = dataType;
        this.constant = constant;
        this.concHardwareId = concHardwareId;
        this.initialYards = initialYards;
        this.suitablePrice = suitablePrice;
        this.alarmVolume = alarmVolume;
        this.radioFrequency = radioFrequency;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * ��������ˮ����
     */

    public String getWmSn() {
        return this.wmSn;
    }
    
    public void setWmSn(String wmSn) {
        this.wmSn = wmSn;
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

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
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
     *      * �ӱ��
     */

    public String getChildWmSn() {
        return this.childWmSn;
    }
    
    public void setChildWmSn(String childWmSn) {
        this.childWmSn = childWmSn;
    }
    /**       
     *      * ˮ������
     */

    public String getDataType() {
        return this.dataType;
    }
    
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    /**       
     *      * ���峣��
     */

    public Integer getConstant() {
        return this.constant;
    }
    
    public void setConstant(Integer constant) {
        this.constant = constant;
    }
    /**       
     *      * ������ID
     */

    public String getConcHardwareId() {
        return this.concHardwareId;
    }
    
    public void setConcHardwareId(String concHardwareId) {
        this.concHardwareId = concHardwareId;
    }
    /**       
     *      * ��ʼ����
     */

    public String getInitialYards() {
        return this.initialYards;
    }
    
    public void setInitialYards(String initialYards) {
        this.initialYards = initialYards;
    }
    /**       
     *      * ����ˮ��(��λ����)
     */

    public Long getSuitablePrice() {
        return this.suitablePrice;
    }
    
    public void setSuitablePrice(Long suitablePrice) {
        this.suitablePrice = suitablePrice;
    }
    /**       
     *      * �澯��
     */

    public String getAlarmVolume() {
        return this.alarmVolume;
    }
    
    public void setAlarmVolume(String alarmVolume) {
        this.alarmVolume = alarmVolume;
    }
    /**       
     *      * ����Ƶ��
     */

    public String getRadioFrequency() {
        return this.radioFrequency;
    }
    
    public void setRadioFrequency(String radioFrequency) {
        this.radioFrequency = radioFrequency;
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
		if ( !(other instanceof WirelessMeter) ) return false;
		WirelessMeter castOther = ( WirelessMeter ) other;
		if( this.getWmSn() == null || castOther.getWmSn() == null){
			return false;
		}
		
		return ( (this.getWmSn()==castOther.getWmSn()) || ( this.getWmSn()!=null && castOther.getWmSn()!=null && this.getWmSn().equals(castOther.getWmSn()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getWmSn() == null ? random.nextInt(Integer.MAX_VALUE) : this.getWmSn().hashCode());
		return result;
	}





}