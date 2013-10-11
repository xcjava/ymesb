package com.ymsino.esb.comm.service.api;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

@WebService
public interface DeleteSettingsService {

	/**
	 * 删除集中器配置信息
	 * @param concHardwareId	集中器逻辑地址
	 * @return
	 */
	@WSDLDocumentation("删除集中器配置信息")
	public String deleteSettings(@WebParam(name="concHardwareId")String concHardwareId);
	
}
