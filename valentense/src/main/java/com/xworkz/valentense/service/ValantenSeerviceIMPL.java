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
import com.xworkz.valentense.entity.ValantenseEntity;
import com.xworkz.valentense.repository.ValantenseRepo;

@Service
public class ValantenSeerviceIMPL implements ValantenseService {

	@Autowired
	private ValantenseRepo valantenseRepo;

	public ValantenSeerviceIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public ValantenseEntity findById(int id) {
		if (id > 0) {
			ValantenseEntity valintineEntityDto = this.valantenseRepo.findById(id);
			if (valintineEntityDto != null) {
				System.out.println("entity is found in service for id" + id);
				ValantenseEntity vDto = new ValantenseEntity();
				vDto.setGift(valintineEntityDto.getGift());
				vDto.setName(valintineEntityDto.getName());
				vDto.setPlace(valintineEntityDto.getPlace());
				vDto.setValantenseName(valintineEntityDto.getValantenseName());
				vDto.setId(valintineEntityDto.getId());
				return vDto;
			}
		}

		return ValantenseService.super.findById(id);
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
		}

		else {
			System.out.println("Vaiolation does not excist , Data is Successs...");

			ValantenseEntity entity = new ValantenseEntity();
			entity.setName(dto.getName());
			entity.setValantenseName(dto.getValantenseName());
			entity.setPlace(dto.getPlace());
			entity.setGift(dto.getGift());

			boolean saved = valantenseRepo.Save(entity);
			System.out.println("Created Save :" + saved);

			return Collections.emptySet();
		}

	}

}
