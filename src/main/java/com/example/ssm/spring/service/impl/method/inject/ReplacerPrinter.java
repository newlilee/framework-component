package com.example.ssm.spring.service.impl.method.inject;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

/**
 * @author clx at 2017年5月9日 上午10:57:42
 */
public class ReplacerPrinter implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) {
		System.out.println("--replacer printer--");
		return "dfd";
	}
}
