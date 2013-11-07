package com.ymsino.esb.comm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ymsino.esb.comm.service.api.DeleteDataService;
import com.ymsino.esb.comm.service.api.DeleteSettingsService;

public class DeleteSettingsTest {

	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/test/applicationContext_comm_ws.xml");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		DeleteSettingsService deleteSettingsService = (DeleteSettingsService) applicationContext.getBean("deleteSettingsService");
		
		//System.out.println(conClockService.setupClock("00014180", "131026203156"));
		
		System.out.println(deleteSettingsService.deleteSettings("00014180"));

	}
	
}
