package com.ymsino.esb.protocol.codec;

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

public class NettyDecoder extends FrameDecoder {
	
	private static final transient Logger logger = Logger.getLogger(NettyEncoder.class);
	  
    @Override 
    protected Object decode( 
            ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception { 

    	/*if (buffer.readableBytes() < 4) {
    		System.out.println("解码1");
            return null;//(1)
        }
        int dataLength = buffer.getInt(buffer.readerIndex());*/
    	
        /*if (buffer.readableBytes() < dataLength + 4) {
        	System.out.println("解码2");
            return null;//(2)
        }*/
 
        //buffer.skipBytes(4);//(3)
        byte[] decoded = new byte[buffer.array().length];
        buffer.readBytes(decoded);
        //String msg = new String(decoded);//(4)
        
        System.out.println(decoded);
        return decoded;
    }
	
}
