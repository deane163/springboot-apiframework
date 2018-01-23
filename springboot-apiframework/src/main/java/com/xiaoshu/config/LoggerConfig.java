package com.xiaoshu.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import com.xiaoshu.task.impl.LogTask;

/**
 * 
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 *
 * @Description : 
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月20日上午10:59:24
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
@Configuration
@ConditionalOnProperty(prefix ="xiaoshu.log",name="type",havingValue ="async",matchIfMissing=false)
public class LoggerConfig {
	
	private Logger logger = LoggerFactory.getLogger(LoggerConfig.class);

	@Autowired
	private LogTask logTask;
	
	// 启动异步的日志处理操作
	@PostConstruct
	public void startHandlerLog(){
		logger.info("启动异步日志处理，进行日志到数据库的操作。");
		Thread dataThread = new Thread(logTask);
		// 作为守护进程进行启动
		dataThread.setDaemon(true); // daemon, service jvm, user thread leave >>> daemon leave >>> jvm leave
		dataThread.start();
		
	}
	
	@PreDestroy
	public void destoryHandlerLog(){
		logger.info("destory the Handler of log records ");
	}
}
