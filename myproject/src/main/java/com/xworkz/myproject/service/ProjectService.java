package com.xworkz.myproject.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.myproject.DTO.ProjectDTO;

public interface ProjectService {

	Set<ConstraintViolation<ProjectDTO>> ValidateAndSave(ProjectDTO dto);
}
