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


