package com.lti.training;

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

import com.lti.training.Repository.CustomerRepo;
import com.lti.training.Repository.GenericRepository;
import com.lti.training.entity.Cart;
import com.lti.training.entity.Customer;
import com.lti.training.entity.Item;
import com.lti.training.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class CartItemTest {
@Autowired
	private CustomerRepo customerRepo;
@Autowired
private GenericRepository genericRepository;

	@Transactional
	@Test
	public void addCart() {
Cart c=new Cart();
c.setTotalAmount(12125.25);

Customer cust=customerRepo.fetch(332);
c.setCustomer(cust);
List<Item>i=(List<Item>)genericRepository.fetchAll(Item.class);
System.out.println(i.size());
c.setItems(i);
System.out.println(c.getItems().size());

genericRepository.store(c);
	}

    @Transactional
	@Test
	public void item()
	{
Item i=new Item();
i.setName("heal");

Product prod=genericRepository.fetchById(Product.class, 496);
i.setProduct(prod);
i.setQuantity(121);
genericRepository.store(i);
	}
}
