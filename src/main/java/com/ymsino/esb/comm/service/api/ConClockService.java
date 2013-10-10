package com.ymsino.esb.comm.service.api;

public interface ConClockService {

	public String readClock(String concHardwareId);
	
	public String setupClock(String concHardwareId, String dateStr);
	
}
