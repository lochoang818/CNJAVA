package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigApp.class);

        // Get beans and use them as needed
        MyConfigApp myConfig = context.getBean(MyConfigApp.class);

        // In ra giá trị của thuộc tính greetingMessage
        System.out.println("Greeting Message: " + myConfig.getGreetingMessage());


        context.close();
    }
}