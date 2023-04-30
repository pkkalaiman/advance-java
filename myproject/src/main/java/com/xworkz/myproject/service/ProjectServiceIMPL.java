package com.xworkz.myproject.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.myproject.DTO.ProjectDTO;
import com.xworkz.myproject.Entity.ProjectEntity;
import com.xworkz.myproject.repository.ProjectRepo;

@Service
public class ProjectServiceIMPL implements ProjectService {

	@Autowired
	private ProjectRepo projectRepo;

	public ProjectServiceIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<ProjectDTO>> ValidateAndSave(ProjectDTO dto) {
		System.out.println("Created in ValidateAndSave....");
		System.out.println("dto :" + dto);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<ProjectDTO>> violation = validator.validate(dto);

		if (violation != null && violation.isEmpty()) {
			System.err.println("Violation exist, Return Violation...");
			return violation;

		} else {
			System.out.println("Violation does not Exist : Go to successs Page");

			ProjectEntity entity = new ProjectEntity();
			
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setFatherName(dto.getFatherName());
			entity.setMotherName(dto.getMotherName());
			entity.setGender(dto.getGender());
			entity.setEmail(dto.getEmail());

			boolean saved = this.projectRepo.Save(entity);
			System.out.println("Saved :" + saved);
		}
		return violation;
	}

}
