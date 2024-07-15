package com.micro.hotelservices.customException;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException{

	public IdNotFoundException(String msg) {
		super(msg);
	}
}
