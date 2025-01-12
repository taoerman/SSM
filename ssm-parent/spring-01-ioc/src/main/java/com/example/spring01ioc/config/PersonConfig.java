package com.example.spring01ioc.config;

import com.example.spring01ioc.Bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // tell spring, this is a configuration class
public class PersonConfig {
    @Bean("person")
    public Person person() {
        Person person = new Person();
        person.setName("Qi");
        person.setAge(31);
        person.setGender("male");

        return person;
    }

    @Bean("zhi")
    public Person zhi() {
        Person person = new Person();
        person.setName("Zhi");
        person.setAge(31);
        person.setGender("male");

        return person;
    }
}
