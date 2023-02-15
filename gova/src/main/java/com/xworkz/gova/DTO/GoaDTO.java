package com.xworkz.gova.DTO;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "")
public class GoaDTO {

	@Column(name="")
	@Id
	private int id;
	@Column(name="")
	private String name;
	@Column(name="")
	private String cruise;
	@Column(name="")
	private int entrFees;
	@Column(name="")
	private String freeFood;
	@Column(name="")
	private String freeAlcohol;
}
