# osgi-task
Simple Java Project using OSGi framework with Equinox.
## Description
The purpose of the Web App is to greet someone by name in different languages. In my case there are two languages - English and German. 
In the web browser the user should select which language prefers and write a name, then it displays the greeting in the corresponding language.

The project consists of 4 bundles - one for the API, one for each language implementation and one for the servlet, which helps us to visualise it in the web browser and uses one additional index.html file.
In the servlet bundle I use ServiceTracker and Activator. 

## Instructions

You need to create new Run Configurations from Run > Run Configurations > OSGi Framework > New Configuration > Bundles add all bundles from your workspace (in this case 4),
then add the required bundles:
- org.eclipse.osgi
- org.eclipse.osgi.util
- org.eclipse.osgi.services
- org.eclipse.equinox.console
- org.apache.felix.gogo.command
- org.apache.felix.gogo.runtime
- org.apache.felix.gogo.shell
- org.apache.felix.scr
- org.eclipse.jetty.http
- org.eclipse.equinox.http.jetty
- org.eclipse.equinox.http.servlet
- javax.servlet.jsp
click on Select Requiered Button 

in the Arguments tab it needs to look like this:

![osgi-task-run-config](https://media.github.softwareag.com/user/2541/files/d5b6b76f-e481-4929-9ef1-f58e26ad9168)

In the hello.osgi.api bundle in the MANIFEST.MF > Dependencies > Imported Packeges 
add:
- hello.osgi.servlet,
- org.osgi.framework;version="1.10.0",
- org.osgi.service.http;version="1.2.1",
- org.osgi.util.tracker;version="1.5.3"
