package com.microservices.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.rating.entity.Rating;
import com.microservices.rating.service.RatingService;





@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveRating(@RequestBody Rating rating) {
		
	
		if(rating!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(service.saveRating(rating));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please try again.");
		}
	}
	
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		if(id!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please try again.");
		}
	}
	
	@GetMapping("/ByUserId/{userId}")
	public ResponseEntity<?> getByUserId(@PathVariable int userId){
		
		if(userId != 0) {
			return ResponseEntity.status(HttpStatus.OK).body(service.getByUserId(userId));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please try again.");
		}
		
	}
	
    @DeleteMapping("/deleteUserById/{userId}")
	public ResponseEntity<?> deletebyUserId(@PathVariable int userId) {
		
		if(userId != 0) {
			return ResponseEntity.status(HttpStatus.OK).body(service.deletebyUserId(userId));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(service.deletebyUserId(userId));
		}
	}
    
    
    @PutMapping("/updateRating")
    public ResponseEntity<?> updateRating(@RequestBody Rating ratings) {
    	
    	if(ratings != null) {
    		System.out.println(ratings+"hello");
			return ResponseEntity.status(HttpStatus.OK).body(service.updateRating(ratings));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("somethong went wrong "+service.updateRating(ratings));
		}
    }
    
    
    
    @PatchMapping("/updateRatingByPatch")
    public ResponseEntity<?> updateRatingByPatch(@RequestBody Rating ratings) {
    	
    	if(ratings != null) {
    		System.out.println(ratings+"hello");
			return ResponseEntity.status(HttpStatus.OK).body(service.updateRatingByPatch(ratings));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("somethong went wrong "+service.updateRating(ratings));
		}
    }
	
    
	@GetMapping("/ByHotelId/{hotelId}")
	public ResponseEntity<?> getByHotelid(@PathVariable int hotelId){

		if(hotelId != 0) {
			return ResponseEntity.status(HttpStatus.OK).body(service.getByHotelid(hotelId));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please try again.");
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllRating() {
		
		
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleverd -> "+service.getAllRating());
		
	}
	
}
