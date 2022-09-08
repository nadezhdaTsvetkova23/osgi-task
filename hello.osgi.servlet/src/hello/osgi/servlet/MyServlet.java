package hello.osgi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import hello.osgi.api.HelloService;

public class MyServlet extends HttpServlet {

	private BundleContext context;

	public MyServlet(BundleContext context) {
		this.context = context;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		String name_ = req.getParameter("fname");
		String language = req.getParameter("language");
		String filter = "(language=" + language + ")";
		Collection<ServiceReference<HelloService>> helloServiceEN;
		try {
			helloServiceEN = context.getServiceReferences(HelloService.class, filter);
			HelloService serviceEN = context.getService(helloServiceEN.iterator().next());
			
			out.println(serviceEN.sayHello(name_));
		} catch (Exception e) {
			out.println("Don't have chosen language!");
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
		

	}
}
