package com.badkultechnology.projecttripmanagement.exception;

//This is a custom exception that you throw when a requested resource 
//(like a Trip) does not exist in the database.

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
