package com.xiaoshu.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.xiaoshu.annotation.Log;
import com.xiaoshu.model.LogInfo;
import com.xiaoshu.util.HttpHelper;
import com.xiaoshu.util.IpHelper;

@Aspect
@Component
public class LogAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String LOG_CONTENT = "[类名]:%s,[方法参数]:%s";

	@Pointcut("@annotation(com.xiaoshu.annotation.Log)")
	private void anyMethod(){
		// 定义Pointcut
	}
	
	@Around("anyMethod()")
	public Object doExecute(ProceedingJoinPoint joinPoint) throws Throwable{
		   logger.info("进入切面，对日志数据进行处理"); 
	       HttpServletRequest request = HttpHelper.getHttpServletRequest();
	        //获取ip地址
	       String ipAddress =  IpHelper.getIpAddr(request);
	       
	       MethodSignature signature = (MethodSignature)joinPoint.getSignature();
	       Method method = signature.getMethod();
	       Log log = method.getAnnotation(Log.class);
	       //获取操作类型
	       String operation = log.value();
	       String operationType = log.type().toString();
	       //获取类名
	       String className = joinPoint.getTarget().getClass().getName();
	       //获取参数
	       Object[] params = joinPoint.getArgs();
	       String paramsStr = getParamStr(params,method);
	       
	       String content =  String.format(LOG_CONTENT, className, method.getName()+paramsStr );
	       StopWatch clock = new StopWatch();
	       clock.start();
	       Object object = joinPoint.proceed();
	       clock.stop();
	       LogInfo logInfo = new LogInfo();
	       logInfo.setContent(content);
	       logInfo.setCostTime(110L);
	       logInfo.setOperation(operation);
	       logInfo.setOperationType(operationType);
			
	       logInfo.setDeviceId("12345678");
	       logInfo.setIpAddress(ipAddress);
	       
	       return object;
	}
	
	private String getParamStr(Object[] params, Method method) {
		StringBuffer bf = new StringBuffer("(");
		Class<?>[] clazzs = method.getParameterTypes();
		for(int i=0;i<params.length;i++){
			Object obj = params[i];
			Class<?> clazz = clazzs[i];
			if(obj instanceof HttpServletRequest){
				continue;
			}
			
			if(obj instanceof MultipartFile)
				obj = ((MultipartFile)obj).getOriginalFilename();
			
			if(obj instanceof MultipartFile[]){
				StringBuilder sb = new StringBuilder();
				MultipartFile[] tmp = ((MultipartFile[])obj);
				for(int j=0; j<tmp.length; j++){
					sb.append(tmp[j].getOriginalFilename()).append(",");
				}
				obj = sb.toString().substring(0, sb.toString().length()-1);
			}
			//如果是基本类型，
			if(clazz.getClass().isPrimitive()){
				String typeName = clazz.getSimpleName();
				bf.append(typeName).append(" ");
				bf.append(obj).append(",");
			}else{
				String typeName = clazz.getName();
				bf.append(typeName).append(" ");
				bf.append(JSONObject.toJSONString(obj)).append(",");
			}
		}
		bf.deleteCharAt(bf.length()-1);
		bf.append(")");
		return bf.toString();
	}
}
