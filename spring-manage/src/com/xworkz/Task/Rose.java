
package com.xworkz.Task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration("com.xworkz.task")
public class Rose {

	public Rose() {
		System.out.println("created in Rose configuration");
	}

	@Bean
	public Rose rose() {
		System.out.println("Redistered Aonther Flower in spring....");
		Rose ros = new Rose();
		return ros;
	}

	@Bean
	public Puff eggPuff() {
		System.out.println("Registered In Egg Puff in Spring..");
		Puff puf = new Puff();
		return puf;
	}

}
