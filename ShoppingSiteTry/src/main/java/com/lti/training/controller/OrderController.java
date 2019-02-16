package com.lti.training.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.dto.OrderDto;
import com.lti.training.entity.Order;
import com.lti.training.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(path = "/order/add", method = RequestMethod.POST)
	public String add(@RequestBody OrderDto orderDto) {
		orderService.add(orderDto);
		return "order created successfully";
	}

}
