package org.example.spring.service.impl;

import org.example.spring.service.HelloWorld;

/**
 * @author chenlixin at 2017年1月16日 下午4:04:41
 */
public class BeanIDRefImpl implements HelloWorld {

	private String name;

	public BeanIDRefImpl() {
		super();
	}

	public BeanIDRefImpl(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		System.out.println("name:" + this.getName());
	}
}
