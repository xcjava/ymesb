package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

/**
 * 集中器实时召测表码命令应答
 * @author xcjava@gmail.com
 */
public class TestMeterCodeResp extends AbstractMessage {

	/**
	 * 消息头
	 */
	public MessageHead head = new MessageHead();
	
	/**
	 * 控制码
	 * 1字节
	 * 91
	 */
	private final String[] controlCode = {"91"};
	
	/**
	 * 数据长度
	 * 2字节
	 * 0E 00
	 */
	private final String[] dataLength = {"00", "0E"};

	/**
	 * 表号
	 * 6字节
	 * BCD
	 */
	public String[] waterMeterId = {"FF", "FF", "FF", "FF", "FF", "FF"};
	
	/**
	 * 数据项编号
	 * 2字节
	 * 77 78
	 */
	private final String[] dataSn = {"78", "77"};
	
	/**
	 * 数据项内容
	 * 6字节
	 * HEX
	 */
	public String[] dataContent = new String[6];
	
	/**
	 * 消息尾
	 */
	private MessageBottom messageBottom;

	public TestMeterCodeResp(){}
	
	public TestMeterCodeResp(byte[] bytes){
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
		
		temp = ByteTool.subByte(bytes, offset, this.dataSn.length);
		offset += this.dataSn.length;
		this.dataSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.dataSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.dataContent.length);
		offset += this.dataContent.length;
		this.dataContent[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.dataContent[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.dataContent[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.dataContent[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.dataContent[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.dataContent[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));

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
		str += getNioFieldString(this.dataSn) + "|";
		str += getNioFieldString(this.dataContent) + "|";
		str += this.messageBottom.toString();
		
		return str;
		
	}

	@Override
	public void init() {

		this.bytes = new byte[MessageHead.dataLength + 
	                         	this.controlCode.length +
	                         	this.dataLength.length + 
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
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataSn))), 0, this.bytes, offset, this.dataSn.length);
		offset += this.dataSn.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataContent))), 0, this.bytes, offset, this.dataContent.length);
		offset += this.dataContent.length;

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
