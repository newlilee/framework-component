package com.example.thrift.async;

import com.example.thrift.HelloService;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TTransportException;
import com.example.thrift.HelloServiceImpl;

/**
 * @author clx
 */
public class HelloServiceAsyncServer {

    private static final int SERVER_PORT = 9080;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) {
        try {
            TNonblockingServerTransport transport = new TNonblockingServerSocket(SERVER_PORT, TIMEOUT);
            TCompactProtocol.Factory protocol = new TCompactProtocol.Factory();
            TMultiplexedProcessor processor = new TMultiplexedProcessor();
            processor.registerProcessor("HelloService", new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl()));

            TNonblockingServer.Args arg = new TNonblockingServer.Args(transport);
            arg.protocolFactory(protocol);
            arg.processorFactory(new TProcessorFactory(processor));

            TNonblockingServer server = new TNonblockingServer(arg);
            System.out.println("Thrift async server start on 9080...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
