package com.xworkz.Task;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FlowerTester {

	public static void main(String a[]) {

		ApplicationContext flower = new AnnotationConfigApplicationContext(Flower.class);
		System.out.println(Arrays.toString(flower.getBeanDefinitionNames()));
		System.out.println(flower);

		Flower refOfName = flower.getBean("flower",Flower.class);
		System.out.println(refOfName.getPrice());
		System.out.println(refOfName.getName());
		System.out.println(refOfName.getId());
		
		System.out.println();

		Flower refOfName1 = flower.getBean(Flower.class);
		System.out.println(refOfName1.getPrice());
		System.out.println(refOfName1.getName());
		System.out.println(refOfName1.getId());
		
		BunConfiGuration ref=flower.getBean(BunConfiGuration.class);
		System.out.println(ref);
		System.out.println();
	
	}

}
