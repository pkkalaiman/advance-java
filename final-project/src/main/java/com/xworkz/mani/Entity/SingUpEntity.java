package com.xworkz.mani.Entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "userdetialse")
@NamedQuery(name = "findAll", query = "select ent from SingUpEntity ent")
@NamedQuery(name = "userId", query = "select count(*) from SingUpEntity ent where ent.userId=:userby")
@NamedQuery(name = "emailId", query = "select count(*) from SingUpEntity ent where ent.email=:useremailby")
@NamedQuery(name = "mobileId", query = "select count(*) from SingUpEntity ent where ent.mobileNo=:usermobileby")
@NamedQuery(name="SearchByuserIdAndPassword", query = "select ent from SingUpEntity ent where ent.userId=:userId")
public class SingUpEntity {

	@Id
	@Column(name = "u_id")
	private int id;
	@Column(name = "u_userId")
	private String userId;
	@Column(name = "u_email")
	private String email;
	@Column(name = "u_mobileNo")
	private long mobileNo;
	@Column(name = "u_password")
	private String password;
	@Column(name = "u_confirmpassword")
	private String confirmPassword;
	@Column(name = "u_agrement")
	private boolean agrement;
	@Column(name = "u_createdBy")
	private String createdBy;
	@Column(name = "u_createdDate")
	private LocalDateTime createdDate;
	@Column(name = "u_ubdatedBy")
	private String ubdatedBy;
	@Column(name = "u_ubdatedDate")
	private LocalDateTime ubdatedDate;
}
