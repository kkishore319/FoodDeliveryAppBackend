package com.fds.cart.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fds.cart.entity.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart,Integer> {
	public Cart findById(int cartId);
	//Optional<Cart> findById(int cartId);

}
