package org.demo.thrift.async;

import org.apache.thrift.TException;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import org.demo.thrift.HelloService;

import java.io.IOException;

public class HelloServiceAsyncClient {

    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 9080;

    public static void main(String[] args) {
        try {
            TAsyncClientManager asyncClientManager = new TAsyncClientManager();
            TNonblockingTransport transport = new TNonblockingSocket(SERVER_IP, SERVER_PORT);
            TProtocolFactory protocolFactory = new TCompactProtocol.Factory();
            HelloService.AsyncClient asyncClient = new HelloService.AsyncClient(protocolFactory, asyncClientManager, transport);

            System.out.println("Async client calls...");

            MethodCallback callback = new MethodCallback();
            asyncClient.helloString("Hello, AsyncClient", callback);

            Object res = callback.getResult();
            /*while (res == null) {
                res = callback.getResult();
            }*/

            System.out.println(((HelloService.AsyncClient.helloString_call) res).getResult());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
