package com.internousdev.ecsite.dto;

public class CartItemDTO extends ItemDTO{

	private int buyConut;

	private int totalPrice;

	public int getBuyConut() {
		return buyConut;
	}

	public void setBuyConut(int buyConut) {
		this.buyConut = buyConut;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
