package com.ymsino.esb.manager.model;



/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager  implements java.io.Serializable {


    // Fields    

     /**
      * ����Աid
     */
     private String managerId;
     /**
      * ����
     */
     private String name;
     /**
      * ����(MD5����)
     */
     private String password;
     /**
      * ����
     */
     private String email;
     /**
      * �绰
     */
     private String tel;
     /**
      * ״̬: -1ͣ��, 0�½�, 1����
     */
     private Short status;
     /**
      * ����ʱ��
     */
     private Long createTimestamp;
     /**
      * �շѵ�λ���
     */
     private String chargingUnitId;
     /**
      * ���ű��
     */
     private String departmentId;
     /**
      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */
     private String parentUnits;


    // Constructors

    /** default constructor */
    public Manager() {
    }

	/** minimal constructor */
    public Manager(String managerId) {
        this.managerId = managerId;
    }
    
    /** full constructor */
    public Manager(String managerId, String name, String password, String email, String tel, Short status, Long createTimestamp, String chargingUnitId, String departmentId, String parentUnits) {
        this.managerId = managerId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.status = status;
        this.createTimestamp = createTimestamp;
        this.chargingUnitId = chargingUnitId;
        this.departmentId = departmentId;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * ����Աid
     */

    public String getManagerId() {
        return this.managerId;
    }
    
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    /**       
     *      * ����
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * ����(MD5����)
     */

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    /**       
     *      * ����
     */

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    /**       
     *      * �绰
     */

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**       
     *      * ״̬: -1ͣ��, 0�½�, 1����
     */

    public Short getStatus() {
        return this.status;
    }
    
    public void setStatus(Short status) {
        this.status = status;
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
     *      * ���ű��
     */

    public String getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
   



	public boolean equals(Object other) {
		if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof Manager) ) return false;
		Manager castOther = ( Manager ) other;
		if( this.getManagerId() == null || castOther.getManagerId() == null){
			return false;
		}
		
		return ( (this.getManagerId()==castOther.getManagerId()) || ( this.getManagerId()!=null && castOther.getManagerId()!=null && this.getManagerId().equals(castOther.getManagerId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getManagerId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getManagerId().hashCode());
		return result;
	}





}