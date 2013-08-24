package com.ymsino.esb.manager.model;



/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department  implements java.io.Serializable {


    // Fields    

     /**
      * ���ű��
     */
     private String deptId;
     /**
      * ��������
     */
     private String name;
     /**
      * ��ϵ��
     */
     private String linkMan;
     /**
      * ��ϵ�绰
     */
     private String linkTel;
     /**
      * ��ϵ��ַ
     */
     private String linkAddr;
     /**
      * ״̬: 1����, -1ɾ��
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
      * �ϼ����ű��
     */
     private String parentDeptId;
     /**
      * ��ע
     */
     private String remark;
     /**
      * Ȩ��json,��ʽΪ{"ģ�����":""��������","ģ�����":""��������,��������"},��,{"001":"001,002","002":"003"}
     */
     private String popedomJson;
     /**
      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */
     private String parentUnits;


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(String deptId) {
        this.deptId = deptId;
    }
    
    /** full constructor */
    public Department(String deptId, String name, String linkMan, String linkTel, String linkAddr, Short status, Long createTimestamp, String chargingUnitId, String parentDeptId, String remark, String popedomJson, String parentUnits) {
        this.deptId = deptId;
        this.name = name;
        this.linkMan = linkMan;
        this.linkTel = linkTel;
        this.linkAddr = linkAddr;
        this.status = status;
        this.createTimestamp = createTimestamp;
        this.chargingUnitId = chargingUnitId;
        this.parentDeptId = parentDeptId;
        this.remark = remark;
        this.popedomJson = popedomJson;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * ���ű��
     */

    public String getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    /**       
     *      * ��������
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * ��ϵ��
     */

    public String getLinkMan() {
        return this.linkMan;
    }
    
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
    /**       
     *      * ��ϵ�绰
     */

    public String getLinkTel() {
        return this.linkTel;
    }
    
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }
    /**       
     *      * ��ϵ��ַ
     */

    public String getLinkAddr() {
        return this.linkAddr;
    }
    
    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr;
    }
    /**       
     *      * ״̬: 1����, -1ɾ��
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
     *      * �ϼ����ű��
     */

    public String getParentDeptId() {
        return this.parentDeptId;
    }
    
    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
    }
    /**       
     *      * ��ע
     */

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**       
     *      * Ȩ��json,��ʽΪ{"ģ�����":""��������","ģ�����":""��������,��������"},��,{"001":"001,002","002":"003"}
     */

    public String getPopedomJson() {
        return this.popedomJson;
    }
    
    public void setPopedomJson(String popedomJson) {
        this.popedomJson = popedomJson;
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
		if ( !(other instanceof Department) ) return false;
		Department castOther = ( Department ) other;
		if( this.getDeptId() == null || castOther.getDeptId() == null){
			return false;
		}
		
		return ( (this.getDeptId()==castOther.getDeptId()) || ( this.getDeptId()!=null && castOther.getDeptId()!=null && this.getDeptId().equals(castOther.getDeptId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getDeptId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getDeptId().hashCode());
		return result;
	}





}