package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

/**
 * 读取集中器水表参数应答数据项
 * @author xcjava@gmail.com
 */
public class ReadParamRespItem {
	
	/**
	 * 固定值
	 * 1字节
	 * 00
	 */
	public String[] fixedValue = {"00"};
	
	/**
	 * 水表序号
	 * 2字节
	 */
	public String[] waterMeterSn = {"FF", "FF"};
	
	/**
	 * 表号
	 * 6字节
	 */
	public String[] waterMeterId = {"FF", "FF", "FF", "FF", "FF", "FF"};
	
	/**
	 * 新表类型
	 * 1字节
	 * 00
	 */
	private String[] newMeterType = {"00"};
	
	/**
	 * 中继序号1
	 * 2字节
	 */
	private String[] relayNo1 = {"FF", "FF"};
	
	/**
	 * 中继序号2
	 * 2字节
	 */
	private String[] relayNo2 = {"FF", "FF"};
	
	/**
	 * 中继序号3
	 * 2字节
	 */
	private String[] relayNo3 = {"FF", "FF"};
	
	/**
	 * 中继序号4
	 * 2字节
	 */
	private String[] relayNo4 = {"FF", "FF"};
	
	/**
	 * CT
	 * 2字节
	 * 01 00
	 */
	private String[] ct = {"00", "01"};
	
	/**
	 * 测量性质
	 * 1字节
	 * 23
	 */
	private String[] testKind = {"23"};
	
	/**
	 * 自动中继条件
	 * 7字节
	 */
	private String[] autoRelayCondition = {"00", "00", "00", "00", "00", "00", "00"};
	
	/**
	 * 对应采集终端地址
	 * 6字节
	 */
	private String[] collectTerminalSite = {"FF", "FF", "FF", "FF", "FF", "FF"};

	/**
	 * 字节数
	 */
	public static final int dataLength = 	1 + 
											2 + 
											6 + 
											1 +
											2 + 
											2 + 
											2 + 
											2 + 
											2 + 
											1 + 
											7 +
											6;
	
	public ReadParamRespItem(){}
	
	public ReadParamRespItem(byte[] bytes){
		int offset = 0;
		
		this.fixedValue[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.fixedValue.length;
		
		byte[] temp = ByteTool.subByte(bytes, offset, this.waterMeterSn.length);
		offset += this.waterMeterSn.length;
		this.waterMeterSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.waterMeterSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.waterMeterId.length);
		offset += this.waterMeterId.length;
		this.waterMeterId[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.waterMeterId[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.waterMeterId[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.waterMeterId[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.waterMeterId[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.waterMeterId[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		this.newMeterType[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.newMeterType.length;
		
		temp = ByteTool.subByte(bytes, offset, this.relayNo1.length);
		offset += this.relayNo1.length;
		this.relayNo1[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.relayNo1[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.relayNo2.length);
		offset += this.relayNo2.length;
		this.relayNo2[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.relayNo2[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.relayNo3.length);
		offset += this.relayNo3.length;
		this.relayNo3[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.relayNo3[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.relayNo4.length);
		offset += this.relayNo4.length;
		this.relayNo4[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.relayNo4[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.ct.length);
		offset += this.ct.length;
		this.ct[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.ct[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		this.testKind[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.testKind.length;
		
		temp = ByteTool.subByte(bytes, offset, this.autoRelayCondition.length);
		offset += this.autoRelayCondition.length;
		this.autoRelayCondition[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 6, 1));
		this.autoRelayCondition[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.autoRelayCondition[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.autoRelayCondition[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.autoRelayCondition[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.autoRelayCondition[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.autoRelayCondition[6] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.collectTerminalSite.length);
		offset += this.collectTerminalSite.length;
		this.collectTerminalSite[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 5, 1));
		this.collectTerminalSite[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 4, 1));
		this.collectTerminalSite[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.collectTerminalSite[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.collectTerminalSite[4] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.collectTerminalSite[5] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
	}

	public byte[] toBytes() {
		byte[] bytes = new byte[dataLength];
		
		int offset = 0;		
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.fixedValue))), 0, bytes, offset, this.fixedValue.length);
		offset += this.fixedValue.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.waterMeterSn))), 0, bytes, offset, this.waterMeterSn.length);
		offset += this.waterMeterSn.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.waterMeterId))), 0, bytes, offset, this.waterMeterId.length);
		offset += this.waterMeterId.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.newMeterType))), 0, bytes, offset, this.newMeterType.length);
		offset += this.newMeterType.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.relayNo1))), 0, bytes, offset, this.relayNo1.length);
		offset += this.relayNo1.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.relayNo2))), 0, bytes, offset, this.relayNo2.length);
		offset += this.relayNo2.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.relayNo3))), 0, bytes, offset, this.relayNo3.length);
		offset += this.relayNo3.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.relayNo4))), 0, bytes, offset, this.relayNo4.length);
		offset += this.relayNo4.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.ct))), 0, bytes, offset, this.ct.length);
		offset += this.ct.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.testKind))), 0, bytes, offset, this.testKind.length);
		offset += this.testKind.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.autoRelayCondition))), 0, bytes, offset, this.autoRelayCondition.length);
		offset += this.autoRelayCondition.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.collectTerminalSite))), 0, bytes, offset, this.collectTerminalSite.length);
		offset += this.collectTerminalSite.length;
		
		return bytes;
	}
	
	protected String getString(){
		String str = "";
		str += AbstractMessage.getNioFieldString(this.fixedValue) + "|";
		str += AbstractMessage.getNioFieldString(this.waterMeterSn) + "|";
		str += AbstractMessage.getNioFieldString(this.waterMeterId) + "|";
		str += AbstractMessage.getNioFieldString(this.newMeterType) + "|";
		str += AbstractMessage.getNioFieldString(this.relayNo1) + "|";
		str += AbstractMessage.getNioFieldString(this.relayNo2) + "|";
		str += AbstractMessage.getNioFieldString(this.relayNo3) + "|";
		str += AbstractMessage.getNioFieldString(this.relayNo4) + "|";
		str += AbstractMessage.getNioFieldString(this.ct) + "|";
		str += AbstractMessage.getNioFieldString(this.testKind) + "|";
		str += AbstractMessage.getNioFieldString(this.autoRelayCondition) + "|";
		str += AbstractMessage.getNioFieldString(this.collectTerminalSite) + "|";
		return str;
	}
	
}
