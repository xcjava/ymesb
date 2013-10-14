package com.ymsino.esb.comm.ioprocess;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.Ping;
import com.ymsino.esb.protocol.strutc.PingResp;

public class PingProcess {

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
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, resp.toBytes(), headers);
		
	}
	
}
