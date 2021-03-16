package com.infy.User_Service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.User_Service.Validator.validator;
import com.infy.User_Service.dto.BuyerDTO;
import com.infy.User_Service.dto.LoginDTO;
import com.infy.User_Service.dto.SellerDTO;
import com.infy.User_Service.entity.Buyer;
import com.infy.User_Service.entity.Seller;
import com.infy.User_Service.repository.BuyerRepository;

@Service
public class BuyerService {
	@Autowired
	BuyerRepository buyrepo;
	
	public  List<BuyerDTO> getAllBuyDetails()
	{
		
		List<Buyer> buy=buyrepo.findAll();
		List<BuyerDTO> buyDTO= new ArrayList<>();
		for(Buyer i :buy)
		{
			BuyerDTO buyerDTO=BuyerDTO.valueOf(i);
			buyDTO.add(buyerDTO);
		}
		return buyDTO;
		
	}
	public BuyerDTO getSpecificBuyer(int buyerId)
	{
		BuyerDTO buyDTO = null;
		
		Optional<Buyer> optbuyer=buyrepo.findById(buyerId);
		if(optbuyer.isPresent())
		{
			
			Buyer buy=optbuyer.get();
			//optbuyer=BuyerDTO.valueOf(buy);
			buyDTO=BuyerDTO.valueOf(buy);
			
			
		}
		return buyDTO;
	}
	public void deleteSpecificBuyer(int buyerId)
	{
		buyrepo.deleteById(buyerId);
		//return "Success";
		
	}
   public void addBuyer(Buyer buyer) throws Exception
   {
	   
	  validator.ValidateAllMethods(buyer);
//	  boolean a= validator.ValidateRewardsPoints(buyer);
//	  if(a==true)
//	  {
//		  buyer.setIsPrivileged(1);
//	  }
	   buyrepo.save(buyer);
	   //return "Success";
   }
   public List<BuyerDTO> validateLogin(LoginDTO logindto) throws Exception
   {
	   List<BuyerDTO> buyDTO= new ArrayList<>();
	   try
	   {
	   List<Buyer> buy=buyrepo.findAll();
		
		for(Buyer i :buy)
		{
			BuyerDTO buyerDTO=BuyerDTO.valueOf(i);
			buyDTO.add(buyerDTO);
		}
		for(BuyerDTO i:buyDTO)
		{
			if(logindto.getEmail().equals(i.getEmail()))
			{
				if(logindto.getPassword().equals(i.getPassword()))
				{
					System.out.println("Ok");
					//throw new Exception("User.Invalid");
				}
				else
				{
					throw new Exception("User.Invalid");
				}
				
			}
			
		}
	   }
	   catch(Exception e)
	   {
		  // System.out.println(e.getMessage());
		   throw e;
	   }
	   return buyDTO;
   }
   public  Buyer updateRewardPoints(Buyer buyerdto,int buyerId)
   {
	   Buyer buyer1= buyrepo.findById(buyerId).orElse(null);
	   if(buyer1!=null)
	   {
		   buyer1.setBuyerId(buyerdto.getBuyerId());
		   buyer1.setRewardPoints(buyerdto.getRewardPoints());
		   buyer1.setEmail(buyerdto.getEmail());
		   buyer1.setIsactive(buyerdto.getIsactive());
		   buyer1.setIsPrivileged(buyerdto.getIsPrivileged());
		   buyer1.setPassword(buyerdto.getPassword());
		   buyer1.setPhonenumber(buyerdto.getPhonenumber());
		   buyer1.setName(buyerdto.getName());
		   return buyrepo.save(buyer1);
		   
	   }
	   return null;
   }
   public Buyer updateIsActive(Buyer buyer,int buyerId)
   {
	   Buyer buy=buyrepo.findById(buyerId).orElse(null);
	   if(buy!=null)
	   {
		   buy.setIsactive(0);
		   buyrepo.save(buy);
	   }
	   return null;
   }
}
