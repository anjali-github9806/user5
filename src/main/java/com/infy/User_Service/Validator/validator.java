package com.infy.User_Service.Validator;

import com.infy.User_Service.dto.BuyerDTO;
import com.infy.User_Service.entity.Buyer;
import com.infy.User_Service.entity.Seller;

public class validator {
	public static Boolean validateBuyerName(String name) {
	       boolean a=false;
			String regex1 = "^[a-zA-Z-,]+(\\s{0,1}[a-zA-Z-])*$";
			if(name.matches(regex1)) {
				a=true;
			}
			return a;
		}
	
	public static Boolean validateBuyerEmailID(String email) {
	       boolean a=false;
			String regex1 = "[a-zA-Z0-9]+@[a-zA-Z]+\\.(com)";
			if(email.matches(regex1)) {
				a=true;
			}
			return a;
		}
	
	public static Boolean validateBuyerPhoneNo(String phoneno) {
	       boolean a=false;
			String regex1 = "^[789]\\d{9}$";
			if(phoneno.matches(regex1)) {
				a=true;
			}
			return a;
		}

	public static Boolean validateBuyerPassword(String password) {
	       boolean a=false;
			String regex1 = "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[!@#$%^&*])"
                    + "(?=\\S+$).{7,20}$"; 
			if(password.matches(regex1)) {
				a=true;
			}
			return a;
		}
	
	public static void  ValidateAllMethods(Buyer buyer) throws Exception
	{
		if(!validator.validateBuyerPassword( buyer.getPassword()))
		{
			System.out.println("wrong password");
			throw new Exception("User.Invalid_Password");
		}
		
		if(!validator.validateBuyerName(buyer.getName()))
		{
			System.out.println("wrong BuyerName");
			throw new Exception("User.Invalid_Name");
		}
		if(!validator.validateBuyerEmailID(buyer.getEmail()))
		{
			System.out.println("wrong EmailId");
			throw new Exception("User.Invalid_Email");
		}
		if(!validator.validateBuyerPhoneNo(buyer.getPhonenumber()))
		{
			System.out.println("wrong BuyerPhoneNO");
			throw new Exception("User.Invalid_PhoneNO");
		}
		
		
	}
	public static void  ValidateAllMethodsSeller(Seller buyer) throws Exception
	{
		if(!validator.validateBuyerPassword( buyer.getPassword()))
		{
			System.out.println("wrong password");
			throw new Exception("User.Invalid_Password");
		}
		
		if(!validator.validateBuyerName(buyer.getName()))
		{
			System.out.println("wrong SellerName");
			throw new Exception("User.Invalid_Name");
		}
		if(!validator.validateBuyerEmailID(buyer.getEmail()))
		{
			System.out.println("wrong EmailId");
			throw new Exception("User.Invalid_Email");
		}
		if(!validator.validateBuyerPhoneNo(buyer.getPhonenumber()))
		{
			System.out.println("wrong SellerPhoneNO");
			throw new Exception("User.Invalid_PhoneNO");
		}
		
		
	}
//	public static Boolean ValidateRewardsPoints(Buyer buyer)
//	{
//		int temp=buyer.getRewardPoints();
//		if(temp>10000)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//			
//	}
	
	
}

