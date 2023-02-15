package com.xworkz.boot;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.bean.SoftWearIngineer;
import com.xworkz.configuration.EngineerConfiguration;

public class Runner {

	public static void main(String[] args) {

		ApplicationContext container = new AnnotationConfigApplicationContext(EngineerConfiguration.class);
		System.out.println(Arrays.toString(container.getBeanDefinitionNames()));

		SoftWearIngineer refOfSoft = container.getBean(SoftWearIngineer.class);
		System.out.println(refOfSoft);
		System.out.println(refOfSoft.getName());
		System.out.println(refOfSoft.getPrice());
		/*System.out.println(refOfSoft.getExperience());
		System.out.println(refOfSoft.getWichDevolopper());*/
	}

}
