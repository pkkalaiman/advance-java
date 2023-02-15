package com.xworkz.terrorist.dto;

import javax.validation.constraints.Max; 
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TerraristDto extends AbstrctAudioDto {
	
	@NonNull
	@NotNull(message = "terreorist name is connect be null")
	@Size(min =3, max =20, message ="Name is invalid, should be more ten 20")
	private String name;  // not empty, not null, size:3, max 20
	
	
	@Min(value = 1, message ="Age shoud be greater the 1 or less then 150")
	@Max(value = 150, message="Age shoud be greator then 1 or less then 14")
	private int age;
	
	@NonNull
	@Size(min=2, max=25, message="There Should be minimum 2 letters and maximum 25 lettes are allowed")
	private String country;
	private boolean alive;
	private boolean prision;
	@NotBlank
	@NotNull
	@Size(min=3, max=25,message="There Should be minimum 3 letters and maximum 25 letters")
	private String spacialization;
	

}
