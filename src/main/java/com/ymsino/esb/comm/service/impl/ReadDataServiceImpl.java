package com.ymsino.esb.comm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.math.Arith;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.archives.model.WaterMeter;
import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;
import com.ymsino.esb.comm.service.api.ReadDataService;
import com.ymsino.esb.comm.vo.MeterDataVo;
import com.ymsino.esb.data.domain.FreezeDataManager;
import com.ymsino.esb.data.model.FreezeData;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.ReadData;
import com.ymsino.esb.protocol.strutc.ReadDataResp;
import com.ymsino.esb.protocol.strutc.ReadDataRespItem;

public class ReadDataServiceImpl implements ReadDataService {

	private Logger logger = Logger.getLogger(ReadDataServiceImpl.class);
	
	private ProducerTemplate producerTemplate;
	private ConsumerTemplate consumerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	public void setConsumerTemplate(ConsumerTemplate consumerTemplate) {
		this.consumerTemplate = consumerTemplate;
	}
	
	private CamelContext camelContext;
	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}
	
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	FreezeDataManager freezeDataManager;
	public void setFreezeDataManager(FreezeDataManager freezeDataManager) {
		this.freezeDataManager = freezeDataManager;
	}
	
	private ConcentratorOnLine concentratorOnLine;
	public void setConcentratorOnLine(ConcentratorOnLine concentratorOnLine) {
		this.concentratorOnLine = concentratorOnLine;
	}
	
	@Override
	public List<MeterDataVo> readDataByDate(String concHardwareId, Integer wmSn, Integer count, String dateStr) {
		
		ReadData req = new ReadData();
		req.head.rtua = AbstractMessage.initField(concHardwareId, req.head.rtua.length);
		req.head.mstaSeq = AbstractMessage.initField(concentratorOnLine.getNextMstaSeq(concHardwareId), req.head.mstaSeq.length);
		req.options = AbstractMessage.initField("0140", req.options.length);//日冻结
		req.startWaterMeterSn = AbstractMessage.initField(wmSn.toString(), req.startWaterMeterSn.length);
		req.totalMeterNum = AbstractMessage.initField(count.toString(), req.totalMeterNum.length);
		req.readYear = AbstractMessage.initField(dateStr.substring(0, 2), req.readYear.length);
		req.readMonth = AbstractMessage.initField(dateStr.substring(2, 4), req.readMonth.length);
		req.readDay = AbstractMessage.initField(dateStr.substring(4, 6), req.readDay.length);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("concentratorId", AbstractMessage.getFieldString(req.head.rtua));
		
		logger.debug("发送读日冻结消息:" + concHardwareId + ":" + AbstractMessage.getFieldString(req.head.mstaSeq));
		logger.debug("发送:" + req.toString());
		producerTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, req.toBytes(), headers);
		
		byte[] bytes = (byte[]) consumerTemplate.receiveBody("jms:queue:readData:" + concHardwareId + ":" +
				AbstractMessage.getFieldString(req.head.mstaSeq));
		logger.debug("接收读日冻结响应:" + concHardwareId + ":" + AbstractMessage.getFieldString(req.head.mstaSeq));
		
		ReadDataResp resp = new ReadDataResp(bytes);
		List<MeterDataVo> resultList = new ArrayList<MeterDataVo>();
		for(ReadDataRespItem item : resp.readDataRespItem){
			if(!AbstractMessage.getFieldString(item.meterId).equals("FFFFFFFFFFFF")){
				//map.put(Integer.valueOf(AbstractMessage.getFieldString(item.meterId)).toString(), AbstractMessage.getFieldString(item.meterData));
				
				MeterDataVo vo = new MeterDataVo();
				ObjectMapping.objMapping(item.getMeterDataVo(), vo);
				vo.setReadDateStr(AbstractMessage.getFieldString(item.readDate));
				vo.setMeterId(AbstractMessage.getFieldString(item.meterId));
				
				WaterMeter wm = (WaterMeter) this.commonHibernateDao.get(WaterMeter.class, AbstractMessage.getFieldString(item.meterId));
				if(wm == null)
					continue;
				
				FreezeData freezeData = new FreezeData();
				freezeData = new FreezeData();
				freezeData.setBatteryVoltage(item.getMeterDataVo().getBatteryVoltage());
				freezeData.setChargingUnitId(wm.getChargingUnitId());
				freezeData.setConcHardwareId(concHardwareId);
				freezeData.setCreateTimestamp(new Date().getTime());
				freezeData.setDataType(item.getMeterDataVo().getDataType());
				freezeData.setErrorStatus(item.getMeterDataVo().getErrorStatus());
				freezeData.setFreezeDateStr(AbstractMessage.getFieldString(item.readDate));
				freezeData.setMagneticAttack(item.getMeterDataVo().getMagneticAttack());
				freezeData.setMeterHardwareId(AbstractMessage.getFieldString(item.meterId));
				if("1".equals(wm.getDataType())){
					freezeData.setMeterReading(Arith.div(item.getMeterDataVo().getMeasure(), wm.getConstant(), 1));
					vo.setMeasure(Arith.div(item.getMeterDataVo().getMeasure(), wm.getConstant(), 1));
				}else{
					freezeData.setMeterReading((float) item.getMeterDataVo().getMeasure());
					vo.setMeasure((float) item.getMeterDataVo().getMeasure());
				}
				freezeData.setParentUnits(wm.getParentUnits());
				freezeData.setReplyStatus(item.getMeterDataVo().getReplyStatus());
				freezeData.setUserId(wm.getUserId());
				freezeData.setValveStatus(item.getMeterDataVo().getValveStatus());
				this.freezeDataManager.insertOrUpdate(freezeData);
				
				resultList.add(vo);
			}
		}
		
		return resultList;
	}

}
