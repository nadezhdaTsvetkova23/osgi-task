package hello.osgi.en.impl;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import hello.osgi.api.HelloService;

@Component(immediate = true, service = HelloService.class)
public class HelloEN implements HelloService  {
//	@Reference 
//	HelloService helloService;
//	
	//public HelloEN() {
//		this.helloService = null;
	//}
	
//	@Activate
//    public HelloEN(final @Reference HelloService helloService) {
//        this.helloService = helloService;
//    }

	@Activate
    public void activate() {
		System.out.println("HelloEN is active!");
    }
	
	@Deactivate
    public void deactivate() {
        System.out.println("HelloEN is unactive!");
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