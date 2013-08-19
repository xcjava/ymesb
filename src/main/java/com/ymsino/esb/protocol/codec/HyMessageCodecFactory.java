package com.ymsino.esb.protocol.codec;

import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;

import com.ymsino.esb.protocol.AbstractMessage;

public class HyMessageCodecFactory extends DemuxingProtocolCodecFactory{
	private HyMessageDecoder decoder;
	private HyMessageEncoder encoder;
	
	public HyMessageCodecFactory(HyMessageDecoder decoder,HyMessageEncoder encoder){
		this.decoder = decoder;
		this.encoder = encoder;
		addMessageDecoder(this.decoder);
		addMessageEncoder(AbstractMessage.class, this.encoder);
	}
}
