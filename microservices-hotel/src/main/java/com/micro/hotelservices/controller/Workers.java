package com.micro.hotelservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker")
public class Workers {
	
	
   @GetMapping("/all")
	public ResponseEntity<?> getWorkers(){
	   System.out.println("hello workers ");
		
		List<String> list=Arrays.asList("mohan","sohan","akash","mahi");
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

}
