package com.ymsino.esb.comm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.ymsino.esb.comm.service.api.ReadDataService;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.ReadData;
import com.ymsino.esb.protocol.strutc.ReadDataResp;
import com.ymsino.esb.protocol.strutc.ReadDataRespItem;

public class ReadDataServiceImpl implements ReadDataService {

	private ProducerTemplate producerTemplate;
	private ConsumerTemplate consumerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	public void setConsumerTemplate(ConsumerTemplate consumerTemplate) {
		this.consumerTemplate = consumerTemplate;
	}
	
	@Override
	public Map<String, String> readDataByDate(String concHardwareId, Integer wmSn, Integer count, String dateStr) {
		
		ReadData req = new ReadData();
		req.head.rtua = AbstractMessage.initField(concHardwareId, req.head.rtua.length);
		req.options = AbstractMessage.initField("0140", req.options.length);//日冻结
		req.startWaterMeterSn = AbstractMessage.initField(wmSn.toString(), req.startWaterMeterSn.length);
		req.totalMeterNum = AbstractMessage.initField(count.toString(), req.totalMeterNum.length);
		req.readYear = AbstractMessage.initField(dateStr.substring(0, 2), req.readYear.length);
		req.readMonth = AbstractMessage.initField(dateStr.substring(2, 4), req.readMonth.length);
		req.readDay = AbstractMessage.initField(dateStr.substring(4, 6), req.readDay.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(req.head.rtua));
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, req.toBytes(), headers);
		
		byte[] bytes = (byte[]) consumerTemplate.receiveBody("jms:queue:readData:" + concHardwareId);
		ReadDataResp resp = new ReadDataResp(bytes);
		Map<String, String> map = new HashMap<String, String>();
		for(ReadDataRespItem item : resp.readDataRespItem){
			if(!AbstractMessage.getFieldString(item.meterId).equals("FFFFFFFFFFFF")){
				map.put(Integer.valueOf(AbstractMessage.getFieldString(item.meterId)).toString(), AbstractMessage.getFieldString(item.meterData));
			}
		}
		
		return map;
	}

}
