package com.xworkz.mani.Service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.mani.DTO.ApplicationDTO;

public interface ApplicationService {

	Set<ConstraintViolation<ApplicationDTO>> ValidateAndSave(ApplicationDTO appdto);
}
