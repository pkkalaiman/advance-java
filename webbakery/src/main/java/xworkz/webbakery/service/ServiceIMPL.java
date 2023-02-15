package com.xworkz.webbakery.service;

import org.springframework.beans.factory.annotation.Autowired;

import xworkz.webbakery.DTO.BakeryDTO;
import xworkz.webbakery.repository.RepoIMPL;

@org.springframework.stereotype.Service
public class ServiceIMPL implements Service{

	
	@Autowired
	RepoIMPL repoIMPL;

	@Override
	public boolean validateAndSave(BakeryDTO dto) {
		System.out.println("Running validateAndSave....");
		boolean saved=this.repoIMPL.save(dto);
		System.out.println("Saved..."+saved);
		return false;
	}

	
	
}
