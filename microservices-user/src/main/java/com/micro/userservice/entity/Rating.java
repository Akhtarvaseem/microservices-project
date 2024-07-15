package com.micro.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

	private int ratingid;
	private int userId;
	private int hotelId;
	private int rating;
	private String feedback;
}
