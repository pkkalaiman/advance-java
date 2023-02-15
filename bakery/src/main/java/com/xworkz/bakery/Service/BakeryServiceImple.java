package com.xworkz.bakery.Service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.xworkz.bakery.DTO.BakeryDTO;
import com.xworkz.bakery.Repository.BakerRepoImple;


@Service
public class BakeryServiceImple implements BakeryService {

	@Autowired
	private BakerRepoImple repoimple;

	public BakeryServiceImple() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public boolean ValidateAndSave(BakeryDTO dto) {
		System.out.println("Running in ValidateAnd Save......"+dto);
		boolean saved = this.repoimple.Save(dto);
		System.out.println("ValidatAndSaved :" + saved);
		return false;
	}

}
