package com.health.custom_exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String resource, Long id, HttpStatus status) {
		super(resource +" not found with Id : "+id+ " "+status);
	}
	
	public ResourceNotFoundException(String resource) {
		super(resource);
	}
}
