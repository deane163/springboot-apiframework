/**
 * 
 */
package com.xiaoshu.security;

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
 * @Date : Create in 2017年12月16日 上午9:38:50
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
public interface TokenManager {

	public static final String SECURITY_USER_TOKEN = "user_token:";
	public static final String SECURITY_SPLITER_SIGN = ":";
	
	/**
	 * 检查Token的有效性
	 * @param token
	 * @return
	 */
	public boolean checkToken(String token);
	
	/**
	 * 创建Token
	 * @param userName
	 * @return
	 */
	public String createToken(String userName);
	
}
