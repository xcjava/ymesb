package com.ymsino.esb.freesettle.model;



/**
 * UserWalletLog entity. @author MyEclipse Persistence Tools
 */

public class UserWalletLog  implements java.io.Serializable {


    // Fields    

     /**
      * 用户余额日志自增id
     */
     private Long id;
     /**
      * 系统备注
     */
     private String sysRemark;
     /**
      * 类型: -1:支出, 1收入
     */
     private Short logType;
     /**
      * 创建时间戳
     */
     private Long createTimestamp;
     /**
      * 使用金额(单位毫),正数为收入,负数为支出
     */
     private Long usePrice;
     /**
      * 用户ID
     */
     private Long uid;


    // Constructors

    /** default constructor */
    public UserWalletLog() {
    }

    
    /** full constructor */
    public UserWalletLog(String sysRemark, Short logType, Long createTimestamp, Long usePrice, Long uid) {
        this.sysRemark = sysRemark;
        this.logType = logType;
        this.createTimestamp = createTimestamp;
        this.usePrice = usePrice;
        this.uid = uid;
    }

   
    // Property accessors
    /**       
     *      * 用户余额日志自增id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * 系统备注
     */

    public String getSysRemark() {
        return this.sysRemark;
    }
    
    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }
    /**       
     *      * 类型: -1:支出, 1收入
     */

    public Short getLogType() {
        return this.logType;
    }
    
    public void setLogType(Short logType) {
        this.logType = logType;
    }
    /**       
     *      * 创建时间戳
     */

    public Long getCreateTimestamp() {
        return this.createTimestamp;
    }
    
    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
    /**       
     *      * 使用金额(单位毫),正数为收入,负数为支出
     */

    public Long getUsePrice() {
        return this.usePrice;
    }
    
    public void setUsePrice(Long usePrice) {
        this.usePrice = usePrice;
    }
    /**       
     *      * 用户ID
     */

    public Long getUid() {
        return this.uid;
    }
    
    public void setUid(Long uid) {
        this.uid = uid;
    }
   



	public boolean equals(Object other) {
		if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof UserWalletLog) ) return false;
		UserWalletLog castOther = ( UserWalletLog ) other;
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