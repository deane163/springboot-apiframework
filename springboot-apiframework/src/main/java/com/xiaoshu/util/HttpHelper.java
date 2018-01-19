package com.xiaoshu.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
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
 * @Description : Http Helper 工具类实现
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月26日下午8:09:38
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
public class HttpHelper {

	public static HttpServletRequest getHttpServletRequest() {
		if(null != RequestContextHolder.getRequestAttributes())
			return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		else
			return null;
	}
}
