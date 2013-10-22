package com.ymsino.esb.freesettle.model;



/**
 * UserWallet entity. @author MyEclipse Persistence Tools
 */

public class UserWallet  implements java.io.Serializable {


    // Fields    

     /**
      * 用户uid的MD5
     */
     private String signId;
     /**
      * 账户上一次变动时间戳
     */
     private Long modifyTimestamp;
     /**
      * 账户余额,单位为分
     */
     private Long cashAmount;
     /**
      * 账户签名
     */
     private String healthSign;
     /**
      * 健康状态:1正常;-1警告
     */
     private Short healthStatus;


    // Constructors

    /** default constructor */
    public UserWallet() {
    }

	/** minimal constructor */
    public UserWallet(String signId) {
        this.signId = signId;
    }
    
    /** full constructor */
    public UserWallet(String signId, Long modifyTimestamp, Long cashAmount, String healthSign, Short healthStatus) {
        this.signId = signId;
        this.modifyTimestamp = modifyTimestamp;
        this.cashAmount = cashAmount;
        this.healthSign = healthSign;
        this.healthStatus = healthStatus;
    }

   
    // Property accessors
    /**       
     *      * 用户uid的MD5
     */

    public String getSignId() {
        return this.signId;
    }
    
    public void setSignId(String signId) {
        this.signId = signId;
    }
    /**       
     *      * 账户上一次变动时间戳
     */

    public Long getModifyTimestamp() {
        return this.modifyTimestamp;
    }
    
    public void setModifyTimestamp(Long modifyTimestamp) {
        this.modifyTimestamp = modifyTimestamp;
    }
    /**       
     *      * 账户余额,单位为分
     */

    public Long getCashAmount() {
        return this.cashAmount;
    }
    
    public void setCashAmount(Long cashAmount) {
        this.cashAmount = cashAmount;
    }
    /**       
     *      * 账户签名
     */

    public String getHealthSign() {
        return this.healthSign;
    }
    
    public void setHealthSign(String healthSign) {
        this.healthSign = healthSign;
    }
    /**       
     *      * 健康状态:1正常;-1警告
     */

    public Short getHealthStatus() {
        return this.healthStatus;
    }
    
    public void setHealthStatus(Short healthStatus) {
        this.healthStatus = healthStatus;
    }
   



	public boolean equals(Object other) {
		if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof UserWallet) ) return false;
		UserWallet castOther = ( UserWallet ) other;
		if( this.getSignId() == null || castOther.getSignId() == null){
			return false;
		}
		
		return ( (this.getSignId()==castOther.getSignId()) || ( this.getSignId()!=null && castOther.getSignId()!=null && this.getSignId().equals(castOther.getSignId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getSignId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getSignId().hashCode());
		return result;
	}





}