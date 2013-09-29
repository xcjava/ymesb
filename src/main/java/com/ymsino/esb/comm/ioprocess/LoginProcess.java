package com.ymsino.esb.comm.ioprocess;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.strutc.Login;
import com.ymsino.esb.protocol.strutc.LoginResp;

public class LoginProcess {

	private ProducerTemplate camelTemplate;
	public void setCamelTemplate(ProducerTemplate camelTemplate) {
		this.camelTemplate = camelTemplate;
	}
	
	public void process(Login login){
		
		if(AbstractMessage.getFieldString(login.password).equals("000000")){
			LoginResp resp = new LoginResp();
			resp.head.rtua = AbstractMessage.initField(AbstractMessage.getFieldString(login.head.rtua), login.head.rtua.length);
			
			Map<String, Object> headers = new HashMap<String, Object>();
			headers.put("concentratorId", AbstractMessage.getFieldString(resp.head.rtua));
			camelTemplate.sendBodyAndHeaders("jms:queue:send", ExchangePattern.InOnly, resp.toBytes(), headers);
		}
		
	}
	
}
