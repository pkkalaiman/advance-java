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

import com.xworkz.mobile.MobileDTO.MobileDTO;
import com.xworkz.mobile.Service.MobileService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
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

	@PostMapping("/mobile")
	public String onMobile(MobileDTO dto, Model model) {
		System.out.println("Created in OnMobile Controller......" + dto);

		Set<ConstraintViolation<MobileDTO>> violation = this.mobileService.ValidaateAndSave(dto);
		if (violation.isEmpty()) {
			System.out.println("No Violation in Controller Go to the Successs Pagee...");

			model.addAttribute("message", "Data is Saved");
			model.addAttribute("os", os);
			model.addAttribute("storage", storage);
			model.addAttribute("colors", colors);
			return "Success";
		}
		System.err.println("Violation in Controlle");
		model.addAttribute("os", os);
		model.addAttribute("storage", storage);
		model.addAttribute("colors", colors);
		model.addAttribute("error", violation);
		model.addAttribute("dto", dto);
		return "Mobiles";
	}

	@GetMapping("/search")
	public String onSearch(@RequestParam int id, Model model) {
		System.out.println("Created onSearch running for Id :" + id);
		MobileDTO dto = this.mobileService.finById(id);
		if (dto != null) {
			model.addAttribute("dto", dto);
		} else {
			model.addAttribute("message", "Data Not Found");
		}
		return "MobileSearch";
	}

	@GetMapping("/searchbyname")
	public String onSearchByName(@RequestParam String name, Model model) {

		System.out.println("Running in onSerachByName Controller... :" + name);
		List<MobileDTO> list = this.mobileService.findByName(name);
		if (list.size() > 0) {
			model.addAttribute("list", list);

		} else {
			model.addAttribute("error", "Name Not Macthed");

		}
		return "SearchByName";
	}

	@GetMapping("/searchNameBybrandName")
	public String onSearchNameByBrandName(@RequestParam String name, @RequestParam String brandName, Model model) {
		System.out.println("Running in onSearchNameBybrandName Controller..." + name + " " + brandName);
		List<MobileDTO> list = this.mobileService.findByNameByBrandName(name, brandName);

		if (name != null && !name.isEmpty() || brandName != null && !brandName.isEmpty()) {
			model.addAttribute("name", list);
		} else {
			List<MobileDTO> moblildto = this.mobileService.findByNameByBrandName(name, brandName);
			model.addAttribute("Error", "NameAndBrandName not Matched");
		}
		return "SearchNameBybrandName";
	}

	@GetMapping("/updated")
	public String onUpdate(@RequestParam int id, Model model) {
		System.out.println("Running in onUpdated in Controller :" + id);

		MobileDTO dto = this.mobileService.finById(id);
		System.out.println("entity" + dto);
		model.addAttribute("os", os);
		model.addAttribute("dto", dto);
		model.addAttribute("storage", storage);
		model.addAttribute("colors", colors);
		return "Updated";
	}

	@PostMapping("/updated")
	public String onUpdate(MobileDTO dto, Model model) {
		System.out.println("Running updated :" + dto);
		Set<ConstraintViolation<MobileDTO>> constraintviolation = this.mobileService.ValidateAndUpdate(dto);

		if (constraintviolation.size() > 0) {
			model.addAttribute("error", constraintviolation);
			model.addAttribute("dto", dto);
		} else {
			model.addAttribute("message", "Mobile Updated Successfully....");
			model.addAttribute("dto", dto);
		}
		return "Updated";
	}

	@GetMapping("/delete")
	public String onDelete(int id, Model model) {
		System.out.println("Running in OnDelete");
		System.out.println("Deleting :" + id);

		boolean delet = this.mobileService.onDelete(id);

		model.addAttribute("delete", delet);
		model.addAttribute("message", "Data is Deleted Successfully");
		return "SearchByName";
	}

	@GetMapping("/findall")
	public String onFindAll(Model model) {
		System.out.println("Creating in onFindAll in Controller...");
		List<MobileDTO> list = this.mobileService.findAll();

		if (list != null && !list.isEmpty()) {
			model.addAttribute("findall", list);
		} else {
			model.addAttribute("error", "Data not found in DataBase");
		}
		return "FindAll";
	}

}
