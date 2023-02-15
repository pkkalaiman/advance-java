package com.xworkz.springs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.springs")
public class SpringConfiguration {
	
	
	@Bean
	public String ManiPlayer() {
		System.out.println("Registered In ManiPlayer in Spring");
		String str=new String();
		return "Mani";
	}

}
