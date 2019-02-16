package com.lti.training.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.dto.CustomerLoginDTO;
import com.lti.training.entity.Customer;

@Repository
@Qualifier("customerRepo")
public class CustomerRepo {

	@PersistenceContext
	private EntityManager entityManager;
@Transactional
	public void add(Customer customer) {
		entityManager.persist(customer);
	}

	public Customer fetch(int id) {
		return entityManager.find(Customer.class, id);
	}

	public List<Customer> fetchAll() {
		Query q = entityManager.createQuery("select obj from Customer as obj");
		return q.getResultList();
	}
	public Customer verifyDB(CustomerLoginDTO customerLoginDto) {
		String email = customerLoginDto.getEmail();
		String password = customerLoginDto.getPassword();
		Query q = entityManager.createQuery("select obj from Customer as obj where obj.email=:email and obj.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		Customer c = (Customer) q.getSingleResult(); 
		return c;
	}
}
