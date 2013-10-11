package com.ymsino.esb.comm.service.api;

import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

@WebService
public interface ReadDataService {

	/**
	 * 读日冻结数据
	 * @param concHardwareId	集中器逻辑地址
	 * @param wmSn				水表递增序号
	 * @param count				连续个数
	 * @param dateStr			日期,格式YYMMDD
	 * @return 水表号和水表度数的键值对
	 */
	@WSDLDocumentation("读日冻结数据")
	public Map<String, String> readDataByDate(@WebParam(name="concHardwareId")String concHardwareId, 
			@WebParam(name="wmSn")Integer wmSn, 
			@WebParam(name="count")Integer count, 
			@WebParam(name="dateStr")String dateStr);
	
}
