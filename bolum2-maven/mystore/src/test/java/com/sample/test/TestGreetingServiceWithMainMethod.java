package com.sample.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sample.AppConfig;
import com.sample.service.GreetingService;

public class TestGreetingServiceWithMainMethod {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		GreetingService service=context.getBean(GreetingService.class);
		System.out.println(service.sayGreeting());
		
	}

}
