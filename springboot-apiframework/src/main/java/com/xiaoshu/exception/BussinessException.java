package com.xiaoshu.exception;

import com.xiaoshu.model.CommonErrorEnum;
import com.xiaoshu.model.ErrorResponse;
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
 * @Date : Create in 2017年12月21日下午7:48:56
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
public class BussinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    /**
     * HTTP状态码
     */
    private int httpStatus;
    
    /**
     * 返回的错误对象
     */
    private ErrorResponse er;
    
    
    public static BussinessException builder(CommonErrorEnum ceEnum) throws BussinessException {
        return new BussinessException(ceEnum.getHttpStatus(), ceEnum.getCode(), ceEnum.getMessage());
    }
    
    public static BussinessException builder(int httpStatus, int code, String message) throws BussinessException {
        return new BussinessException(httpStatus, code, message);
    }
    
    public BussinessException(int httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        er = new ErrorResponse(code, message);
    }

    
    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
    
    public ErrorResponse getErrorResponse() {
        return er;
    }

    public void setErrorResponse(ErrorResponse er) {
        this.er = er;
    }
}
