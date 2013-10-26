package com.ymsino.esb.comm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.xcjava.base.dataMapping.JsonMapping;
import com.ymsino.esb.comm.service.api.DeleteDataService;
import com.ymsino.esb.comm.service.api.LoadWmService;
import com.ymsino.esb.comm.service.api.ReadDataService;
import com.ymsino.esb.comm.service.impl.LoadWmServiceImpl;
import com.ymsino.esb.comm.vo.MeterDataVo;

public class DeleteDataTest {

	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/test/applicationContext_comm_ws.xml");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		DeleteDataService deleteDataService = (DeleteDataService) applicationContext.getBean("deleteDataService");
		
		System.out.println(deleteDataService.deleteData("00014180"));
		
	}
}
