package com.xworkz.mobile.Repository;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.mobile.Entity.MobileEntity;
import com.xworkz.mobile.MobileDTO.MobileDTO;

@Repository
public class MobileRepoIMPL implements MobileRepo {

	// it will creating to the LocalcontainerEntityManagerFactoryBean Class
	// (configuration) File
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public MobileRepoIMPL() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public boolean Save(MobileEntity entity) {
		System.out.println("Cerated in Save in Reposiutory....");
		EntityManager manager = this.entityManagerFactory.createEntityManager();

		// this is Save method that's why using this EntityTransection
		EntityTransaction transection = manager.getTransaction();

		transection.begin(); // it will using for application starting to web application
		manager.persist(entity); // it is using for saving data will be updated to the another data
		transection.commit(); // it is using for saving data will be commit to the another data
		manager.close();
		return true;
	}

	@Override
	public MobileEntity findById(int id) {

		EntityManager manager = entityManagerFactory.createEntityManager();

		/*
		 * it is using the Fetch by id(or)name That's why using for this Object Because
		 * this class is the Data Saving class
		 */
		MobileEntity entity = manager.find(MobileEntity.class, id);

		manager.close();
		System.out.println("Find by id :" + entity);
		return entity;
	}

	@Override
	public List<MobileEntity> findByName(String name) {

		System.out.println("Inside SearchByName :" + name);

		EntityManager manager = this.entityManagerFactory.createEntityManager();

		try {
			Query query = manager.createNamedQuery("findByName");
			query.setParameter("nam", name);
			// System.out.println("Query :" + query);
			List<MobileEntity> list = query.getResultList();
			System.out.println("Total List Found in Repo :" + list.size());
			list.forEach(e -> System.out.println(e));
			return list;

		} finally {

			manager.close();
			System.out.println("Released the connection....");
		}

	}

	@Override
	public List<MobileEntity> findByNameBybrandName(String name, String brandName) {
		System.out.println("Created in FindByNameByBrandName...");
		EntityManager manager = this.entityManagerFactory.createEntityManager();

		try {
			Query query = manager.createNamedQuery("findByNameByBrandName");
			query.setParameter("name", name);
			query.setParameter("brand", brandName);
			List<MobileEntity> list = query.getResultList();
			System.out.println("Total list in Found :" + list.size());
			list.forEach(e -> System.out.println(e));
			return list;

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			manager.close();
			System.out.println("Releasing the Connection..");
		}
		return Collections.emptyList();

	}

	@Override
	public boolean update(MobileEntity entity) {
		System.out.println("Created in Updated in Repository.....");

		EntityManager manager = this.entityManagerFactory.createEntityManager();

		try {
			EntityTransaction transection = manager.getTransaction();
			transection.begin(); // it will using for application starting to web application
			manager.merge(entity); // it is using for saving data will be updated to the another data
			transection.commit(); // it is using for saving data will be commit to the another data
			return true;

		} finally {
			manager.close(); // it will using for close this method

		}
	}

	@Override
	public boolean onDelete(int id) {

		EntityManager manager = this.entityManagerFactory.createEntityManager();
		EntityTransaction transection = manager.getTransaction();
		MobileEntity entity = manager.find(MobileEntity.class, id);

		if (entity != null) {
			transection.begin();
			manager.remove(entity);
			transection.commit();
			manager.close();
		} else {
			System.out.println("Data is not Deleted");
		}
		return true;
	}

	@Override
	public List<MobileEntity> findAll(MobileEntity entity) {
		System.out.println("Creating in FindAll in Repository..." + entity);
		EntityManager manager = this.entityManagerFactory.createEntityManager();

		try {
			Query query = manager.createNamedQuery("findAll");
			query.setParameter("mobil", query);
			List<MobileEntity> list = query.getResultList();
			System.out.println("Total list in Found :" + list.size());
			list.forEach(d -> System.out.println(d));

			return list;

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
			System.out.println("Realesing the Connection..");
		}

		return MobileRepo.super.findAll(entity);
	}
}
