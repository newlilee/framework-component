package com.example.ssm.spring.aop.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author clx 2017年7月30日 下午7:54:34
 * @AspectJ annotation
 */
@Aspect
public class AspectJAdvice {

	@Pointcut(value = "execution(* org.example.spring.aop..*.*(..)) && args(param)", argNames = "param")
	public void beforePointcut(String param) {
	}

	@Before(value = "beforePointcut(param)", argNames = "param")
	public void beforeAdvice(String param) {
		System.out.println("before advice param:" + param);
	}
}
