package com.ymsino.esb.comm.service.impl;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.component.mina2.Mina2Constants;
import org.apache.mina.core.session.IoSession;

public class ConcentratorOnLine {
	
	/**
	 * key:集中器逻辑地址
	 * value:在线会话
	 */
	private static Map<String, IoSession> sessionMap = new HashMap<String, IoSession>();
	
	/**
	 * key:集中器逻辑地址
	 * value:主机:端口
	 */
	private static Map<String, String> addressMap = new HashMap<String, String>();
	
	/**
	 * key:集中器逻辑地址
	 * value:
	 */
	private static Map<String, Boolean> idleMap = new HashMap<String, Boolean>();
	
	public static void checkAdd(String id, Exchange exchange){
		
		if(exchange == null || id == null)
			return;
		
		IoSession ioSession = (IoSession) exchange.getIn().getHeader(Mina2Constants.MINA_IOSESSION);
		InetSocketAddress remoteAddress = (InetSocketAddress) exchange.getIn().getHeader(Mina2Constants.MINA_REMOTE_ADDRESS);
		
		if(ioSession == null || remoteAddress == null){
			return;
		}
		
		IoSession session = sessionMap.get(id);
		if(session == null){
			sessionMap.put(id, ioSession);
			addressMap.put(id, remoteAddress.getHostName() + ":" + remoteAddress.getPort());
			idleMap.put(id, Boolean.TRUE);
		}else{
			if(!session.equals(ioSession)){
				session.close(true);
				sessionMap.put(id, ioSession);
				addressMap.put(id, remoteAddress.getHostName() + ":" + remoteAddress.getPort());
				idleMap.put(id, Boolean.TRUE);
			}
		}
	}
	
	public static IoSession getIoSession(String id){
		return sessionMap.get(id);
	}
	
	public static void close(String id, boolean closeImmediately){
		
		IoSession session = sessionMap.get(id);
		session.close(closeImmediately);
		sessionMap.remove(id);
		addressMap.remove(id);
		idleMap.remove(id);
		
	}
	
	public static List<String> getAllId(){
		
		List<String> list = new ArrayList<String>();
		for(String key : sessionMap.keySet())
		{   
			list.add(key);
		}
		return list;
	}
	
	public static List<IoSession> getAllIoSession(){
		
		List<IoSession> list = new ArrayList<IoSession>();
		for(Map.Entry<String, IoSession> entry : sessionMap.entrySet())   
		{   
			list.add(entry.getValue());   
		}
		return list;
	}
	
	public static void setIdelStatus(String id, boolean status){
		if(idleMap.containsKey(id)){
			idleMap.put(id, status);
		}
	}
	
	public static Boolean getIdelStatus(String id, boolean status){
		if(!idleMap.containsKey(id)){
			return null;
		}
		
		return idleMap.get(id);
	}
}
