package com.microservices.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.rating.dao.RatingDao;
import com.microservices.rating.entity.Rating;

@Service
public class RatingService {

	@Autowired
	RatingDao dao;
	
	public Rating saveRating(Rating rating) {

		return dao.saveRating(rating);
	}
	
	
	public Rating getById(int id) {
	
	return dao.getById(id);
	}
	
	public List<Rating> getByUserId(int userId){
		return dao.getByUserId(userId);
	}
	
	public List<Rating> getByHotelid(int hotelId){
		return dao.getByHotelid(hotelId);
	}
	
	public boolean deletebyUserId(int id) {
		return dao.deletebyUserId(id);
	}
	
	public Rating updateRating(Rating ratings) {
		
		return dao.updateRating(ratings);
		
	}
	
	public Rating updateRatingByPatch(Rating rating) {
		return dao.updateRatingByPatch(rating);
		
	}
	
	
	// getting all record
	public List<Rating> getAllRating() {
		
		return dao.getAllRating();
	}
	
}
