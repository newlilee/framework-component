package com.example.springboot.annotation;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author clx 2019-08-02
 */
@Aspect
@Component
public class CatEventAspect {

	@Pointcut(value = "execution(* *.*(..))")
	public void pointCut() {
	}

	@Around(value = "pointCut() && @annotation(catEvent))", argNames = "joinPoint, catEvent")
	public Object aroundMethod(ProceedingJoinPoint joinPoint, CatEvent catEvent) {
		Event event = null;
		Object result = null;
		try {
			MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
			Method method = joinPoint.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
			event = Cat.newEvent(catEvent.name(), method.getName());
			result = joinPoint.proceed();
			event.setSuccessStatus();
		} catch (Throwable ex) {
			if (event != null) {
				event.setStatus(ex);
			}
			Cat.logError(ex);
		} finally {
			if (event != null) {
				event.complete();
			}
		}
		return result;
	}
}
