package com.demo.aspect;

import java.lang.annotation.*;

/**
 * 自定义注解 拦截Controller
 * @author dong.wang
 *
 */

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AddLog {

	/** 要执行的方法描述 **/  
	public String value() default "";

}
