package com.xworkz.valentense.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.valentense.DTO.ValantenseDTO;
import com.xworkz.valentense.entity.ValantenseEntity;

@Repository
public class ValantenseRepoIMPL implements ValantenseRepo {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ValantenseRepoIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public boolean Save(ValantenseEntity entity) {
		System.out.println("Running in Save in Repository");

		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		EntityTransaction transection = entityManager.getTransaction();
		transection.begin();
		entityManager.persist(entity);
		transection.commit();
		entityManager.close();

		return true;
	}

	public ValantenseEntity findById(int id) {

		EntityManager manager = entityManagerFactory.createEntityManager();
		ValantenseEntity enity = manager.find(ValantenseEntity.class, id);
		manager.close();
		return enity;
	}
}
