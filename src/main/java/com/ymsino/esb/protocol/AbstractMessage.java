package com.ymsino.esb.protocol;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;

/**
 * 协议工具
 * @author xcjava@gmail.com
 *
 */
public abstract class AbstractMessage {

	
	//---------协议头--------
	/**
	 * 帧起始符
	 * 1字节
	 */
	//public String[] startSign1 = {"68"};
	/**
	 * 集中器逻辑地址
	 * 4字节
	 */
	//public String[] rtua = new String[4];
	/**
	 * 主站地址与命令序号
	 * 2字节
	 */
	//public String[] mstaSeq = {"01", "40"};
	/**
	 * 帧起始符
	 * 1字节
	 */
	//protected final String[] startSign2 = {"68"};
	//---------协议头--------
	
	/**
	 * 从协议中获取控制码
	 * @param bytes
	 * @return
	 */
	public static String getControlCode(byte[] bytes){
		if(bytes.length < 12)
			return null;
		
		byte[] bs = {bytes[8]};
		String code = DataConverter.bytesToHexString(bs);
		return code;
	}
	
	/**
	 * 从协议中获取数据长度
	 * @param bytes
	 * @return
	 */
	public static String getDataLength(byte[] bytes){
		if(bytes.length < 12)
			return null;
		
		byte[] bs = {bytes[9], bytes[10]};
		String[] dataLength = new String[2];
		dataLength[0] = DataConverter.bytesToHexString(ByteTool.subByte(bs, 1, 1));
		dataLength[1] = DataConverter.bytesToHexString(ByteTool.subByte(bs, 0, 1));
		return dataLength[0] + dataLength[1];
	}
	
	/**
	 * 从协议获取数据项编号
	 * @param bytes
	 * @param startLength
	 * @return
	 */
	public static String getDataSn(byte[] bytes, int startLength){
		byte[] bs = {bytes[startLength], bytes[startLength + 1]};
		String[] dataSn = new String[2];
		dataSn[0] = DataConverter.bytesToHexString(ByteTool.subByte(bs, 1, 1));
		dataSn[1] = DataConverter.bytesToHexString(ByteTool.subByte(bs, 0, 1));
		return dataSn[0] + dataSn[1];
	}
	
	/**
	 * 拼装字段数组中的字符串
	 * @param field
	 * @return
	 */
	public static String getFieldString(String[] field){
		String str = "";
		for(String item : field){
			str += item;
		}
		return str;
	}
	
	/**
	 * 拼装协议传输过程中的字符串
	 * @param field
	 * @return
	 */
	public static String getNioFieldString(String[] field){
		String str = "";
		for(String item : field){
			str = item + str;
		}
		return str;
	}
	
	/**
	 * 根据文本和长度初始化协议体字段域内容
	 * @param str
	 * @param length
	 * @return
	 */
	public static String[] initField(String str, int length){
		if(str.length()%2 != 0){
			str = "0" + str;
		}
		
		if(str.length()/2 > length){
			str = str.substring(str.length() - length * 2, str.length());
		}else if(str.length()/2 < length){
			while(str.length() / 2 != length){
				str = "00" + str;
			}
		}
		
		String[] result = new String[str.length()/2];
		for(int i = 0; i < str.length()/2; i++){
			result[i] = str.substring(i * 2,i * 2 + 2);
		}
		return result;
	}
	
	/**
	 * 存放整个消息的字节数组
	 */
	protected byte[] bytes;
	
	/**
	 * 将协议装为字符串
	 * @return
	 */
	protected abstract String getString();
	
	/**
	 * 初始化协议
	 */
	public abstract void init();
	
	public final String toString(){
		init();
		return this.getString();
	}
	
	public final byte[] toBytes(){
		init();
		return bytes;
	}
	
	public static void main(String[] args) {  
		byte[] bytes = DataConverter.hexStringToByte("0000000000000000A1030400");
		System.out.println(bytes.length);
		System.out.println(getControlCode(bytes));
		System.out.println(getDataLength(bytes));
	}
}
