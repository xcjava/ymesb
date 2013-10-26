package com.ymsino.esb.comm.vo;

import com.gmail.xcjava.base.str.StringTool;
import com.ymsino.esb.protocol.AbstractMessage;

public class MeterDataVo {

	/**
	 * 智能水表编号
	 */
	private String meterId;
	
	/**
	 * 冻结日期
	 */
	private String readDateStr;
	
	/**
	 * 读数
	 * 1-4字节：HEX，水表用量；
	 */
	private Long measure;
	
	/**
	 * 电池电压
	 * 【第6字节（HEX解析方式）+ 200】/100
	 */
	private Float batteryVoltage;
	
	/**
	 * 阀门状态
	 * 第5字节D1,D0
	 * 01=半阀 10=开阀
	 * 11=关阀 00=未知
	 */
	private String valveStatus;
	
	/**
	 * 数据类型
	 * 0=光电
	 * 1=脉冲
	 * 第5字节D4
	 */
	private String dataType;
	
	/**
	 * 磁攻击
	 * 0无磁攻击, 1有磁攻击
	 * 第5字节D5
	 */
	private String magneticAttack;
	
	/**
	 * 错误状态
	 * 0=正确, 1=错误
	 * 第5字节D6
	 */
	private String errorStatus;
	
	/**
	 * 应答状态
	 * 0=有应答, 1=无应答
	 * 第5字节D7
	 */
	private String replyStatus;

	
	
	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getReadDateStr() {
		return readDateStr;
	}

	public void setReadDateStr(String readDateStr) {
		this.readDateStr = readDateStr;
	}

	public void setMeasure(Long measure) {
		this.measure = measure;
	}

	public void setBatteryVoltage(Float batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	public void setValveStatus(String valveStatus) {
		this.valveStatus = valveStatus;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setMagneticAttack(String magneticAttack) {
		this.magneticAttack = magneticAttack;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}

	public Long getMeasure() {
		return measure;
	}

	public Float getBatteryVoltage() {
		return batteryVoltage;
	}

	public String getValveStatus() {
		return valveStatus;
	}

	public String getDataType() {
		return dataType;
	}

	public String getMagneticAttack() {
		return magneticAttack;
	}

	public String getErrorStatus() {
		return errorStatus;
	}

	public String getReplyStatus() {
		return replyStatus;
	}
	
	
}
