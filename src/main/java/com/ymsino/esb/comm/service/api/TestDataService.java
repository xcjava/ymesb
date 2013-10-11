package com.ymsino.esb.comm.service.api;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

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
	public String testData(@WebParam(name="concHardwareId")String concHardwareId, 
			@WebParam(name="waterMeterId")String waterMeterId, 
			@WebParam(name="waterMeterSn")Integer waterMeterSn);
	
}
