package com.xiaoshu.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xiaoshu.cors.CorsFilter;
import com.xiaoshu.json.CustomObjectMapper;
import com.xiaoshu.web.WebContextFilter;

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
 * @Date : Create in 2017年12月15日下午5:18:48
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Configuration
public class CommonConfig {
	
	@Bean	//支持 CORS 跨域
    public FilterRegistrationBean corsFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CorsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("CorsFilter");
        registration.setOrder(10);
        return registration;
    }
	
	@Bean	//用于管理 WebContext 对象的生命周期
	public FilterRegistrationBean webFilterRegistration(){
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new WebContextFilter());
        registration.addUrlPatterns("/*");
        registration.setName("WebFilter");
        registration.setOrder(8);
		return registration;
	}
	
	@Bean	//定制 Jackson 的 ObjectMapper
	public CustomObjectMapper objectMapper(){
		CustomObjectMapper objectMapper = new CustomObjectMapper();
		objectMapper.setCamelCaseToLowerCaseWithUnderscores(true);
		objectMapper.setDateFormatPattern("yyyy-MM-dd HH:mm:ss");
		return objectMapper;
	}
}
