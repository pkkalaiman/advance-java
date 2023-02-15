package com.xworkz.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="new_table")
public class HotelDTO {
	@Id
	@Column(name="mani_id")
	private int id;
	@Column(name="mani_hotelname")
	private String hotelName;
	@Column(name="mani_dishName")
	private String dishName;
	@Column(name="mani_type")
	private String type;
	@Column(name="mani_price")
	private double price;
	@Column(name="mani_quantity")
	private int quantity;

}
