package com.xworkz.mobile.Repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.mobile.Entity.MobileEntity;

public interface MobileRepo {

	boolean Save(MobileEntity entity);
	
	boolean update(MobileEntity entity);

	default MobileEntity findById(int id) {
		return null;
	}

	default List<MobileEntity> findByName(String name) {
		return Collections.emptyList();
	}

}
