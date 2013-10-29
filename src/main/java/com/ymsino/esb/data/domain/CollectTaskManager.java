package com.ymsino.esb.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.gmail.xcjava.base.date.DateUtil;
import com.gmail.xcjava.base.spring.CommonHibernateDao;
import com.ymsino.esb.data.model.CollectTask;

public class CollectTaskManager {

	private Logger logger = Logger.getLogger(CollectTaskManager.class);
	private CommonHibernateDao commonHibernateDao;
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}
	
	/*public void startExec(Long id){
		CollectTask po = (CollectTask) this.commonHibernateDao.get(CollectTask.class, id);
		po.setStartTimestamp(new Date().getTime());
		po.setStatus("1");
	}*/
	
	public void endExec(Long id){
		CollectTask po = (CollectTask) this.commonHibernateDao.get(CollectTask.class, id);
		po.setStartTimestamp(new Date().getTime());
		po.setStatus("-1");
	}
	
	public CollectTask getById(Long id){
		return (CollectTask) this.commonHibernateDao.get(CollectTask.class, id);
	}
	
	public List<CollectTask> getStartList(){
		
		Date now = new Date();
		String date = DateUtil.format(now, "yyyyMMdd");
		List<CollectTask> list = this.commonHibernateDao.find("from CollectTask model where model.executeTag = '1' and status = '-1'");
		List<CollectTask> result = new ArrayList<CollectTask>();
		if(list == null)
			return null;
		
		for(CollectTask item : list){
			Date startDate = DateUtil.parseDate(date + " " + item.getStartHour() + ":" + item.getStartMinute(), "yyyyMMdd HH:mm");
			if(startDate.getTime() >= now.getTime()){
				item.setStartTimestamp(now.getTime());
				item.setStatus("1");
				result.add(item);
			}
		}
		
		return result;
	}
	
	/*public static void main(String[] args) throws Exception{
		
		String str = DateUtil.format(new Date(), "HH:ss");
		System.out.println(str);
		
		Set<String> set = new HashSet<String>();
		set.add("123");
		set.add("123");
		System.out.println(set.size());
	}*/
}
