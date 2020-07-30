package org.example.spring.aop;

/**
 * schema
 * 
 * @author clx at 2017年5月25日 下午6:08:56
 */
public interface HelloWorldService {

	/**
	 * say hello
	 */
	void sayHello();

	/**
	 * say hello with param
	 * 
	 * @param param
	 */
	void sayHello(String param);
}
