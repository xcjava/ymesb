package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

public class ExceptionDate extends AbstractMessage {
	
	/**
	 * 消息头
	 */
	public MessageHead head = new MessageHead();
	
	/**
	 * 控制码
	 * 1字节
	 */
	private final String[] controlCode = {"15"};
	/**
	 * 数据长度
	 * 2字节
	 */
	private final String[] dataLength = {"00", "01"};
	
	/**
	 * 错误编号
	 * 1字节
	 */
	public String[] exceptionNo = new String[1];
	
	/**
	 * 消息尾
	 */
	private MessageBottom messageBottom;
	
	public ExceptionDate(){}
	
	public ExceptionDate(byte[] bytes){
		
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
		
		this.exceptionNo[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.exceptionNo.length;
		
		this.messageBottom.checkCode[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.messageBottom.checkCode.length;
		
		this.messageBottom.endSign[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.messageBottom.endSign.length;
		
	}
	
	@Override
	public void init() {
		this.bytes = new byte[MessageHead.dataLength + 
		                         this.controlCode.length +
		                         this.dataLength.length + 
		                         this.exceptionNo.length + 
		                         MessageBottom.dataLength];
		
		int offset = 0;
		System.arraycopy(head.toBytes(), 0, this.bytes, offset, MessageHead.dataLength);
		offset += MessageHead.dataLength;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.controlCode))), 0, this.bytes, offset, this.controlCode.length);
		offset += this.controlCode.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataLength))), 0, this.bytes, offset, this.dataLength.length);
		offset += this.dataLength.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.exceptionNo))), 0, this.bytes, offset, this.exceptionNo.length);
		offset += this.exceptionNo.length;

		this.bytes[offset] = 0;
		for(int i = 0; i < this.bytes.length - MessageBottom.dataLength; i++){
			this.bytes[offset] += this.bytes[i];
		}
		this.messageBottom.checkCode[0] = DataConverter.bytesToHexString(ByteTool.subByte(this.bytes, offset, 1));
		offset += this.messageBottom.checkCode.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.messageBottom.endSign))), 0, this.bytes, offset, this.messageBottom.endSign.length);
		offset += this.messageBottom.endSign.length;

	}
	
	@Override
	protected String getString(){
		String str = this.head.toString();
		str += getNioFieldString(this.controlCode) + "|";
		str += getNioFieldString(this.dataLength) + "|";
		str += this.messageBottom.toString();
		
		return str;
	}

}
