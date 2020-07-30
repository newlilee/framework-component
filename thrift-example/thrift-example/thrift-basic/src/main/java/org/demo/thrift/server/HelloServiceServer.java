package org.demo.thrift.server;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.*;
import org.demo.thrift.HelloService;
import org.demo.thrift.HelloServiceImpl;

import java.io.IOException;

public class HelloServiceServer {

	private static final int SERVER_PORT = 9080;
	private static final int TIMEOUT = 300;

	/*public static void main(String[] args) {
		try {
			// 设置监听端口
			TServerTransport tTransport = new TServerSocket(SERVER_PORT);
			// 设置协议工厂
			Factory protocolFactory = new TBinaryProtocol.Factory();
			// 关联处理器与服务实现
			TProcessor processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
			TServer server = new TThreadPoolServer(
					new Args(tTransport).processor(processor).protocolFactory(protocolFactory));
			System.out.println("Start server on port 9080...");
			server.serve();
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public static void main(String[] args) {
		try {
			TNonblockingServerSocket tTransport = new TNonblockingServerSocket(SERVER_PORT, TIMEOUT);
			TCompactProtocol.Factory protocol = new TCompactProtocol.Factory();
			TMultiplexedProcessor processor = new TMultiplexedProcessor();
			processor.registerProcessor("HelloService", new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl()));

			TNonblockingServer.Args arg = new TNonblockingServer.Args(tTransport);
			arg.protocolFactory(protocol);
			arg.processorFactory(new TProcessorFactory(processor));
			TServer server = new TNonblockingServer(arg);

			System.out.println("Thrift server start on 9080...");
			server.serve();

		} catch (TTransportException ex) {
			ex.printStackTrace();
		}
	}
}
