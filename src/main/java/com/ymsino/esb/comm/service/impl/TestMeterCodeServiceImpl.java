package com.ymsino.esb.comm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;
import com.ymsino.esb.comm.service.api.TestMeterCodeService;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.TestMeterCode;
import com.ymsino.esb.protocol.strutc.TestMeterCodeResp;

public class TestMeterCodeServiceImpl implements TestMeterCodeService {

	private Logger logger = Logger.getLogger(TestMeterCodeServiceImpl.class);
	
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
	public String testMeterCode(String concHardwareId, String waterMeterId, Integer waterMeterSn) {

		TestMeterCode testMeterCode = new TestMeterCode();
		testMeterCode.head.rtua = AbstractMessage.initField(concHardwareId, testMeterCode.head.rtua.length);
		testMeterCode.head.mstaSeq = AbstractMessage.initField(ConcentratorOnLine.getNextMstaSeq(concHardwareId), testMeterCode.head.rtua.length);
		testMeterCode.waterMeterId = AbstractMessage.initField(waterMeterId, testMeterCode.waterMeterId.length);
		testMeterCode.waterMeterSn = AbstractMessage.initField(waterMeterSn.toString(), testMeterCode.waterMeterSn.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(testMeterCode.head.rtua));
		
		logger.debug("发送集中器实时召测表码消息:" + concHardwareId + ":" + AbstractMessage.getFieldString(testMeterCode.head.mstaSeq));
		logger.debug("发送:" + testMeterCode.toString());
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, testMeterCode.toBytes(), headers);
		
		byte[] bytes = (byte[]) camelContext.createConsumerTemplate().receiveBody("jms:queue:testMeterCode:" + concHardwareId + ":" +
				AbstractMessage.getFieldString(testMeterCode.head.mstaSeq));
		logger.debug("接收集中器实时召测表码响应:" + concHardwareId + ":" + AbstractMessage.getFieldString(testMeterCode.head.mstaSeq));
		
		TestMeterCodeResp resp = new TestMeterCodeResp(bytes);
		
		return AbstractMessage.getFieldString(resp.dataContent);
		
	}

}
