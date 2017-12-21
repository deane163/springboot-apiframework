package com.xiaoshu.model;

import javax.servlet.http.HttpServletResponse;

import com.xiaoshu.exception.BussinessException;
import com.xiaoshu.handler.ErrorEnumHandler;

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
 * @Date : Create in 2017年12月20日下午3:31:15
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
public enum CommonErrorEnum implements ErrorEnumHandler {

	/**
	 * 1001：非法参数格式，不是 JSON 对象
	 */
	INVALID_PARAM_FORMATE(HttpServletResponse.SC_BAD_REQUEST, 1001,
			"Invalid parameter format"),

	/**
	 * 1002：参数对象中的非法字段，缺少字段、字段类型错误、字段取值非法
	 */
	INVALID_PARAM_FILED(HttpServletResponse.SC_BAD_REQUEST, 1002,
			"Invalid fields in the parameter object"),

	/**
	 * 1003：没有鉴权
	 */
	AUTHENTICATION_NOT_FOUND(HttpServletResponse.SC_UNAUTHORIZED, 1003,
			"Authentication not found"),

	/**
	 * 1004：无效鉴权
	 */
	INVALID_AUTHENTICATION(HttpServletResponse.SC_UNAUTHORIZED, 1004,
			"Invalid authentication"),

	/**
	 * 1005：没有权限
	 */
	PERMISSION_DENIED(HttpServletResponse.SC_FORBIDDEN, 1005,
			"Permission denied"),

	/**
	 * 1006：请求次数限制
	 */
	REQUEST_LIMIT(HttpServletResponse.SC_FORBIDDEN, 1006, "Request limit"),

	/**
	 * 1007：资源未找到
	 */
	NOT_FOUNT(HttpServletResponse.SC_NOT_FOUND, 1007, "Not Found"),

	/**
	 * 1008：服务器内部错误
	 */
	INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 1008,
			"Internal Server Error"),

	ERROR_PARAM(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 1009, "参数错误");

	/*
	 * ==========================================================================
	 * ==============================
	 */

	/**
	 * HTTP状态码
	 */
	private int httpStatus;

	/**
	 * 错误码
	 */
	private int code;

	/**
	 * 错误消息
	 */
	private String message;

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private CommonErrorEnum(int httpStatus, int code, String message) {
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
	}

	@Override
	public void throwsException() throws Exception {
		throw BussinessException.builder(this.httpStatus, this.code,this.message);
	}

}
