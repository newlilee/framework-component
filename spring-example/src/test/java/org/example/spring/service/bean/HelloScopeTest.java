package org.example.spring.service.bean;

import org.example.spring.service.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenlixin at 2017年1月4日 下午4:21:24
 */
public class HelloScopeTest {

	@Test
	public void helloWorld() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/org.example.spring/service/biz-service-bean-scope.xml");
		HelloWorld bean = context.getBean("helloCustomScope", HelloWorld.class);
		bean.sayHello();
	}
}
