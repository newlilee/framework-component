package org.example.spring.service.bean;

import org.example.spring.service.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenlixin at 2017年1月4日 下午4:21:24
 */
public class HelloWorldTest {

	@Test
	public void helloWorld() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/org.example.spring/service/biz-service.xml");
		HelloWorld bean = context.getBean("helloWorld", HelloWorld.class);
		// HelloWorld bean = context.getBean(HelloWorld.class);
		bean.sayHello();

		// BeanFactory factory = new ClassPathXmlApplicationContext(
		// "classpath:/com.spring.basic.org.example.spring.service/spring/biz-org.example.spring.service.xml");
		// HelloWorld bean = factory.getBean("helloWorld", HelloWorld.class);
		// String[] aliases = factory.getAliases("helloWorld");
		// for (String alias : aliases) {
		// System.out.println(alias);
		// }
		// Assert.assertEquals(2, aliases.length);
		// factory.getBean("hello", HelloWorld.class).sayHello();
		// factory.getBean("helloCon", HelloWorld.class).sayHello();
	}
}
