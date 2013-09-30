package com.ymsino.esb.comm.ioprocess;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.Login;
import com.ymsino.esb.protocol.strutc.LoginResp;

public class PingProcess {

	private ProducerTemplate producerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}


	public void process(Login login){
		
		ConcentratorOnLine.setActTimestamp(AbstractMessage.getFieldString(login.head.rtua), new Date().getTime());
		
		LoginResp resp = new LoginResp();
		resp.head.rtua = AbstractMessage.initField(AbstractMessage.getFieldString(login.head.rtua), login.head.rtua.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(resp.head.rtua));
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, resp.toBytes(), headers);
		
	}
	
}
