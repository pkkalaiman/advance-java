package com.xworkz.mani.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.mani.ManiDTO.ManiDTO;

public interface ManiService {

	Set<ConstraintViolation<ManiDTO>> ValidateAndSave(ManiDTO dto);

	Set<ConstraintViolation<ManiDTO>> ValidateAndUpdate(ManiDTO dto);

	default ManiDTO finById(int id) {
		return null;
	}

	default List<ManiDTO> findByName(String name) {
		return Collections.emptyList();
	}
}
