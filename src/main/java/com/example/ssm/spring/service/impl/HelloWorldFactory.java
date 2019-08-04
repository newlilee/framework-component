package com.example.ssm.spring.service.impl;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author chenlixin at 2017年1月9日 下午3:42:23
 */
public class HelloWorldFactory implements HelloWorld {

	private String message;

	public HelloWorldFactory(String message) {
		this.message = message;
	}

	@Override
	public void sayHello() {
		System.out.println(this.message);
	}
}
