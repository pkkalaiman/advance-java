package com.xworkz.Taskapp;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.ConfigurationSprings;

public class MallRunner {

	public static void main(String[] args) {

		ApplicationContext mall = new AnnotationConfigApplicationContext(MallConfiguRation.class);

		String[] string = mall.getBeanDefinitionNames();
		System.out.println(Arrays.toString(string));
		
		SpringAnotation refOfstring=mall.getBean(SpringAnotation.class);
		
		System.out.println(refOfstring);
	}

}
