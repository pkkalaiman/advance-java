package com.xworkz.myproject.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ProjectInt extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	public ProjectInt() {
		System.out.println("Running in ProjectIntialization...");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Runnning in getServletConfigClassess....");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in getServletConfigClassesss.....");
		return new Class[] { ProjectConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in GetServletConfigMappingss.....");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in configureDefaultServletHandling....");

		configurer.enable();
	}

}
