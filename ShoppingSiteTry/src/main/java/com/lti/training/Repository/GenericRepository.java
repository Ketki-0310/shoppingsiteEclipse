package com.lti.training.Repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository 
public class GenericRepository {
	
	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	public void store(Object obj) {
		
		entityManager.persist(obj);
	}

	@Transactional
	public <E> E fetchById(Class<E> classname, Object pk) {
		E e = entityManager.find(classname, pk);
		return e;
	}

	public <E> List<?> fetchAll(Class<E> clazz) {
		Query q = entityManager.createQuery("select obj from " + clazz.getName() + " as obj");// JPQL from classname
		return q.getResultList();
	}

}
