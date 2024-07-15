package com.micro.hotelservices.customException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(IdNotFoundException.class)
	public Map<String, String> idNotFoundExceptionHandling(IdNotFoundException exception,WebRequest request){
		
		Map<String, String> mp=new HashMap<>();
		mp.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
		mp.put("message", exception.getMessage());
		mp.put("path", request.getDescription(false));
		return mp;
		
	}
}
