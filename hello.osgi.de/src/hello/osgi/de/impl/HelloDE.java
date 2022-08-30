package hello.osgi.de.impl;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import hello.osgi.api.HelloService;

@Component(immediate = true, service = HelloService.class)
public class HelloDE implements HelloService  {
//	protected final @Reference HelloService helloService;
//	
//	public HelloDE() {
//		this.helloService = null;
//	}
	
//	@Activate
//    public HelloEN(final @Reference HelloService helloService) {
//        this.helloService = helloService;
//    }

	@Activate
    public void activate() {
        System.out.println("HelloDE is active!");
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
