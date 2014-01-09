package com.ymsino.esb.comm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.xcjava.base.dataMapping.JsonMapping;
import com.ymsino.esb.comm.service.api.ConClockService;
import com.ymsino.esb.comm.service.api.LoadWmService;
import com.ymsino.esb.comm.service.api.ReadDataService;
import com.ymsino.esb.comm.service.impl.LoadWmServiceImpl;
import com.ymsino.esb.comm.vo.MeterDataVo;

public class ConClockTest {

	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/test/applicationContext_comm_ws.xml");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		ConClockService conClockService = (ConClockService) applicationContext.getBean("conClockService");
		
		System.out.println(conClockService.setupClock("30014180", "131026203156"));
		
		System.out.println(conClockService.readClock("30014180"));

	}
}
