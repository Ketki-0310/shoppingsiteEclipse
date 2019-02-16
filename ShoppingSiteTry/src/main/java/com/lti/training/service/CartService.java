package com.lti.training.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lti.training.Repository.GenericRepository;
import com.lti.training.dto.CartDto;
import com.lti.training.dto.ItemDto;
import com.lti.training.entity.Cart;
import com.lti.training.entity.Customer;
import com.lti.training.entity.Item;
import com.lti.training.entity.Product;

@Service
public class CartService {
	
		@Autowired
		@Qualifier("cartRepo")
		private GenericRepository genericRepository;
		
		@Transactional
		public void addToCart(CartDto cartDto) {
			String s=cartDto.getCustomerId().replace("\"","");
			int id=Integer.parseInt(s);
			Customer customer = genericRepository.fetchById(Customer.class, id);
			
			Cart cart = new Cart();
			cart.setCustomer(customer);
			cart.setTotalAmount(cartDto.getTotalAmount());
			
			Set<Item> items = new HashSet<>();
			for(ItemDto itemDto : cartDto.getItems()) {
				Product product = genericRepository.fetchById(Product.class, itemDto.getProductId());
				Item item = new Item();
				item.setProduct(product);
				//item.setName(product.getName());
				item.setQuantity(itemDto.getQuantity());
				item.setCart(cart);
				items.add(item);
			}
			cart.setItems(items);
			genericRepository.store(cart);
			
			
			
		}
}