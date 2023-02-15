package com.xworkz.springs;

import org.springframework.context.ApplicationContext; 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class RoadRunner {
	
	public static void main(String[] args) {
		
		ApplicationContext spring = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		System.out.println(spring.getBean(Road.class));
		
	}

}
