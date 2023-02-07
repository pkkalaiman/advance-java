package com.xworkz.datashow.controller;

import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.datashow.DTO.BeverAgeDTO;
import com.xworkz.datashow.DTO.ChatDTO;
import com.xworkz.datashow.DTO.EducationDTO;
import com.xworkz.datashow.DTO.FamilyDTO;
import com.xworkz.datashow.DTO.Mobile;

@Component
@RequestMapping("/") // this called on any method you mention and execute the methods thats called on
						// ("/") method
public class ManiController {

	public ManiController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@GetMapping("/mani") // u can used to any method ( @GetMapping (or) @PostMapping)
	public String onEmail(Model model) {
		System.out.println("Running onEmail....");
		model.addAttribute("eMail", "pkkalaiman@gmail.com");
		return "index.jsp";
	}

	@GetMapping("/mobile")
	public String onMobile(Model model) {
		System.out.println("Running in onMobile....");
		model.addAttribute("MobileNo", "63748803687");
		return "index.jsp";
	}

	@GetMapping("/Aadhar")
	public String onAadharNo(Model model) {
		System.out.println("Running in onAadharNo.....");
		model.addAttribute("AadharNo", "756546787456");
		return "index.jsp";
	}

	@GetMapping("/Age")
	public String onAge(Model model) {
		System.out.println("Runnin onAge.....");
		model.addAttribute("Age", "22");
		return "index.jsp";
	}

	@GetMapping("/DOB")
	public String onDateOfBirthAndTime(Model model) {
		System.out.println("Runnin onDateOfBirthAndTime.....");
		model.addAttribute("DateOfBirthAndTime", "22/08/2022 :12.22");
		return "index.jsp";
	}

	@GetMapping("/Salary")
	public String onDesiredSalary(Model model) {
		System.out.println("Runnin onDesiredSalary.....");
		model.addAttribute("FixedSalary", "2,00.0000");
		return "index.jsp";
	}

	@GetMapping("/best")
	public String onFriends(Model model) {
		System.out.println("Running in BestFriends.........");
		List<String> friend = new ArrayList<String>();
		friend.add("Vishak");
		friend.add("Ganesh");
		friend.add("Raju");
		friend.add("Vinayak");
		friend.add("Varun");
		friend.add("P K Mani");
		model.addAttribute("BestFriends", friend);
		
		return "index.jsp"; // this called as ViewResolver
	}

	@GetMapping("/onvist")
	public String onVisitPlace(Model model) {
		System.out.println("Running in MostVisitablePlace.....");
		List<String> place = new ArrayList<String>();
		place.add("Oganekkal");
		place.add("Kochine");
		place.add("Goaaaa");
		place.add("Pandicheri");
		place.add("Kerala");
		place.add("Kuttralam");
		place.add("Kaaveri False");
		place.add("Kodaikkanal");

		model.addAttribute("VisitPlace", place);
		return "index.jsp";
	}

	@GetMapping("/SkillSet")
	public String onSkillSet(Model model) {
		System.out.println("Running in onSkillSet....");
		List<String> skill = new ArrayList<String>();
		skill.add("JAVA");
		skill.add("HTML");
		skill.add("Java Script");
		skill.add("Tally Erp9");
		skill.add("MsWord");
		skill.add("Excell Sheet");
		skill.add("Spring");
		skill.add("Servlet");
		model.addAttribute("SkillSet", skill);
		return "index.jsp";
	}

	/*
	 * @GetMapping("/DTO") public String onDto(Model model) {
	 * System.out.println("Running in onDto....."); EducationDTO dto= new
	 * EducationDTO(); dto.setName("Mani"); dto.setId(21);
	 * dto.setDateOfBirth(LocalDate.now()); dto.setDeportment("Chemistry");
	 * model.addAttribute("Education", dto); return"index.jsp"; }
	 */

	@GetMapping("/DTO")
	public String onDto( Model model) {
		System.out.println("Running in onDto.....");
		EducationDTO dto=new EducationDTO();
		dto.setName("Mani");
		dto.setId(21);
		dto.setDateOfBirth(LocalDate.now());
		dto.setDeportment("Chemistry");
		model.addAttribute("Education", dto);
		return "index.jsp";
	}

	@GetMapping("/FamilyDto")
	public String onFamilyDto( Model model) {
		System.out.println("Running in onFamilyDto.,...");
	    FamilyDTO fam=new FamilyDTO();
		fam.setBrotherName("Kalaiman");
		fam.setBrotherAge(22);
		fam.setFatherName("Mani");
		fam.setFatherAge(56);
		fam.setMotherName("Sritha");
		fam.setMotherAge(55);
		fam.setSisterName("Ganga");
		fam.setSisterAge(20);
		fam.setGramaName("Sundhari");
		fam.setGranmaaAge(78);
		fam.setGranpaaName("Sundaran");
		fam.setGranpaAge(79);
		model.addAttribute("Family", fam);
		return "index.jsp";
	}

	@GetMapping("/Redmi")
	public String onMobileDto( Model model) {
		System.out.println("Running in onMobileDTO.....");
		Mobile mob=new Mobile();
		mob.setName("Redmi");
		mob.setPrice(120000.67);
		mob.setRam(120);
		mob.setVersion(1234.04);
		mob.setModel("Oppo");
		model.addAttribute("OPPO", mob);
		return "index.jsp";

	}

	@GetMapping("/Beverage")
	public String onBeverageDto( Model model) {
		System.out.println("Running in On BeverageDto......");
		BeverAgeDTO bev=new BeverAgeDTO();
		bev.setBlender("caffeinated");
		bev.setCarbonated("chaser");
		bev.setCocaCola("hospitality");
		bev.setHospitality("iced");
		bev.setProteinshake("refreshment");
		bev.setShake("sparkling");
		bev.setSundowner("sundowner");
		bev.setThirstquenching("caffeinated");

		model.addAttribute("CocaCola", bev);
		return "index.jsp";
	}

	@GetMapping("/Chating")
	public String onChating( Model model) {
		System.out.println("Running onChatingDto........");
		ChatDTO chat=new ChatDTO();
		chat.setName("P K Mani");
		chat.setCollageGroup("Chemistry Rockers");
		chat.setFriends("Bad Boys");
		chat.setFunnyChating("Chemistry Group");
		chat.setNoOfChating(200);
		chat.setNoOfGroups(32);
		chat.setOfflineChating("my Love");
		chat.setOnlineChating("My Crish");
		chat.setWichgroup("My Collage Group");

		model.addAttribute("Group", chat);
		
		return "index.jsp";
	}

}
