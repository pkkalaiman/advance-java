package com.xworkz.mani.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ManiInitlaization extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {

	public ManiInitlaization() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Runnning in getRootConfiguClasss.....");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in getServletConfigureClasss.....");
		return new Class[] { ManiConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in getServletMappings....");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("ConfigureDefaultServletHandling");

		configurer.enable();
	}

}
