package com.ymsino.esb.comm.service.api;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

@WebService
public interface RestoreSettingService {

	/**
	 * 远程复位集中器
	 * @param concHardwareId	集中器逻辑地址
	 * @return
	 */
	@WSDLDocumentation("远程复位集中器")
	public String restoreSettings(@WebParam(name="concHardwareId")String concHardwareId);
	
}
