package com.ymsino.esb.comm.ioprocess;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.component.netty.NettyConstants;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;

import com.gmail.xcjava.base.io.PropertyReader;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.archives.domain.ConcentratorManager;
import com.ymsino.esb.archives.model.Concentrator;

public class ConcentratorOnLine {
	
	/**
	 * key:集中器逻辑地址
	 * value:在线会话
	 */
	private Map<String, Channel> sessionMap = new HashMap<String, Channel>();
	
	/**
	 * key:集中器逻辑地址
	 * value:主机:端口
	
	private static Map<String, String> addressMap = new HashMap<String, String>(); */
	
	/**
	 * key:集中器逻辑地址
	 * value:空闲状态
	 */
	private Map<String, Boolean> idleMap = new HashMap<String, Boolean>();
	
	/**
	 * key:集中器逻辑地址
	 * value:最后活动时间戳
	 */
	private Map<String, Long> lastActTimestamp = new HashMap<String, Long>();
	
	/**
	 * key:集中器逻辑地址
	 * value:IO序列值
	 */
	private Map<String, Integer> seqMap = new HashMap<String, Integer>();
	
	private ConcentratorManager concentratorManager;
	public void setConcentratorManager(ConcentratorManager concentratorManager) {
		this.concentratorManager = concentratorManager;
	}

	/**
	 * 主站编号
	 */
	private String mstaNum = PropertyReader.getProperties("config.properties").getProperty("protocol.mstaNum");
	
	public void checkAdd(String id, Exchange exchange){
		
		if(exchange == null || id == null)
			return;
		
		ChannelHandlerContext channelHandlerContext = (ChannelHandlerContext) exchange.getIn().getHeader(NettyConstants.NETTY_CHANNEL_HANDLER_CONTEXT);
		Channel ioSession = channelHandlerContext.getChannel();
		
		if(ioSession == null){
			return;
		}
		
		Channel session = sessionMap.get(id);
		if(session == null){
			sessionMap.put(id, ioSession);
			idleMap.put(id, Boolean.TRUE);
			lastActTimestamp.put(id, new Date().getTime());
			seqMap.put(id, 0);
		}else{
			if(!session.getId().equals(ioSession.getId())){
				session.close();
				sessionMap.put(id, ioSession);
				idleMap.put(id, Boolean.TRUE);
				lastActTimestamp.put(id, new Date().getTime());
				seqMap.put(id, 0);
			}
		}

		concentratorManager.onLine(id);
		
	}
	
	public Channel getIoSession(String id){
		return sessionMap.get(id);
	}
	
	public void close(String id){
		
		Channel session = sessionMap.get(id);
		session.close();
		sessionMap.remove(id);
		idleMap.remove(id);
		lastActTimestamp.remove(id);
		seqMap.remove(id);
		concentratorManager.offLine(id);
	}
	
	public List<String> getAllId(){
		
		List<String> list = new ArrayList<String>();
		for(String key : sessionMap.keySet())
		{   
			list.add(key);
		}
		return list;
	}
	
	public List<Channel> getAllIoSession(){
		
		List<Channel> list = new ArrayList<Channel>();
		for(Map.Entry<String, Channel> entry : sessionMap.entrySet())   
		{   
			list.add(entry.getValue());   
		}
		return list;
	}
	
	public void setIdelStatus(String id, boolean status){
		if(idleMap.containsKey(id)){
			idleMap.put(id, status);
		}
	}
	
	public Boolean getIdelStatus(String id, boolean status){
		if(!idleMap.containsKey(id)){
			return null;
		}
		
		return idleMap.get(id);
	}
	
	public void setActTimestamp(String id, Long timestamp){
		if(lastActTimestamp.containsKey(id)){
			lastActTimestamp.put(id, timestamp);
		}
	}
	
	public Long getActTimestamp(String id){
		if(!lastActTimestamp.containsKey(id)){
			return null;
		}
		
		return lastActTimestamp.get(id);
	}
	
	public String getNextMstaSeq(String id){
		
		if(seqMap.get(id) == null)
			return "00" + mstaNum;
		
		if(seqMap.get(id) < 99){
			seqMap.put(id, seqMap.get(id) + 1);
		}else{
			seqMap.put(id, 0);
		}

		return seqMap.get(id) + mstaNum;
	}
	
	private void shutdown(){
		
		List<String> strs = this.getAllId();
		if(strs != null && strs.size() > 0){
			for(String item : strs){
				concentratorManager.offLine(item);
			}
		}
		
	}
}
