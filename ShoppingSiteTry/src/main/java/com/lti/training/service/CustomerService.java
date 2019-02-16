package com.lti.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.training.Repository.CustomerRepo;
import com.lti.training.dto.CustomerDto;
import com.lti.training.dto.CustomerLoginDTO;
import com.lti.training.dto.ResponseDto;
import com.lti.training.entity.Customer;
import com.lti.training.entity.enums.ResponseType;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerDao;

	@Transactional
	public ResponseDto add(CustomerDto c) {
		Customer cust = new Customer();
		cust.setContact(c.getContact());
		cust.setEmail(c.getEmail());
		cust.setFirstname(c.getFirstname());
		cust.setLastname(c.getLastname());
		cust.setPassword(c.getPassword());

		customerDao.add(cust);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponse(ResponseType.ADDED);
		return responseDto;
	}

	public Customer fetch(int id) {
		return customerDao.fetch(id);
	}

	public ResponseDto verify(CustomerLoginDTO customer) {
		ResponseDto responseDto = new ResponseDto();

		try {
			Customer c = customerDao.verifyDB(customer);
			responseDto.setResponse(ResponseType.VERIFIED);
			responseDto.setUserId(c.getCustomerId());
		}
		catch(Exception e) {
			e.printStackTrace();
			responseDto.setResponse(ResponseType.INVALID);
		}

		return responseDto;
	}

}
