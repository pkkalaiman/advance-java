package com.xworkz.myproject.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.myproject.Entity.ProjectEntity;

@Repository
public class ProjectRepoIMPL implements ProjectRepo {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ProjectRepoIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public boolean Save(ProjectEntity entity) {
		System.out.println("Running in Save in Repository...");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		EntityTransaction transection = manager.getTransaction();
		transection.begin();
		manager.persist(entity);
		transection.commit();
		manager.close();
		return false;
	}

}
