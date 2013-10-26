package com.ymsino.esb.protocol;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.quartz.SchedulerException;

import com.ymsino.esb.protocol.AbstractMessage;
import com.ymsino.esb.protocol.codec.BytesCodec;
import com.ymsino.esb.protocol.codec.HyMessageCodecFactory;
import com.ymsino.esb.protocol.codec.HyMessageDecoder;
import com.ymsino.esb.protocol.codec.HyMessageEncoder;
import com.ymsino.esb.protocol.strutc.Login;
import com.ymsino.esb.protocol.strutc.Ping;

public class TestClient {
	private static Logger logger = Logger.getLogger(TestClient.class);

	private static String HOST = "127.0.0.1";
	private static int PORT = 8001;

	public static void main(String[] args) throws SchedulerException {
		// 创建一个非阻塞的客户端程序
		IoConnector connector = new NioSocketConnector();
		// 设置链接超时时间
		connector.setConnectTimeout(30000);
		// 添加过滤器
		connector.getFilterChain().addLast(
				"codec",
				new ProtocolCodecFilter(new BytesCodec()));
		
		// 添加业务逻辑处理器类
		connector.setHandler(new TestClientHandler());
		IoSession session = null;
		try {
			ConnectFuture future = connector.connect(new InetSocketAddress(HOST, PORT));// 创建连接
			future.awaitUninterruptibly();// 等待连接创建完成
			session = future.getSession();// 获得session
			//session.setAttribute("isLogin", Boolean.FALSE);
			
			Login login = new Login(); 
			login.head.mstaSeq[0] = "41";
			login.head.mstaSeq[1] = "00";
			login.password = AbstractMessage.initField("000000", login.password.length);
			login.head.rtua = AbstractMessage.initField("80410003", login.head.rtua.length);
			session.write(login.toBytes());
			
			/*Ping ping = new Ping();
			//ping.head.mstaSeq = new String[]{"99", "88"};
			ping.head.rtua = AbstractMessage.initField("12345678", ping.head.rtua.length);
			System.out.println(ping.toString());
			System.out.println(ping.toBytes().length);
			session.write(ping);*/

			
			/*while(true){
			Thread.sleep(10000);
			session.write(req);
			}*/
			
		} catch (Exception e) {
			logger.error("客户端链接异常...", e);
		}

		//session.getCloseFuture().awaitUninterruptibly();// 等待连接断开
		//connector.dispose();
	}
}
