package com.example.ssm.spring.di.circle;

/**
 * @author chenlixin at 2017年1月20日 下午6:53:25
 */
public class CircleFirst {

	private CircleSecond cs;

	public CircleFirst() {
		super();
	}

	public CircleFirst(CircleSecond cs) {
		this.cs = cs;
	}

	public void setCs(CircleSecond cs) {
		this.cs = cs;
	}

	public void cf() {
		cs.cs();
	}
}
