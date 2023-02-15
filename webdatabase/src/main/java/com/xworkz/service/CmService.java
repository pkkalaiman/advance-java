package com.xworkz.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.DTO.CmDTO;

public interface CmService {

	Set<ConstraintViolation<CmDTO>> ValidateAndSave(CmDTO dto);
}
