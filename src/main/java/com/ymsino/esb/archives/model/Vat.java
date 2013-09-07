package com.ymsino.esb.archives.model;



/**
 * Vat entity. @author MyEclipse Persistence Tools
 */

public class Vat  implements java.io.Serializable {


    // Fields    

     /**
      * ��ֵ˰��ʶ������id
     */
     private Long id;
     /**
      * ��ֵ˰��
     */
     private String vatName;
     /**
      * ��ֵ˰��
     */
     private String vatNum;
     /**
      * ��ֵ˰�ʺ�
     */
     private String vatAccount;
     /**
      * ��ֵ˰����
     */
     private String vatBank;
     /**
      * �绰����
     */
     private String tel;
     /**
      * ע���ַ
     */
     private String regAddress;
     /**
      * �û�id
     */
     private Long uid;
     /**
      * �շѵ�λ���
     */
     private String chargingUnitId;
     /**
      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */
     private String parentUnits;
     /**
      * ����ʱ��
     */
     private Long createTimestamp;


    // Constructors

    /** default constructor */
    public Vat() {
    }

    
    /** full constructor */
    public Vat(String vatName, String vatNum, String vatAccount, String vatBank, String tel, String regAddress, Long uid, String chargingUnitId, String parentUnits, Long createTimestamp) {
        this.vatName = vatName;
        this.vatNum = vatNum;
        this.vatAccount = vatAccount;
        this.vatBank = vatBank;
        this.tel = tel;
        this.regAddress = regAddress;
        this.uid = uid;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * ��ֵ˰��ʶ������id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * ��ֵ˰��
     */

    public String getVatName() {
        return this.vatName;
    }
    
    public void setVatName(String vatName) {
        this.vatName = vatName;
    }
    /**       
     *      * ��ֵ˰��
     */

    public String getVatNum() {
        return this.vatNum;
    }
    
    public void setVatNum(String vatNum) {
        this.vatNum = vatNum;
    }
    /**       
     *      * ��ֵ˰�ʺ�
     */

    public String getVatAccount() {
        return this.vatAccount;
    }
    
    public void setVatAccount(String vatAccount) {
        this.vatAccount = vatAccount;
    }
    /**       
     *      * ��ֵ˰����
     */

    public String getVatBank() {
        return this.vatBank;
    }
    
    public void setVatBank(String vatBank) {
        this.vatBank = vatBank;
    }
    /**       
     *      * �绰����
     */

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**       
     *      * ע���ַ
     */

    public String getRegAddress() {
        return this.regAddress;
    }
    
    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
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
		if ( !(other instanceof Vat) ) return false;
		Vat castOther = ( Vat ) other;
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