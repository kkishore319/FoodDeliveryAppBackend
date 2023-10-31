package com.fds.restaurant.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fds.restaurant.model.Item;


public interface ItemRepository extends MongoRepository<Item, String>{
	List<Item> findByItemName(String name);
	List<Item> findByRestaurantId(String restaurantId);
	
}
