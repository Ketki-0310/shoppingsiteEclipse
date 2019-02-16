package com.lti.training;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.Repository.RetailerRepo;
import com.lti.training.entity.Retailer;
import com.lti.training.entity.enums.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DaoTestAdmin {

	@Autowired
	private RetailerRepo retailerRepo;

	@Test
	@Transactional
	public void addRetailer() {
		Retailer retailer = new Retailer();
		retailer.setName("Shruti");
		retailer.setCategory(Category.MOBILE);
		retailerRepo.store(retailer);

	}

	@Test
	@Transactional
	public void GetAllRetailer() {
		List<Retailer> all = (List<Retailer>)retailerRepo.fetchAll(Retailer.class);
		assertNotNull(all);
		System.out.println(all.size());

	}

}
