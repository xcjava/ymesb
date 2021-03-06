package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.gmail.xcjava.base.str.StringTool;
import com.ymsino.esb.protocol.AbstractMessage;

public class ReadDataRespItem {

	/**
	 * 水表编号
	 * 6字节
	 */
	public String[] meterId = {"FF", "FF", "FF", "FF", "FF", "FF"};
	/**
	 * 水表数据块
	 * 6字节
	 */
	public String[] meterData = {"FF", "FF", "FF", "FF", "FF", "FF"};
	/**
	 * 读表日期HHDDMMYY
	 */
	public String[] readDate = {"FF", "FF", "FF", "FF"};
	
	private MeterDataVo meterDataVo;
	public MeterDataVo getMeterDataVo() {
		return meterDataVo;
	}

	/**
	 * 字节数
	 */
	public static final int dataLength = 6 + 6 + 4;
	
	public ReadDataRespItem(){}
	
	public ReadDataRespItem(byte[] bytes){
		int offset = 0;
		
		byte[] temp = ByteTool.subByte(bytes, offset, this.meterId.length);
		offset += this.meterId.length;
		this.meterId[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.meterId[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.meterId[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.meterId[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.meterId[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.meterId[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.meterData.length);
		offset += this.meterData.length;
		this.meterData[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.meterData[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.meterData[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.meterData[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.meterData[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.meterData[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		meterDataVo = new MeterDataVo(this.meterData);
		
		temp = ByteTool.subByte(bytes, offset, this.readDate.length);
		offset += this.readDate.length;
		this.readDate[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.readDate[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.readDate[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.readDate[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
	}

	public byte[] toBytes() {
		byte[] bytes = new byte[dataLength];
		
		int offset = 0;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.meterId))), 0, bytes, offset, this.meterId.length);
		offset += this.meterId.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.meterData))), 0, bytes, offset, this.meterData.length);
		offset += this.meterData.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.readDate))), 0, bytes, offset, this.readDate.length);
		offset += this.readDate.length;
		
		return bytes;
	}

	protected String getString(){
		String str = "";
		str += AbstractMessage.getNioFieldString(this.meterId) + "|";
		str += AbstractMessage.getNioFieldString(this.meterData) + "|";
		str += AbstractMessage.getNioFieldString(this.readDate) + "|";
		return str;
	}
	
	
}
