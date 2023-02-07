package com.xworkz.datashow.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EducationDTO {

	private String name;
	private int id;
	private String deportment;
	private LocalDate dateOfBirth;

	
}
