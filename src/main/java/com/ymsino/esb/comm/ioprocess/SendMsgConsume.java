package com.ymsino.esb.comm.ioprocess;

import org.apache.camel.Body;
import org.apache.camel.Consume;
import org.apache.camel.Header;
import org.apache.mina.core.session.IoSession;

public class SendMsgConsume {

	//jms:queue:
	@Consume(uri = "direct:send")
	public void send(@Body byte[] vo, @Header("concentratorId") String id) {
		
		IoSession session = ConcentratorOnLine.getIoSession(id);
		if(session == null){
			System.out.println("集中器会话中断,无法发送");
			return;
		}
		session.write(vo);
		
	}
	
}
