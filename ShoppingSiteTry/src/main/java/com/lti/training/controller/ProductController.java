package com.lti.training.controller;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.dto.ProductDto;
import com.lti.training.dto.ResponseDto;
import com.lti.training.entity.Product;
import com.lti.training.entity.enums.Category;
import com.lti.training.entity.enums.ResponseType;
import com.lti.training.service.ProductService;

@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/product/add", method = RequestMethod.POST)
	public ResponseDto add(@RequestBody Product product) {
		ResponseDto responseDto = new ResponseDto();
		try {
			productService.add(product);
			responseDto.setResponse(ResponseType.ADDED);
			return responseDto;
		} catch (PersistenceException e) {
			responseDto.setResponse(ResponseType.ERROR);
			return responseDto;
		}
	}

	@RequestMapping(path = "/product/category/{category}", method = RequestMethod.GET)
	public List<Product> ListByCategory(@PathVariable("category") Category category) {
		return productService.fetchbyCategory(category);
	}
	
	@RequestMapping(path = "/product/delete", method = RequestMethod.POST)
	public ResponseDto Delete(@RequestBody ProductDto productDto) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponse(productService.delete(productDto).getResponse());
		return responseDto;
	}
	

}
