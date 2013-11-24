package com.ymsino.esb.freesettle.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.gmail.xcjava.base.hql.OrderParamWriter;
import com.gmail.xcjava.base.hql.QueryCondition;
import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.hql.QueryParamWriter;
import com.ymsino.esb.freesettle.service.api.WaterDayCostService;
import com.ymsino.esb.freesettle.vo.WaterDayCostReturn;

public class WaterCostSettleTask {

	private static Boolean RUN_TAG = false;
	
	private WaterDayCostService waterDayCostService;
	public void setWaterDayCostService(WaterDayCostService waterDayCostService) {
		this.waterDayCostService = waterDayCostService;
	}

	private ProducerTemplate producerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}

	public void settleWaterDayCost(){
		
		if(RUN_TAG)
			return;
		
		RUN_TAG = true;
		
		QueryParamWriter qpw = new QueryParamWriter();
		qpw.addQueryParam("totalCost", null, QueryCondition.QC_UNEQ);
		qpw.addQueryParam("payStatus", Short.valueOf("-1"), QueryCondition.QC_UNEQ);
		qpw.addQueryParam("checkPayStatus", Short.valueOf("-1"), QueryCondition.QC_UNEQ);
		
		QueryParam qp = new QueryParam();
		qp.setQueryLink(qpw.getQueryLink());
		qp.setQueryCon(qpw.getQueryCon());
		qp.setQueryValue(qpw.getQueryValue());
		
		OrderParamWriter opw = new OrderParamWriter();
		opw.addOrderCondition("id", "asc");
		
		qp.setOrderParamStr(opw.getOrderParamStr());
		
		
		List<WaterDayCostReturn> waterDayCostList = waterDayCostService.getListpager(qp, 0, 100);
		if(waterDayCostList == null || waterDayCostList.size() < 1){
			RUN_TAG = false;
			return;
		}
			
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("method", "settleCost");
		header.put("beanName", "waterDayCostManager");
		for (int i = 0; i < 100; i++) {
			producerTemplate.sendBodyAndHeaders("jms:queue:com.ymsino.esb.domain", ExchangePattern.InOut, waterDayCostList.get(i).getId(), header);
		}
		
		RUN_TAG = false;
	}
	
}
