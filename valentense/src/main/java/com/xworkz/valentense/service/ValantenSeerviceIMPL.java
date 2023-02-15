package com.xworkz.valentense.service;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.valentense.DTO.ValantenseDTO;
import com.xworkz.valentense.DTO.ValantenseEntity;
import com.xworkz.valentense.repository.ValantenseRepo;

@Service
public class ValantenSeerviceIMPL implements ValantenSeervice {
	
	@Autowired
	private ValantenseRepo valantenseRepo;

	public ValantenSeerviceIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<ValantenseDTO>> ValidateAndSave(ValantenseDTO dto) {
		System.out.println("Created in ValidateAndSave.....");
		
		ValidatorFactory foctory = Validation.buildDefaultValidatorFactory();
		Validator validator = foctory.getValidator();
		Set<ConstraintViolation<ValantenseDTO>> vaiolation = validator.validate(dto);

		if (vaiolation != null && !vaiolation.isEmpty()) {
			System.err.println("Vaiolataion Excist, return Vaiolation");
			return vaiolation;
		} else {
			System.out.println("Vaiolation does not excist , Data is Successs...");
			
			ValantenseEntity entity=new ValantenseEntity();
			entity.getName();
			entity.getValantenseName();
			entity.getPlace();
			entity.getGift();
			
			
			boolean saved=valantenseRepo.Save(entity);
			System.out.println("Created Save :"+saved);
			
			return Collections.emptySet();
		}

	}

}
