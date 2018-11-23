package app;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import interfaces.IHelloWorldServer;

public class Client {

	public static void main(String[] args) {

		try {

			URL url = new URL("http://localhost:9876/hw?wsdl");
			QName qname = new QName("http://data/",
					"HelloWorldServerService");

			Service service = Service.create(url, qname);

			IHelloWorldServer server = service.getPort(IHelloWorldServer.class);
			String name = "prasad";
			System.out.println(server.sayHello(name));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}