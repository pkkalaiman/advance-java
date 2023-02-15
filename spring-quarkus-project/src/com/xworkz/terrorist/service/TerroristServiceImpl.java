package com.xworkz.terrorist.service;

import com.xworkz.terrorist.dto.TerraristDto;

public class TerroristServiceImpl implements TerrorService{

	@Override
	public boolean validateAndSave(TerraristDto dto) {
		System.out.println("The validateAndSave Method Started");
		System.out.println("DTO passed : "+dto);
		return false;
	}

}
