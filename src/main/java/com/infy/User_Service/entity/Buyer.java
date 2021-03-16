package com.infy.User_Service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="buyer1")//(uniqueConstraints= @UniqueConstraint(columnNames= {"PHONENUMBER"}),name="buyer")

public class Buyer {
	
	@Id
	@Column(name="BUYERID",nullable=false,length=11)
	Integer buyerId;
	@Column(name="NAME",nullable=false,length=50)
	String name;
	@Column(name="EMAIL",nullable=false,length=45)
	String email;
	@Column(name="PHONENUMBER",nullable=false,length=45,unique=true)
	String phonenumber;
	@Column(name="PASSWORD",nullable=false,length=45)
	String password;
	@Column(name="ISACTIVE",length=1)
	@Value("${stuff.value:@null}")
	Integer isactive;
	@Column(name="REWARDPOINTS",length=11)
	@Value("${stuff.value:@null}")
	Integer rewardPoints;
	@Column(name="ISPRIVILEGED",length=1)
	@Value("${stuff.value:@null}")
	Integer isPrivileged;
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public Integer getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public Integer getIsPrivileged() {
		return isPrivileged;
	}
	public void setIsPrivileged(Integer isPrivileged) {
		this.isPrivileged = isPrivileged;
	}
	

}
