package com.xworkz.lazer.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xwokrz.lazer")
public class SpringConfiguration {

	public SpringConfiguration() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
}
