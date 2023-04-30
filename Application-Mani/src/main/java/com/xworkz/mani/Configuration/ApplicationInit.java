package com.xworkz.mani.Configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@Slf4j
public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("Created in GetServletConfigClasss..");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("Created in GetServletConfigClassesss....");
		return new Class[] { ApplicationConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		log.info("Created in getServletConfiMappings..");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		log.info("Created in ConfigureDefaulltServletHandling......");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}

}
