package com.ymsino.esb.comm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.ymsino.esb.comm.service.api.RestoreSettingService;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.RestoreSettings;

public class RestoreSettingsServiceImpl implements RestoreSettingService {

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
	public String restoreSettings(String concHardwareId) {
		
		RestoreSettings restoreSettings = new RestoreSettings();
		restoreSettings.head.rtua = AbstractMessage.initField(concHardwareId, restoreSettings.head.rtua.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(restoreSettings.head.rtua));
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, restoreSettings.toBytes(), headers);
		
		String errorCode = (String) camelContext.createConsumerTemplate().receiveBody("jms:queue:restoreSettings:" + concHardwareId);
		return errorCode;
		
	}

}