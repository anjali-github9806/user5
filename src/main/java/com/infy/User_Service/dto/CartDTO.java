package com.infy.User_Service.dto;

import com.infy.User_Service.entity.Cart;

public class CartDTO {
	int buyerId;
	int proId;
	Integer quantity;
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	// Converts Entity into DTO
		public static CartDTO valueOf(Cart cart) {
			CartDTO cartDTO = new CartDTO();
			cartDTO.setBuyerId(cart.getBuyerId());
			cartDTO.setProId(cart.getProId());
			cartDTO.setQuantity(cart.getQuantity());
			return cartDTO;
		}

		// Converts DTO into Entity
					public Cart createEntity() {
						Cart cart = new Cart();
						cart.setBuyerId(this.getBuyerId());
						cart.setProId(this.getProId());
						cart.setQuantity(this.getQuantity());
						return cart;
					}
		@Override
		public String toString() {
			return "CartDTO [buyerId=" + buyerId + ", prodId=" + proId + ", quantity=" + quantity + "]";
		}

}
