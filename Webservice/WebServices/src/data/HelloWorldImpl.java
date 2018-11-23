package data;

import javax.jws.WebService;

//Service Implementation Bean

@WebService(endpointInterface = "data.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString() {
		return "Hello World JAX-WS";
	}
}