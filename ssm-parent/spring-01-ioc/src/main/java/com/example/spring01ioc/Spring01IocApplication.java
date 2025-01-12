package com.example.spring01ioc;

import com.example.spring01ioc.Bean.Dog;
import com.example.spring01ioc.Bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/*
this is the main entrance class
 */
@SpringBootApplication
public class Spring01IocApplication {

    /*
    * creating time : during the starting of ioc, the component object will be created as well
    * singleton : all  the components are singleton. Just one object would be created.
    * component : framework's base configurations - > using configuration class
    * actually, configuration class also is component
    */
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);

        System.out.println("************************ioc has been created!!!!***********************************");

        Dog bean = ioc.getBean(Dog.class);
        System.out.println("bean = " + bean);

        Dog bean1 = ioc.getBean(Dog.class);
        System.out.println("bean = " + bean1);

        Dog bean2 = ioc.getBean(Dog.class);
        System.out.println("bean = " + bean2);


    }

    public static void test01BeanAnnotation(String[] args) {
        //1. run a spring app
        //ConfigurableApplicationContext: this is an interface, also is Ioc container
        // when SpringApplication run, would return a container
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("ioc = " + ioc);

        System.out.println("***********************************************************");

        //2. what components does this ioc contain?
        //get all names of components in the ioc
        // spring starts running, there would be so many default components
//        String[] names = ioc.getBeanDefinitionNames();
//        for (int i = 0; i < names.length; i++){
//            System.out.println("name = " + names[i]);
//        }


        //4. get component objects from ioc : get certain component from ioc accurately
        // four features of component : name, type, object, scope
        // component name is unique in global

        // 4.1 get object according to name
        Object person = ioc.getBean("person");
        System.out.println("name" + person);

        // 4.2 according to type
//        Person Qi = ioc.getBean(Person.class);
//        System.out.println("name" + Qi);

        // 4.3 according to type get all objects of one type
        Map<String, Person> type = ioc.getBeansOfType(Person.class);
        System.out.println("type = " + type);

        // 4.4 name + type
        Person bean = ioc.getBean("person", Person.class);
        System.out.println("bean = " + bean);


        // 5 component is single instance


    }

    //3. inject a component into ioc
    // every component has its own name, method name is component name.



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
