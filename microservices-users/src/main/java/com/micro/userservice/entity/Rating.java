package com.micro.userservice.entity;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rating {

	private int ratingid;
	private int userId;
	private int hotelId;
	private int rating;
	private String feedback;
	
	@Transient
	private Hotel hotel;
}
