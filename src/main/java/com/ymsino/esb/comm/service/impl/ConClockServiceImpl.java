package com.ymsino.esb.comm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;
import com.ymsino.esb.comm.service.api.ConClockService;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.ReadClock;
import com.ymsino.esb.protocol.strutc.ReadClockResp;
import com.ymsino.esb.protocol.strutc.SetupClock;

public class ConClockServiceImpl implements ConClockService {

	private CamelContext camelContext;
	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}
	
	private ProducerTemplate producerTemplate;
	private ConsumerTemplate consumerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	public void setConsumerTemplate(ConsumerTemplate consumerTemplate) {
		this.consumerTemplate = consumerTemplate;
	}
	
	@Override
	public String readClock(String concHardwareId) {
		
		ReadClock readClock = new ReadClock();
		readClock.head.rtua = AbstractMessage.initField(concHardwareId, readClock.head.rtua.length);
		readClock.head.mstaSeq = AbstractMessage.initField(ConcentratorOnLine.getNextMstaSeq(concHardwareId), readClock.head.rtua.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(readClock.head.rtua));
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, readClock.toBytes(), headers);
		
		byte[] bytes = (byte[]) camelContext.createConsumerTemplate().receiveBody("jms:queue:readClock:" + concHardwareId + ":" +
				AbstractMessage.getFieldString(readClock.head.mstaSeq));
		ReadClockResp resp = new ReadClockResp(bytes);
		
		return AbstractMessage.getFieldString(resp.dataContent);
	}

	@Override
	public String setupClock(String concHardwareId, String dateStr) {
		
		SetupClock setupClock = new SetupClock();
		setupClock.head.rtua = AbstractMessage.initField(concHardwareId, setupClock.head.rtua.length);
		setupClock.head.mstaSeq = AbstractMessage.initField(ConcentratorOnLine.getNextMstaSeq(concHardwareId), setupClock.head.rtua.length);
		setupClock.dataContent = AbstractMessage.initField(dateStr, setupClock.dataContent.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(setupClock.head.rtua));
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, setupClock.toBytes(), headers);
		
		String errorCode = (String) camelContext.createConsumerTemplate().receiveBody("jms:queue:setupClock:" + concHardwareId + ":" +
				AbstractMessage.getFieldString(setupClock.head.mstaSeq));
		return errorCode;
	}

}
