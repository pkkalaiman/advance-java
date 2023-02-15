package com.xworkz.Task;

import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;


@Configuration
public class BunConfiGuration {

	public BunConfiGuration() {
		System.out.println("created to Spring");
	}

	@Bean
	public String getBun() {
		System.out.println("Redistered Aonther Flower in spring....");
		Rose ros = new Rose();
		return "Bun" + ros;
	}

}
