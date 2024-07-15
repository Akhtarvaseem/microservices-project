package com.micro.hotelservices.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.micro.hotelservices.entity.Hotel;
import com.micro.hotelservices.service.Hotelservice;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
   Hotelservice service;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.OK).body(service.saveHotel(hotel));
	
	}
	
	
	@GetMapping("/getBy/{id}")
	public ResponseEntity<?> fetchById(@PathVariable int id ) {
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchById(id));
		
		
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<?> fetchAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchAll());
		
	}
}
