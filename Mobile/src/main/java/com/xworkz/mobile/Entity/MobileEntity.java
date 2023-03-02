package com.xworkz.mobile.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mobile_table")
@NamedQuery(name="findByName",query = "select ent from MobileEntity ent where ent.name=:nam")
public class MobileEntity {

	@Id
	@Column(name = "m_id")
	private int id;

	@Column(name = "m_name")
	private String name;

	@Column(name = "m_brandName")
	private String brandName;

	@Column(name = "m_modelName")
	private String modelName;

	@Column(name = "m_storage")
	private String storage;

	@Column(name = "m_OS")
	private String os;

	@Column(name = "m_price")
	private double price;

	@Column(name = "m_tecnology")
	private String technology;

	@Column(name = "m_colors")
	private String colors;

}
