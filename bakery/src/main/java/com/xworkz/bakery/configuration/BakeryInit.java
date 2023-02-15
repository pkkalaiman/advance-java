package com.xworkz.bakery.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer; 
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BakeryInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	public BakeryInit() {
	System.out.println("Created :" + this.getClass().getSimpleName());	
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running in getRootConfigClasses....");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in the GetServletConfigClassess.....");
		return new Class[] {BakeryConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Runnin g in getServlwetMappings....");
		return new String[] {"/"};
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in ConfigureDefaultServletHandling.....");
		
		configurer.enable();
	}

}
