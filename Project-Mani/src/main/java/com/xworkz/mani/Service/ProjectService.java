package com.xworkz.mani.Service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.mani.DTO.ProjectDTO;
import com.xworkz.mani.Entity.TechnologyEntity;

public interface ProjectService {

	Set<ConstraintViolation<ProjectDTO>> validateAndSave(ProjectDTO dto);

	default ProjectDTO userSignIn(String userId, String password) {
		return null;
	}

	boolean sendMail(String email); // for sending email

	default Long findByUser(String user) {
		return null;
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long mobile) {
		return null;
	}

	default ProjectDTO resetPassword(String email) {
		return null;
	}

	default ProjectDTO updatePassword(String userId, String password, String confirmPassword) {
		return null;
	}

	boolean sendMail(String email, String text);

	default ProjectDTO updateProfile(String userId, String email, Long mobileNumber, String imagePath) {
		return null;
	}

	default ProjectDTO addTechnology(String userId, TechnologyEntity entity) {
		return null;
	}

	default List<TechnologyEntity> viewTechnology(String userId) {
		return null;
	}

}
