package com.xworkz.Task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class Flower {

	@Value("Mani P K")
	private String name;
	@Value("22")
	private int id;
	@Value("28.2")
	private double price;

	public Flower() {
		System.out.println("created in floewr in spring..");
	}

	@Bean
	public String getName() {
		System.out.println("Registered In PuffName to spring...");
		return name;
	}

	@Bean
	public int getId() {
		System.out.println("Register in PuffId to spring.........");
		return id;
	}
	
	public double getPrice() {
		System.out.println("Register in PuffPrice in Spring");
		return 22.2;
	}
}
