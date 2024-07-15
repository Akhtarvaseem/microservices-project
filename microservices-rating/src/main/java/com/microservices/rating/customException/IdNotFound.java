package com.microservices.rating.customException;

@SuppressWarnings("serial")
public class IdNotFound extends RuntimeException{

	public IdNotFound(String msg) {
	super(msg);
	}
}
