package com.ymsino.esb.comm.ioprocess;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.netty.NettyConstants;
import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelHandlerContext;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.DebugResp;
import com.ymsino.esb.protocol.strutc.DeleteDataResp;
import com.ymsino.esb.protocol.strutc.DeleteSettingsResp;
import com.ymsino.esb.protocol.strutc.LoadWmResp;
import com.ymsino.esb.protocol.strutc.Login;
import com.ymsino.esb.protocol.strutc.Logout;
import com.ymsino.esb.protocol.strutc.Ping;
import com.ymsino.esb.protocol.strutc.ReadClockResp;
import com.ymsino.esb.protocol.strutc.ReadDataResp;
import com.ymsino.esb.protocol.strutc.ReadParamResp;
import com.ymsino.esb.protocol.strutc.RestoreSettingsResp;
import com.ymsino.esb.protocol.strutc.SetupClockResp;
import com.ymsino.esb.protocol.strutc.TestDataResp;
import com.ymsino.esb.protocol.strutc.TestMeterCodeResp;

public class ReceiveMsgConsume {
	
	private Logger logger = Logger.getLogger(ReceiveMsgConsume.class);

	private ProducerTemplate producerTemplate;
	private ConsumerTemplate consumerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	public void setConsumerTemplate(ConsumerTemplate consumerTemplate) {
		this.consumerTemplate = consumerTemplate;
	}

	LoginProcess loginProcess;
	LogoutProcess logoutProcess;
	PingProcess pingProcess;
	
	public void setLoginProcess(LoginProcess loginProcess) {
		this.loginProcess = loginProcess;
	}
	public void setLogoutProcess(LogoutProcess logoutProcess) {
		this.logoutProcess = logoutProcess;
	}
	public void setPingProcess(PingProcess pingProcess) {
		this.pingProcess = pingProcess;
	}
	
	public void receive(Exchange exchange){
		//ConcentratorOnLine.checkAdd(i++ + "", exchange);
		//System.out.println(exchange.getIn().getBody().getClass().getName());
		byte[] bytes = (byte[]) exchange.getIn().getBody();

		//AbstractMessage message = null;
		if(AbstractMessage.getControlCode(bytes).equals("A1")){
			
			Login req = new Login(bytes);
			logger.debug("接收:" + req.toString());
			logger.debug("接收登录消息:" + AbstractMessage.getFieldString(req.head.rtua) + ":" + AbstractMessage.getFieldString(req.head.mstaSeq));
			loginProcess.process(req, exchange);
			
		}/*else if(AbstractMessage.getControlCode(bytes).equals("21")){
			message = new LoginResp(bytes);
		}*/else if(AbstractMessage.getControlCode(bytes).equals("A2")){
			Logout logout = new Logout(bytes);
			logger.debug("接收:" + logout.toString());
			logger.debug("接收登出消息:" + AbstractMessage.getFieldString(logout.head.rtua) + ":" + AbstractMessage.getFieldString(logout.head.mstaSeq));
			logoutProcess.process(logout);
		}/*else if(AbstractMessage.getControlCode(bytes).equals("22")){
			message = new LogoutResp(bytes);
		}*/else if(AbstractMessage.getControlCode(bytes).equals("A4")){
			Ping ping = new Ping(bytes);
			logger.debug("接收:" + ping.toString());
			logger.debug("接收心跳消息:" + AbstractMessage.getFieldString(ping.head.rtua) + ":" + AbstractMessage.getFieldString(ping.head.mstaSeq));
			pingProcess.process(ping, exchange);
		}/*else if(AbstractMessage.getControlCode(bytes).equals("24")){
			message = new PingResp(bytes);
		}else if(AbstractMessage.getControlCode(bytes).equals("01")){
			message = new ReadClock(bytes);
		}*/else if(AbstractMessage.getControlCode(bytes).equals("81")){
			
			ReadClockResp resp = new ReadClockResp(bytes);
			logger.debug("接收:" + resp.toString());
			String concHardwareId = AbstractMessage.getFieldString(resp.head.rtua);
			String mstaSeq = AbstractMessage.getFieldString(resp.head.mstaSeq);
			
			producerTemplate.sendBody("jms:queue:readClock:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, resp.toBytes());
			//producerTemplate.sendBody("direct:readClock:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, resp.toBytes());
		}/*else if(AbstractMessage.getControlCode(bytes).equals("15")){
			message = new ReadParam(bytes);
		}*/else if(AbstractMessage.getControlCode(bytes).equals("95")){
			/*for(int i = 0; i < bytes.length; i++){
				System.out.print(DataConverter.bytesToHexString(ByteTool.subByte(bytes, i, 1)) + "|");
			}*/
			ReadParamResp resp = new ReadParamResp(bytes);
			logger.debug("接收:" + resp.toString());
			String concHardwareId = AbstractMessage.getFieldString(resp.head.rtua);
			String mstaSeq = AbstractMessage.getFieldString(resp.head.mstaSeq);
			producerTemplate.sendBody("jms:queue:readWaterMeterSn:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, resp.toBytes());
			//producerTemplate.sendBody("direct:readWaterMeterSn:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, resp.toBytes());
			
		}/*else if(AbstractMessage.getControlCode(bytes).equals("12")){
			message = new ReadData(bytes);
		}*/else if(AbstractMessage.getControlCode(bytes).equals("92")){
			ReadDataResp resp = new ReadDataResp(bytes);
			logger.debug("接收:" + resp.toString());
			String concHardwareId = AbstractMessage.getFieldString(resp.head.rtua);
			String mstaSeq = AbstractMessage.getFieldString(resp.head.mstaSeq);
			producerTemplate.sendBody("jms:queue:readData:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, resp.toBytes());
			//producerTemplate.sendBody("direct:readData:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, resp.toBytes());
		}

		/*else if(AbstractMessage.getControlCode(bytes).equals("08")){
			if(AbstractMessage.getDataLength(bytes).equals("000E")){
				message = new SetupClock(bytes);
			}else if(AbstractMessage.getDataLength(bytes).equals("0153")){
				message = new LoadWm(bytes);
			}else if(AbstractMessage.getDataLength(bytes).equals("0009") &&
					AbstractMessage.getDataSn(bytes, 17).equals("8023")){
				message = new RestoreSettings(bytes);
			}else if(AbstractMessage.getDataLength(bytes).equals("0009") &&
					AbstractMessage.getDataSn(bytes, 17).equals("7808")){
				message = new DeleteData(bytes);
			}else if(AbstractMessage.getDataLength(bytes).equals("0009") &&
					AbstractMessage.getDataSn(bytes, 17).equals("780A")){
				message = new DeleteSettings(bytes);
			}
		}*/
		
		else if(AbstractMessage.getControlCode(bytes).equals("88")){
			if(AbstractMessage.getDataLength(bytes).equals("0004")){
				
				RestoreSettingsResp restoreSettingsResp = new RestoreSettingsResp(bytes);
				logger.debug("接收:" + restoreSettingsResp.toString());
				String concHardwareId = AbstractMessage.getFieldString(restoreSettingsResp.head.rtua);
				String mstaSeq = AbstractMessage.getFieldString(restoreSettingsResp.head.mstaSeq);
				producerTemplate.sendBody("jms:queue:restoreSettings:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, AbstractMessage.getFieldString(restoreSettingsResp.errorCode));
				//producerTemplate.sendBody("direct:restoreSettings:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, AbstractMessage.getFieldString(restoreSettingsResp.errorCode));
				
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("8030")){
				
				SetupClockResp setupClockResp = new SetupClockResp(bytes);
				logger.debug("接收:" + setupClockResp.toString());
				String concHardwareId = AbstractMessage.getFieldString(setupClockResp.head.rtua);
				String mstaSeq = AbstractMessage.getFieldString(setupClockResp.head.mstaSeq);
				producerTemplate.sendBody("jms:queue:setupClock:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, AbstractMessage.getFieldString(setupClockResp.errorCode));
				//producerTemplate.sendBody("direct:setupClock:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, AbstractMessage.getFieldString(setupClockResp.errorCode));
				
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("894D")){
				
				LoadWmResp loadWmResp = new LoadWmResp(bytes);
				logger.debug("接收:" + loadWmResp.toString());
				String concHardwareId = AbstractMessage.getFieldString(loadWmResp.head.rtua);
				String mstaSeq = AbstractMessage.getFieldString(loadWmResp.head.mstaSeq);
				producerTemplate.sendBody("jms:queue:loadWm:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, AbstractMessage.getFieldString(loadWmResp.errorCode));
				//producerTemplate.sendBody("direct:loadWm:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, AbstractMessage.getFieldString(loadWmResp.errorCode));
				
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("7808")){
				
				DeleteDataResp deleteDataResp = new DeleteDataResp(bytes);
				logger.debug("接收:" + deleteDataResp.toString());
				String concHardwareId = AbstractMessage.getFieldString(deleteDataResp.head.rtua);
				String mstaSeq = AbstractMessage.getFieldString(deleteDataResp.head.mstaSeq);
				producerTemplate.sendBody("jms:queue:deleteData:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, AbstractMessage.getFieldString(deleteDataResp.errorCode));
				//producerTemplate.sendBody("direct:deleteData:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, AbstractMessage.getFieldString(deleteDataResp.errorCode));
				
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("780A")){
				
				DeleteSettingsResp deleteSettingsResp = new DeleteSettingsResp(bytes);
				logger.debug("接收:" + deleteSettingsResp.toString());
				String concHardwareId = AbstractMessage.getFieldString(deleteSettingsResp.head.rtua);
				String mstaSeq = AbstractMessage.getFieldString(deleteSettingsResp.head.mstaSeq);
				producerTemplate.sendBody("jms:queue:deleteSettings:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, AbstractMessage.getFieldString(deleteSettingsResp.errorCode));
				//producerTemplate.sendBody("direct:deleteSettings:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, AbstractMessage.getFieldString(deleteSettingsResp.errorCode));
			}
		}
		
		/*else if(AbstractMessage.getControlCode(bytes).equals("11")){
			
			if(AbstractMessage.getDataSn(bytes, 56).equals("7878")){
				message = new Debug(bytes);
			}else if(AbstractMessage.getDataSn(bytes, 56).equals("7877")){
				message = new TestMeterCode(bytes);
			}else if(AbstractMessage.getDataSn(bytes, 56).equals("7979")){
				message = new TestData(bytes);
			}
			
		}*/
		
		else if(AbstractMessage.getControlCode(bytes).equals("91")){
			
			if(AbstractMessage.getDataLength(bytes).equals("0009")){
				
				DebugResp debugResp = new DebugResp(bytes);
				logger.debug("接收:" + debugResp.toString());
				String concHardwareId = AbstractMessage.getFieldString(debugResp.head.rtua);
				String mstaSeq = AbstractMessage.getFieldString(debugResp.head.mstaSeq);
				producerTemplate.sendBody("jms:queue:debug:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, debugResp.toBytes());
				//producerTemplate.sendBody("direct:debug:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, debugResp.toBytes());
				
			}else if(AbstractMessage.getDataLength(bytes).equals("000E")){
				
				TestMeterCodeResp testMeterCodeResp = new TestMeterCodeResp(bytes);
				logger.debug("接收:" + testMeterCodeResp.toString());
				String concHardwareId = AbstractMessage.getFieldString(testMeterCodeResp.head.rtua);
				String mstaSeq = AbstractMessage.getFieldString(testMeterCodeResp.head.mstaSeq);
				producerTemplate.sendBody("jms:queue:testMeterCode:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, testMeterCodeResp.toBytes());
				//producerTemplate.sendBody("direct:testMeterCode:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, testMeterCodeResp.toBytes());
				
			}else if(AbstractMessage.getDataLength(bytes).equals("0012")){
				
				TestDataResp testDataResp = new TestDataResp(bytes);
				logger.debug("接收:" + testDataResp.toString());
				String concHardwareId = AbstractMessage.getFieldString(testDataResp.head.rtua);
				String mstaSeq = AbstractMessage.getFieldString(testDataResp.head.mstaSeq);
				producerTemplate.sendBody("jms:queue:testData:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, testDataResp.toBytes());
				//producerTemplate.sendBody("direct:testData:" + concHardwareId + ":" + mstaSeq, ExchangePattern.InOnly, testDataResp.toBytes());
			}
			
		}
		else{
			logger.warn("无法解析收到消息:" + DataConverter.bytesToHexString(bytes));
		}
	}
	
	
	private int count = 0;
	public void testResp(Exchange exchange){
		//System.out.print(exchange.getIn().getBody());

		//producerTemplate.sendBody("jms:queue:test:2", "小葱:" + count++);
		
		String r = (String) exchange.getIn().getBody();
		logger.debug("接收:" + r);
		
		
		
		//IoSession ioSession = (IoSession) exchange.getIn().getHeader(Mina2Constants.MINA_IOSESSION);
		
		ChannelHandlerContext channelHandlerContext = (ChannelHandlerContext) exchange.getIn().getHeader(NettyConstants.NETTY_CHANNEL_HANDLER_CONTEXT);
		channelHandlerContext.getChannel().write("you send : " + r);
		
		System.out.println(channelHandlerContext.getChannel().getId());
		
		/*if(!r.equals("bye")){
			exchange.getOut().setBody("you send : " + r);
		}else{
			exchange.getOut().setHeader(NettyConstants.NETTY_CLOSE_CHANNEL_WHEN_COMPLETE, true);
			exchange.getOut().setBody("bye!!!");
		}*/
		
	}
	
}
