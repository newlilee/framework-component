package org.demo.thrift.client;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.demo.thrift.HelloService;

public class HelloServiceClient {

    private static final String SERVER_IP = "localhost";
    private static final int CLIENT_PORT = 9080;

	/*public static void main(String[] args) {
        try {
			TTransport transport = new TSocket(SERVER_IP, CLIENT_PORT);
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			HelloService.Client client = new HelloService.Client(protocol);
			System.out.println(client.helloString("hahaha"));
			transport.close();
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

    /*public static void main(String[] args) {

        TTransport transport = new TFramedTransport(new TSocket(SERVER_IP, CLIENT_PORT));
        TProtocol protocol = new TCompactProtocol(transport);
        TMultiplexedProtocol tMultiplexedProtocol = new TMultiplexedProtocol(protocol, "HelloService");
        HelloService.Client client = new HelloService.Client(tMultiplexedProtocol);
        try {
            transport.open();
            System.out.println(client.helloString("Hello,Thrift!"));
        } catch (TTransportException ex) {
            ex.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            transport.close();
        }
    }*/

    public static void main(String[] args) {

        TTransport transport = new TFramedTransport(new TSocket(SERVER_IP, CLIENT_PORT));
        TProtocol protocol = new TCompactProtocol(transport);
        TMultiplexedProtocol tMultiplexedProtocol = new TMultiplexedProtocol(protocol, "HelloService");
        HelloService.Client client = new HelloService.Client(tMultiplexedProtocol);
        try {
            transport.open();
            System.out.println(client.helloNull());
        } catch (TTransportException ex) {
            ex.printStackTrace();
        } catch (TException e) {
            if (e instanceof TApplicationException
                    && ((TApplicationException) e).getType() ==
                    TApplicationException.MISSING_RESULT) {
                System.out.println("The result of helloNull function is NULL");
            }
        } finally {
            transport.close();
        }
    }
}
