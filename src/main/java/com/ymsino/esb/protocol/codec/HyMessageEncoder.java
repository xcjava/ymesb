package com.ymsino.esb.protocol.codec;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;

import com.ymsino.esb.protocol.AbstractMessage;

public class HyMessageEncoder implements MessageEncoder<AbstractMessage>{
	private static Logger logger = Logger.getLogger(HyMessageEncoder.class);
	
	@Override
	public void encode(IoSession session, AbstractMessage obj, ProtocolEncoderOutput out) throws Exception {
		IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);
		buf.put(obj.toBytes());
		buf.flip();
		logger.debug("编码" + buf.toString());
		out.write(buf);
	}

}
