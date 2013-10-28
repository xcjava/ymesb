package com.ymsino.esb.data.model;



/**
 * CollectTask entity. @author MyEclipse Persistence Tools
 */

public class CollectTask  implements java.io.Serializable {


    // Fields    

     /**
      * �ɼ���������id
     */
     private Long id;
     /**
      * ��������
     */
     private String type;
     /**
      * ��������
     */
     private String name;
     /**
      * ���ȼ�
     */
     private String priority;
     /**
      * �ɼ�������
     */
     private String collectType;
     /**
      * ִ�б�־
     */
     private String executeTag;
     /**
      * ��ǰ״̬
     */
     private String status;
     /**
      * ���ɴ���
     */
     private Integer suppCount;
     /**
      * ����ִ�п�ʼʱ��
     */
     private Long startTimestamp;
     /**
      * ����ִ�н���ʱ��
     */
     private Long endTimestamp;
     /**
      * �ɼ����ڿ�ʼʱ
     */
     private Integer startHour;
     /**
      * �ɼ����ڿ�ʼ��
     */
     private Integer startMinute;
     /**
      * �ɼ����ڽ���ʱ
     */
     private Integer endHour;
     /**
      * �ɼ����ڽ�����
     */
     private Integer endMinute;
     /**
      * ������Դ
     */
     private String source;
     /**
      * ������ID�������"||"��ס����|00811000||00820101|
     */
     private String concHardwareIds;
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
    public CollectTask() {
    }

    
    /** full constructor */
    public CollectTask(String type, String name, String priority, String collectType, String executeTag, String status, Integer suppCount, Long startTimestamp, Long endTimestamp, Integer startHour, Integer startMinute, Integer endHour, Integer endMinute, String source, String concHardwareIds, String chargingUnitId, String parentUnits, Long createTimestamp) {
        this.type = type;
        this.name = name;
        this.priority = priority;
        this.collectType = collectType;
        this.executeTag = executeTag;
        this.status = status;
        this.suppCount = suppCount;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.source = source;
        this.concHardwareIds = concHardwareIds;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * �ɼ���������id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * ��������
     */

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
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
     *      * ���ȼ�
     */

    public String getPriority() {
        return this.priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    /**       
     *      * �ɼ�������
     */

    public String getCollectType() {
        return this.collectType;
    }
    
    public void setCollectType(String collectType) {
        this.collectType = collectType;
    }
    /**       
     *      * ִ�б�־
     */

    public String getExecuteTag() {
        return this.executeTag;
    }
    
    public void setExecuteTag(String executeTag) {
        this.executeTag = executeTag;
    }
    /**       
     *      * ��ǰ״̬
     */

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    /**       
     *      * ���ɴ���
     */

    public Integer getSuppCount() {
        return this.suppCount;
    }
    
    public void setSuppCount(Integer suppCount) {
        this.suppCount = suppCount;
    }
    /**       
     *      * ����ִ�п�ʼʱ��
     */

    public Long getStartTimestamp() {
        return this.startTimestamp;
    }
    
    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }
    /**       
     *      * ����ִ�н���ʱ��
     */

    public Long getEndTimestamp() {
        return this.endTimestamp;
    }
    
    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }
    /**       
     *      * �ɼ����ڿ�ʼʱ
     */

    public Integer getStartHour() {
        return this.startHour;
    }
    
    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }
    /**       
     *      * �ɼ����ڿ�ʼ��
     */

    public Integer getStartMinute() {
        return this.startMinute;
    }
    
    public void setStartMinute(Integer startMinute) {
        this.startMinute = startMinute;
    }
    /**       
     *      * �ɼ����ڽ���ʱ
     */

    public Integer getEndHour() {
        return this.endHour;
    }
    
    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }
    /**       
     *      * �ɼ����ڽ�����
     */

    public Integer getEndMinute() {
        return this.endMinute;
    }
    
    public void setEndMinute(Integer endMinute) {
        this.endMinute = endMinute;
    }
    /**       
     *      * ������Դ
     */

    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    /**       
     *      * ������ID�������"||"��ס����|00811000||00820101|
     */

    public String getConcHardwareIds() {
        return this.concHardwareIds;
    }
    
    public void setConcHardwareIds(String concHardwareIds) {
        this.concHardwareIds = concHardwareIds;
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
		if ( !(other instanceof CollectTask) ) return false;
		CollectTask castOther = ( CollectTask ) other;
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