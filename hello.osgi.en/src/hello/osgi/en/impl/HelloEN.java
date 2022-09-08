package hello.osgi.en.impl;

import org.osgi.service.component.annotations.Component;

import hello.osgi.api.HelloService;

@Component
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
