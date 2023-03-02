package com.xworkz.mobile.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.mobile.Entity.MobileEntity;
import com.xworkz.mobile.MobileDTO.MobileDTO;
import com.xworkz.mobile.Repository.MobileRepo;

@Service
public class MobileServiceIMPL implements MobileService {

	@Autowired
	private MobileRepo mobileRepo;

	public MobileServiceIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public MobileDTO finById(int id) {
		if (id > 0) {
			MobileEntity mobileEntity = this.mobileRepo.findById(id);

			if (mobileEntity != null) {
				System.out.println("Entity is found in Service for id :" + id);

				MobileDTO mentity = new MobileDTO();
				mentity.setId(mobileEntity.getId());
				mentity.setName(mobileEntity.getName());
				mentity.setBrandName(mobileEntity.getBrandName());
				mentity.setColors(mobileEntity.getColors());
				mentity.setModelName(mobileEntity.getModelName());
				mentity.setTechnology(mobileEntity.getTechnology());
				mentity.setPrice(mobileEntity.getPrice());
				mentity.setStorage(mobileEntity.getStorage());
				mentity.setOs(mobileEntity.getOs());

				return mentity;
			}
		}
		return MobileService.super.finById(id);
	}

	@Override
	public Set<ConstraintViolation<MobileDTO>> ValidaateAndSave(MobileDTO dto) {
		System.out.println("Created in ValidateAndSave in Servicee.....");
		System.out.println(dto);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<MobileDTO>> violation = validator.validate(dto);

		if (violation != null && violation.isEmpty()) {
			System.err.println("Violaton Excist, Return Voilation...");
			return violation;
		} else {
			System.out.println("Violation does not Excist, go to Success Page");

			MobileEntity entity = new MobileEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setBrandName(dto.getBrandName());
			entity.setModelName(dto.getModelName());
			entity.setColors(dto.getColors());
			entity.setOs(dto.getOs());
			entity.setPrice(dto.getPrice());
			entity.setStorage(dto.getStorage());
			entity.setTechnology(dto.getTechnology());

			boolean saved = this.mobileRepo.Save(entity);
			System.out.println(saved);

			return Collections.emptySet();
		}

	}

	@Override
	public List<MobileDTO> findByName(String name) {
		System.out.println("Running in findByName in MobileService :" + name);

		if (name != null && !name.isEmpty()) {
			System.out.println("Name is Valid Calling Repo...");

			List<MobileEntity> entityies = this.mobileRepo.findByName(name);

			List<MobileDTO> mobdto = new ArrayList<MobileDTO>();

			for (MobileEntity entites : entityies) {
				MobileDTO dto = new MobileDTO();
				dto.setId(entites.getId());
				dto.setName(entites.getName());
				dto.setBrandName(entites.getBrandName());
				dto.setModelName(entites.getModelName());
				dto.setColors(entites.getColors());
				dto.setOs(entites.getOs());
				dto.setPrice(entites.getPrice());
				dto.setStorage(entites.getStorage());
				dto.setTechnology(entites.getTechnology());
				mobdto.add(dto);
			}
			System.out.println("Size of mobdto :" + mobdto.size());
			System.out.println("Size Of Entites :" + entityies.size());

			return mobdto;

		} else {
			System.out.println("Name is Invalid..");
		}
		return Collections.emptyList();
	}

	@Override
	public Set<ConstraintViolation<MobileDTO>> ValidateAndUpdate(MobileDTO dto) {
		System.out.println("Created in ValidateAndUpdate.....");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<MobileDTO>> violation = validator.validate(dto);
		if (violation != null && !violation.isEmpty()) {
			System.err.println("Violation in Dto :" + dto);
			return violation;
		} else {
			System.out.println("vilations is n not there in dto and can Saved...");
			MobileEntity entity = new MobileEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setBrandName(dto.getBrandName());
			entity.setColors(dto.getColors());
			entity.setModelName(dto.getModelName());
			entity.setOs(dto.getOs());
			entity.setPrice(dto.getPrice());
			entity.setStorage(dto.getStorage());
			entity.setTechnology(dto.getTechnology());

			boolean saved = this.mobileRepo.update(entity);
			System.out.println("Entity Data Is Saved :" + saved);
		}
		return Collections.emptySet();
	}

}
