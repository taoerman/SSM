package com.example.spring01ioc;

import com.example.spring01ioc.Bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/*
this is the main entrance class
 */
@SpringBootApplication
public class Spring01IocApplication {

    public static void main(String[] args) {
        //1. run a spring app
        //ConfigurableApplicationContext: this is an interface, also is Ioc container
        // when SpringApplication run, would return a container
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("ioc = " + ioc);

        //2. what components does this ioc contain?
        //get all names of components in the ioc
        // spring starts running, there would be so many default components
        String[] names = ioc.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++){
            System.out.println("name = " + names[i]);
        }
    }

    //3. inject a component into ioc
    // every component has its own name, method name is component name.
    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("Qi");
        person.setAge(31);
        person.setGender("male");

        return person;
    }
    /*
    The Spring @Bean annotation marks a method as a bean definition for the Spring container.
    In other words, when Spring initializes your application context,
    it will call any methods annotated with @Bean and register the returned object as a managed bean. Key points include:
	•	Instantiation and Configuration: Spring will instantiate and manage the lifecycle of the returned object.
	•	Dependency Injection: Other components in your application can receive (or “autowire”)
	    this bean via constructor injection or field injection.
	•	Singleton By Default: Unless otherwise specified,
	    the object is created as a singleton bean (one instance shared throughout the application context),
	    although you can configure different scopes (e.g., prototype, request, etc.).

So, @Bean effectively tells Spring, “Here’s how to create and configure an object that I want you to manage.”
     */

}
