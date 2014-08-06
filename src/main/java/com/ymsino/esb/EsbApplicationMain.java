package com.ymsino.esb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Route;
import org.apache.camel.model.RouteDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.xcjava.base.io.PropertyReader;
import com.ymsino.esb.archives.domain.ConcentratorManager;
import com.ymsino.esb.comm.task.ReadNullTask;

public class EsbApplicationMain {

	public static void main(String[] args) throws Exception{  
		
		boolean startTask = Boolean.valueOf(PropertyReader.getProperties("config.properties").getProperty("esb.task.startup"));
		boolean startService = Boolean.valueOf(PropertyReader.getProperties("config.properties").getProperty("esb.service.startup"));
		boolean startDomain = Boolean.valueOf(PropertyReader.getProperties("config.properties").getProperty("esb.domain.startup"));
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/spring/applicationContext.xml");
		list.add("/META-INF/spring/applicationContext-esb.xml");
		list.add("/META-INF/spring/applicationContext-comm.xml");
		if(startDomain)
			list.add("/META-INF/spring/applicationContext-domain.xml");
		if(startService)
			list.add("/META-INF/spring/applicationContext-service.xml");
		
		Date startDate = new Date();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		
		ConcentratorManager concentratorManager = applicationContext.getBean("concentratorManager", ConcentratorManager.class);
		concentratorManager.resetAllOffLine();
		
		ReadNullTask readNullTask = applicationContext.getBean("readNullTask", ReadNullTask.class);
		readNullTask.exec();
		
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
	    System.out.println("系统版本:2014.8.6");
	    
	}  
	
}