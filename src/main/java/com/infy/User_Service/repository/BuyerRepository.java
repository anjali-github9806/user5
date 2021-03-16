package com.infy.User_Service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.infy.User_Service.entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Integer> {
	List<Buyer> getByBuyerId(int buyerId);
}
