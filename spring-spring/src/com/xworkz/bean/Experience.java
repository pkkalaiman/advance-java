package com.xworkz.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Experience {

	@Autowired
	@Qualifier("Mani")
	private String name;
	@Autowired
	@Qualifier("33")
	private int id;
	
	public Experience() {
		System.out.println("Registerd in Experience in Spring,...");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Bean
	public String MessiPlayer() {
		System.out.println("Registered In Player Spring.....");
		String str = new String();
		System.out.println(str);
		return "Messi";
	}
	
}
