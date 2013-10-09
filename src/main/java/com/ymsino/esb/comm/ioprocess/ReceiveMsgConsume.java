package com.ymsino.esb.comm.ioprocess;

import java.io.Serializable;

import org.apache.camel.Body;
import org.apache.camel.Consume;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Header;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.mina.core.session.IoSession;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.Debug;
import com.ymsino.esb.protocol.strutc.DebugResp;
import com.ymsino.esb.protocol.strutc.DeleteData;
import com.ymsino.esb.protocol.strutc.DeleteDataResp;
import com.ymsino.esb.protocol.strutc.DeleteSettings;
import com.ymsino.esb.protocol.strutc.DeleteSettingsResp;
import com.ymsino.esb.protocol.strutc.LoadWm;
import com.ymsino.esb.protocol.strutc.LoadWmResp;
import com.ymsino.esb.protocol.strutc.Login;
import com.ymsino.esb.protocol.strutc.LoginResp;
import com.ymsino.esb.protocol.strutc.Logout;
import com.ymsino.esb.protocol.strutc.LogoutResp;
import com.ymsino.esb.protocol.strutc.Ping;
import com.ymsino.esb.protocol.strutc.PingResp;
import com.ymsino.esb.protocol.strutc.ReadClock;
import com.ymsino.esb.protocol.strutc.ReadClockResp;
import com.ymsino.esb.protocol.strutc.ReadData;
import com.ymsino.esb.protocol.strutc.ReadDataResp;
import com.ymsino.esb.protocol.strutc.ReadParam;
import com.ymsino.esb.protocol.strutc.ReadParamResp;
import com.ymsino.esb.protocol.strutc.RestoreSettings;
import com.ymsino.esb.protocol.strutc.RestoreSettingsResp;
import com.ymsino.esb.protocol.strutc.SetupClock;
import com.ymsino.esb.protocol.strutc.SetupClockResp;
import com.ymsino.esb.protocol.strutc.TestData;
import com.ymsino.esb.protocol.strutc.TestDataResp;
import com.ymsino.esb.protocol.strutc.TestMeterCode;
import com.ymsino.esb.protocol.strutc.TestMeterCodeResp;

public class ReceiveMsgConsume {

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
	
	public Serializable receive(Exchange exchange){
		//ConcentratorOnLine.checkAdd(i++ + "", exchange);
		//System.out.println(exchange.getIn().getBody().getClass().getName());
		byte[] bytes = (byte[]) exchange.getIn().getBody();

		AbstractMessage message = null;
		if(AbstractMessage.getControlCode(bytes).equals("A1")){
			
			Login req = new Login(bytes);
			loginProcess.process(req, exchange);
			
		}/*else if(AbstractMessage.getControlCode(bytes).equals("21")){
			message = new LoginResp(bytes);
		}*/else if(AbstractMessage.getControlCode(bytes).equals("A2")){
			Logout logout = new Logout(bytes);
			logoutProcess.process(logout);
		}/*else if(AbstractMessage.getControlCode(bytes).equals("22")){
			message = new LogoutResp(bytes);
		}*/else if(AbstractMessage.getControlCode(bytes).equals("A4")){
			Ping ping = new Ping(bytes);
			pingProcess.process(ping);
		}/*else if(AbstractMessage.getControlCode(bytes).equals("24")){
			message = new PingResp(bytes);
		}else if(AbstractMessage.getControlCode(bytes).equals("01")){
			message = new ReadClock(bytes);
		}*/else if(AbstractMessage.getControlCode(bytes).equals("81")){
			
			ReadClockResp resp = new ReadClockResp(bytes);
			String concHardwareId = AbstractMessage.getFieldString(resp.head.rtua);
			producerTemplate.sendBody("jms:queue:readClock:" + concHardwareId, ExchangePattern.InOnly, resp.toBytes());
			
		}/*else if(AbstractMessage.getControlCode(bytes).equals("15")){
			message = new ReadParam(bytes);
		}*/else if(AbstractMessage.getControlCode(bytes).equals("95")){
			
			ReadParamResp resp = new ReadParamResp(bytes);
			String concHardwareId = AbstractMessage.getFieldString(resp.head.rtua);
			producerTemplate.sendBody("jms:queue:readWaterMeterSn:" + concHardwareId, ExchangePattern.InOnly, resp.toBytes());
			
		}/*else if(AbstractMessage.getControlCode(bytes).equals("12")){
			message = new ReadData(bytes);
		}*/else if(AbstractMessage.getControlCode(bytes).equals("92")){
			ReadDataResp resp = new ReadDataResp(bytes);
			String concHardwareId = AbstractMessage.getFieldString(resp.head.rtua);
			producerTemplate.sendBody("jms:queue:readData:" + concHardwareId, ExchangePattern.InOnly, resp.toBytes());
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
				message = new RestoreSettingsResp(bytes);
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("8030")){
				message = new SetupClockResp(bytes);
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("894D")){
				
				LoadWmResp loadWmResp = new LoadWmResp(bytes);
				String concHardwareId = AbstractMessage.getFieldString(loadWmResp.head.rtua);
				producerTemplate.sendBody("jms:queue:loadWm:" + concHardwareId, ExchangePattern.InOnly, AbstractMessage.getFieldString(loadWmResp.errorCode));
				
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("7808")){
				message = new DeleteDataResp(bytes);
			}else if(AbstractMessage.getDataLength(bytes).equals("0005") &&
					AbstractMessage.getDataSn(bytes, 13).equals("780A")){
				message = new DeleteSettingsResp(bytes);
			}
		}
		
		else if(AbstractMessage.getControlCode(bytes).equals("11")){
			
			if(AbstractMessage.getDataSn(bytes, 56).equals("7878")){
				message = new Debug(bytes);
			}else if(AbstractMessage.getDataSn(bytes, 56).equals("7877")){
				message = new TestMeterCode(bytes);
			}else if(AbstractMessage.getDataSn(bytes, 56).equals("7979")){
				message = new TestData(bytes);
			}
			
		}else if(AbstractMessage.getControlCode(bytes).equals("91")){
			
			if(AbstractMessage.getDataLength(bytes).equals("0009")){
				message = new DebugResp(bytes);
			}else if(AbstractMessage.getDataLength(bytes).equals("000E")){
				message = new TestMeterCodeResp(bytes);
			}else if(AbstractMessage.getDataLength(bytes).equals("0012")){
				message = new TestDataResp(bytes);
			}
			
		}
		
		return "error";
		
	}
	
	
	private int count = 0;
	public void testResp(Exchange exchange) throws InterruptedException{
		//System.out.print(exchange.getIn().getBody());

		producerTemplate.sendBody("jms:queue:test:2", "小葱:" + count++);
		
	}
	
}
