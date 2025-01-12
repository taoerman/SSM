package com.example.spring01ioc.config;

import com.example.spring01ioc.Bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfig {
    @Bean("chili")
    public Dog chili() {
        Dog chili = new Dog();
        return chili;
    }
}
