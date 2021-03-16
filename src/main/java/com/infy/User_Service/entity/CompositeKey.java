package com.infy.User_Service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
@Embeddable
public class CompositeKey implements Serializable{
	@Column(name="BUYERID",nullable=false,length=11)
	int buyerId;

	@Column(name="PRODID",nullable=false,length=11)
	int proId;

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
