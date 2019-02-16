package com.lti.training.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.dto.CustomerLoginDTO;
import com.lti.training.dto.RetailerDto;
import com.lti.training.entity.Customer;
import com.lti.training.entity.Retailer;

@Repository
@Qualifier("retailerRepo")
public class RetailerRepo extends GenericRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Transactional
	public void delete(Retailer r) {
		System.out.println("delete repo");
					entityManager.remove(r);
	}
	public Retailer verifyDB(RetailerDto retailerDto) {
		String email = retailerDto.getEmail();
		String password = retailerDto.getPassword();
		Query q = entityManager.createQuery("select obj from Retailer as obj where obj.email=:email and obj.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		Retailer r = (Retailer) q.getSingleResult(); 
		return r;
	}

}
