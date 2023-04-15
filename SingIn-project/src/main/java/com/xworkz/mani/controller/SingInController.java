package com.xworkz.mani.controller;

import java.time.LocalTime;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
		log.info("Runnning in SingIn Info in Controller...");
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
	public String userSignIn(String userId, String password, Model model, HttpServletRequest request) {
		log.info("Running in SingIn in Controller..");
		try {
			SingInDTO udto = this.singInService.userSignIn(userId, password);
			log.info("Login count" + udto.getLoginCount());
			if (udto.getLoginCount() >= 3) {
				model.addAttribute("msg", "Account locked Reset password");
				log.info("Account Locked after 3 attempts wrong Credential ");
				return "SingIn";
			}
			if (udto != null) {

				if (udto.getResetPassword() == true) {
					if (!udto.getExpTime().isAfter(LocalTime.now())) {
						model.addAttribute("Timeout", "Password Expired try again new");
						return "SingIn";
					}
					model.addAttribute("userID", udto.getUserId());
					log.info("Running innreset conditions");
					log.info("reset password :" + udto.getResetPassword());
					log.info("Timer :" + udto.getExpTime().isBefore(LocalTime.now()));
					return "updatePassword";
				}
				log.info("User ID and password is matched");
				model.addAttribute("userID", udto.getUserId());
				HttpSession session = request.getSession(true);
				session.setAttribute(userId, udto.getUserId());
				return "SingInSuccess";
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}

		model.addAttribute("notmatch", "UserID OR Password is not matching");
		return "SingIn";

	}

	@PostMapping("/reset")
	public String reSetPassword(String email, Model model) {
		log.info("Running in Reset Password in Controller....");
		try {
			SingInDTO udto = this.singInService.reSetPassword(email);
			if (udto.getResetPassword() == true) {
				model.addAttribute("msg", "Password reset sucessfull login");
				return "resetpassword";
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return "resetpassword";
	}

	@PostMapping("/passwordUpdate")
	public String upDatePassword(String userId, String password, String confirmPassword, Model model) {
		log.info("Runnning in Update password in Controller..");
		this.singInService.updatePassword(userId, password, confirmPassword);
		model.addAttribute("dto", userId);
		return "updateSuccess";
	}

	/*
	 * @RequestMapping("/send-otp-sms") public String sendOtpSms() { String
	 * fromNumber = "+1234567890"; // Twilio phone number String toNumber =
	 * "+1234567890"; // recipient's phone number String message =
	 * "Your OTP is 1234"; // replace with your OTP message Message sms = new
	 * Message.Builder().body(message).from(new PhoneNumber(fromNumber)).to(new
	 * PhoneNumber(toNumber)).build(); try {
	 * twilioRestClient.messages().create(sms); return "OTP SMS sent successfully";
	 * } catch (TwilioRestException e) { e.printStackTrace(); return
	 * "Failed to send OTP SMS"; } }
	 */
}
