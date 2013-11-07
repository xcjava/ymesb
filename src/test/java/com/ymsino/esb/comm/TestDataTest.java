package com.ymsino.esb.comm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ymsino.esb.comm.service.api.TestDataService;

public class TestDataTest {

	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/test/applicationContext_comm_ws.xml");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		TestDataService testDataService = (TestDataService) applicationContext.getBean("testDataService");
		
		//System.out.println(conClockService.setupClock("00014180", "131026203156"));
		
		System.out.println(testDataService.testData("00014180", "000000000001", 1));

	}
	
}
