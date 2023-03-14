package com.xworkz.mobile.MobileDTO;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileDTO {

	@Id
	private int id;
	
	@Size(min = 3, max = 20, message = "Name will be lesser then 3, Greater then 20")
	private String name;

	@Size(min = 4, max = 30, message = "Name will be lesser then 4, Greater then 30")
	private String brandName;

	@Size(min = 4, max = 40, message = "Name will be lesser then 4, Greater then 40")
	private String modelName;

	@NotBlank(message = "Please Select The OS")
	private String os;

	@NotBlank(message = "Please Select the Storrage")
	private String storage;

	private double price;
	@NotBlank(message = "Please Select the Colors")
	private String colors;

	@NotBlank(message = "Please Select The Technology...")
	private String technology;

}
