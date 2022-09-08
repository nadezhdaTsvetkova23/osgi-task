package hello.osgi.en.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import hello.osgi.api.HelloService;


public class Activator implements BundleActivator {
	private ServiceRegistration registration;
	
	private static BundleContext context;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting bundle EN");
		Activator.context = bundleContext;
		Dictionary<String, String> dict = new Hashtable<>();
		dict.put("language", "English");
		this.registration = context.registerService(HelloService.class.getName(), new HelloEN(), dict);
		System.out.println("Loaded EN");
	}
	

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stoping bundle EN");
		this.registration.unregister();
		Activator.context = null;
		System.out.println("Unloaded EN");
	}


}
