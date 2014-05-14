package com.ymsino.esb.comm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.xcjava.base.dataMapping.JsonMapping;
import com.ymsino.esb.comm.service.api.LoadWmService;
import com.ymsino.esb.comm.service.api.ReadDataService;
import com.ymsino.esb.comm.service.impl.LoadWmServiceImpl;
import com.ymsino.esb.comm.vo.MeterDataVo;

public class ReadDataTest {

	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/test/applicationContext_comm_ws.xml");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		ReadDataService readDataService = (ReadDataService) applicationContext.getBean("readDataService");
		List<MeterDataVo> rs = readDataService.readDataByDate("30014180", 1, 3, "130101");
		
		System.out.println(rs);
		System.out.println(rs.size());
		
		for(MeterDataVo item : rs){
			System.out.println(JsonMapping.obj2json(item));
		}
	}
}
