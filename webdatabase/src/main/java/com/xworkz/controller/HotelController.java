package com.xworkz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.DTO.HotelDTO;
import com.xworkz.service.HotelService;

@Controller
@RequestMapping("/Restourent")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	public HotelController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onRestourent(HotelDTO dto, Model model) {
		System.out.println("Running in onRestourent...");
		model.addAttribute("Id :", dto.getId());
		model.addAttribute("Name :", dto.getHotelName());
		model.addAttribute("Dish Name :", dto.getDishName());
		model.addAttribute("Quantity :", dto.getQuantity());
		model.addAttribute("Price :", dto.getPrice());
		model.addAttribute("Typeee", dto.getType());
		
		boolean saved = this.hotelService.ValidateAndSave(dto);
		System.out.println(saved);
		return "index";
	}

}
