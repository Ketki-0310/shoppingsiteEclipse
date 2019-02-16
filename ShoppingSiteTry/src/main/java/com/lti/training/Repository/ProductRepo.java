package com.lti.training.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.dto.ProductDto;
import com.lti.training.entity.Product;
import com.lti.training.entity.enums.Category;

@Repository

public class ProductRepo extends GenericRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Product> byCategory(Category category ){
		Query q = entityManager.createQuery("select obj from Product as obj where category=:cat");
		q.setParameter("cat", category);
	
		return q.getResultList();
	}
	
	@Transactional
	public void delete(ProductDto productDto) {
		Query q = entityManager.createQuery("select obj from Product as obj where name=:name");
		q.setParameter("name", productDto.getName());
		//q.setParameter("retailer", productDto.getRetailerID());
//	Product p=(Product) q.getSingleResult();
//		entityManager.remove(p);
		List<Product> p=q.getResultList();
		for(Product pt:p)
			entityManager.remove(pt);
}
	
	


	
}
