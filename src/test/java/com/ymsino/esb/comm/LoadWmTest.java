package com.ymsino.esb.comm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.xcjava.base.dataMapping.JsonMapping;
import com.ymsino.esb.comm.service.api.LoadWmService;
import com.ymsino.esb.comm.service.impl.LoadWmServiceImpl;
import com.ymsino.esb.comm.vo.MeterSnVo;

public class LoadWmTest {

	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/test/applicationContext_comm_ws.xml");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		LoadWmService loadWmService = (LoadWmService) applicationContext.getBean("loadWmService");
		//System.out.println(loadWmService.loadWm("00014180"));
		
		List<MeterSnVo> result = loadWmService.readWaterMeterSn("30014180", 1, 15);
		for(MeterSnVo item : result){
			System.out.println(JsonMapping.obj2json(item));
		}
	}
}
