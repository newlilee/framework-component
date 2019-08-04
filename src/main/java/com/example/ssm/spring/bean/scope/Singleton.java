package com.example.ssm.spring.bean.scope;

/**
 * @author clx 2017年5月9日 下午10:47:29
 */
public class Singleton {

	private int counter = 0;

	private Singleton() {}

	private static class InstanceHolder {
		private static final Singleton Instance = new Singleton();
	}

	public static Singleton getInstance() {
		return InstanceHolder.Instance;
	}
}
