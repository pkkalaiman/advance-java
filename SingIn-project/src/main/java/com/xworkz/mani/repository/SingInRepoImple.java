package com.xworkz.mani.repository;

import java.time.LocalTime;
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
		log.info("created" + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(SingInEntity userEntity) {
		log.info("Runnning in Save in Repository...");
		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(userEntity);
			et.commit();
			return false;
		} finally {
			em.close();
		}

	}

	@Override
	public SingInEntity userSignIn(String userId) {
		log.info("Runnning in UserSingInID IN Repository..");
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("user");
			query.setParameter("userinfo", userId);
			Object object = query.getSingleResult();
			SingInEntity entity = (SingInEntity) object;
			log.info("SingIn Entity :" + entity);
			return entity;
		} finally {
			em.close();
		}

	}

	@Override
	public List<SingInEntity> findAll() {
		log.info("Running in FindAll in Repository...");
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
		log.info("Rinning in FindByEmail in Rpository...");
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("emailId");
			query.setParameter("emailby", email);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			log.info("", value);
			return value;

		} finally {
			em.close();
		}

	}

	@Override
	public Long findByUser(String user) {
		log.info("Running in FindByUser in Repsitory");
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
		log.info("Runnning un FindByMobile in Repostiry..");
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("mobileId");
			query.setParameter("mobileBy", number);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			log.info("", value);
			return value;

		} finally {
			em.close();
		}
	}

	@Override
	public boolean logincount(String userID, int count) {
		log.info("running in Logincount:" + count);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createNamedQuery("updateLoginCount");
			query.setParameter("logcount", count);
			query.setParameter("userID", userID);
			query.executeUpdate();
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}

	@Override
	public SingInEntity reSetPassword(String email) {
		log.info("Runnning in ResetPasswor in Repository...");
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("resetPassword");
			query.setParameter("emailIdby", email);
			Object object = query.getSingleResult();
			SingInEntity entity = (SingInEntity) object;
			log.info("Saved in Entity" + entity);
			return entity;
			
		} finally {
			em.close();
		}
	}

	@Override
	public boolean update(SingInEntity sinentity) {
		log.info("Runnning in Update in Repository...");
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
	public boolean updatePassword(String userId, String password, Boolean resetPassword, LocalTime expTime) {
		log.info("Runnning in UpdatePassword in Rposiry....");
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createNamedQuery("updatePassword");
			query.setParameter("uId", userId);
			query.setParameter("userpassword", password);
			query.setParameter("resetpassword", resetPassword);
			query.setParameter("exp", expTime);
			query.executeUpdate();
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}

	/*
	 * @Override public Long findCountByEmailAndUserAndMobile(String email, String
	 * userId, long mobile) {
	 * 
	 * EntityManager manager = this.entityManagerFactory.createEntityManager();
	 * 
	 * Query query = manager.createNamedQuery("findByCount");
	 * query.setParameter("e", email); query.setParameter("u", userId);
	 * query.setParameter("m", mobile); Object object = query.getSingleResult();
	 * Long count = (Long) object; log.error("" + count);
	 * 
	 * return count; }
	 */
	/*
	 * @Override public boolean saveTechnology(TechnologyEntity entity) {
	 * log.info("Running save in saveTechnology");
	 * 
	 * EntityManager em = this.entityManagerFactory.createEntityManager(); try {
	 * EntityTransaction et = em.getTransaction(); et.begin(); em.persist(entity);
	 * et.commit(); return true; } finally { em.close(); } }
	 */
	

}
