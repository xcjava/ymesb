package com.ymsino.esb.manager.vo;

import java.io.Serializable;

public class RoleReturn implements Serializable {

	/**
     * 角色id
    */
    Long id;
    /**
     * 角色名字
    */
    String name;
    /**
     * 角色描述
    */
    String description;
    /**
     * 创建时间
    */
    Long createTimestamp;
    /**
     * 状态:0新建,1启用,-1停用
    */
    Short status;
    /**
     * 创建人ID
    */
    String createrId;
    /**
     * 权限json,格式为{"模块代号":""操作代号","模块代号":""操作代号,操作代号"},如,{"001":"001,002","002":"003"}
    */
    String popedomJson;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getCreaterId() {
		return createrId;
	}
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	public String getPopedomJson() {
		return popedomJson;
	}
	public void setPopedomJson(String popedomJson) {
		this.popedomJson = popedomJson;
	}
}
