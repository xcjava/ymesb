package com.ymsino.esb.archives.model;



/**
 * PrepaidMeter entity. @author MyEclipse Persistence Tools
 */

public class PrepaidMeter  implements java.io.Serializable {


    // Fields    

     /**
      * Ԥ����ˮ����
     */
     private String pmSn;
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
     private String childPmSn;
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
      * ��ǰˮ��(��λ����)
     */
     private Long currentPrice;
     /**
      * ˮ�����ͣ�1,IC��Ԥ����ˮ��;2,���⿨Ԥ����ˮ��
     */
     private Short type;
     /**
      * ����ʱ��
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public PrepaidMeter() {
    }

	/** minimal constructor */
    public PrepaidMeter(String pmSn) {
        this.pmSn = pmSn;
    }
    
    /** full constructor */
    public PrepaidMeter(String pmSn, Long uid, String userId, String userName, String chargingUnitId, String parentUnits, String childPmSn, String nature, String purcAmount, String showWarn, String closeWarn, Long currentPrice, Short type, Long createTimestamp) {
        this.pmSn = pmSn;
        this.uid = uid;
        this.userId = userId;
        this.userName = userName;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.childPmSn = childPmSn;
        this.nature = nature;
        this.purcAmount = purcAmount;
        this.showWarn = showWarn;
        this.closeWarn = closeWarn;
        this.currentPrice = currentPrice;
        this.type = type;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * Ԥ����ˮ����
     */

    public String getPmSn() {
        return this.pmSn;
    }
    
    public void setPmSn(String pmSn) {
        this.pmSn = pmSn;
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

    public String getChildPmSn() {
        return this.childPmSn;
    }
    
    public void setChildPmSn(String childPmSn) {
        this.childPmSn = childPmSn;
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
     *      * ��ǰˮ��(��λ����)
     */

    public Long getCurrentPrice() {
        return this.currentPrice;
    }
    
    public void setCurrentPrice(Long currentPrice) {
        this.currentPrice = currentPrice;
    }
    /**       
     *      * ˮ�����ͣ�1,IC��Ԥ����ˮ��;2,���⿨Ԥ����ˮ��
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
		if ( !(other instanceof PrepaidMeter) ) return false;
		PrepaidMeter castOther = ( PrepaidMeter ) other;
		if( this.getPmSn() == null || castOther.getPmSn() == null){
			return false;
		}
		
		return ( (this.getPmSn()==castOther.getPmSn()) || ( this.getPmSn()!=null && castOther.getPmSn()!=null && this.getPmSn().equals(castOther.getPmSn()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getPmSn() == null ? random.nextInt(Integer.MAX_VALUE) : this.getPmSn().hashCode());
		return result;
	}





}