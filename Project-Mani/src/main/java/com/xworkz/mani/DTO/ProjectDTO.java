package com.xworkz.mani.DTO;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data

public class ProjectDTO {

	private int id;

	@Size(min = 3, max = 20, message = "UserId cannot be less than 3 and greater than 20")
	private String userId;

	@Size(min = 3, max = 50, message = "Email cannot be less than 3 and greater than 20")
	private String email;

	@NotNull
	private Long mobileNumber;

	@NotBlank
	@Size(min = 3, max = 12, message = "Password cannot be less than 3 and greater than 12")
	private String password;

	@NotBlank
	@NotNull
	private String confirmPassword;

	@NotBlank
	private String acceptAgreement;

	private int lockCount;

	private Boolean resetPassword;

	private LocalTime passwordChangedTime;

	private String picName;

}
