package com.xworkz.myproject.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "project_table")
public class ProjectEntity {

	@Id
	@Column(name = "p_id")
	private int id;
	@Column(name = "p_name")
	private String name;
	@Column(name = "p_fatherName")
	private String fatherName;
	@Column(name = "p_motherName")
	private String motherName;
	@Column(name = "p_gender")
	private String gender;
	@Column(name = "p_email")
	private String email;

}
