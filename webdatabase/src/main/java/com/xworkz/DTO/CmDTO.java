package com.xworkz.DTO;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CmDTO {

	@Id
	private int id;

	@NotBlank
	@Size(min = 2, max = 20, message = "Lesserthen 2 GreaterThen 20....")
	private String name;

	@NotBlank(message = "Please Select File State")
	private String state;

	@NotBlank(message = "Please Select Party")
	private String party;

	@NotBlank(message = "Fill Tenure")
	private String tenuer;

}
