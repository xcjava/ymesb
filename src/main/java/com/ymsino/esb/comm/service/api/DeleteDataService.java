package com.ymsino.esb.comm.service.api;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

@WebService
public interface DeleteDataService {

	/**
	 * 删除集中器历史数据
	 * @param concHardwareId
	 * @return
	 */
	@WSDLDocumentation("删除集中器历史数据")
	public String deleteData(@WebParam(name="concHardwareId")String concHardwareId);
	
}
