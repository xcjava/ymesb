package com.ymsino.esb.comm.service.impl;

import org.apache.camel.Body;
import org.apache.camel.Consume;
import org.apache.camel.Header;
import org.apache.mina.core.session.IoSession;

public class SendMsgConsume {

	@Consume(uri = "jms:queue:send")
	public void send(@Body Object vo, @Header("concentratorId") String id) {
		
		IoSession session = ConcentratorOnLine.getIoSession(id);
		if(session == null)
			return;
		session.write(vo);
		
	}
	
}
