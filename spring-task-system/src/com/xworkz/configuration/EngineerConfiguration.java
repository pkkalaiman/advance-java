package com.xworkz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.bean")
public class EngineerConfiguration {

	public EngineerConfiguration() {
		System.out.println("Registered in EngineerConfiguration no argument constructor");
	}

	@Bean
	public String EngineerName() {
		System.out.println("Registered in Spring ");
		return "Mani p k";
	}

	@Bean
	public double EmployeSalary() {
		System.out.println("Registered in Spring Salary");
		return 23456.67;
	}

	/*
	 * @Bean public String DevExpierence() {
	 * System.out.println("Registered in devolopper Languadge to Spring"); return
	 * "9 years"; }
	 * 
	 * @Bean public String wichDevolopper() {
	 * System.out.println("Registered in Expiereince in Spring"); return "JAVA"; }
	 */

}
