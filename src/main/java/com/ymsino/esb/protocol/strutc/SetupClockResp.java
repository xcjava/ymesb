package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

/**
 * 设置集中器时钟响应
 * @author xcjava@gmail.com
 */
public class SetupClockResp extends AbstractMessage {

	/**
	 * 消息头
	 */
	public MessageHead head = new MessageHead();
	
	/**
	 * 控制码
	 * 1字节
	 * 88
	 */
	private final String[] controlCode = {"88"};
	
	/**
	 * 数据长度
	 * 2字节
	 * 05 00
	 */
	private final String[] dataLength = {"00", "05"};
	
	/**
	 * 测量点号TN
	 * 2字节
	 * 固定为00 00，表示主站对集中器设置表号
	 */
	private String[] concentratorSn = {"00", "00"};
	
	/*
	 * 权限等级
	 * 1字节
	 * 此处固定为11
	
	private final String[] popedomLevel = {"11"}; */
	
	/*
	 * 密码
	 * 3字节
	 * 固定为00 00 00
	
	public String[] password = {"00", "00", "00"}; */
	
	/**
	 * 数据项编号
	 * 2字节
	 * 30 80
	 */
	private final String[] dataSn = {"80", "30"};
	
	/**
	 * 错误编码
	 * 1字节
	 * BCD
	 */
	public String[] errorCode = new String[1];
	
	/**
	 * 消息尾
	 */
	private MessageBottom messageBottom;

	public SetupClockResp(){}
	
	public SetupClockResp(byte[] bytes){
		int offset = 0;
		
		byte[] temp = ByteTool.subByte(bytes, offset, MessageHead.dataLength);
		offset += MessageHead.dataLength;
		this.head = new MessageHead(temp);
		
		this.controlCode[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.controlCode.length;
		
		temp = ByteTool.subByte(bytes, offset, this.dataLength.length);
		offset += this.dataLength.length;
		this.dataLength[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.dataLength[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.concentratorSn.length);
		offset += this.concentratorSn.length;
		this.concentratorSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.concentratorSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.dataSn.length);
		offset += this.dataSn.length;
		this.dataSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.dataSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		this.errorCode[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.errorCode.length;
		
		this.messageBottom.checkCode[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.messageBottom.checkCode.length;
		
		this.messageBottom.endSign[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.messageBottom.endSign.length;
	}
	
	@Override
	protected String getString() {

		String str = this.head.toString();
		str += getNioFieldString(this.controlCode) + "|";
		str += getNioFieldString(this.dataLength) + "|";
		str += getNioFieldString(this.concentratorSn) + "|";
		str += getNioFieldString(this.dataSn) + "|";
		str += getNioFieldString(this.errorCode) + "|";
		str += this.messageBottom.toString();
		
		return str;
		
	}

	@Override
	public void init() {

		this.bytes = new byte[MessageHead.dataLength + 
	                         	this.controlCode.length +
	                         	this.dataLength.length + 
								this.concentratorSn.length + 
								this.dataSn.length + 
								this.errorCode.length + 
								MessageBottom.dataLength];
	
		int offset = 0;
		System.arraycopy(head.toBytes(), 0, this.bytes, offset, MessageHead.dataLength);
		offset += MessageHead.dataLength;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.controlCode))), 0, this.bytes, offset, this.controlCode.length);
		offset += this.controlCode.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataLength))), 0, this.bytes, offset, this.dataLength.length);
		offset += this.dataLength.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.concentratorSn))), 0, this.bytes, offset, this.concentratorSn.length);
		offset += this.concentratorSn.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataSn))), 0, this.bytes, offset, this.dataSn.length);
		offset += this.dataSn.length;
	
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.errorCode))), 0, this.bytes, offset, this.errorCode.length);
		offset += this.errorCode.length;
		
		this.bytes[offset] = 0;
		for(int i = 0; i < this.bytes.length - MessageBottom.dataLength; i++){
			this.bytes[offset] += this.bytes[i];
		}
		this.messageBottom.checkCode[0] = DataConverter.bytesToHexString(ByteTool.subByte(this.bytes, offset, 1));
		offset += this.messageBottom.checkCode.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.messageBottom.endSign))), 0, this.bytes, offset, this.messageBottom.endSign.length);
		offset += this.messageBottom.endSign.length;
		
	}
	
}
