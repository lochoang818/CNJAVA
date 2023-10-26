package com.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class MyConfigApp {
    @Value("${greeting.message}")
    private String greetingMessage;
    public String getGreetingMessage() {
        return greetingMessage;
    }
    // Define your beans here, and use greetingMessage where needed.
}