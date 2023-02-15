package com.xworkz.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.bean")
public class FirstTime {

	public FirstTime() {
		System.out.println("Created Class In Spring........");

	}

	
}
