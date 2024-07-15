package com.micro.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.userservice.customException.UserNotFound;
import com.micro.userservice.entity.User;
import com.micro.userservice.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	// insert into database
	public User saveUser(User user) {
	
		return repo.save(user);
		
	}
	
	public User fetchByid(int id) {
		
		User user=repo.findById(id).orElseThrow(()-> new UserNotFound("User not found. Please ! enter correct id"));
		return user;
	}
	
	
	public List<User> getAllUser(){
		return repo.findAll();
		
	}
}
