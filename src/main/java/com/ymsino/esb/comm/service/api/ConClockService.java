package com.ymsino.esb.comm.service.api;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

@WebService
public interface ConClockService {

	/**
	 * 读取集中器时钟
	 * @param concHardwareId
	 * @return YYMMDDHHMMSS
	 */
	@WSDLDocumentation("读取集中器时钟")
	public String readClock(@WebParam(name="concHardwareId")String concHardwareId);
	
	/**
	 * 设置集中器时钟
	 * @param concHardwareId
	 * @param dateStr	格式:YYMMDDHHMMSS
	 * @return
	 */
	@WSDLDocumentation("设置集中器时钟")
	public String setupClock(@WebParam(name="concHardwareId")String concHardwareId, 
			@WebParam(name="dateStr")String dateStr);
	
}
