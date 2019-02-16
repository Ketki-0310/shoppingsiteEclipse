package com.lti.training.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.dto.ResponseDto;
import com.lti.training.dto.RetailerDto;
import com.lti.training.entity.Retailer;
import com.lti.training.entity.enums.ResponseType;
import com.lti.training.service.RetailerService;

@CrossOrigin
@RestController
public class RetailerController {

	@Autowired
	private RetailerService RetailerService;

	@RequestMapping(path = "/loginRetailer", method = RequestMethod.POST)
	public ResponseDto login(@RequestBody RetailerDto retailerDto) {
		
ResponseDto responseDto= RetailerService.verify(retailerDto);
		
		return responseDto;
	}
	
	@RequestMapping(path = "/addRetailer", method = RequestMethod.POST)
	public String add(@RequestBody Retailer retailer) {
		RetailerService.add(retailer);
		return "Retailer Added";
	}
	@RequestMapping(path = "/allRetailer", method = RequestMethod.GET)
	public List<Retailer> fetchAll() {
		return RetailerService.fetchAll();
	}
	@RequestMapping(path = "/DeleteRetailer", method = RequestMethod.GET)
	public ResponseDto delete(@RequestParam String name) throws IOException {
		System.out.println(name);
		boolean flag=RetailerService.delete(name);
		ResponseDto rd=new ResponseDto();
		if(flag)
		rd.setResponse(ResponseType.DELETED);
		else
			rd.setResponse(ResponseType.ERROR);
		return rd;
	}
	
	
}
