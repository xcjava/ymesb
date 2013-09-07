package com.ymsino.esb.archives.model;



/**
 * Bank entity. @author MyEclipse Persistence Tools
 */

public class Bank  implements java.io.Serializable {


    // Fields    

     /**
      * 银行帐号标识，自增id
     */
     private Long id;
     /**
      * 付费优先级
     */
     private String payPriority;
     /**
      * 银行代码
     */
     private String bankCode;
     /**
      * 银行帐号
     */
     private String bankAccount;
     /**
      * 账户名称
     */
     private String accountName;
     /**
      * 托收协议标识
     */
     private String collAgreementId;
     /**
      * 账户类型
     */
     private String accountType;
     /**
      * 用户id
     */
     private Long uid;
     /**
      * 收费单位编号
     */
     private String chargingUnitId;
     /**
      * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
     */
     private String parentUnits;
     /**
      * 创建时间
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
     *      * 银行帐号标识，自增id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * 付费优先级
     */

    public String getPayPriority() {
        return this.payPriority;
    }
    
    public void setPayPriority(String payPriority) {
        this.payPriority = payPriority;
    }
    /**       
     *      * 银行代码
     */

    public String getBankCode() {
        return this.bankCode;
    }
    
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    /**       
     *      * 银行帐号
     */

    public String getBankAccount() {
        return this.bankAccount;
    }
    
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    /**       
     *      * 账户名称
     */

    public String getAccountName() {
        return this.accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    /**       
     *      * 托收协议标识
     */

    public String getCollAgreementId() {
        return this.collAgreementId;
    }
    
    public void setCollAgreementId(String collAgreementId) {
        this.collAgreementId = collAgreementId;
    }
    /**       
     *      * 账户类型
     */

    public String getAccountType() {
        return this.accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
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