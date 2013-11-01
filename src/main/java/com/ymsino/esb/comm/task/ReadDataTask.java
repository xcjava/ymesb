package com.ymsino.esb.comm.task;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gmail.xcjava.base.date.DateUtil;
import com.gmail.xcjava.base.hql.QueryCondition;
import com.gmail.xcjava.base.hql.QueryParam;
import com.gmail.xcjava.base.hql.QueryParamWriter;
import com.gmail.xcjava.base.str.StringTool;
import com.ymsino.esb.archives.service.api.WaterMeterService;
import com.ymsino.esb.comm.service.api.ReadDataService;
import com.ymsino.esb.data.domain.CollectTaskManager;
import com.ymsino.esb.data.model.CollectTask;

/**
 * 收集执行抄表任务的集中器ID
 * @author shallot
 *
 */
public class ReadDataTask {

	private CollectTaskManager collectTaskManager;
	public void setCollectTaskManager(CollectTaskManager collectTaskManager) {
		this.collectTaskManager = collectTaskManager;
	}
	
	private WaterMeterService waterMeterService;
	public void setWaterMeterService(WaterMeterService waterMeterService) {
		this.waterMeterService = waterMeterService;
	}
	
	private ReadDataService readDataService;
	public void setReadDataService(ReadDataService readDataService) {
		this.readDataService = readDataService;
	}

	public void exec(){

		List<CollectTask> list = collectTaskManager.getStartList();
		if(list != null && list.size() > 0){
			for(CollectTask item : list){
				List<String> ids = StringTool.split(item.getConcHardwareIds(), "|");
				if(ids != null && ids.size() > 0){
					for(String id : ids){
						QueryParamWriter qpw = new QueryParamWriter();
						qpw.addQueryParam("wmSn", null, QueryCondition.QC_UNEQ);
						qpw.addQueryParam("concHardwareId", id, QueryCondition.QC_EQ);
						
						QueryParam qp = new QueryParam();
						qp.setQueryLink(qpw.getQueryLink());
						qp.setQueryCon(qpw.getQueryCon());
						qp.setQueryValue(qpw.getQueryValue());
						
						int count = waterMeterService.getCount(qp);
						readDataService.readDataByDate(id, 1, count, DateUtil.format(new Date(), "yyyyMMdd"));
					}
				}
				collectTaskManager.endExec(item.getId());
			}
		}
	}
}
