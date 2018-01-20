package com.xiaoshu.task.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xiaoshu.task.DataHandler;


@Component("logDataHandler")
public class LogDataHandler<LogInfo> implements DataHandler<LogInfo> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void handleData(List<LogInfo> lists) {
		
		logger.info("start handler the logs , size is :{}", lists.size());
	}

}
