package com.xworkz.mobile.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.mobile.Entity.MobileEntity;

@Repository
public class MobileRepoIMPL implements MobileRepo {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public MobileRepoIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public boolean Save(MobileEntity entity) {
		System.out.println("Cerated in Save in Reposiutory....");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		EntityTransaction transection = manager.getTransaction();
		transection.begin();
		manager.persist(entity);
		transection.commit();
		manager.close();
		return true;
	}

	@Override
	public MobileEntity findById(int id) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		MobileEntity entity = manager.find(MobileEntity.class, id);
		manager.close();
		return entity;
	}

}
