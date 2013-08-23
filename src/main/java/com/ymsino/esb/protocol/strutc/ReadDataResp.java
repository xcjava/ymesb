package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

public class ReadDataResp extends AbstractMessage {

	/**
	 * 消息头
	 */
	public MessageHead head = new MessageHead();
	
	/**
	 * 控制码
	 * 1字节
	 */
	private final String[] controlCode = {"92"};
	/**
	 * 数据长度
	 * 2字节
	 */
	private final String[] dataLength = {"00", "15"};
	/**
	 * 帧总数
	 * 1字节
	 */
	public final String[] totalMeterNum = {"01"};
	/**
	 * 起始水表序号
	 * 2字节
	 */
	public String[] startWaterMeterSn = new String[2];
	/**
	 * 当前帧序号
	 * 1字节
	 */
	public final String[] currentMeterNum = {"01"};
	/**
	 * 选项域S
	 * 2字节
	 */
	public String[] options = new String[2];

	/**
	 * 抄表日期年
	 * 1字节
	 */
	public String[] readYear = new String[1];
	/**
	 * 抄表日期月
	 * 1字节
	 */
	public String[] readMonth = new String[1];
	/**
	 * 抄表日期日
	 * 1字节
	 */
	public String[] readDay = new String[1];
	
	/**
	 * 水表数据块
	 */
	public ReadDataRespItem[] readDataRespItem = new ReadDataRespItem[10];
	
	/**
	 * 水表M的序号
	 * 2字节
	 */
	public String[] lastMeterSn = new String[2];
	
	/**
	 * 消息尾
	 */
	private MessageBottom messageBottom;
	
	public ReadDataResp(){}
	
	public ReadDataResp(byte[] bytes){
		
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

		this.totalMeterNum[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.totalMeterNum.length;
		
		temp = ByteTool.subByte(bytes, offset, this.startWaterMeterSn.length);
		offset += this.startWaterMeterSn.length;
		this.startWaterMeterSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.startWaterMeterSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));

		this.currentMeterNum[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.currentMeterNum.length;

		temp = ByteTool.subByte(bytes, offset, this.options.length);
		offset += this.options.length;
		this.options[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.options[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));

		this.readYear[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.readYear.length;

		this.readMonth[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.readMonth.length;

		this.readDay[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.readDay.length;

		for(int i = 0; i < this.readDataRespItem.length; i++){
			temp = ByteTool.subByte(bytes, offset, ReadDataRespItem.dataLength);
			offset += ReadDataRespItem.dataLength;
			this.readDataRespItem[i] = new ReadDataRespItem(temp);
		}
		
		temp = ByteTool.subByte(bytes, offset, this.lastMeterSn.length);
		offset += this.lastMeterSn.length;
		this.lastMeterSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.lastMeterSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));

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
		                         this.totalMeterNum.length + 
		                         this.startWaterMeterSn.length +
		                         this.currentMeterNum.length +
		                         this.options.length + 
		                         this.readYear.length + 
		                         this.readMonth.length + 
		                         this.readDay.length + 
		                         this.readDataRespItem.length * ReadDataRespItem.dataLength +
		                         this.lastMeterSn.length + 
		                         MessageBottom.dataLength];
		
		int offset = 0;
		System.arraycopy(head.toBytes(), 0, this.bytes, offset, MessageHead.dataLength);
		offset += MessageHead.dataLength;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.controlCode))), 0, this.bytes, offset, this.controlCode.length);
		offset += this.controlCode.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataLength))), 0, this.bytes, offset, this.dataLength.length);
		offset += this.dataLength.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.totalMeterNum))), 0, this.bytes, offset, this.totalMeterNum.length);
		offset += this.totalMeterNum.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.startWaterMeterSn))), 0, this.bytes, offset, this.startWaterMeterSn.length);
		offset += this.startWaterMeterSn.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.currentMeterNum))), 0, this.bytes, offset, this.currentMeterNum.length);
		offset += this.currentMeterNum.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.options))), 0, this.bytes, offset, this.options.length);
		offset += this.options.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.readYear))), 0, this.bytes, offset, this.readYear.length);
		offset += this.readYear.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.readMonth))), 0, this.bytes, offset, this.readMonth.length);
		offset += this.readMonth.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.readDay))), 0, this.bytes, offset, this.readDay.length);
		offset += this.readDay.length;

		for(ReadDataRespItem item : this.readDataRespItem){
			System.arraycopy(item.toBytes(), 0, this.bytes, offset, ReadDataRespItem.dataLength);
			offset += ReadDataRespItem.dataLength;
		}
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.lastMeterSn))), 0, this.bytes, offset, this.lastMeterSn.length);
		offset += this.lastMeterSn.length;

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
		str += getNioFieldString(this.totalMeterNum) + "|";
		str += getNioFieldString(this.startWaterMeterSn) + "|";
		str += getNioFieldString(this.currentMeterNum) + "|";
		str += getNioFieldString(this.options) + "|";
		str += getNioFieldString(this.readYear) + "|";
		str += getNioFieldString(this.readMonth) + "|";
		str += getNioFieldString(this.readDay) + "|";
		for(ReadDataRespItem item : this.readDataRespItem){
			str += item.getString();
		}
		str += getNioFieldString(this.lastMeterSn) + "|";
		str += this.messageBottom.toString();
		
		return str;
	}
	
	public static void main(String[] args){
		
	}
	//68| 80 41 01 00| 41 00| 68| 92| 0C 00| 40 01| 01| 12| 11| 12| 78 56 34 12 00 00| 00 00 00 00 00 00| FC 16
	
}
