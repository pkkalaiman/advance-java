package com.xworkz.webbakery.DTO;

import lombok.Data;

@Data
public class BakeryDTO {
	
	private String name;
	private String ownerName;
	private String ownerWifeName;
	private boolean isMarried;
	private String specialFor;
	private int since;

}
