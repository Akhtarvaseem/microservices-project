package com.micro.userservice.customException;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalHandlingException {

	@ExceptionHandler(UserNotFound.class)
	public Map<String , String> userNotFoundExceptionHandling(UserNotFound notFound ,WebRequest request){
		
		Map<String,String> mp=new HashMap<>();
		
		mp.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
		mp.put("message", notFound.getMessage());
		mp.put("path", request.getDescription(false));
		return mp;
		
	}
}
