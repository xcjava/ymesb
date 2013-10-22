package com.ymsino.esb.comm.ioprocess;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.Ping;
import com.ymsino.esb.protocol.strutc.PingResp;

public class PingProcess {

	private Logger logger = Logger.getLogger(PingProcess.class);
	private ProducerTemplate producerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}


	public void process(Ping ping){
		
		ConcentratorOnLine.setActTimestamp(AbstractMessage.getFieldString(ping.head.rtua), new Date().getTime());
		
		PingResp resp = new PingResp();
		resp.head.rtua = AbstractMessage.initField(AbstractMessage.getFieldString(ping.head.rtua), ping.head.rtua.length);
		resp.head.mstaSeq = AbstractMessage.initField(AbstractMessage.getFieldString(ping.head.mstaSeq), ping.head.mstaSeq.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(resp.head.rtua));
		
		logger.debug("发送心跳响应:" + AbstractMessage.getFieldString(resp.head.rtua) + ":" + AbstractMessage.getFieldString(resp.head.mstaSeq));
		logger.debug("发送:" + resp.toString());
		producerTemplate.sendBodyAndHeaders("direct:send", ExchangePattern.InOnly, resp.toBytes(), headers);
		//producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, resp.toBytes(), headers);
		
	}
	
}
