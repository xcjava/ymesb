package com.ymsino.esb.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Route;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.xcjava.base.io.PropertyReader;

public class ManagerApplicationMain {

	public static void main(String[] args) throws Exception{  
		
		boolean startTask = Boolean.valueOf(PropertyReader.getProperties("config.properties").getProperty("esb.task.startup"));
		boolean startService = Boolean.valueOf(PropertyReader.getProperties("config.properties").getProperty("esb.service.startup"));
		boolean startDomain = Boolean.valueOf(PropertyReader.getProperties("config.properties").getProperty("esb.domain.startup"));
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/spring/applicationContext.xml");
		list.add("/META-INF/spring/applicationContext-esb.xml");
		if(startDomain)
			list.add("/META-INF/spring/applicationContext-domain.xml");
		if(startService)
			list.add("/META-INF/spring/applicationContext-service.xml");
		
		Date startDate = new Date();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		CamelContext camelContext = (CamelContext) applicationContext.getBean("camelContext");
		if(!startTask){
			List<Route> routes = camelContext.getRoutes();
			for(Route item : routes){
				if(item.getId().endsWith("Quartz")){
					camelContext.removeRoute(item.getId());
				}
			}
		}
		camelContext.start();
		
		Date endDate = new Date();
	    System.out.println("启动完成,耗时:" + (endDate.getTime() - startDate.getTime()) + "ms");
	    
	}  
	
}