package com.ymsino.esb.comm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;
import com.ymsino.esb.comm.service.api.ConDebugService;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.Debug;
import com.ymsino.esb.protocol.strutc.DebugResp;

public class ConDebugServiceImpl implements ConDebugService {

	private Logger logger = Logger.getLogger(ConDebugServiceImpl.class);
	
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
	
	private ConcentratorOnLine concentratorOnLine;
	public void setConcentratorOnLine(ConcentratorOnLine concentratorOnLine) {
		this.concentratorOnLine = concentratorOnLine;
	}
	
	@Override
	public String debug(String concHardwareId, String waterMeterId, Integer waterMeterSn) {

		Debug debug = new Debug();
		debug.head.rtua = AbstractMessage.initField(concHardwareId, debug.head.rtua.length);
		debug.head.mstaSeq = AbstractMessage.initField(concentratorOnLine.getNextMstaSeq(concHardwareId), debug.head.mstaSeq.length);
		debug.waterMeterId = AbstractMessage.initField(waterMeterId, debug.waterMeterId.length);
		debug.waterMeterSn = AbstractMessage.initField(Integer.toHexString(waterMeterSn), debug.waterMeterSn.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(debug.head.rtua));
		
		logger.debug("发送调试消息:" + concHardwareId + ":" + AbstractMessage.getFieldString(debug.head.mstaSeq));
		logger.debug("发送:" + debug.toString());
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, debug.toBytes(), headers);
		
		byte[] bytes = (byte[]) camelContext.createConsumerTemplate().receiveBody("jms:queue:debug:" + concHardwareId + ":" +
				AbstractMessage.getFieldString(debug.head.mstaSeq));
		logger.debug("接收调试响应:" + concHardwareId + ":" + AbstractMessage.getFieldString(debug.head.mstaSeq));
		DebugResp resp = new DebugResp(bytes);
		
		return AbstractMessage.getFieldString(resp.dataContent);
		
	}

}
