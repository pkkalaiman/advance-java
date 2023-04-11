package com.xworkz.mani.Repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.mani.Entity.SingUpEntity;

public interface SingUpRepository {

	boolean Save(SingUpEntity entity);

	default List<SingUpEntity> findAll() {
		return Collections.emptyList();
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

	default SingUpEntity findByIdAndPassword(String userId) {
		return null;
	}



}
