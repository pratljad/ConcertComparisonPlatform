package app;

import javax.xml.ws.Endpoint;

import data.HelloWorldServer;

public class Server {

	public static void main(String[] args) {

		System.out.println("Beginning to publish HelloWorldService now");
		Endpoint.publish("http://127.0.0.1:9876/hw", new HelloWorldServer());
		System.out.println("Done publishing");
	}

}