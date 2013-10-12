package com.ymsino.esb.comm.service.api;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

@WebService
public interface LoadWmService {

	/**
	 * 读取集中器水表参数
	 * @param concHardwareId	集中器逻辑地址
	 * @param wmSn				开始水表编号
	 * @param count				连续数量
	 * @return	水表序号和水表号的键值对
	 */
	@WSDLDocumentation("读取集中器水表参数")
	public HashMap<String, String> readWaterMeterSn(@WebParam(name="concHardwareId")String concHardwareId, 
			@WebParam(name="wmSn")Integer wmSn, 
			@WebParam(name="count")Integer count);
	
	/**
	 * 加载集中器水表参数
	 * @param concHardwareId	集中器逻辑地址
	 * @param map				水表序号和水表号的键值对
	 * @param optType			操作类型
	 * @return	错误代码,00表示成功
	
	@WSDLDocumentation("加载集中器水表参数")
	public String writeWaterMeterSn(@WebParam(name="concHardwareId")String concHardwareId, 
			@WebParam(name="map")Map<String, String> map, 
			@WebParam(name="optType")String optType);
	 */
	
	/**
	 * 加载集中器水表参数
	 * @param concHardwareId	集中器逻辑地址
	 * @return
	 */
	@WSDLDocumentation("加载集中器水表参数")
	public Boolean loadWm(@WebParam(name="concHardwareId")String concHardwareId);
	
	public void test() throws InterruptedException;
	
}
