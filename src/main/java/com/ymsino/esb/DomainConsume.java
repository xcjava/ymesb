package com.ymsino.esb;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.camel.Body;
import org.apache.camel.Consume;
import org.apache.camel.Header;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DomainConsume implements ApplicationContextAware {

	private ApplicationContext applicationContext;  
	
	@Consume(uri = "jms:queue:com.gdcct.ec.manager.domain?concurrentConsumers=1&maxConcurrentConsumers=30")
	public Serializable doManagerExecute(@Body Object vo, @Header("method") String method, @Header("beanName") String beanName) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if(!beanName.endsWith("Manager"))
			return null;
		
		Object invokeBean = applicationContext.getBean(beanName);
    	Method[] allMethods = invokeBean.getClass().getMethods();
    	for(Method itemMethod : allMethods){
    		if(itemMethod.getName().equals(method)){
    			Serializable resultObj = (Serializable) itemMethod.invoke(invokeBean, vo);
    	    	return resultObj;
    		}
    	}
    	return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

}
