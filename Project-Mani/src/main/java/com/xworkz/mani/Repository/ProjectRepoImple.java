package com.xworkz.mani.Repository;

import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.mani.Entity.ProjectEntity;
import com.xworkz.mani.Entity.TechnologyEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProjectRepoImple implements ProjectRepo {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ProjectRepoImple() {
		log.info("Created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(ProjectEntity entity) {
		log.info("Running save in Repository");
		log.info("Entity in Repo" + entity);

		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entity);
		et.commit();
		em.close();

		return false;
	}

	public Long findByUser(String user) {

		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("userId");
			query.setParameter("userBy", user);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			log.info(""+value);
			return value;
		} finally {
			em.close();
		}

	}

	@Override
	public Long findByEmail(String email) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("emailId");
			query.setParameter("emailBy", email);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			log.info(""+value);
			return value;

		} finally {
			em.close();
		}

	}

	@Override
	public Long findByMobile(Long number) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("mobileId");
			query.setParameter("mobileBy", number);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			log.info(""+value);
			return value;

		} finally {
			em.close();
		}
	}

	@Override
	public ProjectEntity userSignIn(String userId) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("IdandPassword");
			query.setParameter("u", userId);
			Object object = query.getSingleResult();
			ProjectEntity entity = (ProjectEntity) object;
			log.info("" + entity);
			return entity;
		} finally {
			em.close();
		}

	}

	@Override
	public Long findCountByEmailAndUserAndMobile(String email, String userId, long mobile) {

		EntityManager manager = this.entityManagerFactory.createEntityManager();

		Query query = manager.createNamedQuery("findByCount");
		query.setParameter("e", email);
		query.setParameter("u", userId);
		query.setParameter("m", mobile);
		Object object = query.getSingleResult();
		Long count = (Long) object;
		log.error(""+count);

		return count;
	}

	@Override
	public boolean onLock(String userId, int count) {

		EntityManager manager = this.entityManagerFactory.createEntityManager();

		try {
			EntityTransaction et = manager.getTransaction();
			et.begin();
			Query query = manager.createNamedQuery("lockCount");
			query.setParameter("u", userId);
			query.setParameter("c", count);
			query.executeUpdate();
			et.commit();
			return true;
		} finally {
			manager.close();
		}

	}

	@Override
	public ProjectEntity resetPassword(String email) {

		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("email");
			query.setParameter("ed", email);
			Object object = query.getSingleResult();
			ProjectEntity entity = (ProjectEntity) object;
			log.info("" + entity);
			return entity;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean update(ProjectEntity entity) {

		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = manager.getTransaction();
			et.begin();
			manager.merge(entity);
			et.commit();
			return true;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean updatePassword(String userId, String password, Boolean resetPassword,
			LocalTime passwordChangedTime) {

		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = manager.getTransaction();
			et.begin();
			Query query = manager.createNamedQuery("updatePassword");
			query.setParameter("ud", userId);
			query.setParameter("p", password);
			query.setParameter("rp", resetPassword);
			query.setParameter("pct", passwordChangedTime);
			query.executeUpdate();
			et.commit();
			return true;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean saveTechnology(TechnologyEntity entity) {
		log.info("Running save in saveTechnology");

		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(entity);
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}
}
