package hello.osgi.servlet;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

public class HttpServiceTracker extends ServiceTracker{
	
	public HttpServiceTracker(BundleContext context) {
		super(context, HttpService.class.getName(), null);
	}
	
	public Object addingService(ServiceReference reference) {
		
		HttpService httpService = (HttpService) super.addingService(reference);
		
		if(httpService == null) {
			return null;
		}
		BundleContext context = reference.getBundle().getBundleContext();
		
		try {
			System.out.println("Registering service at /osgi-task");
			httpService.registerResources("/index.html", "/index.html", null);
			httpService.registerServlet("/osgi-task", new MyServlet(context), null, null);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return httpService;
	}
	
	public void removedService(ServiceReference reference, Object service) {
		HttpService httpService = (HttpService) service;
		
		System.out.println("Uregistering /osgi-task");
		httpService.unregister("/index.html");
		httpService.unregister("/osgi-task");
		
		super.removedService(reference, service);
		
	}
}
