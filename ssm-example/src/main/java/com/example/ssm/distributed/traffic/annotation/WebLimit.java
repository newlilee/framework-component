package com.example.ssm.distributed.traffic.annotation;

import java.lang.annotation.*;

/**
 * @author clx
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebLimit {
	/**
	 *
	 */
	int errorCode() default 500;
}
