package com.xworkz.mobile.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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

	@Override
	public List<MobileEntity> findByName(String name) {

		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByName");
			query.setParameter("nam", name);
			System.out.println("Query :" + query);
			List<MobileEntity> list = query.getResultList();
			System.out.println("Total List Found in Repo :" + list.size());

			return list;
		} finally {
			manager.close();
			System.out.println("Released the connection....");
		}

	}

	@Override
	public boolean update(MobileEntity entity) {
		System.out.println("Created in Updated in Repository.....");
		EntityManager manager = this.entityManagerFactory.createEntityManager();

		try {
			EntityTransaction transection = manager.getTransaction();
			transection.begin();
			manager.merge(entity);
			transection.commit();
			return true;
		} finally {
			manager.close();

		}
	}
}
