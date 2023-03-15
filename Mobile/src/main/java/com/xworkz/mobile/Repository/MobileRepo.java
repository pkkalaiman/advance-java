package com.xworkz.mobile.Repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.mobile.Entity.MobileEntity;
import com.xworkz.mobile.MobileDTO.MobileDTO;

public interface MobileRepo {

	boolean Save(MobileEntity entity);

	boolean update(MobileEntity entity);

	default MobileEntity findById(int id) {
		return null;
	}

	default List<MobileEntity> findByName(String name) {
		return Collections.emptyList();
	}

	default boolean onDelete(int id) {
		return false;
	}

	default List<MobileEntity> findByNameBybrandName(String name, String brandName) {
		return Collections.emptyList();
	}

	default List<MobileEntity> findAll() {
		return Collections.emptyList();
	}
}
