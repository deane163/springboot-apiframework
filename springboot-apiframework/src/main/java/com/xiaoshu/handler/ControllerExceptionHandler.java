package com.xiaoshu.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoshu.model.ErrorResponse;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

	@ExceptionHandler
	public ErrorResponse bussinessExceptionHandler(HttpServletRequest request, HttpServletResponse response
			
			){
		return null;
	}
}
