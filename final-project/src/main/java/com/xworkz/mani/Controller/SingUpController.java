package com.xworkz.mani.Controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.mani.DTO.SingUpDTO;
import com.xworkz.mani.Service.SingUpService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class SingUpController {

	@Autowired
	private SingUpService singUpService;

	public SingUpController() {
		log.info("Created :" + this.getClass().getSimpleName());
	}

	@GetMapping("/mani")
	public String onSave() {
		log.info("Created in Save in GetMappping in Controlller");
		return "SingUp";
	}

	@PostMapping("/mani")
	public String onSave(SingUpDTO dto, Model model) {
		log.info("Created in onSave PostMappings.." + dto);

		Set<ConstraintViolation<SingUpDTO>> violation = this.singUpService.ValidateAndSave(dto);

		if (violation.isEmpty()) {
			model.addAttribute("message", "Data Saved Successfully");
			log.info("" + dto);
			return "SingUp";
		} else {
			model.addAttribute("error", violation);
			model.addAttribute("messag", "data not Saved");
		}

		return "SingUp";
	}

	@PostMapping("/login")
	public String logIn(@RequestParam String userId, @RequestParam String password, Model model, SingUpDTO dto) {
		System.out.println("Log In running......!");
		try {
			SingUpDTO sindto = this.singUpService.ValidateLoginUsinguserIdAndPassword(userId, password);
			if (sindto != null) {
				log.info("User Id password is matched");
				model.addAttribute("userId", sindto.getUserId());

				return "Success";
			}

		} catch (Exception e) {
			model.addAttribute("msge", "User Id Or Password is Not Matching");
		}
		return "SingIn";
	}

	public String reSetPassword(String email, Model model) {
		SingUpDTO sinDTO = this.singUpService.reSetPassword(email);
		return "resetPassword";
	}

}
