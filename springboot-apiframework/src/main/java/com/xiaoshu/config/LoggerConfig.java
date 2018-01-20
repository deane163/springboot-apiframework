package com.xiaoshu.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

	@Autowired
	private LogTask logTask;
	
	// 启动异步的日志处理操作
	@PostConstruct
	public void startHandlerLog(){
		Thread dataThread = new Thread(logTask);
		// 作为守护进程进行启动
		dataThread.setDaemon(true);
		dataThread.start();
		
	}
	
	@PreDestroy
	public void destoryHandlerLog(){
		
	}
}
