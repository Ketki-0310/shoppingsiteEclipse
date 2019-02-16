package com.lti.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.dto.CustomerDto;
import com.lti.training.dto.CustomerLoginDTO;
import com.lti.training.dto.ResponseDto;
import com.lti.training.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/customer/add", method = RequestMethod.POST)
	public ResponseDto add(@RequestBody CustomerDto customerdto) {
		ResponseDto responseDto=customerService.add(customerdto);
		return responseDto;
	}

	@RequestMapping(path = "/customer/verify", method = RequestMethod.POST)
	public ResponseDto verify(@RequestBody CustomerLoginDTO customerLoginDTO) {
		ResponseDto responseDto= customerService.verify(customerLoginDTO);
		
		return responseDto;
	}

}
