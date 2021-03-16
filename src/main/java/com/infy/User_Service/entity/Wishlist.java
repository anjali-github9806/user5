package com.infy.User_Service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.infy.User_Service.dto.WishlistDTO;


@Entity
@IdClass(CompositeKey.class)
@Table(name="wishlist")
public class Wishlist {
	
	@Id
	@Column(name="BUYERID",nullable=false,length=11)
	int buyerId;
	
	@Id
	@Column(name="PRODID",nullable=false,length=11)
	int proId;
	

	
	// Converts Entity into DTO
		public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

		
}
