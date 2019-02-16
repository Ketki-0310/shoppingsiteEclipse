package com.lti.training.dto;

public class OrderDto {
private int cartId;
private String paymentMode;
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public void setPaymentMode(String paymentMode) {
	this.paymentMode = paymentMode;
}
public int getCartId() {
	return cartId;
}
public String getPaymentMode() {
	return paymentMode;
}
}
