package org.example.spring.service.di;

import org.example.spring.di.navigation.NavigationThree;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenlixin at 2017年1月4日 下午4:21:24
 */
public class HelloWorldTest3 {

	@Test
	public void helloWorld() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/org.example.spring/service/biz-service-di-inject.xml");
		// HelloWorld bean = context.getBean("helloWorld", HelloWorld.class);
		// bean.sayHello();

		// HelloWorld bean = context.getBean("bySetter", HelloWorld.class);
		// bean.sayHello();

		// HelloWorld bean = context.getBean("beanId3", HelloWorld.class);
		// bean.sayHello();

		// HelloWorld bean = context.getBean("beanInject3", HelloWorld.class);
		// bean.sayHello();

		// HelloWorld bean = context.getBean("beanInjectNull",
		// HelloWorld.class);
		// bean.sayHello();

		NavigationThree bean = context.getBean("NavigationThree", NavigationThree.class);
		bean.getNavigationSecond().getList().get(0).sayNavigation();
	}
}
