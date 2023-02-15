package com.xworkz.boot;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.xworkz.bean.Experience;

public class Runner {

	public static void main(String[] args) {

		ApplicationContext spring = new AnnotationConfigApplicationContext(Configuration.class);
		System.out.println(Arrays.toString(spring.getBeanDefinitionNames()));

		Experience refOfName=spring.getBean(Experience.class);
		
		System.out.println(refOfName);
		System.out.println(refOfName.getName());
		System.out.println(refOfName.getId());
	}

}
