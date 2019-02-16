package com.lti.training.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lti.training.dto.CustomerLoginDTO;
import com.lti.training.entity.Admin;

@Repository("adminRepo")
public class AdminRepo extends GenericRepository {

	public int verifyDB(Admin admin) {
		String email = admin.getEmail();
		String password = admin.getPassword();
		System.out.println(email+" "+password);
		Query q = entityManager.createQuery("select obj from Admin as obj where obj.email=:email");
		q.setParameter("email", email);
	//	q.setParameter("password", password);
		
		return q.getResultList().size();
	}
}