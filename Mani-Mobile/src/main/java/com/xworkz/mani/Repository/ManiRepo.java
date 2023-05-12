package com.xworkz.mani.Repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.mani.ManiEntity.ManiEntity;

public interface ManiRepo {

	boolean Save(ManiEntity entity);

	boolean update(ManiEntity entity);

	default ManiEntity findById(int id) {
		return null;
	}

	default List<ManiEntity> findByName(String name) {
		return Collections.emptyList();
	}

}
