package com.lti.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.dto.ResponseDto;
import com.lti.training.entity.Admin;
import com.lti.training.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(path = "/admin/add", method = RequestMethod.POST)
	public String add(@RequestBody Admin admin) {
		adminService.add(admin);
		return "Admin created successfully";
	}

	@RequestMapping(path = "/admin/verify", method = RequestMethod.POST)
	public ResponseDto verify(@RequestBody Admin admin) {
		ResponseDto responseDto=adminService.verify(admin);

	return responseDto;
	}

	
}
