package com.xworkz.gova.controler;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.gova.DTO.GoaDTO;

@Component
@RequestMapping("/goa")
public class GoaController {

	public GoaController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onPost(GoaDTO dto, Model model) {
		System.out.println("Running in onPost!!!.......");

		model.addAttribute("name", dto.getName());
		model.addAttribute("cruise", dto.getCruise());
		model.addAttribute("entrFees", dto.getEntrFees());
		model.addAttribute("freeFood", dto.getFreeFood());
		model.addAttribute("freeAlcohol", dto.getFreeAlcohol());

		System.out.println("Casino Name :" + dto.getName());
		System.out.println("Casino Cruise :" + dto.getCruise());
		System.out.println("Entry Fees :" + dto.getEntrFees());
		System.out.println("Free Food :" + dto.getFreeFood());
		System.out.println("Free Alcohol :" + dto.getFreeAlcohol());

		return "Succsessfully.jsp";
	}

}
