package com.xworkz.mani.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.mani.Entity.ApplicationEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ApplicationRepoImple implements ApplicationRepo {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ApplicationRepoImple() {
		log.info("Created in " + this.getClass().getSimpleName());
	}

	@Override
	public boolean Save(ApplicationEntity entity) {
		log.info("Created in Save Repository...");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		EntityTransaction transection = manager.getTransaction();
		try {
			transection.begin();
			manager.persist(entity);
			transection.commit();
			return false;
		} finally {
			manager.close();
		}

	}

}
