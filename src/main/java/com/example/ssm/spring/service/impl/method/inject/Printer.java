package com.example.ssm.spring.service.impl.method.inject;

/**
 * @author clx 2017年5月5日 上午7:31:57
 */
public class Printer {

	private int counter = 0;

	public String print(String type) {
		System.out.println(type + " printer: " + counter++);
		return "I'm print!";
	}
}
