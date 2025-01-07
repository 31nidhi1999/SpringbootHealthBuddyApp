package com.health.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	
	private String message;
	private LocalDateTime timeStamp;
	private HttpStatus responseStatus;
	
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp = timeStamp.now();
	}

	public ApiResponse(String msg, HttpStatus status) {
		message=msg;
		this.timeStamp=LocalDateTime.now();
		responseStatus=status;
	}
	
	
	
}
