package com.fitness.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class HttpRequestMethodNotSupportedException extends RuntimeException {
	
	String resourceName;
	static LocalDateTime localDate;
	
	public HttpRequestMethodNotSupportedException(String resourceName) {
		super(String.format("Please Enter %s with id to delete"
				+ "and request occured at : %s",resourceName,localDate.now()));
		this.resourceName = resourceName;
		this.localDate = localDate;
	}
	
	

}
