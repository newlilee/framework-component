package org.demo.thrift;

import org.apache.thrift.TException;

public class HelloServiceImpl implements HelloService.Iface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.demo.thrift.HelloService.Iface#helloString(java.lang.String)
	 */
	@Override
	public String helloString(String param) throws TException {
		return param;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.demo.thrift.HelloService.Iface#helloInt(int)
	 */
	@Override
	public int helloInt(int param) throws TException {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return param;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.demo.thrift.HelloService.Iface#helloBoolean(boolean)
	 */
	@Override
	public boolean helloBoolean(boolean param) throws TException {
		return param;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.demo.thrift.HelloService.Iface#helloVoid()
	 */
	@Override
	public void helloVoid() throws TException {
		System.out.println("Hello,Thrift!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.demo.thrift.HelloService.Iface#helloNull()
	 */
	@Override
	public String helloNull() throws TException {
		return null;
	}
}
