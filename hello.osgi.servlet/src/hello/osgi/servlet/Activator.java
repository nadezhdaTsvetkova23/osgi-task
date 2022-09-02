package hello.osgi.servlet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private HttpServiceTracker serviceTracker;
	private static BundleContext context;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		serviceTracker = new HttpServiceTracker(context);
		serviceTracker.open();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		serviceTracker.close();
		serviceTracker = null;
		
	}

}
