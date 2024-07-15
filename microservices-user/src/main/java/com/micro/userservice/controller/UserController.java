package com.micro.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.micro.userservice.entity.User;
import com.micro.userservice.service.UserService;

@RestController
@RequestMapping("com.user")
public class UserController {

	@Autowired
	UserService service;

	
	@PostMapping("submitUser")
	public ResponseEntity<?> saveUser(@RequestBody User user) {

		
		return ResponseEntity.status(HttpStatus.OK).body(service.saveUser(user));
	}

	
	@GetMapping("getUserBy/{id}")
	public ResponseEntity<?> fetchByid(@PathVariable int id) {

		return ResponseEntity.status(HttpStatus.OK).body(service.fetchByid(id));
	}

	@GetMapping("/getUser")
	public ResponseEntity<?> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllUser());
	}

}
