package com.xworkz.gova.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.gova")
public class GoaConfiguration {

	public GoaConfiguration() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
}
