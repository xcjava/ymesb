package com.ymsino.esb.comm.ioprocess;

import org.apache.camel.Body;
import org.apache.camel.Consume;
import org.apache.camel.Header;
import org.jboss.netty.channel.Channel;

public class SendMsgConsume {

	private ConcentratorOnLine concentratorOnLine;
	public void setConcentratorOnLine(ConcentratorOnLine concentratorOnLine) {
		this.concentratorOnLine = concentratorOnLine;
	}


	//direct:
	@Consume(uri = "jms:queue:send")
	public void send(@Body byte[] vo, @Header("concentratorId") String id) {
		
		Channel session = concentratorOnLine.getIoSession(id);
		if(session == null){
			System.out.println("集中器会话中断,无法发送");
			return;
		}
		session.write(vo);
		
	}
	
	/*public synchronized static void sendMsg(byte[] vo, String id) {
		
		Channel session = ConcentratorOnLine.getIoSession(id);
		
		if(session == null){
			System.out.println("集中器会话中断,无法发送");
			return;
		}
		session.write(vo);
		
	}*/
	
}
