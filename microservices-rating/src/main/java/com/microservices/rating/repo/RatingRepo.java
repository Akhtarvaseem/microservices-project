package com.microservices.rating.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.rating.entity.Rating;
import java.util.List;


public interface RatingRepo extends JpaRepository<Rating, Integer>{

	List<Rating> findByUserId(int userId);
	List<Rating> findByHotelId(int hotelId);
	 
}
