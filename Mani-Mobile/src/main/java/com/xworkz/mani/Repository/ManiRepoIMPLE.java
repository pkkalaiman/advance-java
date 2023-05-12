package com.xworkz.mani.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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

	@Override
	public ManiEntity findById(int id) {
		System.out.println("Created in FindById in Repo..." + id);

		EntityManager manager = this.entityManagerFactory.createEntityManager();
		ManiEntity entity = manager.find(ManiEntity.class, id);

		manager.close();
		System.out.println("Find by id :" + entity);
		return entity;
	}

	@Override
	public List<ManiEntity> findByName(String name) {
		System.out.println("Created in FindByName in Repo....");
		EntityManager manager = this.entityManagerFactory.createEntityManager();

		Query query = manager.createNamedQuery("finByName");
		try {
			query.setParameter("name", name);
			List<ManiEntity> list = query.getResultList();
			list.forEach(d -> System.out.println(d));
			return list;
		} finally {
			manager.close();
			System.out.println("Realesed in Connection..");
		}
	}

	@Override
	public boolean update(ManiEntity entity) {
		System.out.println("Running in Update in Repo....");

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
