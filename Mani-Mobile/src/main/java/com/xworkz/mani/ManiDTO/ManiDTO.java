package com.xworkz.mani.ManiDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManiDTO {

	@NotNull
	@Size(min = 3, max = 20, message = "Name it will less then 2 , Greater then 20 fill this one first")
	private String name;
	@NotNull
	@Size(min = 4, max = 30, message = "BrandName is less then 4 Greater then 30 fille this one first")
	private String brandName;
	@NotNull
	@Size(min = 3, max = 40, message = "ModelName is less the 3 Greater thena 40 fill this first")
	private String modelName;
	@NotNull
	@NotBlank(message = "Please Select the OS ...")
	private String os;
	@NotNull
	@NotBlank(message = "Please Select the Storragee....")
	private int storage;
	@NotNull
	@NotBlank(message = "Please Select the Technology..")
	private String technology;
	@NotNull
	@NotBlank(message = "Please Select The Colorss....")
	private String colors;

}
