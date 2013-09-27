package com.ymsino.esb.protocol.strutc;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;

public class Login extends AbstractMessage {
	
	/**
	 * 消息头
	 */
	public MessageHead head = new MessageHead();
	
	/**
	 * 控制码
	 * 1字节
	 */
	private final String[] controlCode = {"A1"};
	
	/**
	 * 数据长度
	 * 2字节
	 */
	private final String[] dataLength = {"00", "03"};
	
	/**
	 * 密码
	 * 3字节
	 */
	public String[] password = new String[3];
	
	/**
	 * 消息尾
	 */
	private MessageBottom messageBottom = new MessageBottom();
	
	public Login(){}
	
	public Login(byte[] bytes){
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
		
		temp = ByteTool.subByte(bytes, offset, this.password.length);
		offset += this.password.length;
		this.password[0] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 2, 1));
		this.password[1] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 1, 1));
		this.password[2] = DataConverter.bytesToHexString(ByteTool.subByte(temp, 0, 1));
		
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
		                         this.password.length + 
		                         MessageBottom.dataLength];
		
		int offset = 0;
		System.arraycopy(head.toBytes(), 0, this.bytes, offset, MessageHead.dataLength);
		offset += MessageHead.dataLength;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.controlCode))), 0, this.bytes, offset, this.controlCode.length);
		offset += this.controlCode.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.dataLength))), 0, this.bytes, offset, this.dataLength.length);
		offset += this.dataLength.length;
		
		System.arraycopy(ByteTool.reverse(DataConverter.hexStringToByte(getFieldString(this.password))), 0, this.bytes, offset, this.password.length);
		offset += this.password.length;
		
		
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
		str += getNioFieldString(this.password) + "|";
		str += this.messageBottom.toString();
		
		return str;
	}
	
	public static void main(String[] args){
		
		Login msg = new Login();
		/*msg.startSign1[0] = "68";
		msg.rtua[0] = "80";
		msg.rtua[1] = "41";
		msg.rtua[2] = "01";
		msg.rtua[3] = "00";
		msg.mstaSeq[0] = "41";
		msg.mstaSeq[1] = "00";
		msg.startSign2[0] = "68";*/
		msg.controlCode[0] = "A1";
		//msg.dataLength[0] = "03";
		//msg.dataLength[1] = "00";
		msg.password[0] = "12";
		msg.password[1] = "34";
		msg.password[2] = "56";
		//msg.checkCode[0] = "AA";
		//msg.endSign[0] = "16";
		
		System.out.println(msg);
		byte[] bytes = msg.toBytes();
		/*for(int i=0; i<bytes.length;i++){
			System.out.print(DataConverter.bytesToHexString(ByteTool.subByte(bytes,i,1)));
		}
		System.out.println();*/
		
		Login msg2 = new Login(bytes);
		System.out.println(msg2);
		
		/*bytes = msg2.toBytes();
		for(int i=0; i<bytes.length;i++){
			System.out.print(DataConverter.bytesToHexString(ByteTool.subByte(bytes,i,1)));
		}*/
	}
	
	//custom 68| 80 41 01 00| 41 00| 68| A1| 03 00| 56 34 12| AA 16
	
	//68| 80 41 01 00| 41 00| 68| A1| 03 00| 11 11 11| AA 16
}
