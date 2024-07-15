package com.micro.hotelservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.hotelservices.customException.IdNotFoundException;
import com.micro.hotelservices.entity.Hotel;
import com.micro.hotelservices.repo.HotelReposetory;

@Service
public class Hotelservice {
    
	@Autowired
	HotelReposetory repo;
	
	public Hotel saveHotel(Hotel hotel) {
		return repo.save(hotel);
		
	}
	
	
	public Hotel fetchById(int id ) {
		return repo.findById(id).orElseThrow(()->new IdNotFoundException("Please enter correct id"));
		
	}
	
	
	public List<Hotel> fetchAll(){
		return repo.findAll();
	}
}
