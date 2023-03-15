package com.xworkz.mobile.configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MobileInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	public MobileInit() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running in getRootConfigurClassess.....");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Running in getServletConfigClassess.....");
		return new Class[] { MobileConfiguation.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Running in getServletMappingss......");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running in configureDefaultServletHandfdling.....");
		configurer.enable();

	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		String temDir = "C:\\temp";
		int maxUploadedImb = 3 * 1024 * 1024;
		File uploadDirectry = new File(temDir);
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(uploadDirectry.getAbsolutePath(),
				maxUploadedImb, maxUploadedImb * 2, maxUploadedImb / 2);

		registration.setMultipartConfig(multipartConfigElement);
	}

}
