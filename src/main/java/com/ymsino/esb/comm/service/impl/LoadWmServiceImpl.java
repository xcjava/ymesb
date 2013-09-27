package com.ymsino.esb.comm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.ymsino.esb.comm.service.api.LoadWmService;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.LoadWm;

public class LoadWmServiceImpl implements LoadWmService {

	private ProducerTemplate camelTemplate;
	public void setCamelTemplate(ProducerTemplate camelTemplate) {
		this.camelTemplate = camelTemplate;
	}

	@Override
	public Map<String, String> readWaterMeterSn(String concHardwareId,
			Integer wmSn, Integer count) {
		// TODO Auto-generated method stub
		return null;
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
		camelTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, loadWm.toBytes(), headers);
		
		return true;
	}

}
