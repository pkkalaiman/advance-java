package com.xworkz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.DTO.HotelDTO;
import com.xworkz.repository.HotelRepo;

@Service
public class HotelServiceIMPL implements HotelService {

	@Autowired
	private HotelRepo hotelRepo;

	public HotelServiceIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public boolean ValidateAndSave(HotelDTO dto) {
		System.out.println("Running in ValidateAndeSave....");
		boolean saved = this.hotelRepo.Save(dto);
		System.out.println("Save :"+saved);
		return false;
	}

}
