package com.xworkz.mobile.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.mobile.Entity.MobileEntity;
import com.xworkz.mobile.MobileDTO.MobileDTO;
import com.xworkz.mobile.Service.MobileService;

@Controller
@RequestMapping("/")
public class MobileController {

	@Autowired
	private MobileService mobileService;

	private List<String> os = Arrays.asList("Android 13.0", "Linux", "IOS", "Web Os", "Crome Os", "Lune Os",
			"Microsoft Windows");
	private List<String> storage = Arrays.asList("120 Rom, 8 GB Ram", "250 Rom, 12 GB Ram", "60 Ram, 8 GB Ram",
			"32 Rom, 6 GB Ram");
	private List<String> colors = Arrays.asList("Bllue", "Yellow", "Green", "Purble", "Voilet", "Purble Blue", "Bloick",
			"Light Blue");

	public MobileController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@GetMapping("/mobile")
	public String onMobile(Model model) {
		System.out.println("Created in onMobile Controllerr....");

		model.addAttribute("os", os);
		model.addAttribute("storage", storage);
		model.addAttribute("colors", colors);
		return "Mobiles";
	}

	@GetMapping("/search")
	public String onSearch(@RequestParam int id, Model model) {
		System.out.println("Created onSearch running for Id :" + id);
		MobileEntity dto = this.mobileService.finById(id);
		if(dto !=null) {
			model.addAttribute("Dto :", dto);
		}else {
			model.addAttribute("message", "Data Not Found");
		}
		return "MobileSearch";
	}

	@PostMapping("/mobile")
	public String onMobile(MobileDTO dto, Model model) {
		System.out.println("Created in OnMobile Controller......");
		System.out.println(dto);
		Set<ConstraintViolation<MobileDTO>> violation = this.mobileService.ValidaateAndSave(dto);
		if (violation.isEmpty()) {
			System.out.println("No Violation in Controller Go to the Successs Pagee...");
			return "Success";
		}
		System.err.println("Violation in Controlle");
		model.addAttribute("os", os);
		model.addAttribute("storage", storage);
		model.addAttribute("colors", colors);
		model.addAttribute("error", violation);
		model.addAttribute("Validdate Dto :", dto);
		return "Mobiles";
	}

}
