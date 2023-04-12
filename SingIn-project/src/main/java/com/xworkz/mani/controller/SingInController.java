package com.xworkz.mani.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.mani.DTO.SingInDTO;
import com.xworkz.mani.service.SingInService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class SingInController {

	@Autowired
	private SingInService singInService;

	public SingInController() {
		log.info("" + this.getClass().getSimpleName());
	}

	@PostMapping("/detials")
	public String userInfo(SingInDTO sinDTO, Model model) {
		Set<ConstraintViolation<SingInDTO>> violations = this.singInService.validateAndSave(sinDTO);

		if (violations != null && violations.isEmpty() && sinDTO != null) {
			model.addAttribute("message", "Registration sucessfull");
			log.info("" + sinDTO);
			return "SingUp";
		}
		model.addAttribute("errors", violations);
		model.addAttribute("messag", "Registration failed");
		model.addAttribute("dto", sinDTO);
		return "SingUp";

	}

	@PostMapping("/signin")
	public String userSignIn(String userId, String password, Model model) {
		try {
			SingInDTO udto = this.singInService.userSignIn(userId, password);
			log.info("Login count" + udto.getLoginCount());
			if (udto.getLoginCount() >= 3) {
				model.addAttribute("msg", "Account locked Reset password");
				return "SingIn";
			}
			if (udto != null) {

				if (udto.getResetPassword() == true) {
					model.addAttribute("userID", udto.getUserId());
					return "updatePassword";
				}
				log.info("User ID and password is matched");
				model.addAttribute("userID", udto.getUserId());
				return "SingInSuccess";
			}
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
		}

		model.addAttribute("notmatch", "UserID OR Password is not matching");
		return "SingIn";

	}

	@PostMapping("/reset")
	public String reSetPassword(String email, Model model) {
		SingInDTO udto = this.singInService.reSetPassword(email);
		if (udto.getResetPassword() == true) {
			
			model.addAttribute("msg", "Password reset sucessful plz login");
			return "resetpassword";
		}
		return "resetpassword";
	}

	@PostMapping("/passwordUpdate")
	public String upDatePassword(String userId, String password, String confirmPassword, Model model) {
		this.singInService.updatePassword(userId, password, confirmPassword);
		model.addAttribute("dto", userId);
		return "updateSuccess";
	}

}
