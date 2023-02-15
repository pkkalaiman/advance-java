package com.xworkz.valentense.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ValantenseWebInit extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {

	 public ValantenseWebInit() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running in RootConfigClassesss...");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in GetConfigServletClassesss.....");
		return new Class[] { ValantenseConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in GetConfigServletMappingss....");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in ConfigDefaultServletHandling.....");

		configurer.enable();
	}

}
