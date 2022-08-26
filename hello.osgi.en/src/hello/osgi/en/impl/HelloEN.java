package hello.osgi.en.impl;

import hello.osgi.api.HelloService;

public class HelloEN implements HelloService  {
	
	public HelloEN() {
	}
	
	@Override
	public String sayHello(String name) {
		if(name != null) {
			if(name.isBlank())
				return "Don't have given name!";
			return "Hello, " + name + "!";
		}
		return "Name is null";
	}
	
}
