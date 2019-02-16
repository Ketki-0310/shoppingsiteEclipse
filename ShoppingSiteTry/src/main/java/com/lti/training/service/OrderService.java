package com.lti.training.service;


import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import com.lti.training.Repository.GenericRepository;
import com.lti.training.dto.OrderDto;
import com.lti.training.entity.Cart;
import com.lti.training.entity.Order;

@Service
public class OrderService {


	//private AdminRepo adminRepo;
	@Autowired
	@Qualifier("orderRepo")
	private GenericRepository genericRepo;
	
	@Transactional
	public void add(OrderDto orderDto) {
		Order order=new Order();
		order.setPaymentMode(orderDto.getPaymentMode());
		Cart cart=genericRepo.fetchById(Cart.class, orderDto.getCartId()); 
		order.setCart(cart);
		genericRepo.store(order);
	}
	
	public Order fetch(int id) {
		return (Order)genericRepo.fetchById(Order.class, id);
	}

	

}
