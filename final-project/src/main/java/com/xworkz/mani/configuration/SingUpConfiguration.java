package com.xworkz.mani.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.xworkz.mani")
@Slf4j
public class SingUpConfiguration {

	public SingUpConfiguration() {
		log.info("Created :" + this.getClass().getSimpleName());
	}

	@Bean
	public ViewResolver viewResolver() {
		log.info("Created in ViewResolverr...");
		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		log.info("Created in LocalContainerEnytityManagerFactoryBean...");
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com.xworkz.mani.Entity");
		bean.setDataSource(datasource());
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return bean;
	}

	public DataSource datasource() {

		DriverManagerDataSource datasource = new DriverManagerDataSource();

		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/mani");
		datasource.setPassword("Xworkz@123");
		datasource.setUsername("root");
		return datasource;

	}

}
