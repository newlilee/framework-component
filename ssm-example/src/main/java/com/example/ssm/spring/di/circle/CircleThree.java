package com.example.ssm.spring.di.circle;

/**
 * @author chenlixin at 2017年1月20日 下午6:53:25
 */
public class CircleThree {

	private CircleFirst cf;

	public CircleThree() {
		super();
	}

	public CircleThree(CircleFirst cf) {
		this.cf = cf;
	}

	public void setCt(CircleFirst cf) {
		this.cf = cf;
	}

	public void ct() {
		cf.cf();
	}
}
