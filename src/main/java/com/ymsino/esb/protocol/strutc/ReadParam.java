package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

/**
 * 读取集中器水表参数
 * @author xcjava@gmail.com
 */
public class ReadParam extends AbstractMessage {

	/**
	 * 消息头
	 */
	public MessageHead head = new MessageHead();
	
	/**
	 * 控制码
	 * 1字节
	 * 15
	 */
	private final String[] controlCode = {"15"};
	/**
	 * 数据长度
	 * 2字节
	 * 04 00
	 */
	private final String[] dataLength = {"00", "04"};
	
	/**
	 * 起始水表序号
	 * 2字节
	 */
	public String[] startWaterMeterSn = new String[2];
	
	/**
	 * 总表数
	 * 2字节
	 */
	public String[] totalMeterNum = new String[2];
	
	/**
	 * 消息尾
	 */
	private MessageBottom messageBottom = new MessageBottom();
	
	public ReadParam(){}
	
	public ReadParam(byte[] bytes){
		
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

		temp = ByteTool.subByte(bytes, offset, this.startWaterMeterSn.length);
		offset += this.startWaterMeterSn.length;
		this.startWaterMeterSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.startWaterMeterSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));

		temp = ByteTool.subByte(bytes, offset, this.totalMeterNum.length);
		offset += this.totalMeterNum.length;
		this.totalMeterNum[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.totalMeterNum[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));

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
		                         this.startWaterMeterSn.length + 
		                         this.totalMeterNum.length + 
		                         MessageBottom.dataLength];
		
		int offset = 0;
		System.arraycopy(head.toBytes(), 0, this.bytes, offset, MessageHead.dataLength);
		offset += MessageHead.dataLength;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.controlCode))), 0, this.bytes, offset, this.controlCode.length);
		offset += this.controlCode.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataLength))), 0, this.bytes, offset, this.dataLength.length);
		offset += this.dataLength.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.startWaterMeterSn))), 0, this.bytes, offset, this.startWaterMeterSn.length);
		offset += this.startWaterMeterSn.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.totalMeterNum))), 0, this.bytes, offset, this.totalMeterNum.length);
		offset += this.totalMeterNum.length;

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
		str += getNioFieldString(this.startWaterMeterSn) + "|";
		str += getNioFieldString(this.totalMeterNum) + "|";
		str += this.messageBottom.toString();
		
		return str;
	}
	
}
