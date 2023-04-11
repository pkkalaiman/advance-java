package com.xworkz.mani.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@Slf4j
public class SingUpInit extends AbstractAnnotationConfigDispatcherServletInitializer 
								implements WebMvcConfigurer {

	public SingUpInit() {
		log.info("Created :" + this.getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("Creaed by getRootConfigClassess...");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("Created by getServletConfigClassesss....");
		return new Class[] { SingUpConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		log.info("Created by getServleetConfigMappings...");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		log.info("Created by configureDefaultServletHandling...");
		configurer.enable();
	}

}
