package com.ymsino.esb.comm.service.api;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.ymsino.esb.comm.vo.MeterDataVo;

@WebService
public interface TestDataService {

	/**
	 * 集中器召测本机动态数据
	 * @param concHardwareId
	 * @param waterMeterId
	 * @param waterMeterSn
	 * @return
	 */
	@WSDLDocumentation("集中器召测本机动态数据")
	public MeterDataVo testData(@WebParam(name="concHardwareId")String concHardwareId, 
			@WebParam(name="waterMeterId")String waterMeterId, 
			@WebParam(name="waterMeterSn")Integer waterMeterSn);
	
}
