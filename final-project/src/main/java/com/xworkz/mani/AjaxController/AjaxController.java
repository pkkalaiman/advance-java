package com.xworkz.mani.AjaxController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.mani.DTO.SingUpDTO;
import com.xworkz.mani.Service.SingUpService;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@RestController
@Slf4j
@RequestMapping("/")
public class AjaxController {

	@Autowired
	private SingUpService singUpService;

	public AjaxController() {
		log.info("Created :" + this.getClass().getSimpleName());
	}

	@GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onEmail(@PathVariable String email) {

		Long dbEmail = this.singUpService.findByEmail(email);
		System.err.println(dbEmail);

		if (dbEmail == 0) {
			System.err.println("Running in Equals Condition..");
			return "";
		} else {
			return "Email id exist";
		}

	}

	@GetMapping(value = "/userName/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onUser(@PathVariable String user) {
		Long dbuser = this.singUpService.findByUser(user);
		System.err.println(dbuser);

		if (dbuser == 0) {
			System.err.println("Running in equalse Conditions..");
			return "";
		} else {
			return "User Id exist";
		}

	}

	@GetMapping(value = "/mobile/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onMobile(@PathVariable Long number) {
		Long dbNumber = this.singUpService.findByMobile(number);
		System.err.println(dbNumber);

		if (dbNumber == 0) {
			System.out.println("Running in equalse Conditionss...");
			return "";
		} else {
			return "Mobile Number exist";
		}

	}

	@GetMapping(value = "/reemail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String reEmail(@PathVariable String email) {
		Long dbEmail = this.singUpService.findByEmail(email);
		System.err.println(dbEmail);

		if (dbEmail == 0) {
			System.err.println("Running in equals condition");
			return "Please enter Existing email";
		} else {
			return "  ";
		}
	}

	@GetMapping(value = "/dto", produces = MediaType.APPLICATION_JSON_VALUE)
	public SingUpDTO singUpDTO() {
		SingUpDTO dto = new SingUpDTO();
		dto.setUserId("Mani123");
		dto.setEmail("pkkalaiman@gmail.com");
		dto.setMobileNo(123456789L);
		System.out.println(dto);
		return dto;

	}

}
