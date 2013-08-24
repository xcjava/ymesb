package com.ymsino.esb.manager.model;



/**
 * ChargingUnit entity. @author MyEclipse Persistence Tools
 */

public class ChargingUnit  implements java.io.Serializable {


    // Fields    

     /**
      * �շѵ�λ���
     */
     private String unitId;
     /**
      * �շѵ�λ����
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
      * ������ID
     */
     private String createrId;
     /**
      * �ϼ��շѵ�λ���
     */
     private String parentUnitId;
     /**
      * ��ע
     */
     private String remark;
     /**
      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */
     private String parentUnits;


    // Constructors

    /** default constructor */
    public ChargingUnit() {
    }

	/** minimal constructor */
    public ChargingUnit(String unitId) {
        this.unitId = unitId;
    }
    
    /** full constructor */
    public ChargingUnit(String unitId, String name, String linkMan, String linkTel, String linkAddr, Short status, Long createTimestamp, String createrId, String parentUnitId, String remark, String parentUnits) {
        this.unitId = unitId;
        this.name = name;
        this.linkMan = linkMan;
        this.linkTel = linkTel;
        this.linkAddr = linkAddr;
        this.status = status;
        this.createTimestamp = createTimestamp;
        this.createrId = createrId;
        this.parentUnitId = parentUnitId;
        this.remark = remark;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * �շѵ�λ���
     */

    public String getUnitId() {
        return this.unitId;
    }
    
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
    /**       
     *      * �շѵ�λ����
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
     *      * ������ID
     */

    public String getCreaterId() {
        return this.createrId;
    }
    
    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }
    /**       
     *      * �ϼ��շѵ�λ���
     */

    public String getParentUnitId() {
        return this.parentUnitId;
    }
    
    public void setParentUnitId(String parentUnitId) {
        this.parentUnitId = parentUnitId;
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
		if ( !(other instanceof ChargingUnit) ) return false;
		ChargingUnit castOther = ( ChargingUnit ) other;
		if( this.getUnitId() == null || castOther.getUnitId() == null){
			return false;
		}
		
		return ( (this.getUnitId()==castOther.getUnitId()) || ( this.getUnitId()!=null && castOther.getUnitId()!=null && this.getUnitId().equals(castOther.getUnitId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getUnitId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getUnitId().hashCode());
		return result;
	}





}