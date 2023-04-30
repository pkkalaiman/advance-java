package com.xworkz.mani.Controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.mani.DTO.ApplicationDTO;
import com.xworkz.mani.Service.ApplicationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	public ApplicationController() {
		log.info("Created in :" + this.getClass().getSimpleName());
	}

	@PostMapping("/registration")
	public String onSave(ApplicationDTO dto, Model model) {
		log.info("Created in Save in Controller..");

		Set<ConstraintViolation<ApplicationDTO>> violation = this.applicationService.ValidateAndSave(dto);

		if (violation != null && !violation.isEmpty()) {
			model.addAttribute("message", "Registration Successsfully");
			log.info("" + dto);
			return "Registration";
		}
		model.addAttribute("errors", violation);
		model.addAttribute("mesage", "registration failed");
		model.addAttribute("dto", dto);
		return "Registration";
	}

}
