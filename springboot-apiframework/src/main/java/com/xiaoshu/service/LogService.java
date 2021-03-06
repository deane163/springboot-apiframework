package com.xiaoshu.service;

import java.util.List;

import com.xiaoshu.model.LogInfo;

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
 * @Description : 日志信息记录
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月27日下午4:01:10
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
public interface LogService {

	public void save(LogInfo log);
	
	public void batchSave(List<LogInfo> logs);
	
}
