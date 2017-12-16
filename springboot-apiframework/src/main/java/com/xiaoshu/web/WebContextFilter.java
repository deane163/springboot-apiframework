package com.xiaoshu.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
 * @Description : 用于管理 WebContext 对象的生命周期
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月16日 上午8:48:11
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
public class WebContextFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return;
        }
		//用于管理 WebContext 对象的生命周期
		WebContext.init(request, response);
		try {
			 filter.doFilter(request, response);
		} finally{
			WebContext.destory();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}
	
}
