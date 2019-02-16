package com.lti.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.Repository.GenericRepository;
import com.lti.training.Repository.RetailerRepo;
import com.lti.training.dto.ResponseDto;
import com.lti.training.dto.RetailerDto;
import com.lti.training.entity.Customer;
import com.lti.training.entity.Retailer;
import com.lti.training.entity.enums.ResponseType;

@Service
public class RetailerService {

	@Autowired
	private RetailerRepo retailerRepo;
	
	@Autowired
	@Qualifier("retailerRepo")
	private GenericRepository genricRepo;
	@Autowired
private RetailerRepo retailerRepo1;
	@Transactional
	public void add(Retailer retailer) {
		genricRepo.store(retailer);
		// retailerRepo.add(retailer);

	}

	public ResponseDto verify(RetailerDto retailerDto) {
		ResponseDto responseDto = new ResponseDto();
		
		try {
			Retailer c = retailerRepo1.verifyDB(retailerDto);
			responseDto.setResponse(ResponseType.VERIFIED);
			responseDto.setUserId(c.getRetailer_id());
		}
		catch(Exception e) {
			e.printStackTrace();
			responseDto.setResponse(ResponseType.INVALID);
		}

		return responseDto;

	}

	public Retailer fetch(int id) {
		return (Retailer) genricRepo.fetchById(Retailer.class, id);

	}

	public List<Retailer> fetchAll() {
		return (List<Retailer>) genricRepo.fetchAll(Retailer.class);
	}

	@Transactional
	public boolean delete(String name) {
		Retailer r = new Retailer();
		List<Retailer> list = fetchAll();
		System.out.println(list.size());
		for (Retailer re : list) {
			if (name.equals(re.getName())) {

				System.out.println("in service class" + re.getName());
				retailerRepo.delete(re);

				return true;
			}
		}
		return false;

	}

}
