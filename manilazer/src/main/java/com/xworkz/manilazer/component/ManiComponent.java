package com.xworkz.manilazer.component;

import org.springframework.stereotype.Component;

@Component
public class ManiComponent {

	public ManiComponent() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
	
}
