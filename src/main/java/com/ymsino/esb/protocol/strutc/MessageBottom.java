package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

public class MessageBottom {

	/**
	 * 校验码
	 * 1字节
	 */
	public String[] checkCode = new String[1];
	
	/**
	 * 结束符
	 * 1字节
	 */
	public final String[] endSign = {"16"};
	
	/**
	 * 字节数
	 */
	public static final int dataLength = 1 + 1;
	
	
	public MessageBottom(){}
	
	public MessageBottom(byte[] bytes){
		int offset = 0;
		
		this.checkCode[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.checkCode.length;
		
		this.endSign[0] = DataConverter.bytesToHexString(ByteTool.subByte(bytes, offset, 1));
		offset += this.endSign.length;
	}
	
	public byte[] toBytes() {
		
		byte[] bytes = new byte[dataLength];
		
		int offset = 0;
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.checkCode))), 0, bytes, offset, this.checkCode.length);
		offset += this.checkCode.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(AbstractMessage.getFieldString(this.endSign))), 0, bytes, offset, this.endSign.length);
		offset += this.endSign.length;
		
		return bytes;
	}

	public String toString(){
		
		String str = "";
		str += AbstractMessage.getNioFieldString(this.checkCode) + "|";
		str += AbstractMessage.getNioFieldString(this.endSign) + "|";
		
		return str;
	}
}
