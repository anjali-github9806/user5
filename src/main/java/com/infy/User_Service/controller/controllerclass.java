package com.infy.User_Service.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.infy.User_Service.service.*;
import com.infy.User_Service.dto.BuyerDTO;
import com.infy.User_Service.dto.CartDTO;
import com.infy.User_Service.dto.LoginDTO;
import com.infy.User_Service.dto.SellerDTO;
import com.infy.User_Service.dto.SubscribedProductDTO;
import com.infy.User_Service.dto.WishlistDTO;
import com.infy.User_Service.entity.Buyer;
import com.infy.User_Service.entity.Cart;
import com.infy.User_Service.entity.*;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class controllerclass {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SellerService sellservice;
	
	@Autowired
	BuyerService buyservice;
	
	@Autowired
	CartService cartservice;
	@Autowired
	WishListService wishlistService;
	@Autowired
	Environment environment;
	
	@Value("${product.uri}")
	String producturi;
	
	@GetMapping(value="/seller",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<SellerDTO> getAllSells()
	{
		logger.info("Fetching all sells");
		return sellservice.getAllSellDetails();
	}
	
	@GetMapping(value= "/seller/{sellerId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public SellerDTO getSpecificsell(@PathVariable Integer sellerId)
	{
		logger.info("Fetching details of sell {}", sellerId);
		return sellservice.getSpecificSell(sellerId);
	}
	@PostMapping(value = "/seller", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> addSellerDetails(@RequestBody Seller seller) {
		 ResponseEntity<String> res=null;
		logger.info("Adding BuyerDetails");
		try {
		sellservice.addSellerDetails(seller);
		res=new ResponseEntity<String>("Inserted Successfully",HttpStatus.OK);
		}
		catch(Exception e)
		{
			res=new ResponseEntity<String>("Insertion UnSuccessfully",HttpStatus.BAD_REQUEST);
		}
		return res;
	}
	
	
	
	@DeleteMapping(value = "/seller/{sellerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SellerDTO> deleteSpecificOrder(@PathVariable Integer SellerId) {
		logger.info("Deleting details of sell {}", SellerId);
		sellservice.deleteSpecificSeller(SellerId);
		return sellservice.getAllSellDetails();
		
}
	@GetMapping(value="/buyer",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<BuyerDTO> getAllbuyers()
	{
		logger.info("Fetching all buyers");
		return  buyservice.getAllBuyDetails();
	}
	@GetMapping(value= "/buyer/{buyerId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public BuyerDTO getSpecificBuyer(@PathVariable int buyerId)
	{
		logger.info("Fetching details of cart {}", buyerId);
		
		return buyservice.getSpecificBuyer(buyerId);
	}
	
	
	
//	@PostMapping(value = "/buyer/register", produces = MediaType.APPLICATION_JSON_VALUE)
//	public  List<BuyerDTO> addOrderDetails(@RequestBody Buyer buyer) {
//		logger.info("Adding BuyerDetails");
//		try {
//		buyservice.addBuyer(buyer);
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//		return buyservice.getAllBuyDetails();
//	}
	
	@PostMapping(value = "/buyer/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> addOrderDetails(@RequestBody Buyer buyer) throws Exception {
		logger.info("Adding BuyerDetails");
		ResponseEntity<String> response=null;
		
		try {
			buyer.setRewardPoints(0);
			buyer.setIsPrivileged(0);
			buyer.setIsactive(1);
		buyservice.addBuyer(buyer);
		String successMessage = "You have registered  successfully.";
		 response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		//return response1;
		
		}
		catch(Exception e)
		{
			 response = new ResponseEntity<String>(environment.getProperty(e.getMessage()), HttpStatus.BAD_REQUEST);
			//System.out.println(e.getMessage());
		}
		//return buyservice.getAllBuyDetails();
		return response;
	
	}
	
	@DeleteMapping(value = "/buyer/{buyerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BuyerDTO> deleteSpecificBuyer(@PathVariable Integer buyerId) {
		logger.info("Deleting details of Buyer {}", buyerId);
		buyservice.deleteSpecificBuyer(buyerId);
		return buyservice.getAllBuyDetails();
		
}
	@GetMapping(value="/cart",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CartDTO> getallcart()
	{
		logger.info("Fetching all cart details");
		return  cartservice.getAllcartDetails();
	}
	@GetMapping(value= "/cart/{buyerId}/{proId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public CartDTO getSpecificCart(@PathVariable int buyerId,@PathVariable  int proId)
	{
		logger.info("Fetching details of cart {}", buyerId);
		
		return cartservice.getSpecificCart(buyerId,proId);
	}
	@GetMapping(value= "/cart/{buyerId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CartDTO> getSpecificCart1(@PathVariable int buyerId)
	{
		logger.info("Fetching details of cart {}", buyerId);
		
		return cartservice.getSpecificCartByBuyerId(buyerId);
	}
	@RequestMapping(method=RequestMethod.PUT,value="buyer/{buyerId}")
	public Object updateRewardPoints(@RequestBody Buyer buyer,@PathVariable int buyerId)
	{
		return buyservice.updateRewardPoints(buyer, buyerId);
	}
//	@PostMapping(value = "/cart", produces = MediaType.APPLICATION_JSON_VALUE)
//	public  List<CartDTO> addCartDetails(@RequestBody Cart cart) {
//		logger.info("Adding cartDetails");
//		
//		cartservice.addCartDetails(cart);
//		return cartservice.getAllcartDetails();
//	}
	@PostMapping(value = "/cart/add")
	public   ResponseEntity<String> addCartDetails(@RequestBody Cart cart) {
		logger.info("Adding cartDetails");
		
		cartservice.addCartDetails(cart);
		String successMessage = "Product added in cart successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
		//return cartservice.getAllcartDetails();
	}
	
	@DeleteMapping(value = "/cart/{buyerId}/{proId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteSpecificCart(@PathVariable int buyerId,@PathVariable int proId) throws Exception {
		//logger.info("Deleting details of cart {}", buyerId);
		
		cartservice.deleteSpecificCart(buyerId,proId);
		String successMessage = "Product removed from cart successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
		//return cartservice.getAllcartDetails();
	}
	public ResponseEntity<String> deleteCart(@RequestBody CartDTO cartdto)
	{
		ResponseEntity<String> response=null;
		boolean status=cartservice.deletecart(cartdto);
		if(!status)
		{
			response = new ResponseEntity<String>(environment.getProperty("DELETION_CART_ITEM"),HttpStatus.OK);
		}
		else
		{
			response = new ResponseEntity<String>(environment.getProperty("CART_DOES_NOT_EXIST"),HttpStatus.BAD_REQUEST);
		}
		return response;
	}
		@GetMapping(value="/wishlist/{buyerId}/{proId}", produces=MediaType.APPLICATION_JSON_VALUE)
		public WishlistDTO getSpecificWishList(@PathVariable int buyerId, @PathVariable int proId) {
			logger.info("Fetching the specific wishlist");
			return wishlistService.getSpecificWishList(buyerId, proId);
		}
		
		@DeleteMapping(value="/wishlist/{buyerId}/{proId}")
		public void deleteSpecificWishList(@PathVariable int buyerId, @PathVariable int proId) {
			logger.info("Deleting the specific wishlist");
			wishlistService.deleteSpecificWishList(buyerId, proId);
		}
		
		@PostMapping(value="/wishlist/add", consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> addWishList(@RequestBody WishlistDTO wishlist) throws Exception {
			ResponseEntity<String> resEntity=null;
			try {
				wishlistService.addWishList(wishlist);
				resEntity= new ResponseEntity<String>("product added to Wishlist Successfully",HttpStatus.OK);
			}
			catch(Exception e)
			{
				ResponseStatusException rsc =new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()), e);
				throw rsc;
			
			}
			return resEntity;
		}
//		@PostMapping(value="/wishlist/add", consumes=MediaType.APPLICATION_JSON_VALUE)
//		public void addWishList(@RequestBody WishlistDTO wishlist) {
//			logger.info("Adding a wishlist");
//			wishlistService.addWishList(wishlist);
//		}
		@PostMapping(value = "/seller/login")
		public ResponseEntity<LoginDTO> validateSellerLogin(@RequestBody LoginDTO login)  {
			//logger.info("Adding BuyerDetails");
			ResponseEntity<LoginDTO> temp=null;
			try {
				List<BuyerDTO> list=buyservice.validateLogin(login);
				
				temp=new ResponseEntity<LoginDTO>(login, HttpStatus.OK);
			}
			
			catch(Exception e) {
				ResponseStatusException rsc =new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()), e);
				throw rsc;
			}
			return temp;
			
	
			//return buyservice.getAllBuyDetails();
		}
		@PostMapping(value="/wishlist/move/{quantity}")
		public void addtoCart(@PathVariable int quantity,@RequestBody WishlistDTO wishlist)
		{
			Cart cart=new Cart();
			cart.setBuyerId(wishlist.getBuyerId());
			cart.setProId(wishlist.getProId());
			cart.setQuantity(quantity);
			cartservice.addCartDetails(cart);
			System.out.println("OK");
			wishlistService.deleteSpecificWishList(wishlist.getBuyerId(), wishlist.getProId());
		}
		
		@PostMapping(value="/subscription/add")
		public  ResponseEntity<String> addSubscription(@RequestBody SubscribedProductDTO subdto)
		{
			int buyerId =subdto.getBuyerId();
			BuyerDTO buyer=buyservice.getSpecificBuyer(buyerId);
			int rewardPoints=buyer.getRewardPoints();
			String temp;
			
			if(rewardPoints>10000)
			{
				temp="Subscription succesfully!";
				new RestTemplate().postForObject(producturi + "/subproducts", subdto, SubscribedProductDTO.class );
			}
//			new RestTemplate().postForObject(producturi + "/subproducts", subdto, SubscribedProductDTO.class );
			else
			{
				temp="Subscription Failed! You have to be a Privileged Buyer";
			}
			//new RestTemplate().postForObject(producturi + "/subproducts", subdto, SubscribedProductDTO.class );
			return new ResponseEntity<String>(temp,HttpStatus.OK);
			
		}
		
		@RequestMapping(method=RequestMethod.PUT,value="seller/inactive/{SellerId}")
		public Object updateIsactive(@RequestBody Seller seller,@PathVariable Integer SellerId)
		{
			//Seller sell= new Seller();
			//sell.setIsactive(0);
			//sellservice.deleteSpecificSeller(SellerId);
			return sellservice.updateIsactive(seller, SellerId);
		}
		@PutMapping(value="/buyer/inactive/{buyerId}")
		public Object updateIsActiveOfbuyer(@RequestBody Buyer buyer,@PathVariable int buyerId)
		{
			return buyservice.updateIsActive(buyer, buyerId);
		}
		
}
	


 