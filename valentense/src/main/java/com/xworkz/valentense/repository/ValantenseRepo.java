package com.xworkz.valentense.repository;

import com.xworkz.valentense.entity.ValantenseEntity;

public interface ValantenseRepo {

	boolean Save(ValantenseEntity entity);

	default ValantenseEntity findById(int id) {
		return null;
	}

}
