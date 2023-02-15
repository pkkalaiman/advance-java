package com.xworkz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationSprings {

	@Bean
	public String Test() {
		System.out.println("Test configuration Send to Spring....");
		return "Spring";
	}

	@Bean
	public Float DisplayIfo() {
		System.out.println("Display Send to Springs .....");
		return 355f;
	}

}
