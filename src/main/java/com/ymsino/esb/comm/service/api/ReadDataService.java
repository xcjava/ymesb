package com.ymsino.esb.comm.service.api;

import java.util.Map;

public interface ReadDataService {

	/**
	 * 读日冻结数据
	 * @param concHardwareId	集中器逻辑地址
	 * @param wmSn				水表递增序号
	 * @param count				连续个数
	 * @param dateStr			日期,格式YYMMDD
	 * @return 水表号和水表度数的键值对
	 */
	public Map<String, String> readDataByDate(String concHardwareId, Integer wmSn, Integer count, String dateStr);
	
}
