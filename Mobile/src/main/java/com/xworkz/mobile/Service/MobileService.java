package com.xworkz.mobile.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.mobile.Entity.MobileEntity;
import com.xworkz.mobile.MobileDTO.MobileDTO;

public interface MobileService {

	Set<ConstraintViolation<MobileDTO>> ValidaateAndSave(MobileDTO dto);

	Set<ConstraintViolation<MobileDTO>> ValidateAndUpdate(MobileDTO dto);
	
	default MobileDTO finById(int id) {

		return null;
	}

	default List<MobileDTO> findByName(String name) {
		return Collections.emptyList();
	}
}
