package com.fds.order.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fds.order.model.Order;

public interface OrderRepo extends MongoRepository<Order, Integer>{

	List<Order> findByUsername(String orderName);
	
}
