package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.str.StringTool;
import com.ymsino.esb.protocol.AbstractMessage;

public class MeterDataVo {

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
	
	
	public MeterDataVo(String[] strs){
		if(AbstractMessage.getFieldString(strs).equals("FFFFFFFFFFFF"))
			return;
		
		this.measure = Long.parseLong(AbstractMessage.getFieldString(strs).substring(4));
		this.batteryVoltage = (Integer.parseInt(strs[5], 16) + 200) / 100f;
		String b5data = Integer.toBinaryString(Integer.parseInt(strs[4], 16));
		b5data = StringTool.fromatNum(b5data, 8);
		this.valveStatus = b5data.substring(6);
		this.dataType = b5data.substring(3, 4);
		this.magneticAttack = b5data.substring(2, 3);
		this.replyStatus = b5data.substring(1, 2);
		this.errorStatus = b5data.substring(0, 1);
	}
	
	public static void main(String[] args){
		
		String[] str = new String[6];
		str = AbstractMessage.initField("689078563412", 6);
		
		Long measure = Long.parseLong(AbstractMessage.getFieldString(str).substring(4));
		//System.out.println(str[5]);
		Float batteryVoltage = (Integer.parseInt(str[5], 16) + 200) / 100f;
		String b5data = Integer.toBinaryString(Integer.parseInt(str[4], 16));
		b5data = StringTool.fromatNum(b5data, 8);
		String valveStatus = b5data.substring(6);
		String dataType = b5data.substring(3, 4);
		String magneticAttack = b5data.substring(2, 3);
		String replyStatus = b5data.substring(1, 2);
		String errorStatus = b5data.substring(0, 1);
		
		System.out.println("接收: 68 90 78 56 34 12");
		System.out.println("表码:" + measure);
		System.out.println("电压:" + batteryVoltage);
		System.out.println("阀门:" + valveStatus);
		System.out.println("数据类型:" + dataType);
		System.out.println("磁攻击:" + magneticAttack);
		System.out.println("正确数据:" + errorStatus);
		System.out.println("有无返回:" + replyStatus);
	}
}
