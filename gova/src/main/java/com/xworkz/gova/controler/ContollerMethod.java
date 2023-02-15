package com.xworkz.gova.controler;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ContollerMethod {

	public ContollerMethod() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
	
	
}
