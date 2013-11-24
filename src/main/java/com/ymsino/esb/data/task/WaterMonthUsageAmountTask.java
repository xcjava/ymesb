package com.ymsino.esb.data.task;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.gmail.xcjava.base.dataMapping.ObjectMapping;
import com.gmail.xcjava.base.date.DateUtil;
import com.gmail.xcjava.base.hql.OrderParamWriter;
import com.gmail.xcjava.base.hql.QueryCondition;
import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.hql.QueryParamWriter;
import com.gmail.xcjava.base.io.PropertyReader;
import com.ymsino.esb.data.model.WaterDayUsageAmount;
import com.ymsino.esb.data.service.api.WaterDayUsageAmountService;
import com.ymsino.esb.data.vo.WaterDayUsageAmountReturn;

public class WaterMonthUsageAmountTask {

	private String settleDateStr = PropertyReader.getProperties("config.properties").getProperty("data.settleDate");

	private WaterDayUsageAmountService waterDayUsageAmountService;
	public void setWaterDayUsageAmountService(
			WaterDayUsageAmountService waterDayUsageAmountService) {
		this.waterDayUsageAmountService = waterDayUsageAmountService;
	}

	private ProducerTemplate producerTemplate;
	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}

	public void countByDayUsageAmount() {

		Date today = new Date();
		
		Date settleDate = DateUtil.parseDate(DateUtil.format(today, "yyyy-MM-") + settleDateStr, "yyyy-MM-dd HH:mm:ss");
		if(today.getTime() < settleDate.getTime()){
			return;
		}
		
		String lastMonthStr = DateUtil.format(DateUtil.addMonth(today, -1), "yy-MM");
		QueryParamWriter qpw = new QueryParamWriter();
		qpw.addQueryParam("freezeYear", lastMonthStr.split("-")[0], QueryCondition.QC_UNEQ);
		qpw.addQueryParam("freezeMonth", lastMonthStr.split("-")[1], QueryCondition.QC_EQ);
		
		QueryParam qp = new QueryParam();
		qp.setQueryLink(qpw.getQueryLink());
		qp.setQueryCon(qpw.getQueryCon());
		qp.setQueryValue(qpw.getQueryValue());
		
		OrderParamWriter opw = new OrderParamWriter();
		opw.addOrderCondition("id", "asc");
		
		qp.setOrderParamStr(opw.getOrderParamStr());

		int count = waterDayUsageAmountService.getCount(qp);
		if (count < 1) {
			return;
		}

		Map<String, Object> header = new HashMap<String, Object>();
		header.put("method", "saveByWaterDayUsageAmount");
		header.put("beanName", "waterMonthUsageAmountManager");

		for (int i = 0; i < count; i++) {
			List<WaterDayUsageAmountReturn> waterDayUsageAmountList = waterDayUsageAmountService.getListpager(qp, i, 1);
			WaterDayUsageAmount amount = new WaterDayUsageAmount();
			ObjectMapping.objMapping(waterDayUsageAmountList.get(0), amount);
			producerTemplate.sendBodyAndHeaders("jms:queue:com.ymsino.esb.domain", ExchangePattern.InOnly, amount, header);
		}

	}

}
