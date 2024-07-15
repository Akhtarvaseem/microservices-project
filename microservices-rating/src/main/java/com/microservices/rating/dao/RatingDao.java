package com.microservices.rating.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.rating.customException.IdNotFound;
import com.microservices.rating.entity.Rating;
import com.microservices.rating.repo.RatingRepo;

@Repository
public class RatingDao {

	@Autowired
	RatingRepo repo;
	
	public Rating saveRating(Rating rating) {
		
		
	Rating rat=	repo.save(rating);
	if(rat!=null) {
		return rat;
		
	}
	return rat;
	   
	}
	
	
	// getting hotel rating using rating id
	public Rating getById(int id) {
	Rating rating=	repo.findById(id).orElseThrow(()->new IdNotFound("Please enter correct id"));
	return rating;
	}
	
	
	public List<Rating> getByHotelid(int hotelId) {
		List<Rating> byHotelId = repo.findByHotelId(hotelId);
		return byHotelId;
	}
	
	// getting records from user id 
	public List<Rating> getByUserId(int userId) {
		List<Rating> byUserId = repo.findByUserId(userId);
		return byUserId;
	}
	
	// deleting rating byUser id
	
	public boolean deletebyUserId(int id) {
		
		boolean f=false;
		     List<Rating> users = getByUserId(id);
		     
		     if(!users.isEmpty() || users!=null) {
		    	  for (Rating rating : users) {
					
		    		  repo.delete(rating);
		    		  
				}
		    	 
		    	 f=true;
		     }
		
		return f;
		
	}
	
//	// update rating by userId and hptelId
	public Rating updateRating(Rating rating) {
	
		Rating r=	repo.findById(rating.getRatingid()).orElseThrow(()->new IdNotFound("Please enter correct id"));
		
		if(r!=null) {
			
			r.setRating(rating.getRating());
			r.setFeedback(rating.getFeedback());
			
			Rating rat=	repo.save(r);
			
			return rat;
		}
	
		return r;
	
	}
	
	
	
	// update rating by userId and hptelId
	public Rating updateRatingByPatch(Rating rating) {
	
		
		
		Rating r=	repo.findById(rating.getRatingid()).orElseThrow(()->new IdNotFound("Please enter correct id"));
		
	
		if(r!=null) {
			
			r.setRating(rating.getRating());
			r.setFeedback(rating.getFeedback());
			
			Rating rat=	repo.save(r);
			
			return rat;
		}
	
		return r;
	
	}
	
	
	
	// getting all rating records
	public List<Rating> getAllRating() {
		
		return repo.findAll();
	}
	
	
	
}
