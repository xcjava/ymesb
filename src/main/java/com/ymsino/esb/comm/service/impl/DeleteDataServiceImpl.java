package com.ymsino.esb.comm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;
import com.ymsino.esb.comm.service.api.DeleteDataService;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.DeleteData;

public class DeleteDataServiceImpl implements DeleteDataService {

	private Logger logger = Logger.getLogger(DeleteDataServiceImpl.class);
	
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
	public String deleteData(String concHardwareId) {

		DeleteData deleteData = new DeleteData();
		deleteData.head.rtua = AbstractMessage.initField(concHardwareId, deleteData.head.rtua.length);
		deleteData.head.mstaSeq = AbstractMessage.initField(ConcentratorOnLine.getNextMstaSeq(concHardwareId), deleteData.head.mstaSeq.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(deleteData.head.rtua));
		
		logger.debug("发送删除历史数据消息:" + concHardwareId + ":" + AbstractMessage.getFieldString(deleteData.head.mstaSeq));
		logger.debug("发送:" + deleteData.toString());
		//producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, deleteData.toBytes(), headers);
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, deleteData.toBytes(), headers);
		
		String errorCode = (String) camelContext.createConsumerTemplate().receiveBody("jms:queue:deleteData:" + 
								concHardwareId + ":" +
								AbstractMessage.getFieldString(deleteData.head.mstaSeq));
		logger.debug("接收删除历史数据响应:" + concHardwareId + ":" + AbstractMessage.getFieldString(deleteData.head.mstaSeq));
		
		return errorCode;
	}

}
