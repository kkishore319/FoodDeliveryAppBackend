package com.fds.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fds.registration.model.Registration;
import com.fds.registration.service.RegistrationServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private RegistrationServiceImpl registrationServiceImpl;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addUser")
	public ResponseEntity<?> saveUser(@Valid @RequestBody Registration user) throws Exception {
		if(user.getRole().equals("Admin")||user.getRole().equals("User")) {
			return ResponseEntity.ok(registrationServiceImpl.save(user));
		}
		else
		{
			return new ResponseEntity<>("Please Select a valid role",
                    HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
}
