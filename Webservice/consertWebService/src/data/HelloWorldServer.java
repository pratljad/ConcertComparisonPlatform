package data;

import javax.jws.WebService;

import interfaces.IHelloWorldServer;

@WebService(endpointInterface = "interfaces.IHelloWorldServer")
public class HelloWorldServer implements IHelloWorldServer {
	
	public String sayHello(String name) {
		return "Hello " + name + " !, Hope you are doing well !!";
	}

}