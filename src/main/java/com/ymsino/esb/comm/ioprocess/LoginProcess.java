package com.ymsino.esb.comm.ioprocess;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.Login;
import com.ymsino.esb.protocol.strutc.LoginResp;

public class LoginProcess {

	private Logger logger = Logger.getLogger(LoginProcess.class);
	private ProducerTemplate producerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}


	public void process(Login login, Exchange exchange){

		if(AbstractMessage.getFieldString(login.password).equals("000000")){
			ConcentratorOnLine.checkAdd(AbstractMessage.getFieldString(login.head.rtua), exchange);
			
			LoginResp resp = new LoginResp();
			resp.head.rtua = AbstractMessage.initField(AbstractMessage.getFieldString(login.head.rtua), login.head.rtua.length);
			resp.head.mstaSeq = AbstractMessage.initField(AbstractMessage.getFieldString(login.head.mstaSeq), login.head.mstaSeq.length);
			
			//exchange.getOut().setBody(resp.toBytes());
			
			Map<String, Object> headers = new HashMap<String, Object>();
			headers.put("concentratorId", AbstractMessage.getFieldString(resp.head.rtua));
			
			logger.debug("发送登录响应:" + AbstractMessage.getFieldString(resp.head.rtua) + ":" + AbstractMessage.getFieldString(resp.head.mstaSeq));
			logger.debug("发送:" + resp.toString());
			//SendMsgConsume.sendMsg(resp.toBytes(), AbstractMessage.getFieldString(resp.head.rtua));
			producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, resp.toBytes(), headers);
			//producerTemplate.sendBodyAndHeaders("direct:send", ExchangePattern.InOnly, resp.toBytes(), headers);
			
		}else{
			ConcentratorOnLine.close(AbstractMessage.getFieldString(login.head.rtua));
		}
		
	}
	
}
