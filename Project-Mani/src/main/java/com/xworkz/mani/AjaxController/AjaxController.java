package com.xworkz.mani.AjaxController;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.xworkz.mani.Service.ProjectService;
import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@RestController
@Slf4j
@RequestMapping("/")
public class AjaxController {

	@Autowired
	private ProjectService projectService;

	public AjaxController() {
		log.info("Created " + this.getClass().getSimpleName());
	}

	@GetMapping(value = "/userName/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onUser(@PathVariable String user) {
		Long dbUser = this.projectService.findByUser(user);
		log.error("" + dbUser);

		if (dbUser == 0) {
			log.error("Running in equals condition");
			return "";
		} else {
			return "UserId exist";
		}

	}

	@GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onEmail(@PathVariable String email) {
		Long dbEmail = this.projectService.findByEmail(email);
		log.error("" + dbEmail);

		if (dbEmail == 0) {
			log.error("Running in equals condition");
			return "";
		} else {
			return "Email id exsist";
		}
	}

	@GetMapping(value = "/mobile/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onMobile(@PathVariable Long number) {
		Long dbNumber = this.projectService.findByMobile(number);
		log.error("" + dbNumber);

		if (dbNumber == 0) {
			log.error("Running in equals condition");
			return "";

		} else {
			return "Mobile Number already exist";
		}
	}

}
