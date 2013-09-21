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
		}else if(AbstractMessage.getControlCode(bytes).equals("01")){
			message = new ReadClock(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("81")){
			message = new ReadClockResp(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("15")){
			message = new ReadParam(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("95")){
			message = new ReadParamResp(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("12")){
			message = new ReadData(in.array());
		}else if(AbstractMessage.getControlCode(bytes).equals("92")){
			message = new ReadDataResp(in.array());
		}

		else if(AbstractMessage.getControlCode(bytes).equals("08")){
			if(AbstractMessage.getDataLength(bytes).equals("000E")){
				message = new SetupClock(in.array());
			}else if(AbstractMessage.getDataLength(bytes).equals("0153")){
				message = new LoadWm(in.array());
			}else if(AbstractMessage.getDataLength(bytes).equals("0009") &&
					AbstractMessage.getDataSn(bytes, 17).equals("8023")){
				message = new RestoreSettings(in.array());
			}else if(AbstractMessage.getDataLength(bytes).equals("0009") &&
					AbstractMessage.getDataSn(bytes, 17).equals("7808")){
				message = new DeleteData(in.array());
			}else if(AbstractMessage.getDataLength(bytes).equals("0009") &&
					AbstractMessage.getDataSn(bytes, 17).equals("780A")){
				message = new DeleteSettings(in.array());
			}
		}else if(AbstractMessage.getControlCode(bytes).equals("88")){
			if(AbstractMessage.getDataLength(bytes).equals("0004")){
				message = new RestoreSettingsResp(in.array());
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("8030")){
				message = new SetupClockResp(in.array());
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("894D")){
				message = new LoadWmResp(in.array());
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("7808")){
				message = new DeleteDataResp(in.array());
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("780A")){
				message = new DeleteSettingsResp(in.array());
			}
		}
		
		else if(AbstractMessage.getControlCode(bytes).equals("11")){
			
			if(AbstractMessage.getDataSn(bytes, 56).equals("7878")){
				message = new Debug(in.array());
			}else if(AbstractMessage.getDataSn(bytes, 56).equals("7877")){
				message = new TestMeterCode(in.array());
			}else if(AbstractMessage.getDataSn(bytes, 56).equals("7979")){
				message = new TestData(in.array());
			}
			
		}else if(AbstractMessage.getControlCode(bytes).equals("91")){
			
			if(AbstractMessage.getDataLength(bytes).equals("0009")){
				message = new DebugResp(in.array());
			}else if(AbstractMessage.getDataLength(bytes).equals("000E")){
				message = new TestMeterCodeResp(in.array());
			}else if(AbstractMessage.getDataLength(bytes).equals("0012")){
				message = new TestDataResp(in.array());
			}
			
		}
		
		else{
			return MessageDecoderResult.NOT_OK;
		}
		
		out.write(message);
		
		return MessageDecoderResult.OK;
	}

	public void finishDecode(IoSession session, ProtocolDecoderOutput out)
			throws Exception {
	}
}
