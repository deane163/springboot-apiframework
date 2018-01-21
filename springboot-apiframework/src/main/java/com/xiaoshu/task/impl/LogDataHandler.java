package com.xiaoshu.task.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xiaoshu.task.DataHandler;

/**
 * 
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
 * @Description : 日志处理程序
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月21日 下午4:16:09
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
@Component("logDataHandler")
public class LogDataHandler<LogInfo> implements DataHandler<LogInfo> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void handleData(List<LogInfo> lists) {
		
		logger.info("start handler the logs , size is :{}", lists.size());
	}

}
