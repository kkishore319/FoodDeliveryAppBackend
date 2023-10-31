package com.fds.payment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fds.payment.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, Long> {

	
	Payment findByOrderId(int orderId);
	
	
	

}
