package com.infy.User_Service.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infy.User_Service.dto.*;
import com.infy.User_Service.entity.Cart;
import com.infy.User_Service.entity.CompositeKey;
import com.infy.User_Service.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartrepo;
	
	public  List<CartDTO> getAllcartDetails()
	{
		List<Cart> cart=cartrepo.findAll();
		List<CartDTO> cartDTO= new ArrayList<>();
		for(Cart i :cart)
		{
			CartDTO cartdto=CartDTO.valueOf(i);
			cartDTO.add(cartdto);
			
		}
		return cartDTO;
	}
   public CartDTO getSpecificCart(int buyerId,int ProId)
   {
	   CompositeKey compkey= new CompositeKey();
	   compkey.setBuyerId(buyerId);
	   compkey.setProId(ProId);
	   CartDTO cartdto=null;
	   Optional<Cart> optCart=cartrepo.findById(compkey);
	  // System.out.println(optCart);
	   if(optCart.isPresent())
	   {
		   Cart cart=optCart.get();
		   cartdto=CartDTO.valueOf(cart);
	   }
	   
	   return cartdto;
   }
   public List<CartDTO> getSpecificCartByBuyerId(int buyerId)
   {
	   List<Cart> cart=cartrepo.findByBuyerId(buyerId);
		List<CartDTO> cartDTO= new ArrayList<>();
		for(Cart i :cart)
		{
			CartDTO cartdto=CartDTO.valueOf(i);
			cartDTO.add(cartdto);
			
		}
		return cartDTO;
	   
	   
   }
   public void deleteSpecificCart(int buyerId, int proId)
   {
	   CompositeKey compkey= new CompositeKey();
	   compkey.setBuyerId(buyerId);
	   compkey.setProId(proId);
	   cartrepo.deleteById(compkey);
   }
   public void addCartDetails(Cart cart)
   {
	   cartrepo.save(cart);
   }
   public boolean deletecart(CartDTO cartdto)
   {
	   CompositeKey copkey=new CompositeKey();
	   copkey.setBuyerId(cartdto.getBuyerId());
	   copkey.setProId(cartdto.getProId());
	   Cart cart= cartrepo.findById(copkey).orElse(null);
	   if(cart!=null)
	   {
		   cart.getBuyerId();
		   cart.getProId();
		   cartrepo.deleteById(copkey);
		   return true;
	   }
	   return false;
   }
}
