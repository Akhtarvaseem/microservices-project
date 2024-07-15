package com.micro.userservice.customException;

@SuppressWarnings("serial")
public class UserNotFound extends RuntimeException{

	public UserNotFound(String msg) {
		
		super(msg);
	}
}
