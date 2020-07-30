package com.example.ssm.spring.service.impl;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author chenlixin at 2017年1月4日 下午4:05:13
 */
public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHello() {
		System.out.println("Hello,World!");
	}
}
