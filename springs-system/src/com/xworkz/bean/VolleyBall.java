package com.xworkz.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VolleyBall {

	@Autowired
	@Qualifier("RonaldoPlayerName")
	private String name;
	@Autowired
	@Qualifier("22")
	private int id;

	
	public String VolleyBallName() {
		System.out.println("Registered In Spring..");
		VolleyBall ref=new VolleyBall();
		return "Mani";
	}
	
	public int VolleBallId() {
		System.out.println("Registered in VollyBallId Spring");
		int id=33;
		return 22;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
