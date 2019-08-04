package com.example.ssm.spring.service.impl;

import java.beans.ConstructorProperties;
import java.util.List;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author chenlixin at 2017年1月11日 下午6:41:02
 */
public class BeanDenInjectFactory implements HelloWorld {

	private int index;
	private String message;
	private List<Integer> idList;

	public BeanDenInjectFactory() {
		super();
	}

	@ConstructorProperties({ "index", "message", "idList" })
	public BeanDenInjectFactory(int index, String message, List<Integer> idList) {
		this.index = index;
		this.message = message;
		this.idList = idList;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setIdList(List<Integer> list) {
		this.idList = list;
	}

	@Override
	public void sayHello() {
		System.out.println("index:" + index + "-" + this.message + ":" + this.idList);
	}

}
