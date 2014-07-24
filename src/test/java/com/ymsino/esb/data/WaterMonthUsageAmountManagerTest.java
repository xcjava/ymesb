package com.ymsino.esb.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.data.domain.WaterMonthUsageAmountManager;
import com.ymsino.esb.data.model.WaterDayUsageAmount;

public class WaterMonthUsageAmountManagerTest {

	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/test1/applicationContext.xml");
		list.add("/META-INF/test1/applicationContext-esb.xml");
		list.add("/META-INF/test1/applicationContext-domain.xml");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		WaterMonthUsageAmountManager wmuam = (WaterMonthUsageAmountManager) applicationContext.getBean("waterMonthUsageAmountManager");
		CommonHibernateDao dao = (CommonHibernateDao) applicationContext.getBean("commonHibernateDao");
		
		WaterDayUsageAmount dayAmount = (WaterDayUsageAmount) dao.get(WaterDayUsageAmount.class, Long.parseLong("1"));
		wmuam.saveByWaterDayUsageAmount(dayAmount);
		
		System.exit(0);
	}
	
}
