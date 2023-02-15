package com.xworkz.kerala.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.kerala")
public class KeralaConfiguration {

	public KeralaConfiguration() {
		System.out.println("Created :"+this.getClass().getSimpleName());
	}
}
