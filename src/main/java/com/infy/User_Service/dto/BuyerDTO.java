package com.infy.User_Service.dto;
import com.infy.User_Service.entity.Buyer;

public class BuyerDTO {
	Integer buyerId;
	String name;
	String email;
	String phonenumber;
	String password;
	Integer isactive;
	Integer rewardPoints;
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
	//converts entity to dto
	
	public static BuyerDTO valueOf(Buyer buy)
	{
		BuyerDTO buyerDTO= new BuyerDTO();
		buyerDTO.setBuyerId(buy.getBuyerId());
		buyerDTO.setEmail(buy.getEmail());
		buyerDTO.setIsactive(buy.getIsactive());
		buyerDTO.setIsPrivileged(buy.getIsPrivileged());
		buyerDTO.setName(buy.getName());
		buyerDTO.setPassword(buy.getPassword());
		buyerDTO.setPhonenumber(buy.getPhonenumber());
		buyerDTO.setRewardPoints(buy.getRewardPoints());
		
		return buyerDTO;
	}
	// converts dto to entity
	public Buyer createEntity()
	{
		Buyer buy=new Buyer();
		buy.setBuyerId(this.getBuyerId());
		buy.setEmail(this.getEmail());
		buy.setIsactive(this.getIsactive());
		buy.setIsPrivileged(this.getIsPrivileged());
		buy.setName(this.getName());
		buy.setPassword(this.getPassword());
		buy.setPhonenumber(this.getPhonenumber());
		buy.setRewardPoints(this.getRewardPoints());
		return buy;
	}
	@Override
	public String toString()
	{
		return "BuyerDTO [buyerid=" + buyerId + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", password=" + password + ", isPrivileged=" + isPrivileged + ", rewardPoints=" + rewardPoints
				+ ", isactive=" + isactive + "]";
	}
}
