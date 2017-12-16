/**
 * 
 */
package com.xiaoshu.security.impl;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.xiaoshu.security.TokenManager;

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
 * @Date : Create in 2017年12月16日 上午9:40:46
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Component
public class DefaultTokenManagerImpl implements TokenManager {

	private ConcurrentHashMap<String, Object> tokenMaps = new ConcurrentHashMap<String, Object>();
	
	@Override
	public boolean checkToken(String token) {
		// 检查Token的有效性
		Object result = tokenMaps.get(SECURITY_USER_TOKEN + token);
		return !ObjectUtils.isEmpty(result);
	}

	@Override
	public String createToken(String userName) {
		String token = UUID.randomUUID().toString().replace("-", "");
		tokenMaps.put(SECURITY_USER_TOKEN + token, userName +SECURITY_SPLITER_SIGN + token);
		return token;
	}

}
