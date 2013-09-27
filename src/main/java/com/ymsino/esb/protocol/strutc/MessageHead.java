package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

public class MessageHead {

	/**
	 * 帧起始符
	 * 1字节
	 */
	public String[] startSign1 = {"68"};
	/**
	 * 集中器逻辑地址
	 * 4字节
	 */
	public String[] rtua = new String[4];
	/**
	 * 主站地址与命令序号
	 * 2字节
	 */
	public String[] mstaSeq = {"01", "40"};
	/**
	 * 帧起始符
	 * 1字节
	 */
	protected final String[] startSign2 = {"68"};

	/**
	 * 字节数
	 */
	public static final int dataLength = 1 + 4 + 2 + 1;
	
	public MessageHead(){}
	
	public MessageHead(byte[] bytes){
		
		int offset = 0;
		
		this.startSign1[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.startSign1.length;
		
		byte[] temp = ByteTool.subByte(bytes, offset, this.rtua.length);
		offset += this.rtua.length;
		this.rtua[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 3, 1));
		this.rtua[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.rtua[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.rtua[3] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		temp = ByteTool.subByte(bytes, offset, this.mstaSeq.length);
		offset += this.mstaSeq.length;
		this.mstaSeq[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.mstaSeq[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
		this.startSign2[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.startSign2.length;
		
	}

	public byte[] toBytes() {
		
		byte[] bytes = new byte[dataLength];
		
		int offset = 0;
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.startSign1))), 0, bytes, offset, this.startSign1.length);
		offset += this.startSign1.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.rtua))), 0, bytes, offset, this.rtua.length);
		offset += this.rtua.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.mstaSeq))), 0, bytes, offset, this.mstaSeq.length);
		offset += this.mstaSeq.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.startSign2))), 0, bytes, offset, this.startSign2.length);
		offset += this.startSign2.length;
		
		return bytes;
	}

	public String toString(){
		
		String str = "";
		str += AbstractMessage.getNioFieldString(this.startSign1) + "|";
		str += AbstractMessage.getNioFieldString(this.rtua) + "|";
		str += AbstractMessage.getNioFieldString(this.mstaSeq) + "|";
		str += AbstractMessage.getNioFieldString(this.startSign2) + "|";
		
		return str;
	}
}
