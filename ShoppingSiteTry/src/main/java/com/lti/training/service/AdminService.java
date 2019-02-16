package com.lti.training.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lti.training.Repository.AdminRepo;
import com.lti.training.Repository.GenericRepository;
import com.lti.training.dto.ResponseDto;
import com.lti.training.entity.Admin;
import com.lti.training.entity.enums.ResponseType;

@Service
public class AdminService {


	//private AdminRepo adminRepo;
	@Autowired
	@Qualifier("adminRepo")
	private GenericRepository genricRepo;

	@Autowired
	private AdminRepo adminRepo;
	@Transactional
	public void add(Admin admin) {
		genricRepo.store(admin);
	}

	public Admin fetch(int id) {
		return (Admin)genricRepo.fetchById(Admin.class, id);
	}

	// to verify the admin credentials
	public ResponseDto verify(Admin admin) {
		
		int i = (int)adminRepo.verifyDB(admin);
		ResponseDto responseDto = new ResponseDto();
System.out.println(i);
		if (i >= 1)
			responseDto.setResponse(ResponseType.VERIFIED);
		else
			responseDto.setResponse(ResponseType.INVALID);
		return responseDto;
	}

}
