package hello.osgi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import hello.osgi.api.HelloService;

@Component(service = MyServlet.class, property = "osgi.http.whiteboard.servlet.pattern=/index.html", scope=ServiceScope.PROTOTYPE)
public class MyServlet extends HttpServlet {

	@Reference
	HelloService helloService;
	
	private BundleContext context;

	public MyServlet() {
	}
	
	public MyServlet(BundleContext context) {
		this.context = context;
	}

	public void init() {
	}
	public void destroy() {
	}
	@Activate
    public void activate(BundleContext context) {
        this.helloService = (HelloService) context;
		//helloService.sayHello("Pesho");
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		String name_ = req.getParameter("fname");
		String language = req.getParameter("language");
		
		helloService.sayHello(name_);
//		String filter = "(language=" + language + ")";
//		Collection<ServiceReference<HelloService>> helloServiceEN;
//		try {
//			helloServiceEN = context.getServiceReferences(HelloService.class, filter);
//			HelloService serviceEN = context.getService(helloServiceEN.iterator().next());
//			
//			out.println(serviceEN.sayHello(name_));
//		} catch (Exception e) {
//			out.println("Don't have chosen language!");
//			e.printStackTrace();
//			//throw new RuntimeException(e);
//		}
		
	}
}
