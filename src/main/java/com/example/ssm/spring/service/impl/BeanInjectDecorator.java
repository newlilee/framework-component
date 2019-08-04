package com.example.ssm.spring.service.impl;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author chenlixin at 2017年1月17日 下午3:43:07
 */
public class BeanInjectDecorator implements HelloWorld {

	private HelloWorld helloWorld;

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	public BeanInjectDecorator() {
		super();
	}

	public BeanInjectDecorator(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	@Override
	public void sayHello() {
		System.out.println("Decorator...");
		helloWorld.sayHello();
	}
}
