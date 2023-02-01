package com.xworkz.food.configuration;

import java.util.Arrays; 

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FoodInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running in getRootConfiguration");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in getServletCongiguration");
		Class[] configure = { FoodConfiguration.class };
		return configure;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in getServletMappings");
		String[] ref = { "/" };
		System.out.println("configuration :" + Arrays.toString(ref));
		return ref;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in ConfigureDefaultServletHandling");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);

		configurer.enable();
	}
}
