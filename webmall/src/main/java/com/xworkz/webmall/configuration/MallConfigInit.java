package com.xworkz.webmall.configuration;

import java.util.Arrays;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MallConfigInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running in GetRootConfigClasses.....");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running GetServletConfigClasses.......");
		Class[] configure= {MallConfiguration.class};
		return configure;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in GetServletMappings...");
		String[] ref= {"/"};
		System.out.println("MallConfiguration :"+Arrays.toString(ref));
		return ref;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in ConfigureDefaultServletHandling.....");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
	}

}
