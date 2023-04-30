package com.xworkz.mani.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {

	@NotNull
	private int id;
	@NotBlank
	@Size(min = 3, max = 30, message = "user name should be greater then 3 less then 30")
	private String userName;
	@NotBlank
	@Size(min = 4, max = 40, message = "email should be greater then 4 less then 40")
	private String email;
	@NotNull
	private String mobile;
	@NotBlank
	@Size(min = 3, max = 30, message = "password should be greater then 3 less then 30")
	private String password;
	@NotNull
	@NotBlank
	private String confirmPassword;
	@NotNull
	private Boolean agrement;

}
