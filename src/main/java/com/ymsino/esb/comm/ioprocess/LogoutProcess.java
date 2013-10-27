package com.ymsino.esb.comm.ioprocess;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.Logout;
import com.ymsino.esb.protocol.strutc.LogoutResp;

public class LogoutProcess {

	private Logger logger = Logger.getLogger(LogoutProcess.class);
	private ProducerTemplate producerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	
	public void process(Logout logout){
		
		LogoutResp resp = new LogoutResp();
		resp.head.rtua = AbstractMessage.initField(AbstractMessage.getFieldString(logout.head.rtua), logout.head.rtua.length);
		resp.head.mstaSeq = AbstractMessage.initField(AbstractMessage.getFieldString(logout.head.mstaSeq), logout.head.mstaSeq.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(resp.head.rtua));
		
		logger.debug("发送退出响应:" + AbstractMessage.getFieldString(resp.head.rtua) + ":" + AbstractMessage.getFieldString(resp.head.mstaSeq));
		logger.debug("发送:" + resp.toString());
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, resp.toBytes(), headers);
		//producerTemplate.sendBodyAndHeaders("direct:send", ExchangePattern.InOnly, resp.toBytes(), headers);
		
		ConcentratorOnLine.close(AbstractMessage.getFieldString(resp.head.rtua));
		
	}
	
}
