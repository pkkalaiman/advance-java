package com.xworkz.valentense.DTO;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ValantenseDTO {

	@Id
	private int id;
	
	@Size(min = 3, max = 20, message = "Name less then 3 Greater then 20")
	private String name;
	
	@Size(min = 2, max = 30, message = "Valantense Name less then 2 Greater then 30")
	private String valantenseName;

	@NotBlank(message = "Please Select the Place")
	private String place;
	
	@NotBlank(message = "Please Select the Gift")
	private String gift;

}
