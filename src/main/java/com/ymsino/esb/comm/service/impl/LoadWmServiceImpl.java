package com.ymsino.esb.comm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.archives.model.WaterMeter;
import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;
import com.ymsino.esb.comm.service.api.LoadWmService;
import com.ymsino.esb.comm.vo.MeterSnVo;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.LoadWm;
import com.ymsino.esb.protocol.strutc.LoadWmItem;
import com.ymsino.esb.protocol.strutc.ReadParam;
import com.ymsino.esb.protocol.strutc.ReadParamResp;
import com.ymsino.esb.protocol.strutc.ReadParamRespItem;

public class LoadWmServiceImpl implements LoadWmService {

	private Logger logger = Logger.getLogger(LoadWmServiceImpl.class);
	
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

	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}

	private ConcentratorOnLine concentratorOnLine;
	public void setConcentratorOnLine(ConcentratorOnLine concentratorOnLine) {
		this.concentratorOnLine = concentratorOnLine;
	}
	
	@Override
	public List<MeterSnVo> readWaterMeterSn(String concHardwareId,
			Integer wmSn, Integer count) {
		
		if(count < 1)
			return null;
		
		List<MeterSnVo> list = new ArrayList<MeterSnVo>();
		int sendTime = wmSn/10 + 1;
		int start = 0;
		
		while(start < sendTime){
		
			int startWaterMeterSn = wmSn + start * 10;
			//int totalMeterNum = start + 1 == sendTime ? wmSn % 10 : 10;
			int totalMeterNum = 10;
			
			ReadParam readParam = new ReadParam();
			readParam.head.rtua = AbstractMessage.initField(concHardwareId, readParam.head.rtua.length);
			readParam.head.mstaSeq = AbstractMessage.initField(concentratorOnLine.getNextMstaSeq(concHardwareId), readParam.head.mstaSeq.length);
			readParam.startWaterMeterSn = AbstractMessage.initField(Integer.toHexString(startWaterMeterSn), readParam.startWaterMeterSn.length);
			readParam.totalMeterNum = AbstractMessage.initField(Integer.toHexString(totalMeterNum) + "", readParam.totalMeterNum.length);
			
			
			Map<String, Object> headers = new HashMap<String, Object>();
			headers.put("concentratorId", AbstractMessage.getFieldString(readParam.head.rtua));
			
			logger.debug("发送读取水表参数消息:" + concHardwareId + ":" + AbstractMessage.getFieldString(readParam.head.mstaSeq));
			logger.debug("发送:" + readParam.toString());
			producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, readParam.toBytes(), headers);
			
			byte[] bytes = (byte[]) camelContext.createConsumerTemplate().receiveBody("jms:queue:readWaterMeterSn:" + concHardwareId + ":" +
					AbstractMessage.getFieldString(readParam.head.mstaSeq));
			logger.debug("接收读取水表参数响应:" + concHardwareId + ":" + AbstractMessage.getFieldString(readParam.head.mstaSeq));
			
			ReadParamResp resp = new ReadParamResp(bytes);
			for(ReadParamRespItem item : resp.readParamRespItem){
				if(!AbstractMessage.getFieldString(item.waterMeterId).equals("FFFFFFFFFFFF")){
					MeterSnVo vo = new MeterSnVo();
					vo.setMeterSn(Integer.parseInt(AbstractMessage.getFieldString(item.waterMeterSn), 16));
					vo.setMeterId(AbstractMessage.getFieldString(item.waterMeterId));
					list.add(vo);
				}
			}
			start++;
		}
		return list;
	}

	/*@Override
	public String writeWaterMeterSn(String concHardwareId,
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
		
		String errorCode = (String) camelContext.createConsumerTemplate().receiveBody("jms:queue:loadWm:" + concHardwareId);
		return errorCode;
	}*/
	
	
	public Boolean loadWm(String concHardwareId){
		
		int sn = 0;
		this.commonHibernateDao.bulkUpdateDelete("update WaterMeter model set model.wmSn = null where concHardwareId = ?", concHardwareId);
		
		while(this.commonHibernateDao.countBy("select count(*) from WaterMeter model where model.wmSn = null and concHardwareId = ?", concHardwareId) > 0){

			String sql = "from WaterMeter model where model.concHardwareId = ?";
			List<Object> paramList = new ArrayList<Object>();
			paramList.add(concHardwareId);
			List<WaterMeter> list = this.commonHibernateDao.findBy(sql, paramList.toArray(), 0, 10);
			
			LoadWm loadWm = new LoadWm();
			loadWm.head.rtua = AbstractMessage.initField(concHardwareId, loadWm.head.rtua.length);
			loadWm.head.mstaSeq = AbstractMessage.initField(concentratorOnLine.getNextMstaSeq(concHardwareId), loadWm.head.mstaSeq.length);
			loadWm.password = AbstractMessage.initField("000000", loadWm.password.length);
			loadWm.optType = AbstractMessage.initField("00", loadWm.optType.length);
			
			for(int i = 0; i < list.size(); i++){
				sn++;
				
				WaterMeter item = list.get(i);
				loadWm.loadWmItem[i] = new LoadWmItem();
				loadWm.loadWmItem[i].waterMeterSn = AbstractMessage.initField(sn + "", loadWm.loadWmItem[i].waterMeterSn.length);
				loadWm.loadWmItem[i].waterMeterId = AbstractMessage.initField(item.getHardwareId(), loadWm.loadWmItem[i].waterMeterId.length);
			}
			
			Map<String, Object> headers = new HashMap<String, Object>();
			headers.put("concentratorId", AbstractMessage.getFieldString(loadWm.head.rtua));
			
			logger.debug("发送加载水表参数消息:" + concHardwareId + ":" + AbstractMessage.getFieldString(loadWm.head.mstaSeq));
			logger.debug("发送:" + loadWm.toString());
			producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, loadWm.toBytes(), headers);
			
			String errorCode = (String) camelContext.createConsumerTemplate().receiveBody("jms:queue:loadWm:" + concHardwareId + ":" +
					AbstractMessage.getFieldString(loadWm.head.mstaSeq));
			logger.debug("接收加载水表参数响应:" + concHardwareId + ":" + AbstractMessage.getFieldString(loadWm.head.mstaSeq));
			
			if(!errorCode.equals("00")){
				return Boolean.FALSE;
			}
			
			for(int i = 0; i < list.size(); i++){
				WaterMeter item = list.get(i);
				item.setWmSn(sn - list.size() + i + 1);
			}
			
			return Boolean.TRUE;
		}
		
		return Boolean.TRUE;
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
		/*ConcentratorOnLine.add("AAA");
		Long seq = ConcentratorOnLine.getNextSeq("AAA");
		System.out.print("获取序号" + seq);*/
		
		
		producerTemplate.sendBody("jms:queue:test:1", "你的名字叫啥?");
		//Thread.sleep(10000);
		
		
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
