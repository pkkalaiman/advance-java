package com.xworkz.terrorist.validator;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import com.xworkz.terrorist.dto.TerraristDto;

public class TerroristValidator {

	public boolean ValidateAndSave(TerraristDto dto) {
		System.out.println("excuting validateAandSave start");
		System.out.println("Dto passed :" + dto);

  ValidatorFactory valid = Validation.buildDefaultValidatorFactory();
  Set<ConstraintViolation<TerraristDto>> violation = valid.getValidator().validate(dto);

		if (!violation.isEmpty()) {

			System.out.println("Error is there");
			violation.forEach(dt -> System.out.println(dt));
		} else {
			System.out.println("Validator Error");

		}

		return false;

	}

}
