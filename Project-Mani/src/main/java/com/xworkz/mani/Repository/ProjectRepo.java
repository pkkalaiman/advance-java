package com.xworkz.mani.Repository;

import java.time.LocalTime;
import java.util.List;

import com.xworkz.mani.Entity.ProjectEntity;
import com.xworkz.mani.Entity.TechnologyEntity;

public interface ProjectRepo {

	boolean save(ProjectEntity entity);

	default Long findCountByEmailAndUserAndMobile(String email, String userId, long mobile) {
		return null;
	}

	// for lock count
	boolean onLock(String userId, int count);

	default ProjectEntity userSignIn(String userId) {
		return null;
	}

	default Long findByUser(String user) {
		return null;
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long mobile) {
		return null;
	}

	// reset password
	default ProjectEntity resetPassword(String email) {
		return null;
	}

	boolean update(ProjectEntity entity);

	boolean updatePassword(String userId, String password, Boolean resetPassword, LocalTime passwordChangedTime);

	boolean saveTechnology(TechnologyEntity entity);

	default List<TechnologyEntity> viewTechnology(String view) {
		return null;
	}

}
