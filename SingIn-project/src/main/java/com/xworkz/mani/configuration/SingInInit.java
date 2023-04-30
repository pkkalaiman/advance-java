package com.xworkz.mani.configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@Slf4j
public class SingInInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("Created in getServletConfigClaaseesss...");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("Created in GetServletConfigClassesss..");
		return new Class[] { SingInConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		log.info("Created in GetServletMappings..");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		log.info("Created in ConfigureDefaultServletHandling....");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
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
