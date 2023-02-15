package com.xworkz.service;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import com.xworkz.DTO.CmDTO;

@Service
public class CmServiceIMPL implements CmService {

	public CmServiceIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
	@Override
	public Set<ConstraintViolation<CmDTO>> ValidateAndSave(CmDTO dto) {
		System.out.println("Running ValidateAndSave...");

		ValidatorFactory foctory = Validation.buildDefaultValidatorFactory();
		Validator validator = foctory.getValidator();
		Set<ConstraintViolation<CmDTO>> constraintViolation = validator.validate(dto);

		if (constraintViolation != null && !constraintViolation.isEmpty()) {
			System.err.println("ConstraintViolation excist, return ConstraintViolation...");
			return constraintViolation;
		} else {
			System.err.println("ConstrainViolation does not excist, Data is Good");
			return Collections.emptySet();
		}
		
	}

}
