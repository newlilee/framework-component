package com.example.ssm.spring.aop.impl;

import com.example.ssm.spring.aop.HelloWorldService;

/**
 * @AspectJ
 * @author clx 2017年7月30日 下午7:58:09
 */
public class AspectJServiceImpl implements HelloWorldService {

	@Override
	public void sayHello() {
	}

	@Override
	public void sayHello(String param) {
		System.out.println("say:" + param);
	}

}
