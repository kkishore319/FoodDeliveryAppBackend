package com.fds.registration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fds.registration.model.Registration;

public interface RegistrationRepo extends MongoRepository<Registration	, String> {
	Registration findByUsername(String username);
}
