package com.xworkz.mani.repository;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import com.xworkz.mani.Entity.SingInEntity;

public interface SingInRepo {

	boolean save(SingInEntity userEntity);

	default List<SingInEntity> findAll() {
		return Collections.emptyList();
	}

	default SingInEntity userSignIn(String userId) {
		return null;
	}

	default Long findByUser(String user) {
		return null;
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long number) {
		return null;
	}

	default SingInEntity reSetPassword(String email) {
		return null;
	}

	boolean logincount(String userId, int count);

	boolean update(SingInEntity userEntity);

	boolean updatePassword(String userId, String password, Boolean resetPassword, LocalTime expTime);

	default Long findCountByEmailAndUserAndMobile(String email, String userId, long mobile) {
		return null;
	}

	/*
	 * boolean saveTechnology(TechnologyEntity entity);
	 * 
	 * default List<TechnologyEntity> viewTechnology(String view) { return null; }
	 */

}
