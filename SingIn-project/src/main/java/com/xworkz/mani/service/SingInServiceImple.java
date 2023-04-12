package com.xworkz.mani.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import com.xworkz.mani.DTO.SingInDTO;
import com.xworkz.mani.Entity.SingInEntity;
import com.xworkz.mani.repository.SingInRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SingInServiceImple implements SingInService {

	@Autowired
	private SingInRepo singinrepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	String reSetPassword = DefaultPasswordGenerator.generate(6);

	private Set<ConstraintViolation<SingInDTO>> validate(SingInDTO sindto) {
		ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validationFactory.getValidator();
		Set<ConstraintViolation<SingInDTO>> vailation = validator.validate(sindto);
		return vailation;
	}

	public SingInServiceImple() {
		log.info("" + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<SingInDTO>> validateAndSave(SingInDTO userDTO) {
		log.info("Created in ValidateAndSave....");
		Long emailCount = this.singinrepo.findByEmail(userDTO.getEmail());
		Long userCount = this.singinrepo.findByUser(userDTO.getUserId());
		Long mobileCount = this.singinrepo.findByMobile(userDTO.getMobile());

		Set<ConstraintViolation<SingInDTO>> violations = validate(userDTO);
		if (violations != null && !violations.isEmpty()) {
			log.info("there is Violation in dto");
			return violations;
		}
		if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
			return null;
		}
		if (emailCount == 0 && userCount == 0 && mobileCount == 0) {
			log.info("No Violations procceding to save");

			SingInEntity entity = new SingInEntity();
			// BeanUtils.copyProperties(userDTO, entity);
			entity.setUserId(userDTO.getUserId());
			entity.setEmail(userDTO.getEmail());
			entity.setMobile(userDTO.getMobile());
			entity.setAgreement(userDTO.getAgreement());
			entity.setCreatedBy(userDTO.getUserId());
			entity.setCreatedDate(LocalDateTime.now());
			entity.setPassword(passwordEncoder.encode(userDTO.getPassword()));

			boolean saved = this.singinrepo.save(entity);
			log.info("Saved in Entity-" + saved);

			if (saved) {
				boolean sent = this.sendMail(userDTO.getEmail());
				log.info("Email sent -:" + sent);

			}

		}
		return Collections.emptySet();
	}

	@Override
	public Long findByEmail(String email) {
		log.info("Created in  FindByEmail");
		Long emailcount = this.singinrepo.findByEmail(email);
		log.error("Find  by Email");
		return emailcount;
	}

	@Override
	public SingInDTO userSignIn(String userId, String password) {
		log.info("Created in UserSingIn in Service..");
		SingInEntity entity = this.singinrepo.userSignIn(userId);
		SingInDTO dto = new SingInDTO();
		BeanUtils.copyProperties(entity, dto);
		log.info("matching--" + passwordEncoder.matches(password, entity.getPassword()));

		if (entity.getLoginCount() >= 3) {
			log.info("Running in Login count condition");
			return dto;
		}

		if (dto.getUserId().equals(userId) && passwordEncoder.matches(password, entity.getPassword())) {
			return dto;
		} else {
			this.singinrepo.logincount(userId, entity.getLoginCount() + 1);
			log.info("count of login" + entity.getLoginCount() + 1);
			return null;
		}
	}

	@Override
	public List<SingInDTO> findAll() {
		log.info("Created in FindAll in Service..");
		List<SingInEntity> sinentity = this.singinrepo.findAll();
		List<SingInDTO> list = new ArrayList<SingInDTO>();
		for (SingInEntity singentity : sinentity) {
			SingInDTO dto = new SingInDTO();
			BeanUtils.copyProperties(singentity, dto);
			list.add(dto);
		}
		return list;
	}

	@Override
	public Long findByMobile(Long mobile) {
		Long mobilecount = this.singinrepo.findByMobile(mobile);
		return mobilecount;
	}

	@Override
	public Long findByUser(String user) {
		Long userCount = this.singinrepo.findByUser(user);
		return userCount;
	}

	@Override
	public SingInDTO updatePassword(String userId, String password, String confirmPassword) {
		log.info("Createt in UpdatePassword");
		SingInEntity sinentity = new SingInEntity();
		if (password.equals(confirmPassword)) {
			boolean passwordUpdated = this.singinrepo.updatePassword(userId, passwordEncoder.encode(password), false);
			log.info("passwordUpdated--" + passwordUpdated);

		}
		return SingInService.super.updatePassword(userId, password, confirmPassword);
	}

	@Override
	public boolean sendMail(String email) {
		String portNumber = "587";
		String hostName = "smtp.office365.com";
		String fromEmail = "pkkalaiman@gmail.com";
		String password = "pkkalaiman@123";
		String to = email;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
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
			message.setSubject("Registration  Completed");
			message.setText("Thanks for registration and your password is" + reSetPassword);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			log.info("mail sent sucessfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public SingInDTO reSetPassword(String email) {

		log.info("ReSetd password " + reSetPassword);

		SingInEntity entity = this.singinrepo.reSetPassword(email);
		
		if (entity != null) {
			
			log.info("entity found for email" + email);
			
			entity.setPassword(passwordEncoder.encode(reSetPassword));
			entity.setUpdatedBy("System");
			entity.setUpdatedDate(LocalDateTime.now());
			entity.setLoginCount(0);
			entity.setResetPassword(true);
			boolean update = this.singinrepo.update(entity);
			if (update) {
				sendMail(entity.getEmail());
			}
			log.info("Updated " + update);
			
			SingInDTO updatedDto = new SingInDTO();
			BeanUtils.copyProperties(entity, updatedDto);

			return updatedDto;
		}
		log.info("entity not found for email" + email);
		
		return SingInService.super.reSetPassword(email);
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

}
