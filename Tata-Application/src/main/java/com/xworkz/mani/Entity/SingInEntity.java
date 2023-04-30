package com.xworkz.mani.Entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tata_loginform")
@Data

@NamedQuery(name = "findAll", query = "select ent from SingInEntity ent")

@NamedQuery(name = "emailId", query = "select count(*) from  SingInEntity ent where ent.email=:emailby")

@NamedQuery(name = "userId", query = "select count(*) from  SingInEntity ent where ent.userId=:userby")

@NamedQuery(name = "mobileId", query = "select count(*) from  SingInEntity ent where ent.mobile=:mobileBy")

@NamedQuery(name = "updateLoginCount", query = "update SingInEntity ent set ent.loginCount=:logcount where ent.userId=:userID")

@NamedQuery(name = "resetPassword", query = "select ent from SingInEntity ent where ent.email=:emailIdby")

@NamedQuery(name = "user", query = "select ent from SingInEntity ent where ent.userId=:userinfo")

@NamedQuery(name = "updatePassword", query = "update SingInEntity ent set ent.password=:userpassword , ent.resetPassword=:resetpassword, ent.expTime=:exp where ent.userId=:uId")

public class SingInEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "a_id")
	private int id;

	@Column(name = "a_userId")
	private String userId;

	@Column(name = "a_email")
	private String email;

	@Column(name = "a_mobile")
	private long mobile;

	@Column(name = "a_password")
	private String password;

	@Column(name = "a_aggrement")
	private Boolean agreement;

	@Column(name = "a_createdBy")
	private String createdBy;

	@Column(name = "a_createdDate")
	private LocalDateTime createdDate;

	@Column(name = "a_updatedBy")
	private String updatedBy;

	@Column(name = "a_updatedDate")
	private LocalDateTime updatedDate;

	@Column(name = "a_logincount")
	private int loginCount;

	@Column(name = "a_resetpasword")
	private Boolean resetPassword;

	@Column(name = "a_expTime")
	private LocalTime expTime;

}
