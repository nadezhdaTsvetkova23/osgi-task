# osgi-task
Simple Java Project using OSGi framework with Equinox.
## Description
The purpose of the Web App is to greet someone by name in different languages. In my case there are two languages - English and German. 
In the web browser the user should select which language prefers and write a name, then it displays the greeting in the corresponding language.

The project consists of 4 bundles - one for the API, one for each language implementation and one for the servlet, which helps us to visualise it in the web browser and uses one additional index.html file.
In the servlet bundle I use ServiceTracker and Activator. 

## Instructions
1. You need to clone the project on your local machine and use Eclipse for your IDE

2. Create new Run Configurations from Run > Run Configurations > OSGi Framework > New Configuration > Bundles add all bundles from your workspace (in this case 4),
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

3. In the Arguments tab it needs to look like this:

![osgi-task-run-config](https://media.github.softwareag.com/user/2541/files/d5b6b76f-e481-4929-9ef1-f58e26ad9168)

4. ***In the hello.osgi.api bundle***  

MANIFEST.MF > Dependencies > Imported Packeges 
add:
- hello.osgi.servlet,
- org.osgi.framework;version="1.10.0",
- org.osgi.service.http;version="1.2.1",
- org.osgi.util.tracker;version="1.5.3"

MANIFEST.MF > Runtime > Exported Packages 
- hello.osgi.api

***In the hello.osgi.en and hello.osgi.de***

MANIFEST.MF > Dependencies > Imported Packeges 
add:
- hello.osgi.api,
- org.osgi.framework;version="1.10.0",
- org.osgi.service.component.annotations;version="1.3.0";resolution:=optional

MANIFEST.MF > Runtime > Exported Packages 
- hello.osgi.en.impl or hello.osgi.de.impl

***In the hello.osgi.servlet bundle***

MANIFEST.MF > Dependencies > Imported Packeges 
add:
- hello.osgi.api,
- hello.osgi.de.impl,
- hello.osgi.en.impl,
- javax.servlet;version="4.0.0",
- javax.servlet.annotation;version="4.0.0",
- javax.servlet.http;version="4.0.0",
- org.eclipse.equinox.http.jetty;version="1.5.0",
- org.eclipse.equinox.http.servlet;version="1.2.0",
- org.osgi.framework;version="1.3.0",
- org.osgi.service.http;version="1.2.1",
- org.osgi.service.http.context;version="1.1.0",
- org.osgi.service.http.runtime;version="1.1.0",
- org.osgi.service.http.whiteboard;version="1.1.0",
- org.osgi.util.tracker;version="1.5.3"

MANIFEST.MF > Runtime > Exported Packages 
- hello.osgi.servlet

5. Run the project with the specified run configurations and make sure all of the 4 bundles are in ACTIVE state
6. Open http://localhost:8080/index.html and use the web app with selected language and given name, then go back and repeat
