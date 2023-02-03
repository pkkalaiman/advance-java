package com.xworkz.webmall.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.webmall")
public class MallConfiguration {

	public MallConfiguration() {
		System.out.println("Creating :"+this.getClass().getSimpleName());
	}
}
