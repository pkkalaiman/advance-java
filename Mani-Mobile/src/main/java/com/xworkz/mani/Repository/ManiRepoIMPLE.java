package com.xworkz.mani.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.mani.ManiEntity.ManiEntity;

@Repository
public class ManiRepoIMPLE implements ManiRepo {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ManiRepoIMPLE() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public boolean Save(ManiEntity entity) {
		System.out.println("Created in Save method on ManiRepo");

		EntityManager manager = this.entityManagerFactory.createEntityManager();
		EntityTransaction transection = manager.getTransaction();
		transection.begin();
		manager.persist(entity);
		transection.commit();
		manager.close();
		return true;
	}

}
