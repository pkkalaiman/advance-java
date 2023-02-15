package com.xworkz.bakery.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data

@Entity
@Table(name="mani_bakery")
public class BakeryDTO {
  
	 
	@Id
    @Column(name="c_id")
	private int id;
	
	@Column(name="c_bakeryName")
	private String bakeryName;
	
	@Column(name="c_bakeryOwnerName")
	private String bakeryOwnerName;
	
	@Column(name="c_bakeryOwnerWifeName")
	private String bakeryOnerWifeName;
	
	@Column(name="c_ownerMarried")
	private String OwnerMarried;
	
	@Column(name="c_bakeryFamous")
	private String bakeryFamous;
	
	@Column(name="c_bakerySince")
	private String bakerySince;
	


	/*
	 * public BakeryDTO(int id, String bakeryName, String bakeryOwnerName, String
	 * bakeryOnerWifeName, String ownerMarried, String bakeryFamous, String
	 * bakerySince) { super(); this.id = id; this.bakeryName = bakeryName;
	 * this.bakeryOwnerName = bakeryOwnerName; this.bakeryOnerWifeName =
	 * bakeryOnerWifeName; OwnerMarried = ownerMarried; this.bakeryFamous =
	 * bakeryFamous; this.bakerySince = bakerySince; }
	 * 
	 * @Override public String toString() { return "BakeryDTO [id=" + id +
	 * ", bakeryName=" + bakeryName + ", bakeryOwnerName=" + bakeryOwnerName +
	 * ", bakeryOnerWifeName=" + bakeryOnerWifeName + ", OwnerMarried=" +
	 * OwnerMarried + ", bakeryFamous=" + bakeryFamous + ", bakerySince=" +
	 * bakerySince + "]"; }
	 * 
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 * 
	 * public String getBakeryName() { return bakeryName; }
	 * 
	 * public void setBakeryName(String bakeryName) { this.bakeryName = bakeryName;
	 * }
	 * 
	 * public String getBakeryOwnerName() { return bakeryOwnerName; }
	 * 
	 * public void setBakeryOwnerName(String bakeryOwnerName) { this.bakeryOwnerName
	 * = bakeryOwnerName; }
	 * 
	 * public String getBakeryOnerWifeName() { return bakeryOnerWifeName; }
	 * 
	 * public void setBakeryOnerWifeName(String bakeryOnerWifeName) {
	 * this.bakeryOnerWifeName = bakeryOnerWifeName; }
	 * 
	 * public String getOwnerMarried() { return OwnerMarried; }
	 * 
	 * public void setOwnerMarried(String ownerMarried) { OwnerMarried =
	 * ownerMarried; }
	 * 
	 * public String getBakeryFamous() { return bakeryFamous; }
	 * 
	 * public void setBakeryFamous(String bakeryFamous) { this.bakeryFamous =
	 * bakeryFamous; }
	 * 
	 * public String getBakerySince() { return bakerySince; }
	 * 
	 * public void setBakerySince(String bakerySince) { this.bakerySince =
	 * bakerySince; }
	 */
	
	
	
	
}
