package com.xworkz.Taskapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Malls {
	
	@Value("doMall")
	private String name;
	@Value("LuluMall")
	private int MallNamme;
	
}
