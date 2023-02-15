package com.xworkz.lazer.component;

import org.springframework.stereotype.Component;

@Component
public class LaserComponent {
	
	public LaserComponent() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
	
}
