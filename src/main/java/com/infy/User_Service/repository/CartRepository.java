package com.infy.User_Service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.infy.User_Service.entity.Buyer;
import com.infy.User_Service.entity.Cart;
import com.infy.User_Service.entity.CompositeKey;

@Repository
public interface CartRepository extends JpaRepository<Cart, CompositeKey> {
	List<Cart> findByBuyerId(int buyerId);
}
