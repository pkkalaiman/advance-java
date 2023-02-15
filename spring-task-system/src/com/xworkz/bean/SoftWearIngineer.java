package com.xworkz.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoftWearIngineer {

	@Autowired
	@Qualifier("EngineerName")
	private String name;

	@Autowired
	@Qualifier("EmployeSalary")
	private double price;

	/*
	 * @Autowired
	 * 
	 * @Qualifier("DevExpierence") private String experience;
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("wichDevolopper") private String wichDevolopper;
	 */

	public SoftWearIngineer(String name, double price, String experience, String wichDevolopper) {
		super();
		this.name = name;
		this.price = price;
		/*
		 * this.experience = experience; this.wichDevolopper = wichDevolopper;
		 */
	}

	@Override
	public String toString() {
		return "SoftWearIngineer [name=" + name + ", price=" + price + "experience" + "]";
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	/*
	 * public String getExperience() { return experience; }
	 * 
	 * public String getWichDevolopper() { return wichDevolopper; }
	 */

}
