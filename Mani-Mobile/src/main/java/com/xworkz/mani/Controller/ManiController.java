package com.xworkz.mani.Controller;

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

import com.xworkz.mani.ManiDTO.ManiDTO;
import com.xworkz.mani.Service.ManiService;

@Controller
@RequestMapping("/")
public class ManiController {

	@Autowired
	private ManiService maniService;

	private List<String> os = Arrays.asList("Android 13.0", "Linux", "IOS", "Web Os", "Crome Os", "Lune Os",
			"Microsoft Windows");
	private List<String> storage = Arrays.asList("120 Rom, 8 GB Ram", "250 Rom, 12 GB Ram", "60 Ram, 8 GB Ram",
			"32 Rom, 6 GB Ram");
	private List<String> colors = Arrays.asList("Bllue", "Yellow", "Green", "Purble", "Voilet", "Purble Blue", "Bloick",
			"Light Blue");

	public ManiController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@GetMapping("/Mobile")
	public String onMobile(Model model) {
		System.out.println("Created in GetMapping onMobilee...");

		model.addAttribute("os", os);
		model.addAttribute("storage", storage);
		model.addAttribute("colors", colors);
		return "Mobile";
	}

	@PostMapping("/Mobile")
	public String onMobile(ManiDTO dto, Model model) {
		System.out.println("Running in onMobile in PostMappingg....");
		System.out.println(dto);

		Set<ConstraintViolation<ManiDTO>> violation = this.maniService.ValidateAndSave(dto);
		if (violation.isEmpty()) {
			System.out.println("No Volation in controller go to Success Page");

			return "Success";
		}

		System.err.println("Violataion in Controller");
		model.addAttribute("os", os);
		model.addAttribute("storage", storage);
		model.addAttribute("colors", colors);
		model.addAttribute("error", violation);
		model.addAttribute("Validate Dto", dto);
		return "Mobile";
	}

}
