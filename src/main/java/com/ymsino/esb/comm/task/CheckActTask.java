package com.ymsino.esb.comm.task;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmail.xcjava.base.io.PropertyReader;
import com.ymsino.esb.comm.ioprocess.ConcentratorOnLine;

public class CheckActTask {

	private Logger logger = Logger.getLogger(CheckActTask.class);
	Long ACT_TIMEOUT = 1000 * 60 * Long.valueOf(PropertyReader.getProperties("config.properties").getProperty("protocol.actTimeout"));
	
	private ConcentratorOnLine concentratorOnLine;
	public void setConcentratorOnLine(ConcentratorOnLine concentratorOnLine) {
		this.concentratorOnLine = concentratorOnLine;
	}
	
	public void checkAct(){
		
		List<String> idList = concentratorOnLine.getAllId();
		if(idList == null || idList.size() < 1){
			return;
		}
		
		for(String id : idList){
			Long actTimestamp = concentratorOnLine.getActTimestamp(id);
			if(new Date().getTime() - actTimestamp > ACT_TIMEOUT){
				logger.info("长时间无收到心跳,断开连接:" + id);
				concentratorOnLine.close(id);
			}else{
				logger.debug("链路检查,未超时:" + id);
			}
		}
	}
	
}
