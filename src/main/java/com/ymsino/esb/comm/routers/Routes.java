package com.ymsino.esb.comm.routers;

import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmail.xcjava.base.io.PropertyReader;

public class Routes extends RouteBuilder {

	private Logger logger = Logger.getLogger(Routes.class);
	
    @Override
    public void configure() throws Exception {

    	String ports = PropertyReader.getProperties("config.properties").getProperty("protocol.port");
    	if(StringUtils.isEmpty(ports)){
    		logger.info("没有启动集中器端口监听");
    	}
    	
    	String[] port = ports.split(",");
    	
		for(int i = 0; i < port.length; i++){
			//from("mina2:tcp://0.0.0.0:" + port[i] + "?codec=#bytesCodec").to("bean:receiveMsgConsume?method=receive");
			//from("netty:tcp://0.0.0.0:" + port[i] + "?encoder=#nettyEncoder&decoder=#nettyDecoder&sync=true").to("bean:receiveMsgConsume?method=receive");
			from("netty:tcp://0.0.0.0:" + port[i] + "?encoder=#nettyEncoder&decoder=#nettyDecoder&sync=false").to("bean:receiveMsgConsume?method=receive");
			
			//from("netty:tcp://0.0.0.0:" + port[i] + "?sync=true").to("bean:receiveMsgConsume?method=receive");
			logger.info("启动集中器端口监听:" + port[i]);
			//from("jms:queue:test:1").to("bean:receiveMsgConsume?method=testResp");
			//from("mina2:tcp://0.0.0.0:" + port[i]).to("bean:loadWmManager?method=test");
			//from("mina2:tcp://0.0.0.0:" + port[i] + "?codec=#hyCodec&sync=true").to("bean:loadWmManager?method=test");
			//from("jms:queue:send" + port[i]).to("mina2:tcp://localhost:" + port[i] + "?textline=true");
		}
		//from("netty:tcp://0.0.0.0:8888?textline=true").to("bean:receiveMsgConsume?method=testResp");
		//from("mina2:tcp://0.0.0.0:8004?sync=true,allowDefaultCodec=true").to("bean:loadWmManager?method=testObject");
		//from("mina2:tcp://0.0.0.0:8005?textline=true").to("bean:loadWmManager?method=testText");
		
		//from("mina2:tcp://0.0.0.0:8004").to("bean:loadWmManager?method=testObject");
		//from("mina2:tcp://0.0.0.0:8005").to("bean:loadWmManager?method=testText");
		
		/*
		from("jms:queue:send").process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				
			}
		});
		 */

    }

}
// END SNIPPET: e1
