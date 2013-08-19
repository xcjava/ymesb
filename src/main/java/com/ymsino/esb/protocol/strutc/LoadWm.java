package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

public class LoadWm extends AbstractMessage {

	
	/**
	 * 消息头
	 */
	public MessageHead head = new MessageHead();
	
	/**
	 * 控制码
	 * 1字节
	 */
	private final String[] controlCode = {"08"};
	
	/**
	 * 数据长度
	 * 2字节
	 */
	private final String[] dataLength = {"01", "53"};
	
	/**
	 * 测量点号TN
	 * 2字节
	 */
	private String[] concentratorSn = {"00", "00"};
	
	/**
	 * 权限等级
	 * 1字节
	 */
	private final String[] popedomLevel = {"11"};

	/**
	 * 密码
	 * 3字节
	 */
	public String[] password = {"00", "00", "00"};
	
	/**
	 * 数据项编号
	 * 2字节
	 */
	private final String[] dataSn = {"89", "4D"};
	
	/**
	 * 操作类型	00新增，01修改，02删除
	 * 1字节
	 */
	public String[] optType = new String[1];
	
	/**
	 * 水表列表
	 */
	public LoadWmItem[] loadWmItem = new LoadWmItem[10];
	
	/**
	 * 校验码
	 * 1字节
	 */
	private String[] checkCode = new String[1];
	
	/**
	 * 结束符
	 * 1字节
	 */
	private final String[] endSign = {"16"};
	
	public LoadWm(){}
	
	public LoadWm(byte[] bytes){
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
		
		this.popedomLevel[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.popedomLevel.length;
		
		temp = ByteTool.subByte(bytes, offset, this.password.length);
		offset += this.password.length;
		this.password[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.password[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.password[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.dataSn.length);
		offset += this.dataSn.length;
		this.dataSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.dataSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		this.optType[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.optType.length;
		
		for(int i = 0; i < this.loadWmItem.length; i++){
			temp = ByteTool.subByte(bytes, offset, LoadWmItem.dataLength);
			offset += LoadWmItem.dataLength;
			loadWmItem[i] = new LoadWmItem(temp);
		}
		
		this.checkCode[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.checkCode.length;
		
		this.endSign[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.endSign.length;
	}

	@Override
	public void init() {
		this.bytes = new byte[MessageHead.dataLength + 
		                         	this.controlCode.length +
		                         	this.dataLength.length + 
									this.concentratorSn.length + 		
									this.popedomLevel.length + 
									this.password.length + 
									this.dataSn.length + 	
									this.optType.length + 
									this.loadWmItem.length * LoadWmItem.dataLength + 
									this.checkCode.length + 
		                         	this.endSign.length];
		
		int offset = 0;
		System.arraycopy(head.toBytes(), 0, this.bytes, offset, MessageHead.dataLength);
		offset += MessageHead.dataLength;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.controlCode))), 0, this.bytes, offset, this.controlCode.length);
		offset += this.controlCode.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataLength))), 0, this.bytes, offset, this.dataLength.length);
		offset += this.dataLength.length;

		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.concentratorSn))), 0, this.bytes, offset, this.concentratorSn.length);
		offset += this.concentratorSn.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.popedomLevel))), 0, this.bytes, offset, this.popedomLevel.length);
		offset += this.popedomLevel.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.password))), 0, this.bytes, offset, this.password.length);
		offset += this.password.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataSn))), 0, this.bytes, offset, this.dataSn.length);
		offset += this.dataSn.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.optType))), 0, this.bytes, offset, this.optType.length);
		offset += this.optType.length;
		
		for(LoadWmItem item : this.loadWmItem){
			if(item == null){
				item = new LoadWmItem();
			}
			System.arraycopy(item.toBytes(), 0, this.bytes, offset, LoadWmItem.dataLength);
			offset += LoadWmItem.dataLength;
		}

		this.bytes[offset] = 0;
		for(int i = 0; i < this.bytes.length - this.checkCode.length - this.endSign.length; i++){
			this.bytes[offset] += this.bytes[i];
		}
		this.checkCode[0] = DataConverter.bytesToHexString(ByteTool.subByte(this.bytes, offset, 1));
		offset += this.checkCode.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.endSign))), 0, this.bytes, offset, this.endSign.length);
		offset += this.endSign.length;
	}
	
	@Override
	protected String getString(){
		String str = this.head.toString();
		str += getNioFieldString(this.controlCode) + "|";
		str += getNioFieldString(this.dataLength) + "|";
		str += getNioFieldString(this.concentratorSn) + "|";
		str += getNioFieldString(this.popedomLevel) + "|";
		str += getNioFieldString(this.password) + "|";
		str += getNioFieldString(this.dataSn) + "|";
		str += getNioFieldString(this.optType) + "|";
		for(LoadWmItem item : this.loadWmItem){
			if(item == null){
				item = new LoadWmItem();
			}
			str += item.getString();
		}
		str += getNioFieldString(this.checkCode) + "|";
		str += getNioFieldString(this.endSign);
		
		return str;
	}
	
	public static void main(String[] args){
		LoadWm loadWm = new LoadWm();
		//loadWm.startSign1 = new String[]{"00"};
		loadWm.optType = new String[]{"00"};
		//loadWm.rtua = AbstractMessage.initField("00014180", loadWm.rtua.length);
		for(int i=0; i<10; i++){
			String seq = Integer.toHexString(i+1).toUpperCase();
			if(seq.length() < 2){
				seq = "0" + seq;
			}
			
			loadWm.loadWmItem[i] = new LoadWmItem();
			loadWm.loadWmItem[i].waterMeterId = AbstractMessage.initField("12080266", loadWm.loadWmItem[0].waterMeterId.length);
			loadWm.loadWmItem[i].waterMeterSn = AbstractMessage.initField(seq, loadWm.loadWmItem[0].waterMeterSn.length);
		}
		
		System.out.println(loadWm);
	}
	
}
