package com.xworkz.datashow.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.datashow")
public class ManiConfiiguration {

	public ManiConfiiguration() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
}
