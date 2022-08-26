package hello.osgi.de.impl;

import hello.osgi.api.HelloService;

public class HelloDE implements HelloService {

	public HelloDE() {	
	}
	
	@Override
	public String sayHello(String name) {
		if(name != null) {
			if(name.isBlank())
				return "Don't have given name!";
			return "Hallo, " + name + "!";
		}
		return "Name is null";
	}

}
