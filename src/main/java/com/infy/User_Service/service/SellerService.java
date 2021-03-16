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
import com.infy.User_Service.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
	SellerRepository sellrepo;
	
	public  List<SellerDTO> getAllSellDetails()
	{
		List<Seller> sells=sellrepo.findAll();
		List<SellerDTO> sellDTO= new ArrayList<>();
		for(Seller i :sells)
		{
			SellerDTO sellerDTO=SellerDTO.valueOf(i);
			sellDTO.add(sellerDTO);
		}
		return sellDTO;
		
	}
	public SellerDTO getSpecificSell(int sellerId )
	{
		SellerDTO sellDTO=null;
		Optional<Seller> optseller=sellrepo.findById(sellerId);
		if(optseller.isPresent())
		{
			Seller sell=optseller.get();
			sellDTO=SellerDTO.valueOf(sell);
		}
		return sellDTO;
	}
	public void deleteSpecificSeller(int sellerId)
	{
		sellrepo.deleteById(sellerId);
	}
   public String addSellerDetails(Seller seller) throws Exception
   {
	  // SellerDTO selldto=null;
	   try
	   {
	   validator.ValidateAllMethodsSeller(seller);
	  // boolean a=validator.ValidateRewardsPoints(null)
	   
	  sellrepo.save(seller);
	   
	   }
	   catch(Exception e)
	   {
		   throw e;
	   }
	   return "OK";
   }
//   public void validateLogin(LoginDTO logindto)
//   {
//	   List<Buyer> buy=sellrepo.findAll();
//		List<BuyerDTO> buyDTO= new ArrayList<>();
//		for(Buyer i :buy)
//		{
//			BuyerDTO buyerDTO=BuyerDTO.valueOf(i);
//			buyDTO.add(buyerDTO);
//		}
//		for(BuyerDTO i:buyDTO)
//		{
//			if(logindto.getEmail().equals(i.getEmail()))
//			{
//				if(logindto.getPassword().equals(i.getPassword()))
//				{
//					System.out.println("Ok");
//				}
//			}
//		}
//
//   }
   public Seller updateIsactive (Seller seller,int SellerId)
   {
	   Seller sell=sellrepo.findById(SellerId).orElse(null);
	   if(sell!=null)
	   {
		   //sell.setEmail(seller.getEmail());
		   sell.setIsactive(0);
		   sellrepo.save(sell);
		   
	   }
	   return null;
	   
   }
}
