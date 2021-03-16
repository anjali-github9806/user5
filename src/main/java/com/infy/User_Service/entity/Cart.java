package com.infy.User_Service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CompositeKey.class)
@Table(name="cart")
public class Cart {
	@Id
	@Column(name="BUYERID",nullable=false,length=11)
	int buyerId;
	@Id
	@Column(name="PRODID",nullable=false,length=11)
	int proId;
	@Column(name="QUANTITY",nullable=false,length=11)
	int quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
