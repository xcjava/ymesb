package com.ymsino.esb.comm.service.api;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

import com.ymsino.esb.comm.vo.MeterDataVo;

@WebService
public interface TestMeterCodeService {

	/**
	 * 集中器实时召测表码
	 * @param concHardwareId	集中器逻辑地址
	 * @param waterMeterId		水表逻辑地址
	 * @param waterMeterSn		水表对应集中器序号
	 * @return
	 */
	@WSDLDocumentation("集中器实时召测表码")
	public MeterDataVo testMeterCode(
			@WebParam(name="concHardwareId")String concHardwareId, 
			@WebParam(name="waterMeterId")String waterMeterId, 
			@WebParam(name="waterMeterSn")Integer waterMeterSn);
	
}
