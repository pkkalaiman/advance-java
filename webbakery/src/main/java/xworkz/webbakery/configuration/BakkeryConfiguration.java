package com.xworkz.webbakery.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.webbakery")
public class BakkeryConfiguration {

	public BakkeryConfiguration() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
}
