package com.xworkz.mani.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
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
import org.springframework.stereotype.Service;

import com.xworkz.mani.DTO.SingUpDTO;
import com.xworkz.mani.Entity.SingUpEntity;
import com.xworkz.mani.Repository.SingUpRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SingUpServiceImple implements SingUpService {

	@Autowired
	private SingUpRepository repository;

	private Set<ConstraintViolation<SingUpDTO>> validate(SingUpDTO dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<SingUpDTO>> violation = validator.validate(dto);
		return violation;
	}

	public SingUpServiceImple() {
		log.info("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<SingUpDTO>> ValidateAndSave(SingUpDTO singUpDTO) {
		log.info("Created in ValidateAndSave...");
		Long emailCount = this.repository.findByEmail(singUpDTO.getEmail());
		Long userCount = this.repository.findByUser(singUpDTO.getUserId());
		Long mobileCount = this.repository.findByMobile(singUpDTO.getMobileNo());

		if (emailCount == 0 && userCount == 0 && mobileCount == 0) {

			if (singUpDTO.getPassword().equals(singUpDTO.getConfirmPassword())) {
				Set<ConstraintViolation<SingUpDTO>> violations = validate(singUpDTO);
				if (violations != null && !violations.isEmpty()) {
					log.info("htere is violation in DTO");
					return violations;
				} else {
					log.info("No violations proced in to Save");

					SingUpEntity entity = new SingUpEntity();
					BeanUtils.copyProperties(singUpDTO, entity);

					entity.setCreatedBy(singUpDTO.getUserId());
					entity.setCreatedDate(LocalDateTime.now());
					boolean saved = this.repository.Save(entity);
					boolean send = this.sendMail(singUpDTO.getEmail());
					log.info("Saved in Entity :" + saved);
					log.info("Email Send --" + send);

				}
			} else {
				log.error("Password must be Same");
			}

		} else {
			log.error("User Already Exsist");
		}

		return Collections.emptySet();
	}

	@Override
	public List<SingUpDTO> findAll() {
		List<SingUpEntity> singEntity = this.repository.findAll();
		List<SingUpDTO> lists = new ArrayList<SingUpDTO>();
		for (SingUpEntity entity : singEntity) {
			SingUpDTO dto = new SingUpDTO();
			BeanUtils.copyProperties(entity, dto);
			lists.add(dto);
		}
		return lists;
	}

	@Override
	public Long findByEmail(String email) {
		Long emailCount = this.repository.findByEmail(email);
		log.error("Find BY Email");
		return emailCount;
	}

	@Override
	public Long findByMobile(Long MobileNo) {
		Long mobilCount = this.repository.findByMobile(MobileNo);
		return mobilCount;
	}

	@Override
	public Long findByUser(String User) {
		Long userCount = this.repository.findByUser(User);
		return userCount;
	}

	@Override
	public boolean sendMail(String email) {
		String portNumber = "587";
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
		prop.put("mail.transport.protocal", "smtp");

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
			message.setText("Thanks for registration");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			log.info("mail sent sucessfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public SingUpDTO ValidateLoginUsinguserIdAndPassword(String userId, String password) {
		SingUpEntity entity = this.repository.findByIdAndPassword(userId);
		SingUpDTO dto = new SingUpDTO();
		BeanUtils.copyProperties(entity, dto);

		if (entity.getId() >= 3) {
			log.info("Running in Login count condition");
			return dto;
		}

		if (dto.getUserId().equals(userId)) {
			return dto;
		} else {
			return null;
		}

		
	}

}
