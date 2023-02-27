package com.xworkz.mobile.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MobileInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	public MobileInit() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running in getRootConfigurClassess.....");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in getServletConfigClassess.....");
		return new Class[] { MobileConfiguation.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in getServletMappingss......");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in configureDefaultServletHandfdling.....");
		configurer.enable();
		
	}

}
