package org.example.spring.service.di;

import org.example.spring.service.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author clx at 2017年5月26日 上午11:43:16
 */
public class CollectionInjectTest {

    @Test
    public void testCollectionInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:/com.spring.basic.org.example.spring.service/spring/biz-org.example.spring.service-di-inject-test.xml");
        HelloWorld bean = context.getBean("helloWorld", HelloWorld.class);
        bean.sayHello();

    }
}
