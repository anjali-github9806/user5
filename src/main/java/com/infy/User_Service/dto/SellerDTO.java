package com.infy.User_Service.dto;
import com.infy.User_Service.entity.Seller;

public class SellerDTO {
	
	Integer sellerId;
	String name;
	String email;
	String phonenumber;
	String password;
	Integer isactive;
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
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
	 
	public static SellerDTO valueOf(Seller sell)
	{
		SellerDTO sellDTO= new SellerDTO();
		sellDTO.setEmail(sell.getEmail());
		sellDTO.setIsactive(sell.getIsactive());
		sellDTO.setName(sell.getName());
		sellDTO.setPassword(sell.getPassword());
		sellDTO.setPhonenumber(sell.getPhonenumber());
		sellDTO.setSellerId(sell.getSellerId());
		
		return sellDTO;
		
		
	}
	public Seller createEntity()
	{
		Seller sell = new Seller();
		sell.setEmail(this.getEmail());
		sell.setIsactive(this.getIsactive());
		sell.setName(this.getName());
		sell.setPassword(this.getPassword());
		sell.setSellerId(this.getSellerId());
		sell.setPhonenumber(this.getPhonenumber());
		return sell;
	}

}
