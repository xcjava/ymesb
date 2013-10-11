package com.ymsino.esb.comm.service.api;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

@WebService
public interface ConDebugService {

	/**
	 * 集中器调试
	 * @param concHardwareId
	 * @param waterMeterId
	 * @param waterMeterSn
	 * @return
	 */
	@WSDLDocumentation("集中器调试")
	public String debug(@WebParam(name="concHardwareId")String concHardwareId, 
			@WebParam(name="waterMeterId")String waterMeterId, 
			@WebParam(name="waterMeterSn")Integer waterMeterSn);
	
}
