package com.xworkz.webbakery.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.webbakery.DTO.BakeryDTO;
import com.xworkz.webbakery.service.ServiceIMPL;

@Component
@RequestMapping("/main")
public class BakeryController {

	ServiceIMPL serviceIMPL;

	public BakeryController() {
		System.out.println("Created...." + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onMake(BakeryDTO dto, Model model) {
		System.out.println("Running....onMake");
		model.addAttribute("bakery", dto);
		System.out.println(dto.getName());
		System.out.println(serviceIMPL.validateAndSave(dto));
		return "index.jsp";
	}

}
