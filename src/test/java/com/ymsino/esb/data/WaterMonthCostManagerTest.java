package com.ymsino.esb.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.xcjava.base.spring.CommonHibernateDao;

public class WaterMonthCostManagerTest {

	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/test1/applicationContext.xml");
		list.add("/META-INF/test1/applicationContext-esb.xml");
		list.add("/META-INF/test1/applicationContext-domain.xml");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		CommonHibernateDao dao = (CommonHibernateDao) applicationContext.getBean("commonHibernateDao");
		
		
		
		
		
		System.exit(0);
	}
	
}
