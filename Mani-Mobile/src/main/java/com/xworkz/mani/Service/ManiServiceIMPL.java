package com.xworkz.mani.Service;

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

			// BeanUtils.copyProperties(entity, dto);

			entity.setBrandName(dto.getBrandName());
			entity.setId(dto.getId());
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

	@Override
	public ManiDTO finById(int id) {
		System.out.println("Running in FindById in Service");

		if (id > 0) {
			ManiEntity entity = this.maniRepo.findById(id);

			if (entity != null) {
				System.out.println("Entity is Found in Id : " + id);

				ManiDTO menentity = new ManiDTO();

				menentity.setId(entity.getId());
				menentity.setBrandName(entity.getBrandName());
				menentity.setStorage(entity.getStorage());
				menentity.setModelName(entity.getBrandName());
				menentity.setTechnology(entity.getTechnology());
				menentity.setOs(entity.getOs());
				menentity.setName(entity.getName());
				menentity.setColors(entity.getColors());

				return menentity;
			}
		}

		return ManiService.super.finById(id);
	}

	@Override
	public List<ManiDTO> findByName(String name) {
		System.out.println("Created iihn FindByName in ServiceImple...");
		if (name != null && !name.isEmpty()) {
			System.out.println("Name is Valid Calling in Repo..");

			List<ManiEntity> entity = this.maniRepo.findByName(name);
			List<ManiDTO> mandto = new ArrayList<ManiDTO>();

			for (ManiEntity maniEntity : entity) {

				ManiDTO dto = new ManiDTO();
				dto.setId(maniEntity.getId());
				dto.setBrandName(maniEntity.getBrandName());
				dto.setColors(maniEntity.getColors());
				dto.setModelName(maniEntity.getModelName());
				dto.setTechnology(maniEntity.getTechnology());
				dto.setName(maniEntity.getName());
				dto.setStorage(maniEntity.getStorage());
				dto.setOs(maniEntity.getOs());
				mandto.add(dto);
			}
			System.out.println("Size of ManDto :" + mandto.size());
			System.out.println("Size of ManEntity :" + entity.size());
			return mandto;

		} else {
			System.out.println("Name is Invalid....");
		}
		return Collections.emptyList();
	}

	@Override
	public Set<ConstraintViolation<ManiDTO>> ValidateAndUpdate(ManiDTO dto) {
		System.out.println("Created in ValidateAndUpdate in Service...");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<ManiDTO>> violation = validator.validate(dto);

		if (violation != null && !violation.isEmpty()) {
			System.out.println("Vioaltion in Dto :" + dto);
			return violation;
		} else {
			System.out.println("Violation is not there in DTO");

			ManiEntity entity = new ManiEntity();
			// BeanUtils.copyProperties(entity, dto);

			entity.setName(dto.getName());
			entity.setBrandName(dto.getBrandName());
			entity.setColors(dto.getColors());
			entity.setId(dto.getId());
			entity.setModelName(dto.getModelName());
			entity.setStorage(dto.getOs());
			entity.setTechnology(dto.getTechnology());

			boolean saved = this.maniRepo.update(entity);
			System.out.println("Entity is Saved :" + saved);
		}

		return Collections.emptySet();
	}

}
