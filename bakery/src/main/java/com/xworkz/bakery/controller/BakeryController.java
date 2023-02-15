package com.xworkz.bakery.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.bakery.DTO.BakeryDTO;
import com.xworkz.bakery.Service.BakeryService;

@Controller
@RequestMapping("/Bakery")
public class BakeryController {
	
	@Autowired
	private BakeryService bakeryService;

	public BakeryController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
	@PostMapping
	public String onBakery(BakeryDTO dto, Model model) {
		System.out.println("Running in onPostMethod...."+dto);
		
		model.addAttribute("bakeryName", dto.getBakeryName());
		model.addAttribute("bakeryOwnerName", dto.getBakeryOwnerName());
		model.addAttribute("bakeryOnerWifeName", dto.getBakeryOnerWifeName());
		model.addAttribute("bakeryFamous", dto.getBakeryFamous());
		model.addAttribute("OwnerMarried", dto.getOwnerMarried());
		model.addAttribute("bakerySince", dto.getBakerySince());
		
		boolean saved=this.bakeryService.ValidateAndSave(dto);
		System.out.println("Saved :"+saved);
		
		return "index";
	}
	
}
