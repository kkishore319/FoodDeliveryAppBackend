package com.fds.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fds.registration.exception.RegistrationException;
import com.fds.registration.model.Registration;
import com.fds.registration.repository.RegistrationRepo;


@Service
public class RegistrationServiceImpl {
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private RegistrationRepo registrationRepo;
	
	public Registration save(Registration user) {
		Registration existingUser= registrationRepo.findByUsername(user.getUsername());
		
		if (existingUser != null) {
			// User with the same username already exists, throw an exception
			throw new RegistrationException("Username already exists: " + user.getUsername());
		}
		Registration login = new Registration();
		login.setUsername(user.getUsername());
		login.setPassword(bcryptEncoder.encode(user.getPassword()));
		login.setRole(user.getRole());
		login.setEmail(user.getEmail());
		login.setPhoneNumber(user.getPhoneNumber());
		login.setCountry(user.getCountry());
		return registrationRepo.save(login);
	}

}
