package com.ymsino.esb.comm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ymsino.esb.comm.service.api.TestMeterCodeService;

public class TestMeterCodeTest {

	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/test/applicationContext_comm_ws.xml");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		TestMeterCodeService testMeterCodeService = (TestMeterCodeService) applicationContext.getBean("testMeterCodeService");
		
		//System.out.println(conClockService.setupClock("00014180", "131026203156"));
		
		System.out.println(testMeterCodeService.testMeterCode("00014180", "000000000001", 1));

	}
	
}
