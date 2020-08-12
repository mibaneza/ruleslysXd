package com.intocables.rulesly.dto;

import java.io.Serializable;

public class QuantityxAddedDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private int quantity;
	private String date;
	public QuantityxAddedDto(int quantity, String date) {
		this.quantity =  quantity;
		this.date = date;
	}
	
	public QuantityxAddedDto() {	}

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
