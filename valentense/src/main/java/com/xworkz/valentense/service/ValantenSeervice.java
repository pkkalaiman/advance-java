package com.xworkz.valentense.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.valentense.DTO.ValantenseDTO;

public interface ValantenSeervice {

	Set<ConstraintViolation<ValantenseDTO>> ValidateAndSave(ValantenseDTO dto);

}
