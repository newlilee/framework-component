package com.example.ssm.distributed.traffic.interceptor;

import com.example.ssm.distributed.traffic.annotation.WebLimit;
import com.example.ssm.distributed.traffic.core.RedisLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author clx
 */
@Component
public class WebInterceptor implements WebMvcConfigurer {

	private RedisLimit redisLimit;

	@Autowired
	public WebInterceptor(RedisLimit redisLimit) {
		this.redisLimit = redisLimit;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new WebLimitInterceptor()).addPathPatterns("/**");
	}

	private class WebLimitInterceptor extends HandlerInterceptorAdapter {
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			if (redisLimit == null) {
				throw new RuntimeException("redis limit is null.");
			}

			if (handler instanceof HandlerMethod) {
				HandlerMethod method = (HandlerMethod) handler;
				WebLimit webLimit = method.getMethodAnnotation(WebLimit.class);
				if (webLimit == null) {
					return true;
				}
				boolean result = redisLimit.limit();
				if (!result) {
					response.sendError(webLimit.errorCode(), "request limited.");
					return false;
				}
			}
			return true;
		}
	}
}
