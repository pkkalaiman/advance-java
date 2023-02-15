package com.xworkz.springs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanSprings {

	@Bean
	public String maniDisplay() {
		System.out.println("Mani Display Send to Springs...");
		return "Mani";
	}
	
	@Bean
	public String WesternRailway() {
		System.out.println("Western Railway Converted to Springs......");
		return "Railway";
	}

}
