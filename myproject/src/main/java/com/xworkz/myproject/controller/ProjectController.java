package com.xworkz.myproject.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.myproject.DTO.ProjectDTO;
import com.xworkz.myproject.service.ProjectService;

@Controller
@RequestMapping("/")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	public ProjectController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@GetMapping("/project")
	public String onProject(Model model) {
		System.out.println("Running in onProject in Controller...");
		
		return "Data";
	}

	@PostMapping("/project")
	public String onProject(ProjectDTO dto, Model model) {
		System.out.println("Running in onProject 	 in PostMappings");
		System.out.println("Dto :" + dto);

		Set<ConstraintViolation<ProjectDTO>> violation = this.projectService.ValidateAndSave(dto);

		if (violation !=null && !violation.isEmpty()) {
			System.out.println("No Vioaltion Controll go to SuccessPage...");
			model.addAttribute("message", "Data is Saved");
			return "Success";
		}
		System.out.println("Violation in Controller");
		model.addAttribute("error", violation);
		model.addAttribute("dto", dto);
		return "Data";
	}

}
