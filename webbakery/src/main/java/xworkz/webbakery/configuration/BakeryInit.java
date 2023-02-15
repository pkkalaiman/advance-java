package com.xworkz.webbakery.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BakeryInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	public BakeryInit() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Runnin in ConfigurationClasse.....");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in GetServletConfigClassess,,,,,,");
		return new Class[] {BakkeryConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in GetServletConfigMappings.......");
		return new String[] {"/"};
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in  ConfigurereDefaultServletHandling.......");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
		
		configurer.enable();
	}

}
