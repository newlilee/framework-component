package com.example.ssm.spring.service.impl;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author clx 2017年1月8日 下午10:21:09
 */
public class HelloWorldImplSecond implements HelloWorld {

	private String message;

	public HelloWorldImplSecond() {
		this.message = "Hello World second";
	}

	public HelloWorldImplSecond(String message) {
		this.message = message;
	}

	@Override
	public void sayHello() {
		System.out.println(message);
	}

}
