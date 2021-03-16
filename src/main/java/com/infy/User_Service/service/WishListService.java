package com.infy.User_Service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.User_Service.dto.WishlistDTO;
import com.infy.User_Service.entity.CompositeKey;
import com.infy.User_Service.entity.Wishlist;
import com.infy.User_Service.repository.WishlistRepository;

@Service
public class WishListService {
	
	@Autowired
	WishlistRepository wishListRepo;
	
	public WishlistDTO getSpecificWishList(int buyerId, int prodId) {
		CompositeKey compKey = new CompositeKey();
		compKey.setBuyerId(buyerId);
		compKey.setProId(prodId);
		WishlistDTO wishlistDTO = null;
		wishListRepo.findAll();
		Optional<Wishlist> optWishList = wishListRepo.findById(compKey);
		if(optWishList.isPresent()) {
			Wishlist wishlist = optWishList.get();
			wishlistDTO = WishlistDTO.valueOf(wishlist);
		}
		return wishlistDTO;
	}
	
	public void deleteSpecificWishList(int buyerId, int prodId) {
		CompositeKey compKey = new CompositeKey();
		compKey.setBuyerId(buyerId);
		compKey.setProId(prodId);
		wishListRepo.deleteById(compKey);
	}

	public void addWishList(WishlistDTO wishlist) throws Exception{
		Wishlist wish = new Wishlist();
		//try {
		wish.setBuyerId(wishlist.getBuyerId());
		wish.setProId(wishlist.getProId());
		wishListRepo.save(wish);
	//	}
//		catch(Exception e)
//		{
//			throw e;
//		}
			//return wishlist;	
	}

}