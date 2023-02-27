package com.xworkz.mobile.Repository;

import com.xworkz.mobile.Entity.MobileEntity;

public interface MobileRepo {

	boolean Save(MobileEntity entity);

	default MobileEntity findById(int id) {
		return null;

	}

}
