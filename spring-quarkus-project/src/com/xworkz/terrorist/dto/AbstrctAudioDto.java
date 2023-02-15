package com.xworkz.terrorist.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstrctAudioDto implements Serializable {

	private String createdby;
	private LocalDateTime createdAt;
	private String ubdateedby;
	private LocalDateTime ubdatedAt;

}
