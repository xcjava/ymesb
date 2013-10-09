package com.ymsino.esb.comm.service.api;

import java.util.Map;

public interface LoadWmService {

	/**
	 * 读取集中器水表参数
	 * @param concHardwareId	集中器逻辑地址
	 * @param wmSn				开始水表编号
	 * @param count				连续数量
	 * @return	水表序号和水表号的键值对
	 */
	public Map<String, String> readWaterMeterSn(String concHardwareId, Integer wmSn, Integer count);
	
	/**
	 * 加载集中器水表参数
	 * @param concHardwareId	集中器逻辑地址
	 * @param map				水表序号和水表号的键值对
	 * @param optType			操作类型
	 * @return	错误代码
	 */
	public String writeWaterMeterSn(String concHardwareId, Map<String, String> map, String optType);
	
	public void test() throws InterruptedException;
	
}
