package com.micro.hotelservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.hotelservices.entity.Hotel;

public interface HotelReposetory extends JpaRepository<Hotel, Integer>{

	
}
