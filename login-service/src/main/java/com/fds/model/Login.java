package com.fds.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userLogin")
public class Login {
	
	@Id
    private String username;
    private String password;
    private String role;
    private long phoneNumber;
    private String email;
    private String country;
	

}
