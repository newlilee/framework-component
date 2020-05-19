package com.example.ssm.distributed.traffic.interceptor;

import com.example.ssm.distributed.traffic.core.RedisLimit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author clx
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CommonLimitAspect {

	private RedisLimit redisLimit;

	@Autowired
	public CommonLimitAspect(RedisLimit redisLimit) {
		this.redisLimit = redisLimit;
	}

	@Pointcut("@annotation(com.example.ssm.distributed.traffic.annotation.CommonLimit)")
	private void checkLimit() {
	}

	@Before("checkLimit()")
	public void beforeLimit(JoinPoint joinPoint) {
		if (redisLimit == null) {
			throw new RuntimeException("Redis limit is null.");
		}

		boolean result = redisLimit.limit();
		if (!result) {
			throw new RuntimeException("Request limit.");
		}
	}
}