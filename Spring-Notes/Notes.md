# Spring Bean Life Cycle:

https://www.geeksforgeeks.org/bean-life-cycle-in-java-spring/

1. comtainer starts.
2. beans are instantiated
3. dependencies injected (depending on request)
4. custom init() ---> if defined
5. utility methods
6. destroy() method ----> if defined
7. container closed

Spring provides 3 ways to use the life cycle of the beans:


1. XML approach:


2. Programmatic approach:

implement the Bean class with 2 interfaces - 
InitializableBean, DisposableBean.

for correcponsing to init 

override method called - afterPropertiesSet()

for corresponding to destroy

override method called - destroy()

3. Annotation Approach:

* in bean class annotate the bean with postConstruct() --- alternative of init.
* in bean class annotate the bean with preDestroy() ---- alternative of destroy.

# Application Context and Servlet Context

* Servlet Context:
It is initialized when a Servlet application is deployed. Servlet Context holds all the configurations (init-param, context-params, etc) of the whole servlet application.

* Application Context:

It is a Spring specific thing. It is initialized by Spring. It holds all the bean definitions and life-cycle of the beans that are defined inside the spring configuration files. Servlet-Context has no idea about these things.

# Dispatcher Servlet

* Dispatcher Servlet is kind of the front controller.
it receiver all the requests coming from client, and decides to which controller the specific request should go to, to handle.
After, the processing of the request is done, the specific controller sends the response back to Dispatcher servlet which in turn sends the response back to Client.

* Configuring Dispatcher Servlet.

- in WEB-INF/web.xml file we have to configure our front controller / Dispatcher Servlet.
- we have got a servlet let as below

<servlet>

    <!-- Provide a Servlet Name -->
    <servlet-name>frontcontroller-dispatcher</servlet-name>
    
    <!-- Provide a fully qualified path to the DispatcherServlet class -->
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    
</servlet>

Now let’s tell this servlet, hey servlet you have to handle all the requests coming to our website called gfg.com (for this example). So the way we are going to tell the above servlet is we can write something like this

<servlet-mapping>

    <!-- Provide a Servlet Name that you want to map -->
    <servlet-name>frontcontroller-dispatcher</servlet-name>
    
    <!-- Provide a url pattern -->
    <url-pattern>/gfg.com/*</url-pattern>
    
</servlet-mapping>







# Spring Boot Embedded Servers

C:\Interview-Preparation\Interview-Preparation\Spring-Notes

* https://www.javaguides.net/2019/04/spring-boot-embedded-servers-tomcat-jetty-and-undertow.html#:~:text=Spring%20Boot%20includes%20support%20for,HTTP%20requests%20on%20port%208080.

* When switching to a different HTTP server, you need to exclude the default dependencies in addition to including the one you need. Spring Boot provides separate starters for HTTP servers to help make this process as easy as possible.
Let's look at how to configure Jetty and Undertow web servers.

* <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <!-- Exclude the Tomcat dependency -->
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<!-- Use Jetty instead -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>



# Inject custom peroperties in Spring Boot App

in application.properties file define properties like below

coach.name=Andrew Garfield
team.name=The Mouse Club

in RestController

@RestController
public Class FunRestController {

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

}


# Ambiguity in Dependency Injection

* @Qualifier

If more than one bean of the same type is available in the container, the framework will throw NoUniqueBeanDefinitionException, indicating that more than one bean is available for autowiring.

To avoid this problem, there are several solutions; the @Qualifier annotation is one of them.

By using the @Qualifier annotation, we can eliminate the issue of which bean needs to be injected.

public class FooService {
     
    @Autowired
    @Qualifier("fooFormatter")
    private Formatter formatter;
}

We need to take into consideration that the qualifier name to be used is the one declared in the @Component annotation.

Note that we could have also used the @Qualifier annotation on the Formatter implementing classes, instead of specifying the names in their @Component annotations, to obtain the same effect:


* @Qualifier vs @Primary

There’s another annotation called @Primary that we can use to decide which bean to inject when ambiguity is present regarding dependency injection.

This annotation defines a preference when multiple beans of the same type are present. The bean associated with the @Primary annotation will be used unless otherwise indicated.

# ApplicationContext
* also known as Spring Container.
* ApplicationContext is where it stores all the instances of the all the Beans present in our classpath.
* also helps in managing all the beans.

# @Component


# @Configuration

* @Configuration indicates that the class has @Bean definition methods.
so spring container can read those classes and process those beans.

* Example:

a simple bean class - 


package com.journaldev.spring;

public class MyBean {

	public MyBean() {
		System.out.println("MyBean instance created");
	}
	
}

before we use any of the spring framework classes we have to import its dependency in pom.xml.

<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>5.0.6.RELEASE</version>
</dependency>

now, lets create a Spring configuration class

@Configuration
public class MyConfiguration {

    @Bean
    public MyBean myBean() {
		return new MyBean();
	}
	
}

now, lets configure our Spring Configuration class - 
public class MySpringApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(MyConfiguration.class);
		ctx.refresh();

		// MyBean mb1 = ctx.getBean(MyBean.class); beans not requested - commented

		// MyBean mb2 = ctx.getBean(MyBean.class);

		ctx.close();
	}

}


Output:





