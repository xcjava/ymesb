package com.ymsino.esb.protocol;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import com.gmail.xcjava.base.math.DataConverter;
import com.gmail.xcjava.base.str.ByteTool;
import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.LoginResp;
import com.ymsino.esb.protocol.strutc.Logout;
import com.ymsino.esb.protocol.strutc.PingResp;
import com.ymsino.esb.protocol.strutc.ReadData;
import com.ymsino.esb.protocol.strutc.ReadDataResp;

public class TestClientHandler extends IoHandlerAdapter {
	private static Logger logger = Logger.getLogger(TestClientHandler.class);
	Scheduler sched;
	
	public TestClientHandler() throws SchedulerException {
		sched = new org.quartz.impl.StdSchedulerFactory().getScheduler();
		sched.start();
	}
	
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		
	}
	
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		
		if (message instanceof byte[]){
			byte[] bytes = (byte[])message;
			for(int i = 0; i < bytes.length; i++){
				System.out.print(DataConverter.bytesToHexString(ByteTool.subByte(bytes, i, 1)) + "|");
			}
			System.out.println(1111111);
			
		}else{
			logger.info("未知请求！");
		}
		
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		logger.error("客户端发生异常...", cause);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		sched.deleteJob("ping", session.getId() + "");
	}

}
