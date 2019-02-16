package com.lti.training;

import java.util.List;

//import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.Repository.AddressRepo;
import com.lti.training.Repository.CustomerRepo;
import com.lti.training.entity.Address;
import com.lti.training.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class CustomerTest {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AddressRepo addressRepo; 
	@Transactional
	@Test
	public void addCustomer() {

		//making the customer object 
		Customer customer = new Customer();
		customer.setFirstname("Melissa");
		customer.setLastname("Dsouza");
		customer.setEmail("melissa@gmail.com");
		customer.setPassword("melissa1996");
		customer.setContact("9876543210");
		
		Address address=new Address();
		address.setLine1("Vasant Vihar Building");
		address.setLine2("Near Kohinoor Hotel");
		address.setState("Maharashtra");
		address.setPincode(400103);
		address.setCity("Mumbai");
		customer.setAddress(address);
		
		//adding the customer details plus the address details to the database
		customerRepo.add(customer);
	}

	@Test
	public void verifyCustomer() {

		boolean flag = false;
		Customer customer = new Customer();
		String email = "pooja";
		String password = "123456";

		List<Customer> customerList = customerRepo.fetchAll();

		for (Customer x : customerList) {
			if (email.equals(x.getEmail())) {
				if (password.equals(x.getPassword())) {
					flag = true;
				}
			}
		}
		String flag1 = Boolean.toString(flag);
		if (flag1.equals("true"))
			System.out.println("customer is verified");
		else
			System.out.println("customer is not verified");
	}
}
