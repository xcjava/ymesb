package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

/**
 * 集中器召测本机动态数据命令
 * @author xcjava@gmail.com
 */
public class TestData extends AbstractMessage {

	/**
	 * 消息头
	 */
	public MessageHead head = new MessageHead();
	
	/**
	 * 控制码
	 * 1字节
	 * 11
	 */
	private final String[] controlCode = {"11"};
	
	/**
	 * 数据长度
	 * 2字节
	 * 23 00
	 */
	private final String[] dataLength = {"00", "23"};
	
	/**
	 * 表号
	 * 6字节
	 * BCD
	 */
	public String[] waterMeterId = {"FF", "FF", "FF", "FF", "FF", "FF"};
	
	/**
	 * 水表序号
	 * 2字节
	 * HEX
	 */
	public String[] waterMeterSn = {"FF", "FF"};
	/**
	 * 中继方式
	 * 00为无中继，01为1级中继04为4级中继FF自动中继
	 * 1字节
	 * BCD
	 */
	public String[] relayType = {"00"};
	/**
	 * 中继序号1
	 * 无中继与自动中继时为FF，其他根据实际情况填写
	 * 6字节
	 * BCD
	 */
	public String[] relayMeterId1 = {"FF", "FF", "FF", "FF", "FF", "FF"};
	/**
	 * 中继序号2
	 * 无中继与自动中继时为FF，其他根据实际情况填写
	 * 6字节
	 * BCD
	 */
	public String[] relayMeterId2 = {"FF", "FF", "FF", "FF", "FF", "FF"};
	/**
	 * 中继序号3
	 * 无中继与自动中继时为FF，其他根据实际情况填写
	 * 6字节
	 * BCD
	 */
	public String[] relayMeterId3 = {"FF", "FF", "FF", "FF", "FF", "FF"};
	/**
	 * 中继序号4
	 * 无中继与自动中继时为FF，其他根据实际情况填写
	 * 6字节
	 * BCD
	 */
	public String[] relayMeterId4 = {"FF", "FF", "FF", "FF", "FF", "FF"};

	/**
	 * 数据项编号
	 * 2字节
	 * 79 79
	 */
	private final String[] dataSn = {"79", "79"};
	
	/**
	 * 消息尾
	 */
	private MessageBottom messageBottom = new MessageBottom();

	public TestData(){}
	
	public TestData(byte[] bytes){
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

		temp = ByteTool.subByte(bytes, offset, this.waterMeterId.length);
		offset += this.waterMeterId.length;
		this.waterMeterId[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.waterMeterId[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.waterMeterId[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.waterMeterId[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.waterMeterId[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.waterMeterId[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.waterMeterSn.length);
		offset += this.waterMeterSn.length;
		this.waterMeterSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.waterMeterSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		this.relayType[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.relayType.length;
		
		temp = ByteTool.subByte(bytes, offset, this.relayMeterId1.length);
		offset += this.relayMeterId1.length;
		this.relayMeterId1[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.relayMeterId1[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.relayMeterId1[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.relayMeterId1[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.relayMeterId1[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.relayMeterId1[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.relayMeterId2.length);
		offset += this.relayMeterId2.length;
		this.relayMeterId2[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.relayMeterId2[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.relayMeterId2[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.relayMeterId2[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.relayMeterId2[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.relayMeterId2[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.relayMeterId3.length);
		offset += this.relayMeterId3.length;
		this.relayMeterId3[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.relayMeterId3[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.relayMeterId3[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.relayMeterId3[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.relayMeterId3[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.relayMeterId3[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.relayMeterId4.length);
		offset += this.relayMeterId4.length;
		this.relayMeterId4[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.relayMeterId4[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.relayMeterId4[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.relayMeterId4[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.relayMeterId4[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.relayMeterId4[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.dataSn.length);
		offset += this.dataSn.length;
		this.dataSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.dataSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));

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
		str += getNioFieldString(this.waterMeterId) + "|";
		str += getNioFieldString(this.waterMeterSn) + "|";
		str += getNioFieldString(this.relayType) + "|";
		str += getNioFieldString(this.relayMeterId1) + "|";
		str += getNioFieldString(this.relayMeterId2) + "|";
		str += getNioFieldString(this.relayMeterId3) + "|";
		str += getNioFieldString(this.relayMeterId4) + "|";
		str += getNioFieldString(this.dataSn) + "|";
		str += this.messageBottom.toString();
		
		return str;
		
	}

	@Override
	public void init() {

		this.bytes = new byte[MessageHead.dataLength + 
	                         	this.controlCode.length +
	                         	this.dataLength.length + 
	                         	this.waterMeterId.length + 
	                         	this.waterMeterSn.length + 
	                         	this.relayType.length + 
	                         	this.relayMeterId1.length + 
	                         	this.relayMeterId2.length + 
	                         	this.relayMeterId3.length + 
	                         	this.relayMeterId4.length + 
								this.dataSn.length + 
								MessageBottom.dataLength];

		int offset = 0;
		System.arraycopy(head.toBytes(), 0, this.bytes, offset, MessageHead.dataLength);
		offset += MessageHead.dataLength;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.controlCode))), 0, this.bytes, offset, this.controlCode.length);
		offset += this.controlCode.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataLength))), 0, this.bytes, offset, this.dataLength.length);
		offset += this.dataLength.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.waterMeterId))), 0, this.bytes, offset, this.waterMeterId.length);
		offset += this.waterMeterId.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.waterMeterSn))), 0, this.bytes, offset, this.waterMeterSn.length);
		offset += this.waterMeterSn.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.relayType))), 0, this.bytes, offset, this.relayType.length);
		offset += this.relayType.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.relayMeterId1))), 0, this.bytes, offset, this.relayMeterId1.length);
		offset += this.relayMeterId1.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.relayMeterId2))), 0, this.bytes, offset, this.relayMeterId2.length);
		offset += this.relayMeterId2.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.relayMeterId3))), 0, this.bytes, offset, this.relayMeterId3.length);
		offset += this.relayMeterId3.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.relayMeterId4))), 0, this.bytes, offset, this.relayMeterId4.length);
		offset += this.relayMeterId4.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataSn))), 0, this.bytes, offset, this.dataSn.length);
		offset += this.dataSn.length;
		
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
