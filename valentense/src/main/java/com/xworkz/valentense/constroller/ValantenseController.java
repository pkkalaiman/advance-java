package com.xworkz.valentense.constroller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.valentense.DTO.ValantenseDTO;
import com.xworkz.valentense.service.ValantenSeervice;

@Controller
@RequestMapping("/valentens")
public class ValantenseController {

	@Autowired
	private ValantenSeervice valantenseService;

	private List<String> place = Arrays.asList("KRP Dam", "Ooty", "Kerala", "Americaa", "Ustraliyaa", "Singapure",
			"Absara Theatre");

	private List<String> gift = Arrays.asList("Teddy", "Watch", "Ring", "Greeting Card", "Chocolate");

	public ValantenseController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@GetMapping
	public String onValantense(Model model) {
		System.out.println("Created in OnValantense Get.....");
		
		model.addAttribute("places", place);
		model.addAttribute("gifts", gift);

		return "Valantense";
	}

	@PostMapping
	public String onValantense(Model model, ValantenseDTO dto) {
		System.out.println("Running in onValantensePost");

		Set<ConstraintViolation<ValantenseDTO>> violation = this.valantenseService.ValidateAndSave(dto);

		if (violation.isEmpty()) {
			System.out.println("no violataion in controller go to Success page...");

			return "ValantenseSeccess";
		}
		System.out.println("violataion in controller");
		model.addAttribute("places", place);
		model.addAttribute("gifts", gift);
		model.addAttribute("error", violation);
		model.addAttribute("Validat Dto :", dto);
		return "Valantense";
	}
}
