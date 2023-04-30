package com.xworkz.mani.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "add.m_technology")
public class TechnologyEntity {

	@Id
	@Column(name = "m_id")
	private int id;

	@Column(name = "m_technology")
	private String technologyName;

	@Column(name = "m_language")
	private String languange;

	@Column(name = "m_version")
	private Double version;

	@Column(name = "m_owner")
	private String owner;

	@Column(name = "m_supportForm")
	private String supportFrom;

	@Column(name = "m_supportTo")
	private String supportTo;

	@Column(name = "m_licenseNo")
	private String licenseNo;

	@Column(name = "m_openSource")
	private String openSource;

	@Column(name = "m_osType")
	private String osType;

	@Column(name = "m_createdBy")
	private String createdBy;
	
	@Column(name = "m_createdDate")
	private LocalDateTime createdDate;

	@Column(name = "m_updatedBy")
	private String updatedBy;

	@Column(name = "m_updatedDate")
	private LocalDateTime updatedDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "s_userId", referencedColumnName = "s_userId")
	private SingInEntity singInEntity;

}
