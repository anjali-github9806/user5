package com.infy.User_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.User_Service.entity.CompositeKey;
import com.infy.User_Service.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, CompositeKey> {

}
