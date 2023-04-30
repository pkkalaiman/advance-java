package com.xworkz.mani.DTO;

import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.Data;

@Data
public class AbstractAutiDTO {

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "createdDate")
	private LocalDateTime createdDate;

	@Column(name = "ubdatedBy")
	private String ubdatedBy;

	@Column(name = "ubbdatedDate")
	private LocalDateTime ubdatedDate;

}
