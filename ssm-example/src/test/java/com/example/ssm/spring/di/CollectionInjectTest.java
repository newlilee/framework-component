package com.example.ssm.spring.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author clx at 2017年5月26日 上午11:43:16
 */
public class CollectionInjectTest {

	@Test
	public void testCollectionInject() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/com.example.ssm/spring/biz-service-di-inject-test.xml");
		HelloWorld bean = context.getBean("helloWorld", HelloWorld.class);
		bean.sayHello();
	}
}
