package com.xworkz.valentense.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
@Entity
@Table(name="manivalantenine_table")
public class ValantenseEntity {
	
	@Id
	@Column(name="m_id")
	private int id;
	
	@Column(name="m_name")
	private String name;
	
	@Column(name="m_valantenseName")
	private String valantenseName;
	
	@Column(name="m_place")
	private String place;
	
	@Column(name="m_gift")
	private String gift;

}
