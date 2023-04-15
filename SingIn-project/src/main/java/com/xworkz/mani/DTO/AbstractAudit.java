package com.xworkz.mani.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AbstractAudit implements Serializable {

	private String createdBy;
	private LocalDateTime createdDate;
	private String updatedBy;
	private LocalDateTime updatedDate;

}
