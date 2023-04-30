package com.xworkz.mani.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "project_technology")

public class TechnologyEntity {

	@Id
	@Column(name = "t_id")
	private int id;

	@Column(name = "t_technologyName")
	private String technologyName;

	@Column(name = "t_language")
	private String languange;

	@Column(name = "t_version")
	private String version;

	@Column(name = "t_owner")
	private String owner;

	@Column(name = "t_supportFrom")
	private String supportFrom;

	@Column(name = "t_supportTo")
	private String supportTo;

	@Column(name = "t_license")
	private String licenseNo;

	@Column(name = "t_openSource")
	private String openSource;

	@Column(name = "t_osType")
	private String osType;

	@Column(name = "t_createdBy")
	private String createdBy;

	@Column(name = "t_createdDate")
	private LocalDateTime createdDate;

	@Column(name = "t_updatedBy")
	private String updatedBy;

	@Column(name = "t_updatedDate")
	private LocalDateTime updatedDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "p_userId", referencedColumnName = "p_userId")
	private ProjectEntity projectEntity;

}
