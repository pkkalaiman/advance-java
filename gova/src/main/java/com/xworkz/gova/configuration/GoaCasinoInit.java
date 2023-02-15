package com.xworkz.gova.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class GoaCasinoInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running in GetConfigClasses....");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in GetServletConfigClasses......");
		return new Class[] {GoaConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in GetServletMapings........");
		return new String[] {"/"};
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in ConfigureDefalutServletHandling......");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
		
		configurer.enable();
	}

}
