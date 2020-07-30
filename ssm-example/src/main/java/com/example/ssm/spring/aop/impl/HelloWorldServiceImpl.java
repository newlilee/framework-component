package com.example.ssm.spring.aop.impl;

import com.example.ssm.spring.aop.HelloWorldService;

/**
 * schema
 * 
 * @author clx at 2017年5月25日 下午6:09:45
 */
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public void sayHello() {
		System.out.println("*****say hello*****");
	}

	@Override
	public void sayHello(String param) {
		System.out.println("*****say hello " + param + "*****");
	}
}
