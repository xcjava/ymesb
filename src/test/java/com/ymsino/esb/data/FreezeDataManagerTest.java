package com.ymsino.esb.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.xcjava.base.math.Arith;
import com.ymsino.esb.data.domain.FreezeDataManager;
import com.ymsino.esb.data.model.FreezeData;

public class FreezeDataManagerTest {

	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("/META-INF/test1/applicationContext.xml");
		list.add("/META-INF/test1/applicationContext-esb.xml");
		list.add("/META-INF/test1/applicationContext-domain.xml");
		
		FreezeData model = new FreezeData();
		model.setBatteryVoltage((float) 3.5);
		model.setChargingUnitId("SF01");
		model.setConcHardwareId("30014180");
		model.setCreateTimestamp(new Date().getTime());
		model.setDataType("1");
		model.setErrorStatus("0");
		model.setFreezeDateStr("140800");
		model.setMagneticAttack("0");
		model.setMeterHardwareId("000012079850");
		model.setMeterReading((float) 646.5);
		model.setParentUnits("|SF01|");
		model.setReplyStatus("0");
		model.setUserId("kh1");
		model.setValveStatus("11");
		model.setWaterCustomerId("W_kh1_241");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(list.toArray(new String[list.size()]));
		FreezeDataManager fdm = (FreezeDataManager) applicationContext.getBean("freezeDataManager");
		
		for(int i = 0; i < 3; i++){
			model.setId(null);
			model.setFreezeDateStr(Integer.parseInt(model.getFreezeDateStr()) + 1 + "");
			//model.setMeterReading(model.getMeterReading() + 10 + Arith.mul(0.1f, i + 1));
			model.setMeterReading(model.getMeterReading() + 10);
			fdm.insertOrUpdate(model);
			
			try {
				System.out.println("数据" + model.getFreezeDateStr());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
		System.exit(0);
	}
	
}
