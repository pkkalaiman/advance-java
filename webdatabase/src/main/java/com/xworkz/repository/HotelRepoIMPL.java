package com.xworkz.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.DTO.HotelDTO;

@Repository
public class HotelRepoIMPL implements HotelRepo {

	@Autowired
	private EntityManagerFactory EntityManagerFactory;

	@Override
	public boolean Save(HotelDTO dto) {
		System.out.println("Running in Save....");

		EntityManager entityManager = this.EntityManagerFactory.createEntityManager();
		EntityTransaction transection = entityManager.getTransaction();
		transection.begin();
		entityManager.persist(dto);
		transection.commit();
		entityManager.close();
		return false;
	}

}
