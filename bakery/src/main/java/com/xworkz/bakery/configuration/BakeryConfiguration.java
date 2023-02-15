package com.xworkz.bakery.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.bakery")
public class BakeryConfiguration {

	public BakeryConfiguration() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver("/",".jsp");
		return resolver;
	}
	
	
	  @Bean 
	  public LocalContainerEntityManagerFactoryBean
	  		localContainerEntityManagerFactoryBean() {
	  System.out.println("Registered LocalContainerEntityManagerFactoryBean.....");
	  
	  LocalContainerEntityManagerFactoryBean bean = new
			  						LocalContainerEntityManagerFactoryBean(); 
	  return bean;
	  
	  }
	 
	
	
	
}
