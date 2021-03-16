package com.infy.User_Service.dto;

import javax.persistence.Id;

import com.infy.User_Service.entity.Wishlist;

public class WishlistDTO {
	
	Integer buyerId;
	
	Integer proId;
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public static WishlistDTO valueOf(Wishlist wishlist) {
		WishlistDTO wishlistDTO = new WishlistDTO();
		wishlistDTO.setBuyerId(wishlist.getBuyerId());
		wishlistDTO.setProId(wishlist.getProId());
		return wishlistDTO;
	}

	public Wishlist createEntity() {
		Wishlist wishlist = new Wishlist();
		wishlist.setBuyerId(wishlist.getBuyerId());
		wishlist.setProId(wishlist.getProId());
		return wishlist;
	}
	
	@Override
	public String toString() {
		return "WishlistDTO [buyerId=" + buyerId + ", prodid=" + proId + "]";
	}

}

