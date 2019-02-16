package com.lti.training.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
@Id
@GeneratedValue
	private int itemId;
private String name;
private int quantity;
@OneToOne
private Product product;
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="cartId")
@JsonIgnore
private Cart cart;

public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}




}
