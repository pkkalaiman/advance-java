package com.xworkz.mobile.Service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.mobile.Entity.MobileEntity;
import com.xworkz.mobile.MobileDTO.MobileDTO;

public interface MobileService {

	Set<ConstraintViolation<MobileDTO>> ValidaateAndSave(MobileDTO dto);

	default MobileEntity finById(int id) {
		
		return null;
	}
}
