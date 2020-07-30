package com.example.ssm.spring.service.impl.method.inject;

import com.example.ssm.spring.service.HelloWorld;

/**
 * @author clx 2017年5月5日 上午7:34:46
 */
public abstract class MethodInjectImpl implements HelloWorld {

	private Printer printer;

	@Override
	public void sayHello() {
		printer.print("setter");
		createPrototypePrinter().print("prototype");
		createSingletonPrinter().print("singleton");
	}

	/**
	 * printer
	 * 
	 * @return
	 */
	public abstract Printer createPrototypePrinter();

	public Printer createSingletonPrinter() {
		System.out.println("wrong");
		return new Printer();
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
}
