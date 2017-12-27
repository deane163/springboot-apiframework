package com.xiaoshu.annotation;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited
@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

	/**
	 * 日志信息说明，方法的功能说明
	 * @return
	 */
	String value() default "";
	
	/**
	 * 方法类型的说明，类型说明
	 * @return
	 */
	LogType type() default LogType.OTHER;
	
}
