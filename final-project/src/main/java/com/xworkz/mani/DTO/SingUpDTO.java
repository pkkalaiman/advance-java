package com.xworkz.mani.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SingUpDTO extends AbstractAutiDTO {

	private int id;

	@NotBlank
	@Size(min = 4, max = 30, message = "UserId Should be greater then 4 less then 30")
	private String userId;

	@NotBlank
	@Size(min = 4, max = 40, message = "Email Id Should be greater then 4 less then 40")
	private String email;

	@NotNull
	private long mobileNo;

	@NotBlank
	@Size(min = 4, max = 12, message = "Password should be greater then 4 less then 12")
	private String password;

	@NotNull
	@NotBlank
	private String confirmPassword;

	@NotNull
	private boolean agrement;

}
