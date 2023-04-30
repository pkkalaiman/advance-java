package com.xworkz.myproject.DTO;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectDTO {
	
	@Id
	private int id;
	@NotBlank
	@Size(min=2,max=30,message="Name is Lesser then 2, Greater then 30")
	private String name;
	@NotBlank
	@Size(min=2,max=30,message="Name is Lesser then 2, Greater then 30")
	private String fatherName;
	@NotBlank
	@Size(min=2,max=30,message="Name is Lesser then 2, Greater then 30")
	private String motherName;
	@NotBlank
	@Size(message="Please Select the Gender")
	private String gender;
	@NotBlank
	@Size(message="Please fill the Email")
	private String email;
	
	

}
