package com.lti.training.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lti.training.entity.enums.Category;

@Entity
@Table(name="SS_retailer")
public class Retailer {
@Id
@GeneratedValue
	private int retailer_id;
	private String name;
	private Category category;
	private String email;
	private String password;
	
	@OneToMany(mappedBy="retailer",cascade=CascadeType.ALL)
	private Set<Product> product;

	public int getRetailer_id() {
		return retailer_id;
	}

	public void setRetailer_id(int retailer_id) {
		this.retailer_id = retailer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public Retailer(int retailer_id, String name, Category category, String email, String password,
			Set<Product> product) {
		super();
		this.retailer_id = retailer_id;
		this.name = name;
		this.category = category;
		this.email = email;
		this.password = password;
		this.product = product;
	}

	public Retailer() {
		super();
	}
	
	
}
