package org.example.spring.service.di;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenlixin at 2017年1月4日 下午4:21:24
 */
public class HelloWorldTest4 {

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void helloWorld() throws Throwable {
        try {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:/com.spring.basic.org.example.spring.service/spring/biz-org.example.spring.service-di-circle.xml");
        } catch (Exception ex) {
            Throwable cause = ex.getCause().getCause().getCause();
            throw cause;
        }

    }
}
