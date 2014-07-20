package com.ymsino.esb.protocol;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.Ping;


public class ClientPingTask implements Job{

public static Logger logger = Logger.getLogger(ClientPingTask.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		IoSession session = (IoSession) dataMap.get("session");
		Ping ping = new Ping();
		ping.head.mstaSeq[0] = "12";
		ping.head.mstaSeq[1] = "34";
		ping.head.rtua = AbstractMessage.initField("00014180", ping.head.rtua.length);
		session.write(ping);
	}
	
}
