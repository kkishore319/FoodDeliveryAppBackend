package com.fds.restaurant.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fds.restaurant.model.Item;
import com.fds.restaurant.model.Restaurant;

public interface RestaurantRepo extends MongoRepository<Restaurant, String> {
	
	List<Restaurant> findByRestaurantName(String restaurantName);
	List<Restaurant> findByType(String type);
	List<Restaurant> findByLocation(String location);
//	List<Item> findByItems (String item);
	
}
