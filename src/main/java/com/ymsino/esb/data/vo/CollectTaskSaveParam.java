package com.ymsino.esb.data.vo;

import java.io.Serializable;

public class CollectTaskSaveParam implements Serializable {

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
     * 执行标志
    */
    private String executeTag;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getCollectType() {
		return collectType;
	}
	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}
	public String getExecuteTag() {
		return executeTag;
	}
	public void setExecuteTag(String executeTag) {
		this.executeTag = executeTag;
	}
	public Integer getSuppCount() {
		return suppCount;
	}
	public void setSuppCount(Integer suppCount) {
		this.suppCount = suppCount;
	}
	public Long getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(Long startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	public Long getEndTimestamp() {
		return endTimestamp;
	}
	public void setEndTimestamp(Long endTimestamp) {
		this.endTimestamp = endTimestamp;
	}
	public Integer getStartHour() {
		return startHour;
	}
	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}
	public Integer getStartMinute() {
		return startMinute;
	}
	public void setStartMinute(Integer startMinute) {
		this.startMinute = startMinute;
	}
	public Integer getEndHour() {
		return endHour;
	}
	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}
	public Integer getEndMinute() {
		return endMinute;
	}
	public void setEndMinute(Integer endMinute) {
		this.endMinute = endMinute;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getConcHardwareIds() {
		return concHardwareIds;
	}
	public void setConcHardwareIds(String concHardwareIds) {
		this.concHardwareIds = concHardwareIds;
	}
	public String getChargingUnitId() {
		return chargingUnitId;
	}
	public void setChargingUnitId(String chargingUnitId) {
		this.chargingUnitId = chargingUnitId;
	}
}
