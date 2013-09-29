package com.ymsino.esb.comm.task;

import java.util.Date;
import java.util.List;

import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;

public class CheckActTask {

	private static final long ACT_TIMEOUT = 1000 * 60 * 3;
	
	public void checkAct(){
		
		List<String> idList = ConcentratorOnLine.getAllId();
		if(idList == null || idList.size() < 1){
			return;
		}
		
		for(String id : idList){
			Long actTimestamp = ConcentratorOnLine.getActTimestamp(id);
			if(new Date().getTime() - actTimestamp > ACT_TIMEOUT){
				ConcentratorOnLine.close(id, true);
			}
		}
	}
	
}
