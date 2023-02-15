package com.xworkz.kerala.controller;

import org.springframework.stereotype.Component; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.kerala.DTO.KochineDTO;

@Component
@RequestMapping("/kerala")
public class KeralaController {

	public KeralaController() {
		System.out.println("Created :"+this.getClass().getSimpleName());
	}
	
	@PostMapping
	public String onKerala(KochineDTO dto, Model model) {
		System.out.println("Running in on Kerala Post Controller");
		model.addAttribute("name :", dto.getName());
		model.addAttribute("parksName :", dto.getParksName());
		model.addAttribute("entryFees :", dto.getEntryFees());
		model.addAttribute("faalse :", dto.getFaalse());
		model.addAttribute("noOfFalse :", dto.getNoOfFalse());
		
		System.out.println(dto);
		
		return "Successfully.jsp";
	}
	
}
