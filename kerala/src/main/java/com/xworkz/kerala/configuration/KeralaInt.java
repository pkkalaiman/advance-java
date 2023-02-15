package com.xworkz.kerala.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer; 
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class KeralaInt extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {
	
	

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running in GetRootConfigClasses.....");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in getServletConfigClasses......");
		return new Class[] {KeralaConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running getServletMappings........");
		return new String[] {"/"};
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running ConfigDefaultServletHandling....");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
		
		configurer.enable();
	}

}
