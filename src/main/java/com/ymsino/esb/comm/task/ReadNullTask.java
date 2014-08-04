package com.ymsino.esb.comm.task;

import java.util.Date;
import java.util.List;

import com.gmail.xcjava.base.date.DateUtil;
import com.ymsino.esb.archives.service.api.ConcentratorService;
import com.ymsino.esb.archives.vo.ConcentratorReturn;
import com.ymsino.esb.data.domain.FreezeDataManager;

public class ReadNullTask {

	ConcentratorService concentratorService;
	FreezeDataManager freezeDataManager;
	public void setConcentratorService(ConcentratorService concentratorService) {
		this.concentratorService = concentratorService;
	}
	public void setFreezeDataManager(FreezeDataManager freezeDataManager) {
		this.freezeDataManager = freezeDataManager;
	}


	public void exec(){
		
		String freezeDateStr = DateUtil.format(new Date(), "yyMMdd");
		
		List<ConcentratorReturn> list = concentratorService.getListpager(null, 0, Integer.MAX_VALUE);
		for(ConcentratorReturn item : list){
			freezeDataManager.initNullFreezeData(item.getHardwareId(), freezeDateStr);
		}
		
	}
}
