package com.ymsino.esb.archives.model;



/**
 * Bank entity. @author MyEclipse Persistence Tools
 */

public class Bank  implements java.io.Serializable {


    // Fields    

     /**
      * �����ʺű�ʶ������id
     */
     private Long id;
     /**
      * �������ȼ�
     */
     private String payPriority;
     /**
      * ���д���
     */
     private String bankCode;
     /**
      * �����ʺ�
     */
     private String bankAccount;
     /**
      * �˻�����
     */
     private String accountName;
     /**
      * ����Э���ʶ
     */
     private String collAgreementId;
     /**
      * �˻�����
     */
     private String accountType;
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
    public Bank() {
    }

    
    /** full constructor */
    public Bank(String payPriority, String bankCode, String bankAccount, String accountName, String collAgreementId, String accountType, Long uid, String chargingUnitId, String parentUnits, Long createTimestamp) {
        this.payPriority = payPriority;
        this.bankCode = bankCode;
        this.bankAccount = bankAccount;
        this.accountName = accountName;
        this.collAgreementId = collAgreementId;
        this.accountType = accountType;
        this.uid = uid;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * �����ʺű�ʶ������id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * �������ȼ�
     */

    public String getPayPriority() {
        return this.payPriority;
    }
    
    public void setPayPriority(String payPriority) {
        this.payPriority = payPriority;
    }
    /**       
     *      * ���д���
     */

    public String getBankCode() {
        return this.bankCode;
    }
    
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    /**       
     *      * �����ʺ�
     */

    public String getBankAccount() {
        return this.bankAccount;
    }
    
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    /**       
     *      * �˻�����
     */

    public String getAccountName() {
        return this.accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    /**       
     *      * ����Э���ʶ
     */

    public String getCollAgreementId() {
        return this.collAgreementId;
    }
    
    public void setCollAgreementId(String collAgreementId) {
        this.collAgreementId = collAgreementId;
    }
    /**       
     *      * �˻�����
     */

    public String getAccountType() {
        return this.accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
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
		if ( !(other instanceof Bank) ) return false;
		Bank castOther = ( Bank ) other;
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