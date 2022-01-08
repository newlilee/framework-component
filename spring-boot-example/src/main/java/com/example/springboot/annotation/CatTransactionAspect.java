package com.example.springboot.annotation;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
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
public class CatTransactionAspect {

	@Pointcut(value = "execution(* *.*(..))")
	public void pointCut() {
	}

	@Around(value = "pointCut() && @annotation(catTransaction))", argNames = "joinPoint, catTransaction")
	public Object aroundMethod(ProceedingJoinPoint joinPoint, CatTransaction catTransaction) {
		Transaction transaction = null;
		Object result = null;
		try {
			MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
			Method method = joinPoint.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
			transaction = Cat.newTransaction(catTransaction.name(), method.getName());
			result = joinPoint.proceed();
			transaction.setSuccessStatus();
		} catch (Throwable ex) {
			if (transaction != null) {
				transaction.setStatus(ex);
			}
			Cat.logError(ex);
		} finally {
			if (transaction != null) {
				transaction.complete();
			}
		}
		return result;
	}
}