package com.ymsino.esb.comm.routers;

import org.apache.camel.builder.RouteBuilder;

public class Routes extends RouteBuilder {

    @Override
    public void configure() throws Exception {

    	int[] port = {8001, 8002, 8003};
		for(int i = 0; i < port.length; i++){
			from("mina2:tcp://0.0.0.0:" + port[i] + "?codec=#hyCodec").to("bean:receiveMsgConsume?method=receive");
			from("jms:queue:test:1").to("bean:receiveMsgConsume?method=testResp");
			//from("mina2:tcp://0.0.0.0:" + port[i]).to("bean:loadWmManager?method=test");
			//from("mina2:tcp://0.0.0.0:" + port[i] + "?codec=#hyCodec&sync=true").to("bean:loadWmManager?method=test");
			//from("jms:queue:send" + port[i]).to("mina2:tcp://localhost:" + port[i] + "?textline=true");
		}
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
