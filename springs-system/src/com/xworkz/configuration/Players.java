package com.xworkz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.bean")
public class Players {

	
	@Bean
	public String RonaldoPlayerName() {
		System.out.println("Registered In Player Ronaldo To Spring....");
		String str=new String();
		return "Ronaldo";
	}
	@Bean
	public int MessiPlayerId() {
		System.out.println("Created In Messi To Spring...");
		int id=22;
		System.out.println(id);
		return 22;
	}

}
