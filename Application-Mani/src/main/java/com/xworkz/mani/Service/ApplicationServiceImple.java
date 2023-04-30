package com.xworkz.mani.Service;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.mani.DTO.ApplicationDTO;
import com.xworkz.mani.Entity.ApplicationEntity;
import com.xworkz.mani.Repository.ApplicationRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApplicationServiceImple implements ApplicationService {

	@Autowired
	private ApplicationRepo applicationRepo;

	public ApplicationServiceImple() {
		log.info("Created in" + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<ApplicationDTO>> ValidateAndSave(ApplicationDTO appdto) {
		log.info("Created in ValidateAndSave in Service....");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<ApplicationDTO>> violation = validator.validate(appdto);

		if (violation != null && !violation.isEmpty()) {
			log.error("there is violation in dto");
			return violation;
		} else {
			log.info("Violation does not exsist go to success page");

			ApplicationEntity entity = new ApplicationEntity();
			BeanUtils.copyProperties(entity, appdto);

			boolean saved = this.applicationRepo.Save(entity);
			log.info("Saved " + saved);
		}

		return Collections.emptySet();
	}

}
