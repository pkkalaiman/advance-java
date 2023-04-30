package com.xworkz.mani.Controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.mani.DTO.ProjectDTO;
import com.xworkz.mani.Entity.TechnologyEntity;
import com.xworkz.mani.Service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	private List<String> list = Arrays.asList("Windows", "Linux", "macOS", "Android", "Unix", "Ubuntu", "Red Hat",
			"Chrome OS", "Symbian");
	private List<String> os = Arrays.asList("Yes", "No");
	private List<String> language = Arrays.asList("Java", "HTML", "JavaScript", "BootStrap", "Python", "PHP", "SQL",
			"CSS", "AI", "ML");

	public ProjectController() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	@PostMapping("/unique")
	public String onSignUp(ProjectDTO dto, Model model) {

		if (dto.getPassword().equals(dto.getConfirmPassword())) {
			Set<ConstraintViolation<ProjectDTO>> violations = this.projectService.validateAndSave(dto);

			if (violations == null) {
				model.addAttribute("AlreadyExist", "UserId or Email or Mobile already exist");
				return "SignUp";
			}

			if (violations.isEmpty() && violations != null) {
				model.addAttribute("message", "data saved successfully");
				log.info("" + dto);
				return "SignUp";
			} else {
				model.addAttribute("error", violations);
				model.addAttribute("dto", dto);
			}
			return "SignUp";
		} else {
			model.addAttribute("password", "Password and confirmed password must be same");
		}
		return "SignUp";

	}

	@PostMapping("/special")
	public String userSignIn(String userId, String password, Model model, HttpServletRequest request) {
		log.info("Running in userSignIn condition ");
		try {
			ProjectDTO dto = this.projectService.userSignIn(userId, password);
			log.info("Login count" + dto.getLockCount());
			if (dto.getLockCount() >= 3) {
				model.addAttribute("msg", "Account locked Reset password");
				log.info("Acount locked due to 3 attempts");
				return "SignIn";
			}

			if (dto != null) {

				if (dto.getResetPassword() == true) {
					log.info("Running in ResetPassword true condition");
					if (!dto.getPasswordChangedTime().isAfter(LocalTime.now())) {
						log.info("Running in time warifying condition");
						model.addAttribute("msgs", "Time out plz try again after sometime");
						return "SignIn";
					}
					model.addAttribute("userID", dto.getUserId());
					log.info("Running in reset condition");
					log.info("ResetPassword---" + dto.getResetPassword());
					log.info("Timer-----" + dto.getPasswordChangedTime().isAfter(LocalTime.now()));
					return "UpdatePassword";
				}

				log.info("User ID and password is matched");
				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("userID", dto.getUserId());
				httpSession.setAttribute("dtoPic", dto.getPicName());
				httpSession.setAttribute("dto", dto);
				return "PasswordSuccess";
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		log.info("UserID OR Password is not matching");
		model.addAttribute("msg", "UserID OR Password is not matching");
		return "SignIn";
	}

	@PostMapping("/reset")
	public String resetPassword(String email, Model model) {
		try {
			ProjectDTO dto = this.projectService.resetPassword(email);
			if (dto.getResetPassword() == true) {
				model.addAttribute("message", "Password reset successfull plz login within 2 min with otp");
				model.addAttribute("message", "Password reset successful plz login within 2 min with otp");
				return "ResetPassword";
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return "ResetPassword";
	}

	@PostMapping("/passwordUpdate")
	public String updatePassword(String userId, String password, String confirmPassword) {
		log.info("Running in updatePassword method");
		this.projectService.updatePassword(userId, password, confirmPassword);
		return "PasswordSuccess";
	}

	@PostMapping("/upload")
	public String onUpload(@RequestParam("mani") MultipartFile multipartFile, String userId, String email,
			Long mobileNumber, Model model) throws IOException {
		log.info("multipartFile" + multipartFile);
		log.info(multipartFile.getOriginalFilename());

		String imageFormat = multipartFile.getOriginalFilename().substring(
				multipartFile.getOriginalFilename().lastIndexOf('.'), multipartFile.getOriginalFilename().length());

		log.info("Image Format " + imageFormat);
		log.info(multipartFile.getContentType());
		log.info("Size of file" + multipartFile.getSize());
		log.info("Size of bite" + multipartFile.getBytes());
		if (multipartFile.isEmpty()) {
			log.info("file not uploaded");
			model.addAttribute("error", "please select file");
			return "updateProfile";
		}
		model.addAttribute("sucess", "image uploaded sucessfully");
		byte[] bytes = multipartFile.getBytes();
		Path path = Paths.get("D:\\pic\\" + userId + System.currentTimeMillis() + imageFormat);
		Files.write(path, bytes);
		String imageName = path.getFileName().toString();
		log.info("Image name--" + imageName);
		log.info("Image name in tostring--" + path.toString());
		log.info("Image file name--" + path.getFileName());
		this.projectService.updateProfile(userId, email, mobileNumber, imageName);
		return "updateProfile";
	}

	@GetMapping("/download")
	public void onDownload(HttpServletResponse response, @RequestParam String fileName, ProjectDTO user)
			throws IOException {

		try {
			Path path = Paths.get("D:\\pic\\" + user.getPicName());
			path.toFile();
			response.setContentType("image/jpeg");
			File file = new File("D:\\pic\\" + fileName);
			InputStream in = new BufferedInputStream(new FileInputStream(file));
			ServletOutputStream out = response.getOutputStream();
			IOUtils.copy(in, out);
			response.flushBuffer();
		} catch (FileNotFoundException fnfe) {
			fnfe.getStackTrace();
		}

	}

	// get mapping for adding drop downs for some technologies in add technologies
	@GetMapping("/technology")
	public String listTechnology(Model model) {
		log.info("Running listTechnology");
		model.addAttribute("list", list);
		model.addAttribute("os", os);
		model.addAttribute("lang", language);
		return "AddTechnology";
	}

	// add technology
	@PostMapping("/technology")
	public String onTechnology(String userId, TechnologyEntity entity, Model model) {
		log.info("Running technology in controller");

		ProjectDTO dto = this.projectService.addTechnology(userId, entity);

		model.addAttribute("list", list);
		model.addAttribute("os", os);
		model.addAttribute("lang", language);
		model.addAttribute("techs", "technologies added successfully");
		model.addAttribute("techno", entity);
		return "AddTechnology";

	}

	// view technology
	@GetMapping("/viewTech")
	public String onViewTech(@RequestParam String userId, Model model) {

		log.info("Running view Technology in controller");
		List<TechnologyEntity> technology = this.projectService.viewTechnology(userId);
		model.addAttribute("viewTech", technology);

		return "ViewTechnology";
	}

}
