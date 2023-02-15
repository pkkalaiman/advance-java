package com.xworkz.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.DTO.CmDTO;
import com.xworkz.service.CmService;

@Controller
@RequestMapping("/cm")
public class CmController {

	@Autowired
	private CmService cmService;

	public CmController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onCm(CmDTO dto, Model model) {
		System.out.println("Running in OnCm...");
		
		Set<ConstraintViolation<CmDTO>> violation = 
				this.cmService.ValidateAndSave(dto);
		
		if (violation.isEmpty()) {
			System.err.println("Validation Failed error Message..");
			
			violation.forEach((cm) 
					-> System.err.println(cm.getMessage()));
			
		} else {
			System.out.println("Validation Successs, Display Success Message..");
		}
		return "index";
	}
}
