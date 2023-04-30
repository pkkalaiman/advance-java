package com.xworkz.mani.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.mani.DTO.ProjectDTO;
import com.xworkz.mani.Entity.ProjectEntity;
import com.xworkz.mani.Entity.TechnologyEntity;
import com.xworkz.mani.Repository.ProjectRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectServiceImple implements ProjectService {

	@Autowired
	private ProjectRepo projectRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	String resetPassword = DefaultPasswordGenerator.generate(6);

	public ProjectServiceImple() {
		log.info("Created " + this.getClass().getSimpleName());
	}

	@Override
	public Long findByUser(String user) {
		Long userCount = this.projectRepo.findByUser(user);
		return userCount;
	}

	@Override
	public Long findByEmail(String email) {
		Long emailCount = this.projectRepo.findByEmail(email);
		return emailCount;
	}

	@Override
	public Long findByMobile(Long mobile) {
		Long mobileCount = this.projectRepo.findByMobile(mobile);
		return mobileCount;
	}

	@Override
	public Set<ConstraintViolation<ProjectDTO>> validateAndSave(ProjectDTO dto) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<ProjectDTO>> violations = validator.validate(dto);

		if (violations != null && !violations.isEmpty()) {
			System.err.println("Violation in dto " + dto);
			return violations;
		} else {
			log.info("Violation is not There in dto, can Save the data");

			Long count = this.projectRepo.findCountByEmailAndUserAndMobile(dto.getEmail(), dto.getUserId(),
					dto.getMobileNumber());

			if (count == 0) {

				ProjectEntity entity = new ProjectEntity();
				entity.setUserId(dto.getUserId());
				entity.setEmail(dto.getEmail());
				entity.setMobileNumber(dto.getMobileNumber());
				entity.setCreatedBy(dto.getUserId());
				entity.setCreatedDate(LocalDateTime.now());
				entity.setPassword(passwordEncoder.encode(dto.getPassword()));
				entity.setPasswordChangedTime(LocalTime.of(0, 0, 0));
				entity.setResetPassword(false);
				// BeanUtils.copyProperties(dto, entity);

				boolean saved = this.projectRepo.save(entity);
				boolean sent = sendMail("rghiremath26@gmail.com");
				log.info("Email sent " + sent);
				log.info("Entity Data is Saved " + saved);

			} else {
				System.out.println("data already exists");
				return null;
			}
		}
		return Collections.emptySet();

	}

	@Override
	public ProjectDTO userSignIn(String userId, String password) {
		ProjectEntity entity = this.projectRepo.userSignIn(userId);
		ProjectDTO dto = new ProjectDTO();
		BeanUtils.copyProperties(entity, dto);

		log.info("matching--" + passwordEncoder.matches(password, entity.getPassword()));
		log.info("Time matching--" + entity.getPasswordChangedTime().isAfter(LocalTime.now()));
		log.info("Now Present Time--" + LocalTime.now());
		log.info("PasswordChangedTime--" + entity.getPasswordChangedTime());

		log.info("Time " + LocalTime.now().isBefore(entity.getPasswordChangedTime()));
		if (entity.getLockCount() >= 3) {
			log.info("Running in Login count condition");
			return dto;
		}

		if (dto.getUserId().equals(userId) && passwordEncoder.matches(password, entity.getPassword())) {
			log.info("Running userId matching and password matching");
			return dto;
		} else {
			this.projectRepo.onLock(userId, entity.getLockCount() + 1);
			log.info("count of login" + entity.getLockCount() + 1);
			return null;
		}
	}

	@Override
	public boolean sendMail(String email) {
		String portNumber = "587"; // 485,587,25
		String hostName = "smtp.office365.com";
		String fromEmail = "maniit1234@outlook.com";
		String password = "manimani@123";
		String to = email;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.trust", "smtp.office365.com");
		prop.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Registration completed");
			message.setText("Thanks for Registering!!!");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			log.info("mail sent successfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public ProjectDTO resetPassword(String email) {
		log.info("Reset Password " + resetPassword);

		ProjectEntity entity = this.projectRepo.resetPassword(email);
		if (entity != null) {
			log.info("entity found in email " + email);
			entity.setPassword(passwordEncoder.encode(resetPassword));
			entity.setUpdatedBy("System");
			entity.setUpdatedDate(LocalDateTime.now());
			entity.setLockCount(0);
			entity.setResetPassword(true);
			entity.setPasswordChangedTime(LocalTime.now().plusSeconds(120));
			boolean update = this.projectRepo.update(entity);
			if (update) {
				sendMail(entity.getEmail(), "Your reset password is " + resetPassword);
			}
			log.info("Updated---" + update);
			ProjectDTO updatedDto = new ProjectDTO();
			BeanUtils.copyProperties(entity, updatedDto);

			return updatedDto;
		}
		log.info("Email not found for email " + email);
		return ProjectService.super.resetPassword(email);
	}

	@Override
	public ProjectDTO updatePassword(String userId, String password, String confirmPassword) {

		ProjectEntity entity = new ProjectEntity();

		if (password.equals(confirmPassword)) {

			boolean passwordUpdated = this.projectRepo.updatePassword(userId, passwordEncoder.encode(password), false,
					LocalTime.of(0, 0, 0));
			log.info("passwordUpdated " + passwordUpdated);
		}
		return ProjectService.super.updatePassword(userId, password, confirmPassword);
	}

	@Override
	public ProjectDTO updateProfile(String userId, String email, Long mobileNumber, String imagePath) {
		log.info("Inside update profile method");

		ProjectEntity upEntity = this.projectRepo.resetPassword(email);
		log.info("userId: " + userId + "email: " + email + "mobile: " + mobileNumber + "image name: " + imagePath);

		upEntity.setUserId(userId);
		upEntity.setMobileNumber(mobileNumber);
		upEntity.setPicName(imagePath);
		boolean updated = this.projectRepo.update(upEntity);
		log.info("updated--" + updated);
		return ProjectService.super.updateProfile(userId, email, mobileNumber, imagePath);
	}

	@Override
	public boolean sendMail(String email, String text) {

		String portNumber = "587"; // 485,587,25
		String hostName = "smtp.office365.com";
		String fromEmail = "maniit1234@outlook.com";
		String password = "manimani@123";
		String to = email;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.debug", "true");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.office365.com");
		prop.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Registration completed");
			message.setText(text);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			log.info("mail sent successfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;
	}

	public final static class DefaultPasswordGenerator {
		private static final String[] charCategories = new String[] { "abcdefghijklmnopqrstuvwxyz",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789" };

		public static String generate(int length) {
			StringBuilder password = new StringBuilder(length);
			Random random = new Random(System.nanoTime());

			for (int i = 0; i < length; i++) {
				String charCategory = charCategories[random.nextInt(charCategories.length)];
				int position = random.nextInt(charCategory.length());
				password.append(charCategory.charAt(position));
			}

			return new String(password);
		}
	}

	@Override
	public ProjectDTO addTechnology(String userId, TechnologyEntity technologyEntity) {

		log.info("Running addTechnology in service impl");

		ProjectEntity prjectEntity = this.projectRepo.userSignIn(userId);
		technologyEntity.setCreatedBy(userId);
		technologyEntity.setProjectEntity(prjectEntity);
		log.info("accessing entity" + prjectEntity);

		boolean saved = this.projectRepo.saveTechnology(technologyEntity);
		log.info("Technologies saved in database" + saved);

		return ProjectService.super.addTechnology(userId, technologyEntity);
	}

	@Override
	public List<TechnologyEntity> viewTechnology(String userId) {

		log.info("Running view Technology in service imple");
		ProjectEntity projectEntity = this.projectRepo.userSignIn(userId);
		List<TechnologyEntity> technology = projectEntity.getTechnology();
		log.info("Getting technologies as per userId : " + userId + " : " + technology);

		return technology;
	}

}
