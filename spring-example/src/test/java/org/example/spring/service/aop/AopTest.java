package org.example.spring.service.aop;

import org.example.spring.aop.HelloWorldService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * aop test
 * 
 * @author clx at 2017年5月25日 下午7:15:27
 */
public class AopTest {

	/**
	 * aop base schema
	 */
	@Test
	public void testAopHelloWorld() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:/org.example.spring/service/biz-service-aop-schema.xml");
		HelloWorldService service = ctx.getBean("helloWorld", HelloWorldService.class);
		service.sayHello();
	}

	/**
	 * aop base aspectj annotation
	 */
	@Test
	public void testAopAspectj() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:/org.example.spring/service/biz-service-aop-annotation.xml");
		ctx.getBean("helloWorld", HelloWorldService.class).sayHello("before");
	}

	@Test
	public void testAroundAdvice() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/org.example.spring/service/biz-service-aop-schema.xml");
		context.getBean("helloWorld", HelloWorldService.class).sayHello("aop");
	}
}
