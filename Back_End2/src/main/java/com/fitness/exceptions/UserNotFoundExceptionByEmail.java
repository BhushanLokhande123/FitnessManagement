package com.fitness.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundExceptionByEmail extends RuntimeException
{
	String resourceName;
	String fieldName;
	String fieldValue;
	
	
	public UserNotFoundExceptionByEmail(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		fieldValue = fieldValue;
	}
	
	
}
