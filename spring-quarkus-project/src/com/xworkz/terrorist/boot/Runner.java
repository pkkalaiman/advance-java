package com.xworkz.terrorist.boot;

import com.xworkz.terrorist.dto.TerraristDto;

public class Runner {

	public static void main(String[] args) {

		TerraristDto dto = new TerraristDto();

		
		dto.setName("Kaalaiman");
		dto.setAge(22);
		dto.setCountry("Indian");
		dto.setPrision(true);
		dto.setAlive(true);
		dto.setSpacialization("Devlopper coding");
		System.out.println(dto);
	}

}
