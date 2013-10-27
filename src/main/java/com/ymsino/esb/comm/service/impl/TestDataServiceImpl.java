package com.ymsino.esb.comm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.archives.model.WaterMeter;
import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;
import com.ymsino.esb.comm.service.api.TestDataService;
import com.ymsino.esb.comm.vo.MeterDataVo;
import com.ymsino.esb.data.domain.TestDynamicDataManager;
import com.ymsino.esb.data.model.TestDynamicData;
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
	
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	TestDynamicDataManager testDynamicDataManager;
	public void setTestDynamicDataManager(
			TestDynamicDataManager testDynamicDataManager) {
		this.testDynamicDataManager = testDynamicDataManager;
	}
	
	@Override
	public MeterDataVo testData(String concHardwareId, String waterMeterId, Integer waterMeterSn) {

		WaterMeter wm = (WaterMeter) this.commonHibernateDao.get(WaterMeter.class, waterMeterId);
		if(wm == null){
			logger.info(waterMeterId + "水表不存在");
		}
		
		TestData testData = new TestData();
		testData.head.rtua = AbstractMessage.initField(concHardwareId, testData.head.rtua.length);
		testData.head.mstaSeq = AbstractMessage.initField(ConcentratorOnLine.getNextMstaSeq(concHardwareId), testData.head.mstaSeq.length);
		testData.waterMeterId = AbstractMessage.initField(waterMeterId, testData.waterMeterId.length);
		testData.waterMeterSn = AbstractMessage.initField(waterMeterSn.toString(), testData.waterMeterSn.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(testData.head.rtua));
		
		logger.debug("发送集中器召测本机动态数据消息:" + concHardwareId + ":" + AbstractMessage.getFieldString(testData.head.mstaSeq));
		logger.debug("发送:" + testData.toString());
		producerTemplate.sendBodyAndHeaders("direct:send", ExchangePattern.InOnly, testData.toBytes(), headers);
		
		byte[] bytes = (byte[]) camelContext.createConsumerTemplate().receiveBody("direct:testData:" + concHardwareId + ":" +
				AbstractMessage.getFieldString(testData.head.mstaSeq));
		logger.debug("接收集中器召测本机动态数据响应:" + concHardwareId + ":" + AbstractMessage.getFieldString(testData.head.mstaSeq));
		
		TestDataResp resp = new TestDataResp(bytes);
		
		TestDynamicData tdd = new TestDynamicData();
		tdd.setBatteryVoltage(resp.getMeterDataVo().getBatteryVoltage());
		tdd.setChargingUnitId(wm.getChargingUnitId());
		tdd.setConcHardwareId(concHardwareId);
		tdd.setCreateTimestamp(new Date().getTime());
		tdd.setDataType(resp.getMeterDataVo().getDataType());
		tdd.setErrorStatus(resp.getMeterDataVo().getErrorStatus());
		tdd.setMagneticAttack(resp.getMeterDataVo().getMagneticAttack());
		tdd.setMeterHardwareId(waterMeterId);
		tdd.setMeterReading(resp.getMeterDataVo().getMeasure());
		tdd.setParentUnits(wm.getParentUnits());
		tdd.setReplyStatus(resp.getMeterDataVo().getReplyStatus());
		tdd.setUserId(wm.getUserId());
		tdd.setValveStatus(resp.getMeterDataVo().getValveStatus());
		testDynamicDataManager.save(tdd);
		
		
		MeterDataVo vo = new MeterDataVo();
		ObjectMapping.objMapping(resp.getMeterDataVo(), vo);
		vo.setReadDateStr(AbstractMessage.getFieldString(resp.dataDate));
		vo.setMeterId(AbstractMessage.getFieldString(resp.waterMeterId));
		return vo;
		
	}

}
