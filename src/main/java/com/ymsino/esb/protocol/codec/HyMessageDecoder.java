package com.ymsino.esb.protocol.codec;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.*;

public class HyMessageDecoder implements MessageDecoder {
	private Logger logger = Logger.getLogger(HyMessageDecoder.class);

	// 检查给定的IoBuffer是否适合解码
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		// 长度检查
		if (in.remaining() < 12) {
			return MessageDecoderResult.NEED_DATA;
		}

		// 控制码检查(未实现)
		/*byte b = in.array();
		
		if (tag == (short) 0x0001 || tag == (short) 0x8001) {
			logger.info("请求标识符：" + tag);
		} else {
			logger.error("未知的解码类型....");
			return MessageDecoderResult.NOT_OK;
		}*/

		// 数据长度检查(未实现)
		/*int len = in.getInt();
		if (in.remaining() < len) {
			return MessageDecoderResult.NEED_DATA;
		}*/
		
		//校验代码

		return MessageDecoderResult.OK;
	}

	public MessageDecoderResult decode(IoSession session, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		logger.debug("解码：" + in.toString());
		
		byte[] bytes = new byte[in.array().length];
		for(int i = 0; in.remaining() != 0; i++){
			bytes[i] = in.get();
		}
		
		//解析协议类型
		AbstractMessage message = null;
		if(AbstractMessage.getControlCode(bytes).equals("A1")){
			message = new Login(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("21")){
			message = new LoginResp(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("A2")){
			message = new Logout(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("22")){
			message = new LogoutResp(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("A4")){
			message = new Ping(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("24")){
			message = new PingResp(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("12")){
			message = new ReadData(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("08")){
			message = new LoadWm(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("88")){
			message = new LoadWmResp(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("92")){
			message = new ReadDataResp(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("15")){
			message = new ExceptionDate(in.array());
		}else{
			return MessageDecoderResult.NOT_OK;
		}
		
		out.write(message);
		
		return MessageDecoderResult.OK;
	}

	public void finishDecode(IoSession session, ProtocolDecoderOutput out)
			throws Exception {
	}
}
