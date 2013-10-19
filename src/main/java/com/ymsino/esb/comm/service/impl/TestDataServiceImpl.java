package com.ymsino.esb.comm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;
import com.ymsino.esb.comm.service.api.TestDataService;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.TestData;
import com.ymsino.esb.protocol.strutc.TestDataResp;

public class TestDataServiceImpl implements TestDataService {

	private Logger logger = Logger.getLogger(TestDataServiceImpl.class);
	
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
	public String testData(String concHardwareId, String waterMeterId, Integer waterMeterSn) {

		TestData testData = new TestData();
		testData.head.rtua = AbstractMessage.initField(concHardwareId, testData.head.rtua.length);
		testData.head.mstaSeq = AbstractMessage.initField(ConcentratorOnLine.getNextMstaSeq(concHardwareId), testData.head.rtua.length);
		testData.waterMeterId = AbstractMessage.initField(waterMeterId, testData.waterMeterId.length);
		testData.waterMeterSn = AbstractMessage.initField(waterMeterSn.toString(), testData.waterMeterSn.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(testData.head.rtua));
		
		logger.debug("发送集中器召测本机动态数据消息:" + concHardwareId + ":" + AbstractMessage.getFieldString(testData.head.mstaSeq));
		logger.debug("发送:" + testData.toString());
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, testData.toBytes(), headers);
		
		byte[] bytes = (byte[]) camelContext.createConsumerTemplate().receiveBody("jms:queue:testData:" + concHardwareId + ":" +
				AbstractMessage.getFieldString(testData.head.mstaSeq));
		logger.debug("接收集中器召测本机动态数据响应:" + concHardwareId + ":" + AbstractMessage.getFieldString(testData.head.mstaSeq));
		
		TestDataResp resp = new TestDataResp(bytes);
		
		return AbstractMessage.getFieldString(resp.dataContent);
		
	}

}
