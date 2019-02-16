package com.lti.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.dto.CartDto;
import com.lti.training.dto.ResponseDto;
import com.lti.training.entity.Admin;
import com.lti.training.entity.enums.ResponseType;
import com.lti.training.service.CartService;

@RestController
@CrossOrigin
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(path = "/cart/add", method = RequestMethod.POST)
	public ResponseDto add(@RequestBody CartDto cartDto) {
		
		cartService.addToCart(cartDto);
		ResponseDto re=new ResponseDto();
		re.setResponse(ResponseType.ADDED);
		return re;
	}



	
}
