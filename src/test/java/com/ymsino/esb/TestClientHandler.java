package com.ymsino.esb;

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
		
		if (message instanceof AbstractMessage){
			AbstractMessage am = (AbstractMessage) message;
			
			if(AbstractMessage.getControlCode(am.toBytes()).equals("21")){
				LoginResp loginResp = (LoginResp) am;
				session.setAttribute("isLogin", Boolean.TRUE);
				
				JobDataMap jdm = new JobDataMap();
				jdm.put("session", session);
				//创建心跳检查任务
				JobDetail pingJob = new JobDetail("ping", session.getId() + "", ClientPingTask.class);
				pingJob.setJobDataMap(jdm);
				//心跳检查任务,每分钟检查一次
				sched.scheduleJob(pingJob, new CronTrigger("ping", session.getId() + "", "0 * * * * ?"));
				
			}else if(AbstractMessage.getControlCode(am.toBytes()).equals("22")){
				Logout logout = (Logout) am;
				session.setAttribute("isLogin", Boolean.FALSE);
			}else if(AbstractMessage.getControlCode(am.toBytes()).equals("24")){
				PingResp pingResp = (PingResp) am;
				session.setAttribute("pingTime", new Date());
			}else if(AbstractMessage.getControlCode(am.toBytes()).equals("12")){
				ReadData readData = (ReadData) am;
				List<String[][]> list = new ArrayList<String[][]>();
				ReadDataResp readDataResp = new ReadDataResp();
				readDataResp.startWaterMeterSn = readData.startWaterMeterSn;
				readDataResp.head.mstaSeq = readData.head.mstaSeq;
				readDataResp.options = readData.options;
				readDataResp.readDay = readData.readDay;System.out.println(AbstractMessage.getFieldString(readData.readDay));
				readDataResp.readMonth = readData.readMonth;System.out.println(AbstractMessage.getFieldString(readData.readMonth));
				readDataResp.readYear = readData.readYear;System.out.println(AbstractMessage.getFieldString(readData.readYear));
				readDataResp.head.rtua = readData.head.rtua;
				//readDataResp.meterData = AbstractMessage.initField("12345", readDataResp.meterData.length);
				//readDataResp.meterId = AbstractMessage.initField("112233445566", readDataResp.meterId.length);;
				session.write(readDataResp);
			}
			
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
