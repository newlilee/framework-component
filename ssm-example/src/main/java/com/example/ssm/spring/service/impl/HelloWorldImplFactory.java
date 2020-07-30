package com.example.ssm.spring.service.impl;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author chenlixin at 2017年1月9日 下午3:43:44
 */
public class HelloWorldImplFactory {

	/**
	 * static factory method
	 * 
	 * @param message
	 * @return
	 */
	public static HelloWorld getInstance(String message) {
		return new HelloWorldFactory(message);
	}

	/**
	 * instance factory method
	 * 
	 * @param message
	 * @return
	 */
	public HelloWorld newInstance(String message) {
		return new HelloWorldFactory(message);
	}
}
