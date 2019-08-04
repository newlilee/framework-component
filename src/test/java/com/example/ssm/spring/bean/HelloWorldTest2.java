package com.example.ssm.spring.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author chenlixin at 2017年1月4日 下午4:21:24
 */
public class HelloWorldTest2 {

	@Test
	public void helloWorld() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/com.example.ssm/spring/biz-service-bean-init.xml");
		HelloWorld bean = context.getBean("helloWorld", HelloWorld.class);
		bean.sayHello();
	}
}
