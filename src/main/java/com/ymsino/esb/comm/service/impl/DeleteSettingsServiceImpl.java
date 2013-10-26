package com.ymsino.esb.comm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;
import com.ymsino.esb.comm.service.api.DeleteSettingsService;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.DeleteSettings;

public class DeleteSettingsServiceImpl implements DeleteSettingsService {

	private Logger logger = Logger.getLogger(DeleteSettingsServiceImpl.class);
	
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
	public String deleteSettings(String concHardwareId) {

		DeleteSettings deleteSettings = new DeleteSettings();
		deleteSettings.head.rtua = AbstractMessage.initField(concHardwareId, deleteSettings.head.rtua.length);
		deleteSettings.head.mstaSeq = AbstractMessage.initField(ConcentratorOnLine.getNextMstaSeq(concHardwareId), deleteSettings.head.mstaSeq.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(deleteSettings.head.rtua));
		
		logger.debug("发送删除集中器设置消息:" + concHardwareId + ":" + AbstractMessage.getFieldString(deleteSettings.head.mstaSeq));
		logger.debug("发送:" + deleteSettings.toString());
		producerTemplate.sendBodyAndHeaders("direct:send", ExchangePattern.InOnly, deleteSettings.toBytes(), headers);
		
		String errorCode = (String) camelContext.createConsumerTemplate().receiveBody("direct:deleteSettings:" + concHardwareId + ":" +
				AbstractMessage.getFieldString(deleteSettings.head.mstaSeq));
		logger.debug("接收删除集中器设置响应:" + concHardwareId + ":" + AbstractMessage.getFieldString(deleteSettings.head.mstaSeq));
		
		return errorCode;
		
	}

}
