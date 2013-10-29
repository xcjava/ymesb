package com.ymsino.esb.data.model;



/**
 * CollectTask entity. @author MyEclipse Persistence Tools
 */

public class CollectTask  implements java.io.Serializable {


    // Fields    

     /**
      * 采集任务自增id
     */
     private Long id;
     /**
      * 任务类型
     */
     private String type;
     /**
      * 任务名称
     */
     private String name;
     /**
      * 优先级
     */
     private String priority;
     /**
      * 采集点类型
     */
     private String collectType;
     /**
      * 执行标志:1执行,-1暂停
     */
     private String executeTag;
     /**
      * 当前状态:1忙,-1空闲
     */
     private String status;
     /**
      * 补采次数
     */
     private Integer suppCount;
     /**
      * 任务执行开始时间
     */
     private Long startTimestamp;
     /**
      * 任务执行结束时间
     */
     private Long endTimestamp;
     /**
      * 采集周期开始时
     */
     private Integer startHour;
     /**
      * 采集周期开始分
     */
     private Integer startMinute;
     /**
      * 采集周期结束时
     */
     private Integer endHour;
     /**
      * 采集周期结束分
     */
     private Integer endMinute;
     /**
      * 任务来源
     */
     private String source;
     /**
      * 集中器ID，多个用"||"包住，如|00811000||00820101|
     */
     private String concHardwareIds;
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
     *      * 采集任务自增id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * 任务类型
     */

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    /**       
     *      * 任务名称
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 优先级
     */

    public String getPriority() {
        return this.priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    /**       
     *      * 采集点类型
     */

    public String getCollectType() {
        return this.collectType;
    }
    
    public void setCollectType(String collectType) {
        this.collectType = collectType;
    }
    /**       
     *      * 执行标志:1执行,-1暂停
     */

    public String getExecuteTag() {
        return this.executeTag;
    }
    
    public void setExecuteTag(String executeTag) {
        this.executeTag = executeTag;
    }
    /**       
     *      * 当前状态:1忙,-1空闲
     */

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    /**       
     *      * 补采次数
     */

    public Integer getSuppCount() {
        return this.suppCount;
    }
    
    public void setSuppCount(Integer suppCount) {
        this.suppCount = suppCount;
    }
    /**       
     *      * 任务执行开始时间
     */

    public Long getStartTimestamp() {
        return this.startTimestamp;
    }
    
    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }
    /**       
     *      * 任务执行结束时间
     */

    public Long getEndTimestamp() {
        return this.endTimestamp;
    }
    
    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }
    /**       
     *      * 采集周期开始时
     */

    public Integer getStartHour() {
        return this.startHour;
    }
    
    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }
    /**       
     *      * 采集周期开始分
     */

    public Integer getStartMinute() {
        return this.startMinute;
    }
    
    public void setStartMinute(Integer startMinute) {
        this.startMinute = startMinute;
    }
    /**       
     *      * 采集周期结束时
     */

    public Integer getEndHour() {
        return this.endHour;
    }
    
    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }
    /**       
     *      * 采集周期结束分
     */

    public Integer getEndMinute() {
        return this.endMinute;
    }
    
    public void setEndMinute(Integer endMinute) {
        this.endMinute = endMinute;
    }
    /**       
     *      * 任务来源
     */

    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    /**       
     *      * 集中器ID，多个用"||"包住，如|00811000||00820101|
     */

    public String getConcHardwareIds() {
        return this.concHardwareIds;
    }
    
    public void setConcHardwareIds(String concHardwareIds) {
        this.concHardwareIds = concHardwareIds;
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