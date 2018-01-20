package com.xiaoshu.task.impl;

import org.springframework.stereotype.Component;

import com.xiaoshu.model.LogInfo;
import com.xiaoshu.task.DataHandler;
import com.xiaoshu.task.Task;

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
 * @Date : Create in 2018年1月20日上午10:30:40
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */

@Component("logTask")
public class LogTask extends Task<LogInfo> {

	public LogTask(DataHandler<LogInfo> dataHandler) {
		super(dataHandler);
		// TODO Auto-generated constructor stub
	}

}
