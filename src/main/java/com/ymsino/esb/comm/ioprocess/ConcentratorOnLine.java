package com.ymsino.esb.comm.ioprocess;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Date;
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
	 * value:空闲状态
	 */
	private static Map<String, Boolean> idleMap = new HashMap<String, Boolean>();
	
	/**
	 * key:集中器逻辑地址
	 * value:最后活动时间戳
	 */
	private static Map<String, Long> lastActTimestamp = new HashMap<String, Long>();
	
	/**
	 * key:集中器逻辑地址
	 * value:IO序列值
	 */
	private static Map<String, Long> seqMap = new HashMap<String, Long>();
	
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
			lastActTimestamp.put(id, new Date().getTime());
			seqMap.put(id, 0l);
		}else{
			if(!session.equals(ioSession)){
				session.close(true);
				sessionMap.put(id, ioSession);
				addressMap.put(id, remoteAddress.getHostName() + ":" + remoteAddress.getPort());
				idleMap.put(id, Boolean.TRUE);
				lastActTimestamp.put(id, new Date().getTime());
				seqMap.put(id, 0l);
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
		lastActTimestamp.remove(id);
		seqMap.remove(id);
		
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
	
	public static void setActTimestamp(String id, Long timestamp){
		if(lastActTimestamp.containsKey(id)){
			lastActTimestamp.put(id, timestamp);
		}
	}
	
	public static Long getActTimestamp(String id){
		if(!lastActTimestamp.containsKey(id)){
			return null;
		}
		
		return lastActTimestamp.get(id);
	}
	
	public static Long getCurrSeq(String id){
		if(!seqMap.containsKey(id)){
			return null;
		}
		
		return seqMap.get(id);
	}
	
	public static Long getNextSeq(String id){
		if(seqMap.containsKey(id)){
			seqMap.put(id, seqMap.get(id) + 1);
		}
		
		return seqMap.get(id);
	}
}
