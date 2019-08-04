package com.example.ssm.spring.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * schema
 *
 * @author clx at 2017年5月25日 下午6:39:05
 */
public class HelloWorldAdvice {

	/**
	 * before advice
	 */
	public void beforeAdvice() {
		System.out.println("*****before advice*****");
	}

	/**
	 * after final advice
	 */
	public void afterFinalAdvice() {
		System.out.println("*****after final advice*****");
	}

	/**
	 * around advice
	 */
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("***around before advice");
		Object retVal = joinPoint.proceed(new Object[]{"Replace"});
		System.out.println("*** around after advice");
		return retVal;
	}
}
