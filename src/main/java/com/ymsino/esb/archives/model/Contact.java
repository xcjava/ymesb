package com.ymsino.esb.archives.model;



/**
 * Contact entity. @author MyEclipse Persistence Tools
 */

public class Contact  implements java.io.Serializable {


    // Fields    

     /**
      * ��ϵ��Ϣ��ʶ������id
     */
     private Long id;
     /**
      * ��ϵ����
     */
     private String type;
     /**
      * ��ϵ��Ϣ��Դ
     */
     private String source;
     /**
      * ��ϵ���ȼ�
     */
     private String priority;
     /**
      * ��ϵ��
     */
     private String linkMan;
     /**
      * �Ա�
     */
     private String sex;
     /**
      * ���ű��
     */
     private String departmentId;
     /**
      * ְ��/ְ��
     */
     private String position;
     /**
      * �칫�绰
     */
     private String officePhone;
     /**
      * �ƶ��绰
     */
     private String mobile;
     /**
      * �������
     */
     private String fax;
     /**
      * �ʱ�
     */
     private String postcode;
     /**
      * ��������
     */
     private String email;
     /**
      * ��ϵ��ע
     */
     private String remark;
     /**
      * ��ϵ��ַ
     */
     private String address;
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
    public Contact() {
    }

    
    /** full constructor */
    public Contact(String type, String source, String priority, String linkMan, String sex, String departmentId, String position, String officePhone, String mobile, String fax, String postcode, String email, String remark, String address, Long uid, String chargingUnitId, String parentUnits, Long createTimestamp) {
        this.type = type;
        this.source = source;
        this.priority = priority;
        this.linkMan = linkMan;
        this.sex = sex;
        this.departmentId = departmentId;
        this.position = position;
        this.officePhone = officePhone;
        this.mobile = mobile;
        this.fax = fax;
        this.postcode = postcode;
        this.email = email;
        this.remark = remark;
        this.address = address;
        this.uid = uid;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * ��ϵ��Ϣ��ʶ������id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * ��ϵ����
     */

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    /**       
     *      * ��ϵ��Ϣ��Դ
     */

    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    /**       
     *      * ��ϵ���ȼ�
     */

    public String getPriority() {
        return this.priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
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
     *      * �Ա�
     */

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
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
     *      * ְ��/ְ��
     */

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    /**       
     *      * �칫�绰
     */

    public String getOfficePhone() {
        return this.officePhone;
    }
    
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }
    /**       
     *      * �ƶ��绰
     */

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**       
     *      * �������
     */

    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**       
     *      * �ʱ�
     */

    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    /**       
     *      * ��������
     */

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    /**       
     *      * ��ϵ��ע
     */

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**       
     *      * ��ϵ��ַ
     */

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
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
		if ( !(other instanceof Contact) ) return false;
		Contact castOther = ( Contact ) other;
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