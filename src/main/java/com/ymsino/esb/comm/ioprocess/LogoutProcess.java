package com.ymsino.esb.comm.ioprocess;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.Logout;
import com.ymsino.esb.protocol.strutc.LogoutResp;

public class LogoutProcess {

	private ProducerTemplate producerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	
	public void process(Logout logout){
		
		LogoutResp resp = new LogoutResp();
		resp.head.rtua = AbstractMessage.initField(AbstractMessage.getFieldString(logout.head.rtua), logout.head.rtua.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(resp.head.rtua));
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, resp.toBytes(), headers);
		
		ConcentratorOnLine.close(AbstractMessage.getFieldString(resp.head.rtua), true);
		
	}
	
}