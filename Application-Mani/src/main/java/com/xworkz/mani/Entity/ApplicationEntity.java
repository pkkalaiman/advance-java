package com.xworkz.mani.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "application_mani")
public class ApplicationEntity {

	@Id
	@Column(name = "a_id")
	private int id;
	@Column(name = "a_userName")
	private String userName;
	@Column(name = "a_email")
	private String email;
	@Column(name = "a_mobile")
	private long mobile;
	@Column(name = "a_passowrd")
	private String password;
	@Column(name = "a_aggrement")
	private int agrement;
	@Column(name = "a_createdBy")
	private String createdBy;
	@Column(name = "a_createdDate")
	private LocalDateTime createdDate;
	@Column(name = "a_updatedBy")
	private String updatedBy;
	@Column(name = "a_updatedDate")
	private LocalDateTime updatedDate;

}
