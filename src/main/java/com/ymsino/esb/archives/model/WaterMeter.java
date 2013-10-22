package com.ymsino.esb.archives.model;



/**
 * WaterMeter entity. @author MyEclipse Persistence Tools
 */

public class WaterMeter  implements java.io.Serializable {


    // Fields    

     /**
      * ˮ����
     */
     private String hardwareId;
     /**
      * ��ˮ�û����
     */
     private String waterCustomerId;
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
      * ��ˮ����
     */
     private String nature;
     /**
      * �޹���
     */
     private String purcAmount;
     /**
      * ��ʾ�澯
     */
     private String showWarn;
     /**
      * �ط��澯
     */
     private String closeWarn;
     /**
      * �ӱ��
     */
     private String childHardwareId;
     /**
      * �������
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
      * ��Ӧ�����������
     */
     private Integer wmSn;
     /**
      * ��ʼ����
     */
     private String initialYards;
     /**
      * ����ˮ�ۡ���ǰˮ��(��λ����)
     */
     private Long price;
     /**
      * �澯��
     */
     private String alarmVolume;
     /**
      * ����Ƶ��
     */
     private String radioFrequency;
     /**
      * ˮ�����ͣ�1,IC��Ԥ����ˮ��;2,���⿨Ԥ����ˮ��;3,��������ˮ��
     */
     private Short type;
     /**
      * ����ʱ��
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public WaterMeter() {
    }

	/** minimal constructor */
    public WaterMeter(String hardwareId) {
        this.hardwareId = hardwareId;
    }
    
    /** full constructor */
    public WaterMeter(String hardwareId, String waterCustomerId, Long uid, String userId, String userName, String chargingUnitId, String parentUnits, String nature, String purcAmount, String showWarn, String closeWarn, String childHardwareId, String dataType, Integer constant, String concHardwareId, Integer wmSn, String initialYards, Long price, String alarmVolume, String radioFrequency, Short type, Long createTimestamp) {
        this.hardwareId = hardwareId;
        this.waterCustomerId = waterCustomerId;
        this.uid = uid;
        this.userId = userId;
        this.userName = userName;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.nature = nature;
        this.purcAmount = purcAmount;
        this.showWarn = showWarn;
        this.closeWarn = closeWarn;
        this.childHardwareId = childHardwareId;
        this.dataType = dataType;
        this.constant = constant;
        this.concHardwareId = concHardwareId;
        this.wmSn = wmSn;
        this.initialYards = initialYards;
        this.price = price;
        this.alarmVolume = alarmVolume;
        this.radioFrequency = radioFrequency;
        this.type = type;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * ˮ����
     */

    public String getHardwareId() {
        return this.hardwareId;
    }
    
    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }
    /**       
     *      * ��ˮ�û����
     */

    public String getWaterCustomerId() {
        return this.waterCustomerId;
    }
    
    public void setWaterCustomerId(String waterCustomerId) {
        this.waterCustomerId = waterCustomerId;
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
     *      * ��ˮ����
     */

    public String getNature() {
        return this.nature;
    }
    
    public void setNature(String nature) {
        this.nature = nature;
    }
    /**       
     *      * �޹���
     */

    public String getPurcAmount() {
        return this.purcAmount;
    }
    
    public void setPurcAmount(String purcAmount) {
        this.purcAmount = purcAmount;
    }
    /**       
     *      * ��ʾ�澯
     */

    public String getShowWarn() {
        return this.showWarn;
    }
    
    public void setShowWarn(String showWarn) {
        this.showWarn = showWarn;
    }
    /**       
     *      * �ط��澯
     */

    public String getCloseWarn() {
        return this.closeWarn;
    }
    
    public void setCloseWarn(String closeWarn) {
        this.closeWarn = closeWarn;
    }
    /**       
     *      * �ӱ��
     */

    public String getChildHardwareId() {
        return this.childHardwareId;
    }
    
    public void setChildHardwareId(String childHardwareId) {
        this.childHardwareId = childHardwareId;
    }
    /**       
     *      * �������
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
     *      * ��Ӧ�����������
     */

    public Integer getWmSn() {
        return this.wmSn;
    }
    
    public void setWmSn(Integer wmSn) {
        this.wmSn = wmSn;
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
     *      * ����ˮ�ۡ���ǰˮ��(��λ����)
     */

    public Long getPrice() {
        return this.price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
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
     *      * ˮ�����ͣ�1,IC��Ԥ����ˮ��;2,���⿨Ԥ����ˮ��;3,��������ˮ��
     */

    public Short getType() {
        return this.type;
    }
    
    public void setType(Short type) {
        this.type = type;
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
		if ( !(other instanceof WaterMeter) ) return false;
		WaterMeter castOther = ( WaterMeter ) other;
		if( this.getHardwareId() == null || castOther.getHardwareId() == null){
			return false;
		}
		
		return ( (this.getHardwareId()==castOther.getHardwareId()) || ( this.getHardwareId()!=null && castOther.getHardwareId()!=null && this.getHardwareId().equals(castOther.getHardwareId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getHardwareId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getHardwareId().hashCode());
		return result;
	}





}