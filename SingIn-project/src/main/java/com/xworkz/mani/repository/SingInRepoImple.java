package com.xworkz.mani.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.mani.Entity.SingInEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class SingInRepoImple implements SingInRepo {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public SingInRepoImple() {
		log.info("" + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(SingInEntity userEntity) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(userEntity);
			et.commit();
			return true;
		} finally {
			em.close();
		}

	}

	@Override
	public SingInEntity userSignIn(String userId) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("user");
			query.setParameter("userinfo", userId);
			Object object = query.getSingleResult();
			SingInEntity entity = (SingInEntity) object;
			log.info("" + entity);
			return entity;
		} finally {
			em.close();
		}

	}

	@Override
	public List<SingInEntity> findAll() {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("findAll");
			List<SingInEntity> list = query.getResultList();
			log.info("Total list size found in repo" + list.size());
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
			query.setParameter("emailby", email);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
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
			query.setParameter("mobileBy", number);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			em.close();
		}
	}

	@Override
	public boolean logincount(String userID, int count) {
		log.info("count:" + count);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createNamedQuery("updateLoginCount");
			query.setParameter("userID", userID);
			query.setParameter("logcount", count);
			query.executeUpdate();
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}

	@Override
	public SingInEntity reSetPassword(String email) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("resetPassword");
			query.setParameter("emailIdby", email);
			Object object = query.getSingleResult();
			SingInEntity entity = (SingInEntity) object;
			log.info("" + entity);
			return entity;
		} finally {
			em.close();
		}
	}

	@Override
	public boolean update(SingInEntity sinentity) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(sinentity);
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}

	@Override
	public boolean updatePassword(String userId, String password, Boolean resetPassword) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createNamedQuery("updatePassword");
			query.setParameter("uId", userId);
			query.setParameter("userpassword", password);
			query.setParameter("resetpassword", resetPassword);
			query.executeUpdate();
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}

}
