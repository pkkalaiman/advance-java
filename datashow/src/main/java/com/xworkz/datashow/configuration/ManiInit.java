package com.xworkz.datashow.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ManiInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running in getRootConfigClaasses....");
		return null;
	}

	
	/* THIS METHODS USING REFERENCE OF CONFIGUARATIONCLASS WILL SHOWING THAT'S USING
	 * THIS METHOD
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in getServletConfigClasses......");
		return new Class[] { ManiConfiiguration.class };
	}

	
	/* this method is using for u have Any HTML.JSP.IMAGES.URL LINKS. etc all
	 * facilities using this method
	 */
	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in GetServletConfigMapping.....");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in ConfigureDefaultServletHandling......");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}

}
