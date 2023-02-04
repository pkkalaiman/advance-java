package com.xworkz.gova.controler;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.gova.DTO.BeachDTO;

@Component
@RequestMapping("/Beach")
public class BeachController {

	public BeachController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onBeach(BeachDTO dto, Model model) {
		System.out.println("Running to the Beach Location!!!.......");

		model.addAttribute("name", dto.getName());
		model.addAttribute("location", dto.getLocation());
		model.addAttribute("clean", dto.getClean());

		System.out.println("name :" + dto.getName());
		System.out.println("location :" + dto.getLocation());
		System.out.println("clean :" + dto.getClean());

		return "Succsessfully.jsp";
	}

}
