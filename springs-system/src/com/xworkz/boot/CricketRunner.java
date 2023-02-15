package com.xworkz.boot;

import org.springframework.context.ApplicationContext; 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.xworkz.configuration.Players;

public class CricketRunner {
	
	public static void main(String[] args) {
		
	
	ApplicationContext spring=new AnnotationConfigApplicationContext(Players.class);
 String[] beanName=spring.getBeanDefinitionNames();
	System.out.println(beanName);
	
	Players refOfVolly=spring.getBean("VolleyBallName",Players.class);
	System.out.println(refOfVolly);
	//System.out.println(refOfVolly);
}
}
