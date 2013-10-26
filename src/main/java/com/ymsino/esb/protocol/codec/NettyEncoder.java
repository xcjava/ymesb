package com.ymsino.esb.protocol.codec;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

public class NettyEncoder extends OneToOneEncoder {

	private static final transient Logger logger = Logger.getLogger(NettyDecoder.class);
    
    @Override 
    protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception { 
    	
    	/*if (!(msg instanceof byte[])) {
            return msg;//(1)
        }*/
 
        //String res = (String)msg;
        byte[] data = (byte[]) msg;
        //int dataLength = data.length;
        ChannelBuffer buf = ChannelBuffers.dynamicBuffer(data.length);//(2)
        //buf.writeInt(dataLength);
        buf.writeBytes(data);
        return buf;//(3)
    }

}
