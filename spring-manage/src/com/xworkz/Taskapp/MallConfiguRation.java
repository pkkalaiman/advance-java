package com.xworkz.Taskapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class MallConfiguRation {
	

	@Bean
	public String doMalls() {
		System.out.println("Created In String mall....");
		return "String";
	}
	@Bean
	public String LuluMall() {
		
		System.out.println("Converting to the Strings Configuration.....");
		return "Malls";
	}
	@Bean
	public String OrienMalls() {
		System.out.println("Orien Mall Coverting to Spring.....");
		return "Orien Mal";
	}
	@Bean
	public String ManiMall() {
		System.out.println("Spring Mani Mall Converting.....");
		return "ManiMalls";
	}
	@Bean
	public Boolean newFromValue() {
		System.out.println(" Spring Cinverting");
		return true;
	}
	@Bean
	public Boolean MantriSquare() {
		System.out.println(" Spring Cinverting");
		return true;
	}
	@Bean
	public Boolean RoyalMeenacthi() {
		System.out.println(" Spring Cinverting");
		return true;
	}
	@Bean
	public Boolean PhoenixMarketCity() {
		System.out.println(" Spring Cinverting");
		return true;
	}
	@Bean
	public Boolean Garuda() {
		System.out.println(" Spring Cinverting");
		return true;
	}
 

}
