package com.micro.userservice.controller;

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


import com.micro.userservice.entity.User;
import com.micro.userservice.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.PUT;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;


	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user) {

		return ResponseEntity.status(HttpStatus.OK).body(service.saveUser(user));
	}

	
	
	int fallbackCount=1;
	@GetMapping("/getUserBy/{id}")
//	@CircuitBreaker(name="ratingHotelBroker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name="ratingHotelService" , fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name="rateLimiter" ,fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<?> fetchByid(@PathVariable int id) {
		fallbackCount++;
		System.out.println("Your fallback service "+fallbackCount);
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchByid(id));
	}
	
//	Fallback method
	
	public ResponseEntity<?> ratingHotelFallback( int id, Exception ex){
		
	   User user= User.builder().name("Dummy").email("dummy@gamil.com").about("Its not for real data.").userId(1).build();
	   return ResponseEntity.status(HttpStatus.OK).body(user);
		
	}
	
	

	
	@DeleteMapping("deleteBy/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
boolean f=		service.deleteUser(id);
		if(f) {
			
			return ResponseEntity.status(HttpStatus.OK).body("successfully deleted");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request .");
		}
		
	}
	
	@DeleteMapping("deleteRatingByUser/{id}")
	public ResponseEntity<?> deleteUsersrating(@PathVariable int id) {
		boolean f=service.deleteUsersRating(id);
		if(f) {
			
			return ResponseEntity.status(HttpStatus.OK).body("successfully deleted");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request .");
		}
	}
	
	
	@PutMapping("/updateByUser")
	public ResponseEntity<?> updateRatingByUser(@RequestBody User user) {
		boolean f=service.updateRatingByUser(user);
     if(f) {	
			return ResponseEntity.status(HttpStatus.OK).body("successfully update");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request .");
		}
	}
	
	
	@PatchMapping("/updateByPatch")
	public ResponseEntity<?> updateRatingByUserPatch(@RequestBody User user) {
		boolean f=service.updateRatingByUserPatch(user);
		if(f) {	
			return ResponseEntity.status(HttpStatus.OK).body("successfully update");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request .");
		}
	}
	
	
	@GetMapping("/getUser")
	public ResponseEntity<?> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllUser());
	}
	
	
	
	
	

}
