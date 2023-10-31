package com.fds.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fds.model.Login;

@Repository
public interface LoginRepository extends MongoRepository<Login, String>{
	Login findByUsername(String username);
	Login findByPassword(String password);
}
