package com.xworkz.lazer.configuration;

import java.util.Arrays;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	public SpringWebInit() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running in getRootConfigClass");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in getServletConigClasses");
		Class[] conficlass = { SpringConfiguration.class };
		return conficlass;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in getServletMappings");
		String[] ref = {"/"};
		System.out.println("SpringConfigratin" + Arrays.toString(ref));
		return ref;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in configureDefaultServletHandling");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);

		configurer.enable();
	}

}
