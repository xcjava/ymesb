package com.ymsino.esb.comm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.ymsino.esb.comm.service.api.LoadWmService;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.LoadWm;
import com.ymsino.esb.protocol.strutc.ReadParam;
import com.ymsino.esb.protocol.strutc.ReadParamResp;
import com.ymsino.esb.protocol.strutc.ReadParamRespItem;

public class LoadWmServiceImpl implements LoadWmService {

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
	public Map<String, String> readWaterMeterSn(String concHardwareId,
			Integer wmSn, Integer count) {
		
		ReadParam readParam = new ReadParam();
		readParam.head.rtua = AbstractMessage.initField(concHardwareId, readParam.head.rtua.length);
		readParam.startWaterMeterSn = AbstractMessage.initField(wmSn.toString(), readParam.startWaterMeterSn.length);
		readParam.totalMeterNum = AbstractMessage.initField(count.toString(), readParam.totalMeterNum.length);
		
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(readParam.head.rtua));
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, readParam.toBytes(), headers);
		
		byte[] bytes = (byte[]) camelContext.createConsumerTemplate().receiveBody("jms:queue:readWaterMeterSn:" + concHardwareId);
		ReadParamResp resp = new ReadParamResp(bytes);
		Map<String, String> map = new HashMap<String, String>();
		
		for(ReadParamRespItem item : resp.readParamRespItem){
			if(!AbstractMessage.getFieldString(item.waterMeterSn).equals("FFFF")){
				map.put(Integer.valueOf(AbstractMessage.getFieldString(item.waterMeterSn)).toString(), AbstractMessage.getFieldString(item.waterMeterId));
			}
		}
		
		return map;
	}

	@Override
	public boolean writeWaterMeterSn(String concHardwareId,
			Map<String, String> map, String optType) {
		
		LoadWm loadWm = new LoadWm();
		loadWm.head.rtua = AbstractMessage.initField(concHardwareId, loadWm.head.rtua.length);
		loadWm.password = AbstractMessage.initField("000000", loadWm.password.length);
		loadWm.optType = AbstractMessage.initField(optType, loadWm.optType.length);
		
		int i = 0;
		
		for(Map.Entry<String, String> entry : map.entrySet())   
		{   
			loadWm.loadWmItem[i].waterMeterSn = AbstractMessage.initField(entry.getKey(), loadWm.loadWmItem[i].waterMeterSn.length);
			loadWm.loadWmItem[i].waterMeterId = AbstractMessage.initField(entry.getValue(), loadWm.loadWmItem[i].waterMeterId.length);
			i++;
		}
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(loadWm.head.rtua));
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, loadWm.toBytes(), headers);
		
		return true;
	}
	
	private int count = 0;
	@Override
	public void test() throws InterruptedException {
		
		/*System.out.print("生产1:");
		
		ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate();
		try {
			consumerTemplate.start();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}*/
		
		
		producerTemplate.sendBody("jms:queue:test:1", "你的名字叫啥?");
		Thread.sleep(10000);
		
		String name = (String) camelContext.createConsumerTemplate().receiveBody("jms:queue:test:2");
		//String name = (String) consumerTemplate.receiveBody("jms:queue:test:2");
		System.out.println(count++ + ":" + name);
		
		/*String name = (String) consumerTemplate.receiveBody("jms:queue:test:2");
		System.out.print(name);
		
		try {
			consumerTemplate.stop();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}*/
		
		
	}

}
