package com.lti.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lti.training.Repository.GenericRepository;
import com.lti.training.Repository.ProductRepo;
import com.lti.training.dto.ProductDto;
import com.lti.training.dto.ResponseDto;
import com.lti.training.entity.Product;
import com.lti.training.entity.enums.Category;
import com.lti.training.entity.enums.ResponseType;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	@Qualifier("productRepo")
	private GenericRepository genricRepository;

	@Transactional
	public void add(Product product) {
		genricRepository.store(product);
	}

	public List<Product> fetchbyCategory(Category category) {
		return productRepo.byCategory(category);
	}
	public ResponseDto delete(ProductDto productDto) {
		productRepo.delete(productDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponse(ResponseType.DELETED);
		return responseDto;
	}

}
