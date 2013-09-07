package com.ymsino.esb.archives.model;



/**
 * Vat entity. @author MyEclipse Persistence Tools
 */

public class Vat  implements java.io.Serializable {


    // Fields    

     /**
      * 增值税标识，自增id
     */
     private Long id;
     /**
      * 增值税名
     */
     private String vatName;
     /**
      * 增值税号
     */
     private String vatNum;
     /**
      * 增值税帐号
     */
     private String vatAccount;
     /**
      * 增值税银行
     */
     private String vatBank;
     /**
      * 电话号码
     */
     private String tel;
     /**
      * 注册地址
     */
     private String regAddress;
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
     *      * 增值税标识，自增id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * 增值税名
     */

    public String getVatName() {
        return this.vatName;
    }
    
    public void setVatName(String vatName) {
        this.vatName = vatName;
    }
    /**       
     *      * 增值税号
     */

    public String getVatNum() {
        return this.vatNum;
    }
    
    public void setVatNum(String vatNum) {
        this.vatNum = vatNum;
    }
    /**       
     *      * 增值税帐号
     */

    public String getVatAccount() {
        return this.vatAccount;
    }
    
    public void setVatAccount(String vatAccount) {
        this.vatAccount = vatAccount;
    }
    /**       
     *      * 增值税银行
     */

    public String getVatBank() {
        return this.vatBank;
    }
    
    public void setVatBank(String vatBank) {
        this.vatBank = vatBank;
    }
    /**       
     *      * 电话号码
     */

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**       
     *      * 注册地址
     */

    public String getRegAddress() {
        return this.regAddress;
    }
    
    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
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