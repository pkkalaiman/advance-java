package com.xworkz.food.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.food")
public class FoodConfiguration {

	public FoodConfiguration() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
}
