package com.example.lab6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Lab6Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");

		// Retrieve beans from the context
		Product firstProduct = (Product) context.getBean("firstBean");
		Product secondProduct = (Product) context.getBean("secondBean");
		Product thirdProduct = (Product) context.getBean("thirdBean");

	// Print product information
        System.out.println("First Product: " + firstProduct);
        System.out.println("Second Product: " + secondProduct);
        System.out.println("Third Product: " + thirdProduct);

	// Check if first two beans are prototype objects and the third bean is a singleton object
        System.out.println("First Bean is Prototype: " + context.isPrototype("firstBean"));
        System.out.println("Second Bean is Prototype: " + context.isPrototype("secondBean"));
        System.out.println("Third Bean is Singleton: " + context.isSingleton("thirdBean"));
	}

}
