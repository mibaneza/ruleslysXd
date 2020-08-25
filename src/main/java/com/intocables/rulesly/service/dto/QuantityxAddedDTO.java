package com.intocables.rulesly.service.dto;

import java.io.Serializable;

public class QuantityxAddedDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int quantity;
	private String date;
	public QuantityxAddedDTO(int quantity, String date) {
		this.quantity =  quantity;
		this.date = date;
	}
	
	public QuantityxAddedDTO() {	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
