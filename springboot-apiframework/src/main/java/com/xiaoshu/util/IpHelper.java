package com.xiaoshu.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

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
 * @Description : IpHelper 工具类实现
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月26日下午8:11:01
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
public class IpHelper {
	private static final Logger logger = Logger.getLogger("IpHelper");

	private static String LOCAL_IP_STAR_STR = "192.168.";

	static {
		String ip = null;
		String hostName = null;
		try {
			hostName = InetAddress.getLocalHost().getHostName();
			InetAddress ipAddr[] = InetAddress.getAllByName(hostName);
			for (int i = 0; i < ipAddr.length; i++) {
				ip = ipAddr[i].getHostAddress();
				if (ip.startsWith(LOCAL_IP_STAR_STR)) {
					break;
				}
			}
			if (ip == null) {
				ip = ipAddr[0].getHostAddress();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		LOCAL_IP = ip;
		HOST_NAME = hostName;

	}

	public static final String LOCAL_IP;

	public static final String HOST_NAME;

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1")) {
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
					ip = inet.getHostAddress();
				} catch (UnknownHostException e) {
					logger.info("IpHelper error." + e.toString());
				}
			}
		}
		/**
		 */
		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}
}
