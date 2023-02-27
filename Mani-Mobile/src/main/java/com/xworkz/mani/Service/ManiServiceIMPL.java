package com.xworkz.mani.Service;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.mani.ManiDTO.ManiDTO;
import com.xworkz.mani.ManiEntity.ManiEntity;
import com.xworkz.mani.Repository.ManiRepo;

@Service
public class ManiServiceIMPL implements ManiService {

	@Autowired
	private ManiRepo maniRepo;

	public ManiServiceIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<ManiDTO>> ValidateAndSave(ManiDTO dto) {
		System.out.println("Created in ValidateAndSave in Service....");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<ManiDTO>> violation = validator.validate(dto);

		if (violation != null && !violation.isEmpty()) {
			System.err.println("Violation exvist, Return Violation...");
			return violation;
		} else {
			System.out.println("Violation  dose not Excist , Data is Successs");

			ManiEntity entity = new ManiEntity();
			entity.setBrandName(dto.getBrandName());
			entity.setColors(dto.getColors());
			entity.setModelName(dto.getModelName());
			entity.setName(dto.getName());
			entity.setOs(dto.getOs());
			entity.setStorage(dto.getStorage());
			entity.setTechnology(dto.getTechnology());

			boolean saved = this.maniRepo.Save(entity);
			System.out.println(saved);

			
		}

		return Collections.emptySet();
	}

}
