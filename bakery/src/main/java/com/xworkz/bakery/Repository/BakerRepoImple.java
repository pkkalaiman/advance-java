package com.xworkz.bakery.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.bakery.DTO.BakeryDTO;

@Repository
public class BakerRepoImple implements BakeryRepo {

	
	  @Autowired
	  private EntityManagerFactory entityManagerFactory;
	 
	
	@Override
	public boolean Save(BakeryDTO dto) {
		System.out.println("Running in Save Method...."+dto);
		
		
		  EntityManager entityManager= this.entityManagerFactory.createEntityManager();
		  EntityTransaction transection=entityManager.getTransaction();
		  transection.begin(); 
		  entityManager.persist(dto); 
		  transection.commit();
		  entityManager.close();
		 
		return false;
	}

}
