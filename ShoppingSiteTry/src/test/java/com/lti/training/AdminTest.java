/*package com.lti.training;

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

import com.lti.training.Repository.AdminRepo;
import com.lti.training.entity.Admin;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class AdminTest {

	@Autowired
	private AdminRepo adminDao;

	@Transactional
	@Test
	public void addAdmin() {

		//making the customer object 
		Admin admin = new Admin();
		admin.setEmail("Lisha");
		admin.setPassword("123456789");
		
		//adding the customer details plus the address details to the database
		adminDao.add(admin);
	}


	@Test
	public void verifyAdmin()
	{

		boolean flag = false;
		String email = "Pooja";
		String password = "1234";

		List<Admin> adminList = adminDao.fetchAll();

		for (Admin x : adminList) {
			if (email.equals(x.getEmail())) {
				if (password.equals(x.getPassword())) {
					flag = true;
				}
			}
		}
		String flag1 = Boolean.toString(flag);
		if (flag1.equals("true"))
			System.out.println("user is verified");
		else
			System.out.println("user is not verified");
	}
}
*/