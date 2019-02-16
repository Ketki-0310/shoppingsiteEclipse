package com.lti.training.dto;

import java.util.List;

import com.lti.training.entity.Cart;
import com.lti.training.entity.Item;

public class CartDto {

	private String customerId;
	private double totalAmount;

	private List<ItemDto> items;

	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<ItemDto> getItems() {
		return items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
