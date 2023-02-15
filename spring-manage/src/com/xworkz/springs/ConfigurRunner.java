package com.xworkz.springs;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurRunner {

	public static void main(String[] args) {

		ApplicationContext spring = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		String[] beanName = spring.getBeanDefinitionNames();

		System.out.println(Arrays.toString(beanName));

		String refOfbean = spring.getBean("WesternRailway", String.class);

		System.out.println(refOfbean.hashCode());

		Road confi = spring.getBean(Road.class);
		System.out.println(confi);
		System.out.println(confi.getName());
		System.out.println(confi.getId());
		
	}
}
