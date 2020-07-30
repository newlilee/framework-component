package com.example.ssm.spring.service.impl;

import java.util.List;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author chenlixin at 2017年1月11日 下午6:49:18
 */
public class BeanDenInjectImplFactory {

	public static HelloWorld newInstance(int index, String message, List<Integer> list) {
		return new BeanDenInjectFactory(index, message, list);
	}

	public HelloWorld getInstance(int index, String message, List<Integer> list) {
		return new BeanDenInjectFactory(index, message, list);
	}
}
