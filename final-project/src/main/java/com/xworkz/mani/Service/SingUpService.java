package com.xworkz.mani.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import com.xworkz.mani.DTO.SingUpDTO;

public interface SingUpService {

	Set<ConstraintViolation<SingUpDTO>> ValidateAndSave(SingUpDTO singUpDTO);

	default List<SingUpDTO> findAll() {
		return Collections.emptyList();
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long MobileNo) {
		return null;
	}

	default Long findByUser(String User) {
		return null;
	}

	boolean sendMail(String email);

	default SingUpDTO ValidateLoginUsinguserIdAndPassword(String userId, String password) {
		return null;
	}

	default SingUpDTO reSetPassword(String email) {
		return null;
	}

}
