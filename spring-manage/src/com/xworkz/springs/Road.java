package com.xworkz.springs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Road {
	
	@Autowired
	private String name;
	@Autowired
	private int id;
	
	public Road() {
		System.out.println("created in class spring");
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
