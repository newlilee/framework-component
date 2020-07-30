package com.example.ssm.spring.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author chenlixin at 2017年1月4日 下午4:21:24
 */
public class HelloScopeTest {

	@Test
	public void helloWorld() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/com.example.ssm/spring/biz-service-bean-scope.xml");
		HelloWorld bean = context.getBean("helloCustomScope", HelloWorld.class);
		bean.sayHello();
	}
}
