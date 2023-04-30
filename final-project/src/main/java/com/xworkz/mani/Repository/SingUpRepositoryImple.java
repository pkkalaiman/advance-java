package com.xworkz.mani.Repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.mani.Entity.SingUpEntity;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class SingUpRepositoryImple implements SingUpRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public SingUpRepositoryImple() {
		log.info("Created :" + this.getClass().getSimpleName());
	}

	@Override
	public boolean Save(SingUpEntity entity) {
		log.info("Created in Save in Repository....");
		entity.setCreatedBy(entity.getUserId());
		entity.setCreatedDate(LocalDateTime.now());
		EntityManager entitymanager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transection = entitymanager.getTransaction();
			transection.begin();
			entitymanager.persist(entity);
			transection.commit();

			return true;
		} finally {
			entitymanager.close();
		}

	}

	@Override
	public SingUpEntity userSingIn(String userId) {
		log.info("Created by userSingIn in RepoImple");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("");
			query.setParameter("", userId);
			Object object = query.getSingleResult();
			SingUpEntity entity = (SingUpEntity) object;
			log.info("SingInEntity :" + entity);
			return entity;
		} finally {
			manager.close();
		}
	}

	@Override
	public List<SingUpEntity> findAll() {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("findAll");
			List<SingUpEntity> list = query.getResultList();
			log.info("Total List found in repo" + list.size());
			return list;
		} finally {
			em.close();
		}

	}

	@Override
	public Long findByEmail(String email) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("emailId");
			query.setParameter("useremailby", email);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			return value;
		} finally {
			em.close();
		}

	}

	@Override
	public Long findByUser(String user) {

		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("userId");
			query.setParameter("userby", user);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
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
			query.setParameter("usermobileby", number);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;
		} finally {
			em.close();
		}
	}
	
	@Override
	public SingUpEntity resetPassword(String email) {
		
		
		return SingUpRepository.super.resetPassword(email);
	}

}
