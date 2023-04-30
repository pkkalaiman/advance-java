package com.xworkz.mani.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity

@Table(name = "project_singin")

@NamedQuery(name = "findByCount", query = "select count(*) from ProjectEntity ent where ent.userId=:u or ent.email=:e or ent.mobileNumber=:m")

@NamedQuery(name = "userId", query = "select count(*) from ProjectEntity ent where ent.userId=:userBy")

@NamedQuery(name = "emailId", query = "select count(*) from  ProjectEntity ent where ent.email=:emailBy")

@NamedQuery(name = "mobileId", query = "select count(*) from  ProjectEntity ent where ent.mobileNumber=:mobileBy")

@NamedQuery(name = "IdandPassword", query = "select ent from ProjectEntity ent where ent.userId=:u")

@NamedQuery(name = "lockCount", query = "update ProjectEntity ent set ent.lockCount=:c where ent.userId=:u")

@NamedQuery(name = "email", query = "select ent from ProjectEntity ent where ent.email=:ed")

@NamedQuery(name = "updatePassword", query = "update ProjectEntity ent set ent.password=:p, ent.resetPassword=:rp, ent.passwordChangedTime=:pct where ent.userId=:ud")
public class ProjectEntity implements Serializable {

	@Id
	@Column(name = "p_id")
	private int id; 

	@Column(name = "p_userId")
	private String userId;

	@Column(name = "p_email")
	private String email;

	@Column(name = "p_mobile")
	private long mobileNumber;

	@Column(name = "p_password")
	private String password;

	@Column(name = "p_createdBy")
	private String createdBy;

	@Column(name = "p_createdByDate")
	private LocalDateTime createdDate;

	@Column(name = "p_updatedBy")
	private String updatedBy;

	@Column(name = "p_updatedByDate")
	private LocalDateTime updatedDate;

	@Column(name = "p_loginCount")
	private int lockCount;

	@Column(name = "p_resetPassword")
	private Boolean resetPassword;

	@Column(name = "p_passwordChangedTime")
	private LocalTime passwordChangedTime;

	@Column(name = "p_picName")
	private String picName;

	@OneToMany(mappedBy = "ProjectEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<TechnologyEntity> technology;

}
